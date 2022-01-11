package apis;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import constants.EndPoint;

public class Api_RetreiveWatchlist {
    private Cookies cookies;

    public Api_RetreiveWatchlist(Cookies cookies){
        this.cookies = cookies;
    }

    public Cookies getCookies(){
        return cookies;
    }

    /***
     * Call the API to retrieve the watchlist details for an authenticated user
     * @return response
     */
    public Response RetrieveWatchlist(){
    	Map<String, String> queryParams = new HashMap<>();
    	
        Response response = ApiRequest.get(EndPoint.ApiRetreiveWatchList.url, queryParams, cookies);
        if(response.getStatusCode() != 200){
            throw new RuntimeException("Failed to retrieve watchlist" +
                    ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
