package org.ovirt.engine.api.restapi.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.ovirt.engine.api.model.Cluster;
import org.ovirt.engine.api.model.Network;
import org.ovirt.engine.api.resource.AssignedNetworkResource;
import org.ovirt.engine.api.resource.AssignedNetworksResource;
import org.ovirt.engine.core.common.action.AttachNetworkToVdsGroupParameter;
import org.ovirt.engine.core.common.action.VdcActionParametersBase;
import org.ovirt.engine.core.common.action.VdcActionType;
import org.ovirt.engine.core.common.businessentities.VDSGroup;
import org.ovirt.engine.core.common.queries.IdQueryParameters;
import org.ovirt.engine.core.common.queries.VdcQueryParametersBase;
import org.ovirt.engine.core.common.queries.VdcQueryType;
import org.ovirt.engine.core.compat.NGuid;

public class BackendClusterNetworksResource
    extends AbstractBackendNetworksResource
    implements AssignedNetworksResource {

    private String clusterId;

    public BackendClusterNetworksResource(String clusterId) {
        super(VdcQueryType.GetAllNetworksByClusterId,
              VdcActionType.AttachNetworkToVdsGroup,
              VdcActionType.DetachNetworkToVdsGroup);
        this.clusterId = clusterId;
    }

    @Override
    public Response add(Network network) {
        validateParameters(network, "id|name");

        String networkName = null;
        if (network.isSetId()) {
            org.ovirt.engine.core.common.businessentities.network.Network net =
                    getNetworkById(network.getId(), clusterId);
            if (net == null) {
                notFound(Network.class);
            } else {
                networkName = net.getName();
            }
        }

        String networkId = null;
        if (network.isSetName()) {
            org.ovirt.engine.core.common.businessentities.network.Network net =
                    getNetworkByName(network.getName(), clusterId);
            if (net == null) {
                notFound(Network.class);
            } else {
                networkId = net.getId().toString();
            }
        }

        if (!network.isSetId()) {
            network.setId(networkId);
        } else if (network.isSetName() && !network.getId().equals(networkId)) {
            badRequest("Network ID provided does not match the ID for network with name: " + network.getName());
        }

        org.ovirt.engine.core.common.businessentities.network.Network entity = map(network);
        return performCreate(addAction,
                               getActionParameters(network, entity),
                               new NetworkIdResolver(StringUtils.defaultIfEmpty(network.getName(), networkName)));
    }

    private org.ovirt.engine.core.common.businessentities.network.Network getNetworkById(String networkId, String clusterId) {
        for (org.ovirt.engine.core.common.businessentities.network.Network network : getNetworks(clusterId)) {
            if (network.getId().toString().equals(networkId)) {
                return network;
            }
        }
        return null;
    }

    private org.ovirt.engine.core.common.businessentities.network.Network getNetworkByName(String networkName,
            String clusterId) {
        for (org.ovirt.engine.core.common.businessentities.network.Network network : getNetworks(clusterId)) {
            if (network.getName().equals(networkName)) {
                return network;
            }
        }
        return null;
    }

    @Override
    protected VdcQueryParametersBase getQueryParameters() {
        return new IdQueryParameters(asGuid(clusterId));
    }

    @Override
    protected VdcActionParametersBase getActionParameters(Network network, org.ovirt.engine.core.common.businessentities.network.Network entity) {
        return new AttachNetworkToVdsGroupParameter(getVDSGroup(), entity);
    }

    protected String[] getRequiredAddFields() {
        return new String[] { "id" };
    }

    @Override
    public Network addParents(Network network) {
        network.setCluster(new Cluster());
        network.getCluster().setId(clusterId);
        return network;
    }

    protected VDSGroup getVDSGroup() {
        return getEntity(VDSGroup.class,
                         VdcQueryType.GetVdsGroupByVdsGroupId,
                         new IdQueryParameters(asGuid(clusterId)),
                         clusterId);
    }

    @Override
    @SingleEntityResource
    public AssignedNetworkResource getAssignedNetworkSubResource(String id) {
        return inject(new BackendClusterNetworkResource(id, this));
    }

    private List<org.ovirt.engine.core.common.businessentities.network.Network> getNetworks(String clusterId) {
        NGuid dataCenterId =
                getEntity(VDSGroup.class,
                        VdcQueryType.GetVdsGroupById,
                        new IdQueryParameters(asGuid(clusterId)),
                        null).getStoragePoolId();
        IdQueryParameters params = new IdQueryParameters(asGuid(dataCenterId));
        return getBackendCollection(VdcQueryType.GetAllNetworks, params);
    }

    @Override
    protected Network doPopulate(Network model, org.ovirt.engine.core.common.businessentities.network.Network entity) {
        return model;
    }
}
