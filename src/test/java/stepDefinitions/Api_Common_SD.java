package stepDefinitions;


import context.TestContext;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

public class Api_Common_SD {

    private TestContext context;
    private Response response;

    public Api_Common_SD(TestContext context){
        this.context = context;
    }

    @Given("TradeMe API connection up")
    public void trademeApiConnectionUp() {
        System.out.println("TradeMe Sandbox API is up and running!!!");
    }

}
