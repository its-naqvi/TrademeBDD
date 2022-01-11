package stepDefinitions;

import constants.EndPoint;
import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.PageFactoryManager;

import java.util.List;

public class Ui_Home_SD {
    private HomePage homePage;

    public Ui_Home_SD(TestContext context){
        homePage = PageFactoryManager.getHomePage(context.driver);
    }

    @Given("User is on trademe Homepage")
    public void userIsOnTrademeHomepage() {
        homePage.load(EndPoint.HOME.url);
    }

    @And("User open listing category type")
    public void userOpenListingCategoryType(DataTable dt) {
        List<String> categoryType = dt.row(0);
        homePage.openListingCategoryType(categoryType.get(0));
    }


}
