package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.SelectWrapper;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to wrap a list of WebElement's with list of ControlWrapper's
 * or optionally list of SelectWrapper's.
 *
 * @author Danil Zhyliaiev
 */
public class ControlListWrapper {
    /**
     * wrapped list of controls.
     */
    private List<ControlWrapper> controls;
    /**
     * wrapped list of webElements.
     */
    private List<WebElement> webElements;
    /**
     * wrapped list of selects.
     */
    private List<SelectWrapper> selects;

    /**
     * Constructor.
     * Initialize the controls and webElements fields.
     * Wraps the income webElements with the ControlWrapper and
     * collects it into an ArrayList.
     *
     * @param webElementsToWrap - List&#60WebElement> webElements to wrap
     */
    public ControlListWrapper(final List<WebElement> webElementsToWrap) {
        controls = new ArrayList<>();
        webElements = webElementsToWrap;

        for (WebElement webElementToWrap : webElements) {
            controls.add(new ControlWrapper(webElementToWrap));
        }
    }

    /**
     * @return the List of wrapped Controls.
     */
    public final List<ControlWrapper> get() {
        return controls;
    }

    /**
     * gets the Select tags form the <code>webElements</code> into an ArrayList.
     *
     * @return List&#60SelectWrapper>
     */
    public final List<SelectWrapper> getSelects() {
        if (selects == null) {
            selects = new ArrayList<>();

            for (WebElement webElement : webElements) {
                selects.add(new SelectWrapper(webElement));
            }
        }
        return selects;
    }
}
