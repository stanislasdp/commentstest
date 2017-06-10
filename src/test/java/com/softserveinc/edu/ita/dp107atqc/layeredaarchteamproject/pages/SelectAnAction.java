package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages;

/**
 * Created by Natalia on 17.02.2017.
 */
public class SelectAnAction {
  private SelectAnActionUIMap selectAnActionUIMap;

  public SelectAnAction(){
      this.selectAnActionUIMap = new SelectAnActionUIMap();
  }

    public void Activate(){
      selectAnActionUIMap.getDropdown("Activate");
  }

    public void InActivate(){
        selectAnActionUIMap.getDropdown("InActivate");
    }

  public MainPage filterMenuPage(){
      FilterMenuPage filterMenuPage = new FilterMenuPage();
      filterMenuPage.filterCategory("");
      filterMenuPage.applyButton();
      return new MainPage();
  }

    public void commentPage (String number){
        CommentsTablePage commentsTablePage = new CommentsTablePage();
        commentsTablePage.selectCommentWithCommentNumber(commentsTablePage.getCommentFromTableByNumber(number));
    }
    public void RemoveFromCategory(){
        selectAnActionUIMap.getDropdown("RemoveFromCategory");
        selectAnActionUIMap.getYesButton().click();
        selectAnActionUIMap.getNoButton().click();
    }

}


