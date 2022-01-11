package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Then;
import objects.Motor;
import pages.ListingDeatilsPage;
import pages.PageFactoryManager;

public class UI_ListingDetails_SD {
    private Motor carDetails;
    private ListingDeatilsPage listingDeatilsPage;

    public UI_ListingDetails_SD(TestContext context){
        listingDeatilsPage = PageFactoryManager.getListingDetailsPage(context.driver);
    }

    @Then("Verify the listing numberPlate {string} kilometer {string} BodyStyle {string} seats {string} details")
    public void verifyTheListingNumberPlateKilometerBodySeatsDetails(String numberPlate, String kilometer, String BodyStyle, String seats) {
        listingDeatilsPage.validateListingResults(numberPlate, kilometer, BodyStyle, seats);
    }
}
