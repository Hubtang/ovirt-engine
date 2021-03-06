package org.ovirt.engine.core.bll.validator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.ovirt.engine.core.bll.ValidationResult;
import org.ovirt.engine.core.bll.network.VmInterfaceManager;
import org.ovirt.engine.core.common.FeatureSupported;
import org.ovirt.engine.core.common.businessentities.BusinessEntityMap;
import org.ovirt.engine.core.common.businessentities.VDS;
import org.ovirt.engine.core.common.businessentities.network.IpConfiguration;
import org.ovirt.engine.core.common.businessentities.network.Network;
import org.ovirt.engine.core.common.businessentities.network.NetworkAttachment;
import org.ovirt.engine.core.common.businessentities.network.NetworkBootProtocol;
import org.ovirt.engine.core.common.businessentities.network.NetworkCluster;
import org.ovirt.engine.core.common.businessentities.network.NetworkClusterId;
import org.ovirt.engine.core.common.businessentities.network.VdsNetworkInterface;
import org.ovirt.engine.core.common.errors.EngineMessage;
import org.ovirt.engine.core.common.utils.PluralMessages;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.core.dao.VdsDao;
import org.ovirt.engine.core.dao.VmDao;
import org.ovirt.engine.core.dao.network.NetworkClusterDao;
import org.ovirt.engine.core.dao.network.NetworkDao;
import org.ovirt.engine.core.utils.ReplacementUtils;


public class NetworkAttachmentValidator {

    public static final String VAR_ACTION_TYPE_FAILED_ROLE_NETWORK_HAS_NO_BOOT_PROTOCOL_ENTITY = "ACTION_TYPE_FAILED_ROLE_NETWORK_HAS_NO_BOOT_PROTOCOL_ENTITY";
    public static final String VAR_ACTION_TYPE_FAILED_NETWORK_ADDRESS_CANNOT_BE_CHANGED_LIST = "ACTION_TYPE_FAILED_NETWORK_ADDRESS_CANNOT_BE_CHANGED_LIST";
    public static final String VAR_NETWORK_ATTACHMENT_ID = "networkAttachmentID";

    private final VdsDao vdsDao;
    private final NetworkDao networkDao;
    private final NetworkClusterDao networkClusterDao;
    private final VmInterfaceManager vmInterfaceManager;
    private final VmDao vmDao;

    private final NetworkAttachment attachment;
    private final VDS host;
    private Network network;

    private NetworkCluster networkCluster;
    private NetworkValidator networkValidator;

    public NetworkAttachmentValidator(NetworkAttachment attachment,
            VDS host,
            VmInterfaceManager vmInterfaceManager,
            NetworkClusterDao networkClusterDao,
            NetworkDao networkDao,
            VdsDao vdsDao,
            VmDao vmDao) {

        this.attachment = attachment;
        this.host = host;
        this.vmInterfaceManager = vmInterfaceManager;
        this.networkClusterDao = networkClusterDao;
        this.networkDao = networkDao;
        this.vdsDao = vdsDao;
        this.vmDao = vmDao;
    }

    public ValidationResult networkAttachmentIsSet() {
        EngineMessage engineMessage = EngineMessage.NETWORK_ATTACHMENT_NOT_EXISTS;
        return ValidationResult.failWith(engineMessage,
            ReplacementUtils.getVariableAssignmentString(engineMessage, null))
            .when(attachment == null);
    }

    public ValidationResult networkExists() {
        Guid networkId = attachment.getNetworkId();
        String networkName = attachment.getNetworkName();

        /*
         * following code relies on fact, that completors were ran and fixed the user input, so we need to consider
         * what original user input looked like, and how it was altered by completors.
         */

        // User did not specify neither id nor name.
        if (networkId ==null && networkName == null) {
            return new ValidationResult(EngineMessage.NETWORK_ATTACHMENT_NETWORK_ID_OR_NAME_IS_NOT_SET);
        }

        // User specified id, for which completors did not find Network record.
        if (networkId != null && networkName == null) {
            EngineMessage engineMessage = EngineMessage.NETWORK_HAVING_ID_NOT_EXISTS;
            return new ValidationResult(engineMessage,
                    ReplacementUtils.getVariableAssignmentString(engineMessage, networkId.toString()));
        }

        // User specified name, for which completors did not find Network record.
        if (networkId == null && networkName != null) {
            EngineMessage engineMessage = EngineMessage.NETWORK_HAVING_NAME_NOT_EXISTS;
            return new ValidationResult(engineMessage,
                    ReplacementUtils.getVariableAssignmentString(engineMessage, networkName));
        }

        return ValidationResult.VALID;
    }

    public ValidationResult networkNotUsedByVms() {
        return networkNotUsedByVms(getNetwork().getName());
    }

    private ValidationResult networkNotUsedByVms(String networkName) {

        if (FeatureSupported.changeNetworkUsedByVmSupported(host.getClusterCompatibilityVersion())) {
            return ValidationResult.VALID;
        }

        List<String> vmNames =
                vmInterfaceManager.findActiveVmsUsingNetworks(host.getId(), Collections.singleton(networkName));

        return new PluralMessages().getNetworkInUse(vmNames,
                EngineMessage.VAR__ENTITIES__VM,
                EngineMessage.VAR__ENTITIES__VMS);
    }

