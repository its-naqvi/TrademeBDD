package apis;

import constants.Api_Auth;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder{
	private static Properties properties;

	/***
	 * @Retrun the Post Response to a given End Point, headers, form parameters and cookies.
	 * @param endPoint
	 * @param headers
	 * @param formParams
	 * @param cookies
	 */
    public static Response post(String endPoint, Headers headers,
                                HashMap<String, Object> formParams, Cookies cookies){
        return 
	    		given(getRequestSpec()).
	            	headers(headers).
	            	formParams(formParams).
	            	cookies(cookies).
	            when().
	            	post(endPoint).
	            then().spec(getResponseSpec()).
	            	extract().
	            	response();
    }

	/***
	 * @Retrun the Get Response from a given End Point, queryParams and cookies
	 * @param endPoint
	 * @param queryParams
	 * @param cookies
	 */
    public static Response get(String endPoint, Map<String, String> queryParams, Cookies cookies){
        return 
	    		given(getRequestSpec()).
	        		cookies(cookies).
	        		queryParams(queryParams).
					auth().oauth(Api_Auth.CONSUMER_KEY, Api_Auth.CONSUMER_SECRET, Api_Auth.ACCESS_TOKEN, Api_Auth.SECRET_TOKEN).
	            when().
	                get(endPoint).
	            then().
	            	spec(getResponseSpec()).
	                extract().
	                response();
    }

}
