package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.Elements.Dealer;
//import static base.Elements.ElementToBeSelected;
import static base.Elements.Price;
import static base.Elements.SearchInput;
import static base.Elements.SearchSubmit;
import static org.junit.Assert.assertTrue;

/**
 * This class provide all the method performing operations
 *
 * @author Jyoti Pareek
 */
public class BasePage {

    public static WebDriver driver = null;
    public static WebDriverWait waitVar = null;
    public static String baseURL = "https://www.amazon.in/";
    public static Actions action;
    public static JavascriptExecutor jse;
    String altContent="https://www.amazon.in/Boldfit-Pollution-protective-Third-manufacturer-Ministry/dp/B08BFXSM4B/ref=sr_1_1?crid=25FPG1ZZKH7PI&dib=eyJ2IjoiMSJ9.JgSmGAioqHpJjZoTDAYZ_b6mMMM8ntoA1mby41MtM-1EeNZnOQlxS6rASgfz-KvpjFOJElcYH8FuVtFLoGDTc4EpIAg7wLTvPfHHH9rEtNTiO1LIOE2OfEASLcPd5fqAri5qC4VAtsnuBfe6bjIyY2-lM3a2GOqPyRF5v_5dMafFU4uhzvbyYVwjRShdAnnwc014irbubJrs-rsVknQERFS-eCFrIZ0vjR4bj8lsi3xlVJ6BoudcTmD-RPyVpcaN0jEgWERWyLffX3_9dr9_uVEJCnktZXuWAIeKpNMAVXw.ckLiaZKiwxPhoVNgkwvbIHT3UN6-ycTHAfzQIdqSbRY&dib_tag=se&keywords=N95%2Bmasks&qid=1723551812&sprefix=%2Caps%2C190&sr=8-1&th=1";

    /**
     * @param browserType is taking user's browser name
     * @param appUrl      is taking the url of the website to be worked upon
     * @throws MalformedURLException is thrown when URL is not correct
     * @throws InterruptedException  is shown when there is any issue with the connection
     */
    public void createDriver(String browserType, String appUrl) throws MalformedURLException, InterruptedException {
        switch (browserType) {
            // check our browser
            case "Firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "Chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "InternetExplorer": {
                driver = new InternetExplorerDriver();
                break;
            }
            case "Safari": {
                driver = new SafariDriver();
                break;
            }
            // if our browser is not listed, throw an error
            default: {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // open a new driver instance to our application URL
        driver.get(appUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
//        driver.get(baseURL);
//        waitVar = new WebDriverWait(driver, 9);
    }

    /**
     * Closes the browser instance
     */
    @After
    public void teardown() {
        driver.quit();
    }


    /**
     * Makes driver to sleep for some time
     *
     * @param i is taking the amount of wait
     */
    public void WaitForTime(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Moves control to new tab
     */
    public void validateNewTab() {
        String current_title = driver.getTitle();
        System.out.println(current_title);
        assertTrue("All Deals are displayed in new page",
                current_title.contains("Amazon.in Today's Deals: Great Savings. Every Day."));
    }

    /**
     * Switch the control to the new drivre window
     */
    public void switch_window() {
        Set<String> handles = driver.getWindowHandles();
        String current_window = driver.getWindowHandle();
        handles.remove(current_window);
        String second_handle = handles.iterator().next();
        String winHandle = handles.iterator().next();
        if (winHandle != current_window) {
            second_handle = winHandle;
            driver.switchTo().window(second_handle);
        }
    }

    /**
     * Switch the control to the new drivre window
     */
    public void switch_window_to_default() {
        driver.switchTo().defaultContent();
    }


    /**
     * Take screenshot
     */
//    public void take_screenshots() {
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File currDir = new File("");
//        String path = currDir.getAbsolutePath();
//        File DestFile = new File(path + "/src/test/java/screenshot/Screenshot.png");
//        try {
//            File.copyFile(src, DestFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * GetDriver Details
     */
    public WebDriver getDriver() {
        return driver;
    }

    public void searchThing(String text) {
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(text);
    }

    public void searchHit(){
        driver.findElement(By.xpath("//div[@aria-label='n95 masks']")).click();
    }

    public void selectSearchedElement() {
        driver.findElement(By.xpath("//a[@href='"+altContent+"']")).click();
//        (//div[contains(@class,'widgetId=search-results_1')])[1]
    }

    public boolean validatePrice(String str)
    {

        String text= driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
        return text.equals(str);
    }

    public boolean validateDealer(String str){

        String text= driver.findElement(By.xpath("(//a[@id='sellerProfileTriggerId'])[1]")).getText();
        return text.equals(str);
    }
}

