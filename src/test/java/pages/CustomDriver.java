package pages;
import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.*;

public class CustomDriver {
    private static final Logger log = LogManager.getLogger(CustomDriver.class.getName());
    public WebDriver driver;
    private JavascriptExecutor js;

    public CustomDriver() {

    }

    public CustomDriver(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

     /***
     * Builds the By type with given locator strategy
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @return Returns By Type
     */
    public By getByType(String locator) {
        By by = null;
        String locatorType = locator.split("=>")[0];
        locator = locator.split("=>")[1];
        try {
            if (locatorType.contains("id")) {
                by = By.id(locator);
            } else if (locatorType.contains("name")) {
                by = By.name(locator);
            } else if (locatorType.contains("xpath")) {
                by = By.xpath(locator);
            } else if (locatorType.contains("css")) {
                by = By.cssSelector(locator);
            } else if (locatorType.contains("class")) {
                by = By.className(locator);
            } else if (locatorType.contains("tag")) {
                by = By.tagName(locator);
            } else if (locatorType.contains("link")) {
                by = By.linkText(locator);
            } else if (locatorType.contains("partiallink")) {
                by = By.partialLinkText(locator);
            } else {
                log.info("Locator type not supported");
            }
        } catch (Exception e) {
            log.error("By type not found with: " + locatorType);
        }
        return by;
    }

    /**
     * Builds The WebElement By given locator strategy
     *
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *                tag=>example, xpath=>//example, link=>example
     * @param info - Information about element, usually text on element
     * @return WebElement
     */
    public WebElement getElement(String locator, String info) {
        waitForElement(locator, 15); //Mansoor
        WebElement element = null;
        By byType = getByType(locator);
        try {
            element = driver.findElement(byType);
        } catch (Exception e) {
            log.error("Element not found with: " + locator);
            e.printStackTrace();
        }
        return element;
    }


    /**
     * Click element with information about element and
     * time to wait in seconds after click
     *
     * @param element - WebElement to perform Click operation
     * @param info    - information about element
     */
    public void elementClick(WebElement element, String info, long timeToWait) {
        try {
            element.click();
            if (timeToWait == 0) {
                log.info("Clicked On :: " + info);
            } else {
                Util.sleep(timeToWait, "Clicked on :: " + info);
            }
        } catch (Exception e) {
            log.error("Cannot click on :: " + info);
            takeScreenshot("Click ERROR", "");
        }
    }

    /**
     * Click element with no time to wait after click
     *
     * @param element - WebElement to perform Click operation
     * @param info    - information about element
     */
    public void elementClick(WebElement element, String info) {
        elementClick(element, info, 0);
    }

    /**
     * Click element with locator
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param info
     * @param timeToWait
     * @return
     */
    public void elementClick(String locator, String info, long timeToWait) {
        WebElement element = this.getElement(locator, info);
        elementClick(element, info, timeToWait);
    }

    /**
     * Click element with locator and no time to wait
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param info - Information about element
     * @return
     */
    public void elementClick(String locator, String info) {
        WebElement element = getElement(locator, info);
        elementClick(element, info, 500);
    }

     /***
     * Click element when element is clickable
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param timeout - Duration to try before timeout
     */
    public void clickWhenReady(By locator, int timeout) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            WebElement element = null;
            log.info("Waiting for max:: " + timeout + " seconds for element to be clickable");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
            element.click();
            log.info("Element clicked on the web page");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        } catch (Exception e) {
            log.error("Element not appeared on the web page");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
    }

    /***
     * Send Keys to element
     * @param element - WebElement to send data
     * @param data - Data to send
     * @param info - Information about element
     * @param clear - True if you want to clear the field before sending data
     */
    public void sendData(WebElement element, String data, String info, Boolean clear) {
        try {
            if (clear) {
                element.clear();
            }
            //Util.sleep(1000, "Waiting Before Entering Data");
            element.sendKeys(data);
            log.info("Send Keys on element :: " + info + " with data :: " + data);
        } catch (Exception e) {
            log.error("Cannot send keys on element :: " + info + " with data :: " + data);
        }
    }

