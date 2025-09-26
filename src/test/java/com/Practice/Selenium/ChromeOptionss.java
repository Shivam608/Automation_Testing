package com.Practice.Selenium;

import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ChromeOptionss extends BaseTestUtils {

    @Test
    public void chromeOptionss() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        ///  Block PopUps
        options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));

        /// Set Download Directory
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Downloads");
        options.setExperimentalOption("prefs", prefs);

        ///  Disable banner "Chrome is being controlled by a automated test Software"
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));

        /// Initialize Chrome Browser
        WebDriver driver = new ChromeDriver(options);

        driver.get(getUrl("RSA_ExpiredSSL"));
        System.out.println(driver.getTitle());

        driver.manage().deleteAllCookies();

        driver.quit();

    }

}
