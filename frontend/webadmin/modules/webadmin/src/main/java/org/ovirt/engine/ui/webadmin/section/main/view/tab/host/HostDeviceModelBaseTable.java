package org.ovirt.engine.ui.webadmin.section.main.view.tab.host;

import com.google.gwt.event.shared.EventBus;
import org.ovirt.engine.core.common.businessentities.HostDeviceView;
import org.ovirt.engine.ui.common.CommonApplicationConstants;
import org.ovirt.engine.ui.common.system.ClientStorage;
import org.ovirt.engine.ui.common.uicommon.model.SearchableTableModelProvider;
import org.ovirt.engine.ui.common.widget.table.column.TextColumnWithTooltip;
import org.ovirt.engine.ui.common.widget.uicommon.AbstractModelBoundTableWidget;
import org.ovirt.engine.ui.uicommonweb.models.vms.hostdev.HostDeviceListModelBase;
import org.ovirt.engine.ui.webadmin.section.main.view.popup.vm.HostDeviceColumnHelper;

public abstract class HostDeviceModelBaseTable<M extends HostDeviceListModelBase> extends AbstractModelBoundTableWidget<HostDeviceView, M> {

    public HostDeviceModelBaseTable(SearchableTableModelProvider<HostDeviceView, M> modelProvider, EventBus eventBus, ClientStorage clientStorage) {
        super(modelProvider, eventBus, clientStorage, false);
    }

    @Override
    public void initTable(final CommonApplicationConstants constants) {

        getTable().enableColumnResizing();

        addColumn(constants.deviceName(), "200px", new TextColumnWithTooltip<HostDeviceView>() { //$NON-NLS-1$
            @Override
            public String getValue(HostDeviceView object) {
                return object.getDeviceName();
            }
        });
        addColumn(constants.capability(), "130px", new TextColumnWithTooltip<HostDeviceView>() { //$NON-NLS-1$
            @Override
            public String getValue(HostDeviceView object) {
                return object.getCapability();
            }
        });
        addColumn(constants.product(), "350px", new TextColumnWithTooltip<HostDeviceView>() { //$NON-NLS-1$
            @Override
            public String getValue(HostDeviceView object) {
                return HostDeviceColumnHelper.renderNameId(object.getProductName(), object.getProductId());
            }
        });
        addColumn(constants.vendor(), "200px", new TextColumnWithTooltip<HostDeviceView>() { //$NON-NLS-1$
            @Override
            public String getValue(HostDeviceView object) {
                return HostDeviceColumnHelper.renderNameId(object.getVendorName(), object.getVendorId());
            }
        });
        addColumn(constants.currentlyUsedByVm(), "150px", new TextColumnWithTooltip<HostDeviceView>() { //$NON-NLS-1$
            @Override
            public String getValue(HostDeviceView object) {
                return object.getRunningVmName();
            }
        });
        addColumn(constants.attachedToVms(), "150px", new TextColumnWithTooltip<HostDeviceView>() { //$NON-NLS-1$
            @Override
            public String getValue(HostDeviceView object) {
                return HostDeviceColumnHelper.renderVmNamesList(object.getAttachedVmNames());
            }
        });
        addColumn(constants.iommuGroup(), "150px", new TextColumnWithTooltip<HostDeviceView>() { //$NON-NLS-1$
            @Override
            public String getValue(HostDeviceView object) {
                return HostDeviceColumnHelper.renderIommuGroup(object.getIommuGroup());
            }
        });
    }

    private void addColumn(String header, String width, TextColumnWithTooltip<HostDeviceView> column) {
        column.makeSortable();
        getTable().addColumn(column, header, width);
    }
}
