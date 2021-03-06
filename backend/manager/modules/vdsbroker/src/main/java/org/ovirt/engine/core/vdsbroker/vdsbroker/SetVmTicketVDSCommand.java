package org.ovirt.engine.core.vdsbroker.vdsbroker;

import java.util.HashMap;
import java.util.Map;

import org.ovirt.engine.core.common.FeatureSupported;
import org.ovirt.engine.core.common.vdscommands.SetVmTicketVDSCommandParameters;
import org.ovirt.engine.core.dal.dbbroker.DbFacade;

public class SetVmTicketVDSCommand<P extends SetVmTicketVDSCommandParameters> extends VdsBrokerCommand<P> {

    private String connectionAction = "disconnect";

    public SetVmTicketVDSCommand(P parameters) {
        super(parameters, DbFacade.getInstance().getVdsDao().get(parameters.getVdsId()));
    }

    @Override
    protected void executeVdsBrokerCommand() {
        if (FeatureSupported.graphicsDeviceEnabled(getVds().getClusterCompatibilityVersion())) {
            setTicketUsingUpdateDevice();
        } else {
            setTicketLegacy();
        }

        proceedProxyReturnValue();
    }

    private void setTicketLegacy() {
        status = getBroker().setVmTicket(getParameters().getVmId().toString(), getParameters().getTicket(),
                String.valueOf(getParameters().getValidTime()), connectionAction, getUidParams());
    }

    /**
     * Sets console ticket using updateDevice command. This is used in VDSMs that support graphics framebuffer
     * as a device.
     */
    private void setTicketUsingUpdateDevice() {
        Map<String, Object> devStruct = new HashMap<>();

        devStruct.put("deviceType", "graphics");
        devStruct.put("graphicsType", getParameters().getGraphicsType().name().toLowerCase());
        devStruct.put("password", getParameters().getTicket());
        devStruct.put("ttl", getParameters().getValidTime());
        devStruct.put("existingConnAction", connectionAction);
        devStruct.put("disconnectAction", getParameters().getDisconnectAction());
        devStruct.put("params", getUidParams());

        status = getBroker().vmUpdateDevice(getParameters().getVmId().toString(), devStruct);
    }

    private Map<String, String> getUidParams() {
        Map<String, String> params = new HashMap<>();
        params.put("userName", getParameters().getUserName());
        params.put("userId", getParameters().getUserId().toString());
        return params;
    }

}
