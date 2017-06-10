package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces;

/**
 * Class to represent custom web element as divs, spans etc.
 * <p>
 * Determines the main functionality for the Custom control.
 *
 * @author Danil Zhyliaiev
 */
public interface Custom {

    void click();

    void clear();

    void submit();

    boolean isSelected();

    boolean isEnabled();

    boolean isDisplayed();

    String getText();

    String getAttributeValue (String attribute);

    void sendKeys(String text);
}
