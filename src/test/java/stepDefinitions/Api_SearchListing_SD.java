package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import apis.Api_UsedMotorSearch;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.CheckPoint;
import utils.Util;

public class Api_SearchListing_SD {

    private static final Logger log = LogManager.getLogger(Api_SearchListing_SD.class.getName());
    private TestContext context;
    private Response response;

    public Api_SearchListing_SD(TestContext context){
        this.context = context;
    }

    @When("User search Keywords {string} Make {string} Model {string} YearFrom {string} YearTo {string} PriceFrom {string} PriceTo {string} BodyStyle {string} listing")
    public void UserRetrieveListOfCharities(
            String Keywords, String Make, String Model, String YearFrom, String YearTo, String PriceFrom, String PriceTo, String BodyStyle) {

        Api_UsedMotorSearch usedMotorSearch = new Api_UsedMotorSearch(context.cookies.getCookies());

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("search_string", Keywords);
        queryParams.put("make", Make);
        queryParams.put("model", Model);
        queryParams.put("year_min", YearFrom);
        queryParams.put("year_max", YearTo);
        queryParams.put("price_min", PriceFrom);
        queryParams.put("price_max", PriceTo);
        queryParams.put("body_style", BodyStyle);

        response = usedMotorSearch.UsedMotorSearch(queryParams);
        context.cookies.setCookies(usedMotorSearch.getCookies());
    }

    @Then("Verify the details numberPlate {string} kilometer {string} body {string} seats {string}")
    public void verifyTheMotorDetails(String numberPlate, String kilometer, String body, String seats) {
    	Map<String, ?> motorDetails = response.path("List.find { it.numberPlate == '%s' }", numberPlate);
        log.info("watchlistDetails ::" + motorDetails);

        CheckPoint.markFinal("verifyTheMotorDetails", Util.verifyTextMatch(motorDetails.get("numberPlate").toString(), numberPlate), "numberPlate");
    }
}
