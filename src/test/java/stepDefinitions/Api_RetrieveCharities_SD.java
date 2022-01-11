package stepDefinitions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import apis.Api_RetreiveCharities;
import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.CheckPoint;
import utils.Util;

public class Api_RetrieveCharities_SD {

    private static final Logger log = LogManager.getLogger(Api_RetrieveCharities_SD.class.getName());
    private TestContext context;
    private Response response;

    public Api_RetrieveCharities_SD(TestContext context){
        this.context = context;
    }

  
    @When("User retrieve list of charities")
    public void UserRetrieveListOfCharities(){
        Api_RetreiveCharities charitiesAPI = new Api_RetreiveCharities(context.cookies.getCookies());
        response = charitiesAPI.RetrieveListOfCharities();
        context.cookies.setCookies(charitiesAPI.getCookies());
    }

    @Then("Verify the charityDescription {string} Tagline {string} CharityType {int} details")
    public void verifyTheCharityDetails(String charityDescription, String Tagline, int CharityType) {
    	Map<String, ?> chartiyDetails = response.path("find { it.Description == '%s' }", charityDescription);
        log.info("chartiyDetails ::" + chartiyDetails);

        CheckPoint.mark("verifyTheCharityDetails", Util.verifyTextMatch(chartiyDetails.get("Description").toString(), charityDescription), "charityDescription");
        CheckPoint.mark("verifyTheCharityDetails", Util.verifyTextMatch(chartiyDetails.get("Tagline").toString(), Tagline), "Tagline");
        CheckPoint.markFinal("verifyTheCharityDetails", Util.verifyTextMatch(chartiyDetails.get("CharityType").toString(), Integer.toString(CharityType)), "CharityType");
    }
    
}
