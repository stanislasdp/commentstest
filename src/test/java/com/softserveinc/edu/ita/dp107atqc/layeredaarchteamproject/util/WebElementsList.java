package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;


import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.*;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.*;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import java.util.ArrayList;
import java.util.List;


public final class WebElementsList {


    private List<ControlWrapper> controls;

    private ControlListWrapper controlListWrapper;


    private WebElementsList(final ControlListWrapper aControlListWrapper) {
        controlListWrapper = aControlListWrapper;
        controls = controlListWrapper.get();
    }

    public static WebElementsList getById(final String id) {
        return get(ControlLocation.getById(id));
    }


    public static WebElementsList getByName(final String searchName) {
        return get(ControlLocation.getByName(searchName));
    }


    public static WebElementsList getByCss(final String cssSelector) {
        return get(ControlLocation.getByCss(cssSelector));
    }


    public static WebElementsList getByXPath(final String xpathExpression) {
        return get(ControlLocation.getByXPath(xpathExpression));
    }


    private static WebElementsList get(final ControlLocation controlLocation) {
        return new WebElementsList(new ControlListWrapper(
                ContextVisible.get().getList(controlLocation)));
    }


    public List<Button> asButtons() {
        List<Button> buttons = new ArrayList<>();

        for (ControlWrapper control : controls) {
            buttons.add(new ButtonElement(control));
        }

        return buttons;
    }


    public List<CheckBox> asCheckboxes() {
        List<CheckBox> checkboxes = new ArrayList<>();

        for (ControlWrapper control : controls) {
            checkboxes.add(new CheckBoxElement(control));
        }

        return checkboxes;
    }

    public List<Label> asLabels() {
        List<Label> labels = new ArrayList<>();

        for (ControlWrapper control : controls) {
            labels.add(new LabelElement(control));
        }

        return labels;
    }


    public List<Link> asLinks() {
        List<Link> links = new ArrayList<>();

        for (ControlWrapper control : controls) {
            links.add(new LinkElement(control));
        }

        return links;
    }

    public List<TextInput> asTextInputs() {
        List<TextInput> textInputs = new ArrayList<>();

        for (ControlWrapper control : controls) {
            textInputs.add(new TextInputElement(control));
        }

        return textInputs;
    }

}
