package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.ButtonElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.CheckBoxElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LabelElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.TextInputElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.TextInput;


public class CommentPageUIMap {

    Button getRefreshButton() {
        return ButtonElement.getByCss("#editor-navigation > a");
    }

    Button getSaveButton() {
        return ButtonElement.getByCss("#editor-navigation > input:nth-child(2)");
    }

    Button getSaveAndReturnButton() {
        return ButtonElement.getByCss("#editor-navigation > input:nth-child(3)");
    }

    TextInput getCommentText() {
        return TextInputElement.getById("Text");
    }

    TextInput getCommentNumber() {
        return TextInputElement.getById("Number");
    }

    CheckBox getCommentActivateCheckbox() {
        return CheckBoxElement.getByCss("#Active");
    }

     Label getErrorLabel() {
        return LabelElement.getByCss("#errorfield");
    }
}
