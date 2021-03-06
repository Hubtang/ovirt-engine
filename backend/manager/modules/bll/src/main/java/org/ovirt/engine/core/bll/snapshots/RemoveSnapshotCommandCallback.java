package org.ovirt.engine.core.bll.snapshots;

import java.util.List;

import org.ovirt.engine.core.bll.job.ExecutionHandler;
import org.ovirt.engine.core.bll.tasks.CommandCoordinatorUtil;
import org.ovirt.engine.core.bll.tasks.interfaces.CommandCallback;
import org.ovirt.engine.core.common.action.RemoveSnapshotParameters;
import org.ovirt.engine.core.compat.CommandStatus;
import org.ovirt.engine.core.compat.Guid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveSnapshotCommandCallback extends CommandCallback {
    private static final Logger log = LoggerFactory.getLogger(RemoveSnapshotCommandCallback.class);

    @Override
    public void doPolling(Guid cmdId, List<Guid> childCmdIds) {

        boolean anyFailed = false;
        for (Guid childCmdId : childCmdIds) {
            switch (CommandCoordinatorUtil.getCommandStatus(childCmdId)) {
            case NOT_STARTED:
            case ACTIVE:
                log.info("Waiting on Live Merge child commands to complete");
                return;
            case ENDED_WITH_FAILURE:
            case FAILED:
            case EXECUTION_FAILED:
            case UNKNOWN:
                anyFailed = true;
                break;
            default:
                break;
            }
        }

        RemoveSnapshotCommand<RemoveSnapshotParameters> command = getCommand(cmdId);
        command.getParameters().setTaskGroupSuccess(!anyFailed);
        command.setCommandStatus(anyFailed ? CommandStatus.FAILED : CommandStatus.SUCCEEDED);
        log.info("All Live Merge child commands have completed, status '{}'",
                command.getCommandStatus());
    }

    @Override
    public void onSucceeded(Guid cmdId, List<Guid> childCmdIds) {
        endAction(cmdId, true);
    }

    @Override
    public void onFailed(Guid cmdId, List<Guid> childCmdIds) {
        endAction(cmdId, false);
    }

    private void endAction(Guid commandId, boolean succeeded) {
        RemoveSnapshotCommand<RemoveSnapshotParameters> command = getCommand(commandId);
        command.endAction();
        CommandCoordinatorUtil.removeAllCommandsInHierarchy(commandId);
        ExecutionHandler.endJob(command.getExecutionContext(), succeeded);
    }

    private RemoveSnapshotCommand<RemoveSnapshotParameters> getCommand(Guid cmdId) {
        return CommandCoordinatorUtil.retrieveCommand(cmdId);
    }
}
