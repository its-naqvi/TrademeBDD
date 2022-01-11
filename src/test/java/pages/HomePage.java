package pages;

import factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
    private String MOTORS_LINK = "link=>Motors";
    private String JOBS_LINK = "link=>Jobs";


    public HomePage(WebDriver driver) {super(driver);}

    /***
     * When user is on Home page, based on the search category, open the link e.g Motors, Jobs, Marketplace etc..
     * @param searchCategory
     */
    public void openListingCategoryType(String searchCategory){
        switch(searchCategory) {
            case "Motors":
                elementClick(MOTORS_LINK, "Motors LINK");
                break;
            case "Jobs":
                log.info("Method userOpenListingType ::" + searchCategory + "(Pending Implementation)");
                break;
            default:
                throw new IllegalStateException("INVALID listing search type : " + searchCategory);
        }

    }

}
