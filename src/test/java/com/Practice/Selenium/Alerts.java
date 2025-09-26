package com.Practice.Selenium;

import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Alerts extends BaseTestUtils {

    @Test
    public void handelAlerts() {

        WebDriver driver = initializeChromeDriver(getUrl("RSA_AutomationPractice"));
        driver.manage().window().maximize();

        driver.findElement(By.id("name")).sendKeys("Hello World");
        driver.findElement(By.id("alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
    }
}
