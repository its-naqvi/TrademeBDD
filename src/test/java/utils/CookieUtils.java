package utils;

import org.openqa.selenium.Cookie;
import io.restassured.http.Cookies;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {
    /***
     * To convert the rest assured cookies to selenium cookies list
     * @param cookies
     */
    public List<Cookie> convertRestAssuredCookiesToSelniumCookies(Cookies cookies){
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies = cookies.asList();
        List<Cookie> seleniumCookies = new ArrayList<>();
        for(io.restassured.http.Cookie cookie: restAssuredCookies){
            seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),
                    cookie.getPath(), cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(),
                    cookie.getSameSite()));
        }
        return seleniumCookies;
    }
}
