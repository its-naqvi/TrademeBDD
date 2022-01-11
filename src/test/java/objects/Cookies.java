package objects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.CookieUtils;

import java.util.List;

public class Cookies {
    private io.restassured.http.Cookies cookies;
    public io.restassured.http.Cookies getCookies(){
        return cookies;
    }

    public void setCookies(io.restassured.http.Cookies cookies){
        this.cookies = cookies;
    }

    public void injectCookiesToBrowser(WebDriver driver){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSelniumCookies(cookies);
        int i = 0;
        for (Cookie cookie: seleniumCookies){
            System.out.println(("COUNTER " + i + ": " + cookie.toString()));
            driver.manage().addCookie(cookie);
            i++;
        }
        driver.navigate().refresh();
    }
}
