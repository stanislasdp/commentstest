package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;


import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.ButtonElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.DropDownElement;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Button;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.DropDown;


public class SelectAnActionUIMap {
    private DropDown dropDownElement;
    private Button yes;
    private Button no;

    public SelectAnActionUIMap(){
        DropDownElement.getById("commandSelect");
    }
    public DropDown getDropdown(String action) {
        if (dropDownElement == null) {
            dropDownElement = DropDownElement.getByName(action);
        }
        return this.dropDownElement;
  }

    public Button getYesButton(){
        if(yes == null){
           yes = ButtonElement.getByXpath
                   ("/html/body/div[2]/div[3]/div/button[1]/span");
        }
        return yes;
  }

    public Button getNoButton(){
        if(no == null){
            no = ButtonElement.getByXpath
                    ("/html/body/div[2]/div[3]/div/button[2]/span");
        }
        return no;
    }

  }


