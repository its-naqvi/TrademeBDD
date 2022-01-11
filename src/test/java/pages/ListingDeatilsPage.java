package pages;

import org.openqa.selenium.WebDriver;
import utils.CheckPoint;
import utils.Util;

public class ListingDeatilsPage extends BasePage{
    public ListingDeatilsPage(WebDriver driver) {
        super(driver);
    }

    private String ODOMETER_DIV = "xpath=>//*[@name='vehicle-odometer']/ancestor::div[1]";
    private String BODY_DIV = "xpath=>//*[@name='vehicle-car']/ancestor::div[1]";
    private String SEATS_DIV = "xpath=>//*[@name='vehicle-seat']/ancestor::div[1]";
    private String NUMBERPLATE_DIV = "xpath=>//span[contains(text(), 'Number plate:')]/ancestor::div[1]";

    /***
     * Validate the listing details for the following values which are passed as parameters.
     * @param numberPlate
     * @param kilometer
     * @param body
     * @param seats
     */
    public void validateListingResults(String numberPlate, String kilometer, String body, String seats){
        CheckPoint.mark("validateListingResults", Util.verifyTextContains(getText(ODOMETER_DIV, "ODOMETER"), kilometer), "kilometer");
        CheckPoint.mark("validateListingResults", Util.verifyTextContains(getText(BODY_DIV, "BODY"), body), "body");
        CheckPoint.mark("validateListingResults", Util.verifyTextContains(getText(SEATS_DIV, "SEATS"), seats), "seats");
        CheckPoint.markFinal("validateListingResults", Util.verifyTextContains(getText(NUMBERPLATE_DIV, "NUMBERPLATE"), numberPlate), "numberPlate");
    }
}
