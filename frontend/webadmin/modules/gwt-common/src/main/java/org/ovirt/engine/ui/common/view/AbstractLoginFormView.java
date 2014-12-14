package org.ovirt.engine.ui.common.view;

import java.util.Arrays;

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.ListBox;
import org.ovirt.engine.ui.common.CommonApplicationResources;
import org.ovirt.engine.ui.common.idhandler.WithElementId;
import org.ovirt.engine.ui.common.utils.VisibleLocalesInfoData;
import org.ovirt.engine.ui.common.widget.HasUiCommandClickHandlers;
import org.ovirt.engine.ui.common.widget.PatternflyUiCommandButton;
import org.ovirt.engine.ui.frontend.utils.FrontendUrlUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Ignore;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Base implementation of the login form.
 */
public abstract class AbstractLoginFormView extends AbstractView {

    interface MotdAnchorTemplate extends SafeHtmlTemplates {
        @Template("<a href=\"{0}\" target=\"blank\">{1}</a>")
        SafeHtml anchor(String url, String text);
    }

    private static final String DEFAULT_LOCALE = "default"; //$NON-NLS-1$

    private static MotdAnchorTemplate template;

    @UiField(provided = true)
    @Ignore
    @WithElementId("localeBox")
    public ListBox localeBox;

    @UiField
    public FocusPanel loginForm;

    @UiField
    @Path("userName.entity")
    @WithElementId("userName")
    public Input userNameEditor;

    @UiField
    @Path("password.entity")
    @WithElementId("password")
    public Input passwordEditor;

    @UiField
    @Path("profile.selectedItem")
    @WithElementId("profile")
    public ListBox profileEditor;

    @UiField
    @WithElementId
    public PatternflyUiCommandButton loginButton;

    @UiField
    @Ignore
    public Label errorMessage;

    @UiField
    @Ignore
    public Alert errorMessagePanel;

    @UiField
    @Ignore
    public HTMLPanel informationMessagePanel;

    public AbstractLoginFormView(EventBus eventBus,
            CommonApplicationResources resources) {
        initLocalizationEditor();
    }

    protected void setStyles() {
        errorMessagePanel.setVisible(false);
        informationMessagePanel.setVisible(false);
    }

    private void initLocalizationEditor() {
        localeBox = new ListBox();

        // Add the option to change the locale
        String currentLocale = LocaleInfo.getCurrentLocale().getLocaleName();
        String[] localeNames = LocaleInfo.getAvailableLocaleNames();
        localeNames = VisibleLocalesInfoData.instance().getFilteredLocaleNames(Arrays.asList(localeNames));

        // Populate the locale list box with available locales
        boolean foundDefaultLocale = false;
        for (String localeName : localeNames) {
            if (!DEFAULT_LOCALE.equals(localeName)) {
                String nativeName = LocaleInfo.getLocaleNativeDisplayName(localeName);
                localeBox.addItem(nativeName, localeName);

                if (localeName.equals(currentLocale)) {
                    setSelectedLocale(localeBox.getItemCount() - 1);
                    foundDefaultLocale = true;
                }
            }
        }

        // When no available locale matches the current locale, select the first available locale
        if (!foundDefaultLocale && localeNames.length > 0) {
            setSelectedLocale(0);
        }

        localeBox.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                String localeQueryParam = LocaleInfo.getLocaleQueryParam();
                String localeString = "?" + localeQueryParam + "=" + localeBox.getValue(localeBox.getSelectedIndex()); //$NON-NLS-1$ //$NON-NLS-2$
                Window.open(FrontendUrlUtils.getCurrentPageURL() + localeString, "_self", ""); //$NON-NLS-1$ //$NON-NLS-2$
            }
        });
    }

    void setSelectedLocale(int index) {
        localeBox.setSelectedIndex(index);
    }

    MotdAnchorTemplate getTemplate() {
        if (template == null) {
            template = GWT.create(MotdAnchorTemplate.class);
        }
        return template;
    }

    protected void setErrorMessageLabel(Label errorMessage, SafeHtml text) {
        if (text != null) {
            errorMessage.getElement().setInnerSafeHtml(text);
        } else {
            errorMessage.getElement().setInnerHTML(null);
        }
    }

    public String getMotdAnchorHtml(String url) {
        return getTemplate().anchor(url, url).asString();
    }

    public void clearErrorMessage() {
        setErrorMessageHtml(null);
        errorMessagePanel.setVisible(false);
    }

    public void setErrorMessageHtml(SafeHtml text) {
        setErrorMessageLabel(errorMessage, text);
        errorMessage.setVisible(text != null);
        if (errorMessage.isVisible()) {
            errorMessagePanel.setVisible(true);
        }
    }

    public void resetAndFocus() {
        clearErrorMessage();
    }

    public HasUiCommandClickHandlers getLoginButton() {
        return loginButton;
    }

    public HasKeyPressHandlers getLoginForm() {
        return loginForm;
    }

    public Input getUserNameEditor() {
        return userNameEditor;
    }

    public Input getPasswordEditor() {
        return passwordEditor;
    }

    public ListBox getProfileEditor() {
        return profileEditor;
    }
}
