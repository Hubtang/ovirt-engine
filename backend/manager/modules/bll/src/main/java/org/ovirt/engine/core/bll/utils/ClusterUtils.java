package org.ovirt.engine.core.bll.utils;

import java.util.List;
import java.util.Random;

import org.ovirt.engine.core.common.businessentities.VDS;
import org.ovirt.engine.core.common.businessentities.VDSStatus;
import org.ovirt.engine.core.common.businessentities.VM;
import org.ovirt.engine.core.common.businessentities.VmBase;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.core.compat.Version;
import org.ovirt.engine.core.dal.dbbroker.DbFacade;
import org.ovirt.engine.core.dao.ClusterDao;
import org.ovirt.engine.core.dao.VdsDao;

public class ClusterUtils {

    private static ClusterUtils instance = new ClusterUtils();

    public static ClusterUtils getInstance() {
        return instance;
    }

    /**
     * Returns a server that is in {@link VDSStatus#Up} status.<br>
     * This server is chosen randomly from all the Up servers.
     *
     * @return One of the servers in up status
     */
    public VDS getRandomUpServer(Guid clusterId) {
        List<VDS> servers = getAllUpServers(clusterId);
        if (servers == null || servers.isEmpty()) {
            return null;
        }
        return servers.get(new Random().nextInt(servers.size()));
    }

    /**
     * Returns a server that is in {@link VDSStatus#Up} status.<br>
     * This server is returned as first from list of the Up servers.
     *
     * @return One of the servers in up status
     */
    public VDS getUpServer(Guid clusterId) {
        List<VDS> servers = getAllUpServers(clusterId);
        if (servers == null || servers.isEmpty()) {
            return null;
        }
        return servers.get(0);
    }

    public List<VDS> getAllUpServers(Guid clusterId) {
        return getVdsDao().getAllForClusterWithStatus(clusterId, VDSStatus.Up);
    }

    public List<VDS> getAllServers(Guid clusterId) {
        return getVdsDao().getAllForCluster(clusterId);
    }

    public boolean hasMultipleServers(Guid clusterId) {
        return getServerCount(clusterId) > 1;
    }

    public boolean hasServers(Guid clusterId) {
        return getServerCount(clusterId) > 0;
    }

    public int getServerCount(Guid clusterId) {
        return getVdsDao().getAllForCluster(clusterId).size();
    }

    public VdsDao getVdsDao() {
        return DbFacade.getInstance()
                .getVdsDao();
    }

    public static Version getCompatibilityVersion(VM vm) {
        return getCompatibilityVersion(vm.getStaticData());
    }

    public static Version getCompatibilityVersion(VmBase vmBase) {
        return vmBase.getClusterId() != null ?
                getInstance().getClusterDao().get(vmBase.getClusterId()).getCompatibilityVersion()
                : Version.v3_5;
    }

    public ClusterDao getClusterDao() {
        return DbFacade.getInstance().getClusterDao();
    }
}
