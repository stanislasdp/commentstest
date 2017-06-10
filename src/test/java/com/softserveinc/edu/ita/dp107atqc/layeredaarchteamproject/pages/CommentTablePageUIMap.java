package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebElementsList;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.CheckBoxElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LabelElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.LinkElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.TableElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.CheckBox;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Link;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Table;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommentTablePageUIMap {


    Link getSortByNumberLink() {
            return LinkElement.
                    getByCss(".webgrid-header >th:nth-child(2) > a");
    }

    Link getSortByCommentTextLink() {
            return LinkElement.
                    getByCss(".webgrid-header >th:nth-child(3) > a");
    }

    Link getSortByActiveStatusLink() {
            return LinkElement.
                    getByCss(".webgrid-header >th:nth-child(4) > a");

    }

    List<CommentTablePageRow> getCommentRows() {
        int rowsSize;
        try {
            rowsSize = WebElementsList.getByCss("table > tbody > tr").asLabels().size();
        } catch (TimeoutException e) {
            rowsSize = 0;
        }
        List<CommentTablePageRow> tableRows = new ArrayList<>();
        for (int i = 1; i <= rowsSize; i++) {
            tableRows.add(getCommentRow(i));
        }
        return tableRows;
    }

    public CommentTablePageRow getCommentRow(int rowNumber) {
        return new CommentTablePageRow(String.format("table > tbody > tr:nth-of-type(%d)", rowNumber));
    }

    public List<Link> getPages() {
        List<Link> pages;
        try {
            pages = WebElementsList.getByCss(".webgrid-footer > td > a").asLinks();
        } catch (TimeoutException e) {
            pages = WebElementsList.getByCss(".page > footer").asLinks();
        }
        return pages;

    }


}
