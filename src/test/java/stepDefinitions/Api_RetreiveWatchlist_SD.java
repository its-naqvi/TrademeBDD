package stepDefinitions;

import java.util.Map;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import apis.Api_RetreiveWatchlist;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.CheckPoint;
import utils.Util;

public class Api_RetreiveWatchlist_SD {

    private static final Logger log = LogManager.getLogger(Api_RetreiveWatchlist_SD.class.getName());
    private TestContext context;
    private Response response;

    public Api_RetreiveWatchlist_SD(TestContext context){
        this.context = context;
    }

    @When("User retrieve the watchlist")
    public void userRetrieveTheWatchlist() {
    	Api_RetreiveWatchlist watchlistAPI = new Api_RetreiveWatchlist(context.cookies.getCookies());
        response = watchlistAPI.RetrieveWatchlist();        		
        context.cookies.setCookies(watchlistAPI.getCookies());
    }

    @Then("Verify the details Title {string} Region {string} Suburb {string} StartPrice {string} CategoryName {string}")
    public void verifyTheWatchlistDetails(String Title, String Region, String Suburb, String StartPrice, String CategoryName) {
    	Map<String, ?> watchlistDetails = response.path("List.find { it.Title == '%s'}", Title);
        log.info("watchlistDetails ::" + watchlistDetails);

        CheckPoint.mark("verifyTheWatchlistDetails", Util.verifyTextMatch(watchlistDetails.get("Title").toString(), Title), "Title");
        CheckPoint.mark("verifyTheWatchlistDetails", Util.verifyTextMatch(watchlistDetails.get("Region").toString(), Region), "Region");
        CheckPoint.mark("verifyTheWatchlistDetails", Util.verifyTextMatch(watchlistDetails.get("Suburb").toString(), Suburb), "Suburb");
        CheckPoint.mark("verifyTheWatchlistDetails", Util.verifyTextMatch(watchlistDetails.get("StartPrice").toString(), StartPrice.trim()), "StartPrice");
        CheckPoint.markFinal("verifyTheWatchlistDetails", Util.verifyTextMatch(watchlistDetails.get("CategoryName").toString(), CategoryName), "CategoryName");
    }

}
