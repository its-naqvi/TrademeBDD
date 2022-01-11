package pages;

import factory.DriverFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Util;

public class SearchResultPage extends BasePage{
    private static final Logger log = LogManager.getLogger(SearchResultPage.class.getName());
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private String LISTINGTYPE_TAB = "xpath=>//tg-tab-heading[normalize-space()='%s']";
    private String KEYWORD_FIELD = "name=>keyword";
    private String MAKE_DROPDOWN = "name=>selectedMake";
    private String MODEL_DROPDOWN = "name=>searchParams.model";
    private String YEAR_FROM_DROPDOWN = "name=>year_min";
    private String YEAR_TO_DROPDOWN = "name=>year_max";
    private String PRICE_FROM_DROPDOWN = "name=>price_min";
    private String PRICE_TO_DROPDOWN = "name=>price_max";
    private String BODY_STYLE_MULTISELECTDD = "class=>tm-motors-search-bar__dropdown-multi-select-text";
    private String BODY_STYLE_CHECKBOX = "xpath=>//span[contains(text(),'%s')]";

    private String SEARCH_BUTTON = "css=>button[type='submit']";
    private String KILOMETER_RESULT = "xpath=>//span[@tmid='odometer' and contains(text(),'%s')]";

    private String SEARCH_RESULT_COUNT_DIV = "xpath=>//tm-search-header-result-count";

    /***
     * Search the Motor listing based on the provided search criteria. Fill the Search criteria and Click Search
     * @param ListingType
     * @param Keywords
     * @param Make
     * @param Model
     * @param YearFrom
     * @param YearTo
     * @param BodyStle
     */
    public void searchListing(String ListingType, String Keywords, String Make, String Model, String YearFrom, String YearTo, String PriceFrom, String PriceTo, String BodyStle){
        elementClick(String.format(LISTINGTYPE_TAB, ListingType), ListingType+ " Tab");

        sendData(KEYWORD_FIELD, "\"" + Keywords + "\"", "Search Keyword");
        selectOption(MAKE_DROPDOWN, Make, "Make");
        selectOption(MODEL_DROPDOWN, Model, "Model");
        selectOption(YEAR_FROM_DROPDOWN, YearFrom, "YearFrom");
        selectOption(YEAR_TO_DROPDOWN, YearTo, "YearTo");
        elementClick(BODY_STYLE_MULTISELECTDD, "Body Style Dropdown");
        elementClick(String.format(BODY_STYLE_CHECKBOX, BodyStle), "Body Style Dropdown");
        elementClick(SEARCH_BUTTON, "Search");
    }

    /***
     * From the search result set, find the desired listing based on odometer kilometers and Open that listing
     * @param kilometers
     */
    public String openDesiredListingResult(String kilometers){

        String searchResultCount = getText(SEARCH_RESULT_COUNT_DIV, "Search Result Count");
        String iCount = StringUtils.substringBetween(searchResultCount, "Showing", "result");
        if (Integer.parseInt(iCount.trim()) > 0){
            log.info("Search Result Count ::" + searchResultCount);
            elementClick(String.format(KILOMETER_RESULT, kilometers), "Body Style Dropdown");
        }
        else
        {
            throw new IllegalStateException("No result found : " + iCount);
        }

        return searchResultCount;
    }
}
