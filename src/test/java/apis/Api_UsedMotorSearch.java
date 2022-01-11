package apis;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.Map;

import constants.EndPoint;

public class Api_UsedMotorSearch {
    private Cookies cookies;

    public Api_UsedMotorSearch(Cookies cookies){
        this.cookies = cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }

    /***
     * Call the API to get the Used Motor Search Results based on given query paramters
     * @param queryParams
     * @return response
     */
    public Response UsedMotorSearch(Map<String, String> queryParams){
        Response response = ApiRequest.get(EndPoint.ApiUsedMotorSearch.url, queryParams, cookies);
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to search the motor" +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
