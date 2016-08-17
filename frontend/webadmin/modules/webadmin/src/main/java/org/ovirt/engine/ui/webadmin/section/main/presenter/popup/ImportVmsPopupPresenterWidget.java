package org.ovirt.engine.ui.webadmin.section.main.presenter.popup;

import org.ovirt.engine.ui.common.presenter.AbstractModelBoundPopupPresenterWidget;
import org.ovirt.engine.ui.uicommonweb.models.vms.ImportVmsModel;
import org.ovirt.engine.ui.uicompat.Event;
import org.ovirt.engine.ui.uicompat.EventArgs;
import org.ovirt.engine.ui.uicompat.IEventListener;
import org.ovirt.engine.ui.uicompat.PropertyChangedEventArgs;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.inject.Inject;

public class ImportVmsPopupPresenterWidget extends AbstractModelBoundPopupPresenterWidget<ImportVmsModel, ImportVmsPopupPresenterWidget.ViewDef> {

    public interface ViewDef extends AbstractModelBoundPopupPresenterWidget.ViewDef<ImportVmsModel> {

        HasEnabled getLoadVmsFromExportDomainButton();

        HasEnabled getLoadVmsFromVmwareButton();

        HasEnabled getLoadOvaButton();
    }

    @Inject
    public ImportVmsPopupPresenterWidget(EventBus eventBus, ViewDef view) {
        super(eventBus, view);
    }

    @Override
    public void init(final ImportVmsModel model) {
        super.init(model);
        addDataCenterListener();
        addImportSourceListener();
        updateExportDomainLoadButtonEnabledState();
    }

    private void addImportSourceListener() {
        getModel().getImportSources().getSelectedItemChangedEvent().addListener(new IEventListener<EventArgs>() {
            @Override
            public void eventRaised(Event<? extends EventArgs> ev, Object sender, EventArgs args) {
                updateExportDomainLoadButtonEnabledState();
            }
        });
    }

    private void addDataCenterListener() {
        getModel().getDataCenters().getPropertyChangedEvent().addListener(new IEventListener<PropertyChangedEventArgs>() {
            @Override
            public void eventRaised(Event<? extends PropertyChangedEventArgs> ev,
                    Object sender,
                    PropertyChangedEventArgs args) {
                if ("IsChangable".equals(args.propertyName)) { //$NON-NLS-1$
                    final boolean enabled = getModel().getDataCenters().getIsChangable();
                    updateExportDomainLoadButtonEnabledState();
                    getView().getLoadVmsFromVmwareButton().setEnabled(enabled);
                    getView().getLoadOvaButton().setEnabled(enabled);
                }
            }
        });

    }

    private void updateExportDomainLoadButtonEnabledState() {
        getModel().getProblemDescription().getEntityChangedEvent().addListener(new IEventListener<EventArgs>() {
            @Override
            public void eventRaised(org.ovirt.engine.ui.uicompat.Event<? extends EventArgs> ev, Object object, EventArgs args) {
                final boolean enabled = getModel().getExportDomain() != null && getModel().getDataCenters().getIsChangable();
                getView().getLoadVmsFromExportDomainButton().setEnabled(enabled);
            }
        });
    }
}