    /***
     * Send Keys to element with locator
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param data - Data to send
     * @param info - Information about element
     * @param clear - True if you want to clear the field before sending data
     */
    public void sendData(String locator, String data, String info, Boolean clear) {
        WebElement element = this.getElement(locator, info);
        sendData(element, data, info, clear);
    }

    /***
     * Send Keys to element with clear
     * @param element - WebElement to send data
     * @param data - Data to send
     * @param info - Information about element
     */
    public void sendData(WebElement element, String data, String info) {
        sendData(element, data, info, true);
    }

    /***
     * Send Keys to element with locator and clear
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param data - Data to send
     * @param info - Information about element
     */
    public void sendData(String locator, String data, String info) {
        WebElement element = getElement(locator, info);
        sendData(element, data, info, true);
    }

    /**
     * Get text of a web element
     *
     * @param element - WebElement to perform click action
     * @param info    - Information about element
     */
    public String getText(WebElement element, String info) {
        System.out.println("Getting Text on element :: " + info);
        String text = null;
        text = element.getText();
        if (text.length() == 0) {
            text = element.getAttribute("innerText");
        }
        if (!text.isEmpty()) {
            log.info("The text is : " + text);
        } else {
            log.error("Text Not Found");
        }
        return text.trim();
    }

    /**
     * Get text of a web element with locator
     * @param locator
     * @param info
     * @return
     */
    public String getText(String locator, String info) {
        WebElement element = this.getElement(locator, info);
        return this.getText(element, info);
    }


    /**
     * @param locator
     * @param timeout
     * @return
     */
    public WebElement waitForElement(String locator, int timeout) {
        By byType = getByType(locator);
        WebElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            log.info("Waiting for max:: " + timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(byType));
            log.info("Element appeared on the web page");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        } catch (Exception e) {
            log.error("Element not appeared on the web page");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return element;
    }

    /***
     * Wait for element to be clickable
     * @param locator - locator strategy, id=>example, name=>example, css=>#example,
     *      *                tag=>example, xpath=>//example, link=>example
     * @param timeout - Duration to try before timeout
     */
    public WebElement waitForElementToBeClickable(String locator, int timeout) {
        By byType = getByType(locator);
        WebElement element = null;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            log.info("Waiting for max:: " + timeout + " seconds for element to be clickable");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(byType));
            log.info("Element is clickable on the web page");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        } catch (Exception e) {
            log.error("Element not appeared on the web page");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return element;
    }

    /**
     * @param element
     * @param optionToSelect
     */
    public void selectOption(WebElement element, String optionToSelect) {
        Select sel = new Select(element);
        sel.selectByVisibleText(optionToSelect);
        log.info("Selected option : " + optionToSelect);
    }

    /**
     * Selects a given option in list box
     *
     * @param locator
     * @param optionToSelect
     */
    public void selectOption(String locator, String optionToSelect, String info) {
        WebElement element = getElement(locator, info);
        this.selectOption(element, optionToSelect);
    }

    /**
     * get Selected drop down value
     *
     * @param element
     * @return
     */
    public String getSelectDropDownValue(WebElement element) {
        Select sel = new Select(element);
        return sel.getFirstSelectedOption().getText();
    }

    /***
     *
     * @param methodName
     * @param browserName
     * @return
     */
    public String takeScreenshot(String methodName, String browserName) {
        String fileName = Util.getScreenshotName(methodName, browserName);
        String screenshotDir = System.getProperty("user.dir") + "//" + "test-output/screenshots";
        new File(screenshotDir).mkdirs();
        String path = screenshotDir + "//" + fileName;

        try {
            File screenshot = ((TakesScreenshot)driver).
                    getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            log.info("Screen Shot Was Stored at: "+ path);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return path;
    }


}