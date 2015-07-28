package org.ovirt.engine.ui.webadmin.section.main.view.tab.host;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import org.ovirt.engine.core.common.businessentities.HostDeviceView;
import org.ovirt.engine.core.common.businessentities.VDS;
import org.ovirt.engine.ui.common.CommonApplicationConstants;
import org.ovirt.engine.ui.common.idhandler.ElementIdHandler;
import org.ovirt.engine.ui.common.system.ClientStorage;
import org.ovirt.engine.ui.common.uicommon.model.SearchableDetailModelProvider;
import org.ovirt.engine.ui.common.view.AbstractSubTabTableWidgetView;
import org.ovirt.engine.ui.uicommonweb.models.hosts.HostListModel;
import org.ovirt.engine.ui.uicommonweb.models.vms.hostdev.HostDeviceListModel;
import org.ovirt.engine.ui.webadmin.section.main.presenter.tab.host.SubTabHostDevicePresenter;

public class SubTabHostDeviceView
        extends AbstractSubTabTableWidgetView<VDS, HostDeviceView, HostListModel, HostDeviceListModel>
        implements SubTabHostDevicePresenter.ViewDef {

    interface ViewIdHandler extends ElementIdHandler<SubTabHostDeviceView> {
        ViewIdHandler idHandler = GWT.create(ViewIdHandler.class);
    }

    @Inject
    public SubTabHostDeviceView(
            SearchableDetailModelProvider<HostDeviceView, HostListModel, HostDeviceListModel> modelProvider,
            EventBus eventBus, ClientStorage clientStorage) {
        super(new HostDeviceModelTable(modelProvider, eventBus, clientStorage));
        ViewIdHandler.idHandler.generateAndSetIds(this);
        CommonApplicationConstants constants = GWT.create(CommonApplicationConstants.class);
        initTable(constants);
        initWidget(getModelBoundTableWidget());
    }
}
