package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;



public class SelectWrapper extends ControlWrapper {

    private Select select;


    public SelectWrapper(final WebElement webElement) {
        super(webElement);
        this.select = new Select(webElement);
    }


    private Select getSelect() {
        return select;
    }


    public final void deselectAll() {
        getSelect().deselectAll();
    }


    public final void deselectByIndex(final int index) {
        getSelect().deselectByIndex(index);
    }


    public final void deselectByValue(final String value) {
        getSelect().deselectByValue(value);
    }


    public final void deselectByVisibleText(final String text) {
        getSelect().deselectByVisibleText(text);
    }


    public final List<String> getAllSelectedOptions() {
        List<String> selectedOptions = new ArrayList<>();
        for (WebElement option : getSelect().getAllSelectedOptions()) {
            selectedOptions.add(option.getText());
        }
        return selectedOptions;
    }


    public final WebElement getFirstSelectedOption() {
        return getSelect().getFirstSelectedOption();
    }


    public final String getSelectedOptionIndex() {
        return getSelect().getFirstSelectedOption().getAttribute("index");
    }


    public final String getSelectedOptionValue() {
        return getSelect().getFirstSelectedOption().getAttribute("value");
    }


    public final String getSelectedOptionText() {
        return getSelect().getFirstSelectedOption().getText();
    }


    public final List<String> getOptions() {
        List<String> options = new ArrayList<>();
        for (WebElement option : getSelect().getOptions()) {
            options.add(option.getText());
        }
        return options;
    }


    public final boolean isMultiple() {
        return getSelect().isMultiple();
    }


    public final void selectByIndex(final int index) {
        getSelect().selectByIndex(index);
    }



    public final void selectByValue(final String value) {
        getSelect().selectByValue(value);
    }


    public final void selectByVisibleText(final String text) {
        getSelect().selectByVisibleText(text);
    }
}
