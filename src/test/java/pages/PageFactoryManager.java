package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static HomePage homePage;
    private static SearchResultPage searchResultPage;
    private static ListingDeatilsPage listingDetailsPage;

    public static HomePage getHomePage(WebDriver driver){
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static SearchResultPage getSearchResultPage(WebDriver driver){
        return searchResultPage == null ? new SearchResultPage(driver) : searchResultPage;
    }

    public static ListingDeatilsPage getListingDetailsPage(WebDriver driver){
        return listingDetailsPage == null ? new ListingDeatilsPage(driver) : listingDetailsPage;
    }
}
