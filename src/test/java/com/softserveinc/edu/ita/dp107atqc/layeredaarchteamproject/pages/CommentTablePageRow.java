package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.CheckBoxElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.CustomElementImpl;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LabelElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Custom;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;

public class CommentTablePageRow {

  private String parentCss;

    CommentTablePageRow(String parentCss) {
        this.parentCss = parentCss;
    }


    CheckBox getCheckBox() {
            return CheckBoxElement.getByCss(String.format("%s > .checkedcolumn>input[type='checkbox']"
                    , parentCss));
    }

    Label getCommentNumber() {
           return LabelElement.getByCss(String.format("%s > .numbercolumn", parentCss));

    }

    Label getCommentText() {
            return LabelElement.getByCss(String.format("%s > .textcolumn", parentCss));
    }

    Label getActiveStatus() {
            return LabelElement.getByCss(String.format("%s > .inactivecolumn", parentCss));
    }

    Label getCommentCategories() {
            return LabelElement.getByCss(String.format("%s > .categorycolumn", parentCss));
    }



}
