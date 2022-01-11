package apis;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import constants.EndPoint;

public class Api_RetreiveCharities {
    private Cookies cookies;

    public Api_RetreiveCharities(Cookies cookies){
        this.cookies = cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }

    /***
     * Call the API to retrieve the list of charities
     * @return response
     */
    public Response RetrieveListOfCharities(){
    	Map<String, String> queryParams = new HashMap<>();
    	
        Response response = ApiRequest.get(EndPoint.ApiRetreiveCharities.url,queryParams, cookies);
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to retrieve charities" +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