    public ValidationResult notExternalNetwork() {
        EngineMessage engineMessage = EngineMessage.EXTERNAL_NETWORK_HAVING_NAME_CANNOT_BE_PROVISIONED;
        return ValidationResult.failWith(engineMessage,
            ReplacementUtils.getVariableAssignmentString(engineMessage, getNetwork().getName()))

            .when(getNetwork().isExternal());
    }

    public ValidationResult notRemovingManagementNetwork() {
        return getNetworkValidator().notRemovingManagementNetwork();
    }

    public ValidationResult networkAttachedToCluster() {
        EngineMessage engineMessage = EngineMessage.NETWORK_OF_GIVEN_NAME_NOT_EXISTS_IN_CLUSTER;
        return ValidationResult.failWith(engineMessage,
            ReplacementUtils.getVariableAssignmentString(engineMessage, this.attachment.getNetworkName()))
            .when(getNetworkCluster() == null);
    }

    public ValidationResult bootProtocolSetForRoleNetwork() {
        IpConfiguration ipConfiguration = attachment.getIpConfiguration();
        boolean failWhen = isRoleNetwork() &&
                (ipConfiguration == null
                        || !ipConfiguration.hasPrimaryAddressSet()
                        || ipConfiguration.getPrimaryAddress().getBootProtocol() == NetworkBootProtocol.NONE);

        return ValidationResult.failWith(EngineMessage.ACTION_TYPE_FAILED_ROLE_NETWORK_HAS_NO_BOOT_PROTOCOL,
                ReplacementUtils.createSetVariableString(
                        VAR_ACTION_TYPE_FAILED_ROLE_NETWORK_HAS_NO_BOOT_PROTOCOL_ENTITY,
                        getNetwork().getName()))
                .when(failWhen);
    }

    protected boolean isRoleNetwork() {
        return getNetworkCluster().isDisplay() ||
                getNetworkCluster().isMigration() ||
                getNetworkCluster().isGluster();
    }

    public ValidationResult nicNameIsSet() {
        return ValidationResult.failWith(EngineMessage.HOST_NETWORK_INTERFACE_DOES_NOT_HAVE_NAME_SET)
                .when(attachment.getNicName() == null && attachment.getNicId() == null);
    }

    /**
     * Checks if a network is configured incorrectly:
     * <ul>
     * <li>If the host was added to the system using its IP address as the computer name for the certification creation,
     * it is forbidden to modify the IP address without reinstalling the host.</li>
     * </ul>
     */
    public ValidationResult networkIpAddressWasSameAsHostnameAndChanged(BusinessEntityMap<VdsNetworkInterface> existingInterfaces) {
        IpConfiguration ipConfiguration = attachment.getIpConfiguration();
        if (ipConfiguration != null
                && ipConfiguration.hasPrimaryAddressSet()
                && ipConfiguration.getPrimaryAddress().getBootProtocol() == NetworkBootProtocol.STATIC_IP) {
            VdsNetworkInterface existingIface = existingInterfaces.get(attachment.getNicName());
            if (existingIface != null) {
                String oldAddress = existingIface.getAddress();
                return ValidationResult.failWith(EngineMessage.ACTION_TYPE_FAILED_NETWORK_ADDRESS_CANNOT_BE_CHANGED,
                    ReplacementUtils.createSetVariableString(
                        VAR_ACTION_TYPE_FAILED_NETWORK_ADDRESS_CANNOT_BE_CHANGED_LIST,
                        getNetwork().getName()))
                    .when(StringUtils.equals(oldAddress, host.getHostName())
                            && !StringUtils.equals(oldAddress, ipConfiguration.getPrimaryAddress().getAddress()));

            }
        }

        return ValidationResult.VALID;
    }

    public ValidationResult networkNotChanged(NetworkAttachment oldAttachment) {
        Guid oldAttachmentId = oldAttachment == null ? null : oldAttachment.getId();
        boolean when = oldAttachment != null &&
            !Objects.equals(oldAttachment.getNetworkId(), attachment.getNetworkId());
        return ValidationResult.failWith(EngineMessage.CANNOT_CHANGE_ATTACHED_NETWORK,
            ReplacementUtils.createSetVariableString(VAR_NETWORK_ATTACHMENT_ID, oldAttachmentId))

            .when(when);
    }

    public ValidationResult networkNotAttachedToHost() {
        return ValidationResult.failWith(EngineMessage.NETWORK_ALREADY_ATTACHED_TO_HOST,
            ReplacementUtils.createSetVariableString("networkName", getNetwork().getName()),
            ReplacementUtils.createSetVariableString("hostName", host.getName())).when(networkAttachedToHost());

    }

    private boolean networkAttachedToHost() {
        List<VDS> hostsAttachedToNetwork = vdsDao.getAllForNetwork(attachment.getNetworkId());
        for (VDS hostAttachedToNetwork : hostsAttachedToNetwork) {
            if (hostAttachedToNetwork.getId().equals(host.getId())) {
                return true;
            }
        }

        return false;
    }

    protected Network getNetwork() {
        if (network == null) {
            network = networkDao.get(attachment.getNetworkId());
        }

        return network;
    }

    NetworkValidator getNetworkValidator() {
        if (networkValidator == null) {
            networkValidator = new NetworkValidator(vmDao, getNetwork());
        }

        return networkValidator;
    }

    private NetworkCluster getNetworkCluster() {
        if (networkCluster == null) {
            NetworkClusterId networkClusterId = new NetworkClusterId(host.getClusterId(), attachment.getNetworkId());
            networkCluster = networkClusterDao.get(networkClusterId);
        }

        return networkCluster;
    }
}
