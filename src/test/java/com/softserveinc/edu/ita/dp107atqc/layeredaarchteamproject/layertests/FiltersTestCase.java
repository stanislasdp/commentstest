package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.layertests;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.entities.Category;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.pages.MainPage;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.tests.domain.Specification;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.WebDriverUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Sasha on 20.02.2017.
 */
public class FiltersTestCase {

    @DataProvider
    public Object[][] categories() {
        return new Object[][]{
                {"Cat0"},
                {"Cat3"},
                {"Cat5"}
        };
    }

    @BeforeClass
    public void setUp() {
        WebDriverUtils.getWebDriver();
        WebDriverUtils.OpenUrl("http://commentssprintone.azurewebsites.net");

    }

    @AfterClass
    public void tearDown() {
       WebDriverUtils.stop();
    }

    @Test
    public void TestCase1_UseFilterOnActive() {
        MainPage mainPage = new MainPage();
        mainPage.getFilterMenuPage().filterStatus("Active");
        mainPage = mainPage.getFilterMenuPage().applyButton();
        Specification.get()
                .For(mainPage.getCommentsTablePage()).allCommentsAreWithActiveStatus(true)
                .next()
                .check();

    }

    @Test
    public void TestCase2_UseFilterOnInactive() {
        MainPage mainPage = new MainPage();
        mainPage.getFilterMenuPage().filterStatus("Inactive");
        mainPage = mainPage.getFilterMenuPage().applyButton();
        Specification.get()
                .For(mainPage.getCommentsTablePage()).allCommentsAreWithActiveStatus(false)
                .next()
                .check();

    }



    @Test(dataProvider = "categories")
    public void TestCase3_UseFilterOnCategory(String category) {
        MainPage mainPage = new MainPage();
        mainPage.getFilterMenuPage().filterCategory(category);
        mainPage = mainPage.getFilterMenuPage().applyButton();
        Specification.get()
                .For(mainPage.getCommentsTablePage()).allCommentsAreWithCategory(new Category
                (category))
                .next()
                .check();
        mainPage.getFilterMenuPage().filterCategory("All");
    }

}
