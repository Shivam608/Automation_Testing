package com.Practice.Selenium;

import Components.FrameWorkUtilities;
import Components.XpathStore;
import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class DemoTestClass extends BaseTestUtils {

    @Test(invocationCount = 5)
    public void Demo() {

        WebDriver driver = new ChromeDriver();
        driver.get(FrameWorkUtilities.getUrl("RSA_SignIn"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofSeconds(2));

        driver.findElement(XpathStore.forgotPassword_rsa_Login).click();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.findElement(XpathStore.placeHolder("Name")).sendKeys("RSA");
            driver.findElement(XpathStore.placeHolder("Email")).sendKeys("RSA.com");
            driver.findElement(XpathStore.placeHolder("Phone")).sendKeys("12345679");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        }

        driver.findElement(XpathStore.resetButton_rsa_Login).click();

        String resetPasswordText = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();

        String[] words = resetPasswordText.split(" ");
        String password = null;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase("password")) {
                password = words[i + 1].replace("'", "");
                break;
            }
        }

        System.out.println(password);
        Assert.assertNotNull(password);
        driver.findElement(XpathStore.goToLoginButton_rsa_Login).click();

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            driver.findElement(XpathStore.placeHolder("Username")).sendKeys("RSA");
            driver.findElement(XpathStore.placeHolder("Password")).sendKeys(password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        }

        WebElement element = driver.findElement(By.id("chkboxOne"));
        wait.until(ExpectedConditions.visibilityOf(element));

        staticWait(1);
        driver.findElement(XpathStore.SelectCheckBox("Remember ")).click();
        driver.findElement(XpathStore.SelectCheckBox("agree")).click();

        driver.findElement(By.className("submit")).click();

        Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("You are successfully logged in"));

        driver.quit();

    }
}
