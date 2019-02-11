package com.firstgoogletest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {
    private WebDriver driver;


    /**
     * Set up method
     *
     */
    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Open Google page, search for https://www.qasymphony.com click and quit
     *
     */
    @Test
    public void testSearchGoogleTest() throws Exception {
        driver.get("https://google.com.ua");
        driver.findElement(By.name("q")).sendKeys("Automation testing");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        String link = "https://www.qasymphony.com";
        if (driver.findElements(By.partialLinkText(link)).size() > 0){
            driver.findElement(By.partialLinkText(link)).click();
        }else{
            driver.findElement(By.xpath("//*[@id=\"nav\"]/tbody/tr/td[3]/a")).click();
            driver.findElement(By.partialLinkText(link)).click();
        }
    }

    /**
     * Quit driver
     *
     */

    @After
    public void tearDown() {
        driver.quit();
    }
}
