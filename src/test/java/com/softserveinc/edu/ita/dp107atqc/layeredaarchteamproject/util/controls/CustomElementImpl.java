package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;


import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Custom;

/**
 * Class to represent custom div and elements.
 * <p>
 * implementation of the Custom control for the web API.
 *
 * @author Danil Zhyliaiev
 */
public class CustomElementImpl implements Custom {

    private ControlWrapper control;

    protected CustomElementImpl(final ControlWrapper controlToWrap) {
        control = controlToWrap;
    }


    public static Custom getById(final String id) {
        return get(ControlLocation.getById(id));
    }


    public static Custom getByName(final String searchedName) {
        return get(ControlLocation.getByName(searchedName));
    }


    public static Custom getByLinkText(final String linkText) {
        return get(ControlLocation.getByLinkText(linkText));
    }


    public static Custom getByXpath(final String xpathExpression) {
        return get(ControlLocation.getByXPath(xpathExpression));
    }


    public static Custom getByCss(final String cssSelector) {
        return get(ControlLocation.getByCss(cssSelector));
    }


    private static Custom get(final ControlLocation controlLocation) {
        return new CustomElementImpl(new ControlWrapper(ContextVisible.get()
                .get(controlLocation)));
    }

    @Override
    public final void click() {
        control.click();
    }

    @Override
    public final void clear() {
        control.clear();
    }

    @Override
    public final void submit() {
        control.submit();
    }

    @Override
    public final boolean isSelected() {
        return control.isSelected();
    }

    @Override
    public final boolean isEnabled() {
        return control.isEnabled();
    }

    @Override
    public final boolean isDisplayed() {
        return control.isDisplayed();
    }

    @Override
    public final String getText() {
        return control.getText();
    }

    @Override
    public String getAttributeValue(String attribute) {
        return control.getAttribute(attribute);
    }

    @Override
    public final void sendKeys(final String text) {
        control.sendText(text);
    }
}
