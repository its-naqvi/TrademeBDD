package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.Motor;
import pages.PageFactoryManager;
import pages.SearchResultPage;

public class UI_Search_SD {
    private SearchResultPage searchResultPage;

    public UI_Search_SD(TestContext context){
        searchResultPage = PageFactoryManager.getSearchResultPage(context.driver);
    }

    @When("User search for ListingType {string} Keywords {string} Make {string} Model {string} YearFrom {string} YearTo {string} PriceFrom {string} PriceTo {string} BodyStyle {string} listing")
    public void userSearchForMotorListing(
            String ListingType, String Keywords, String Make, String Model, String YearFrom, String YearTo, String PriceFrom, String PriceTo, String BodyStyle) {
        searchResultPage.searchListing(ListingType, Keywords, Make, Model, YearFrom, YearTo, PriceFrom, PriceTo, BodyStyle);
    }

    @And("User open the desired listing from the result set based on kilometer {string}")
    public void userOpenTheDesiredListingFromTheResultSet(String kilometer) {
        searchResultPage.openDesiredListingResult(kilometer);
    }
}
