package org.ovirt.engine.core.bll.scheduling.policyunits;

import org.ovirt.engine.core.bll.hostdev.HostDeviceManager;
import org.ovirt.engine.core.bll.scheduling.PolicyUnitImpl;
import org.ovirt.engine.core.common.businessentities.VDS;
import org.ovirt.engine.core.common.businessentities.VM;
import org.ovirt.engine.core.common.errors.VdcBllMessages;
import org.ovirt.engine.core.common.scheduling.PerHostMessages;
import org.ovirt.engine.core.common.scheduling.PolicyUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Filters hosts based on the passthroughSupported flag when the VM requires hostdev passthrough
 */
public class HostDeviceFilterPolicyUnit extends PolicyUnitImpl {

    private static final Logger log = LoggerFactory.getLogger(HostDeviceFilterPolicyUnit.class);

    private HostDeviceManager hostDeviceManager;

    public HostDeviceFilterPolicyUnit(PolicyUnit policyUnit) {
        super(policyUnit);
        hostDeviceManager = HostDeviceManager.getInstance();
    }

    @Override
    public List<VDS> filter(List<VDS> hosts, VM vm, Map<String, String> parameters, PerHostMessages messages) {

        // noop if VM does not require host devices
        if (!hostDeviceManager.checkVmNeedsDirectPassthrough(vm)) {
            return hosts;
        }

        List<VDS> list = new ArrayList<>();
        for (VDS host : hosts) {
            if (host.isHostDevicePassthroughEnabled()) {
                list.add(host);
            } else {
                messages.addMessage(host.getId(), VdcBllMessages.VAR__DETAIL__HOSTDEV_DISABLED.toString());
                log.debug("Host '{}' does not support host device passthrough", host.getName());
            }
        }

        return list;
    }
}
