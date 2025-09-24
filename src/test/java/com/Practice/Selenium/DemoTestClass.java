package com.Practice.Selenium;

import Components.FrameWorkUtilities;
import Components.XpathStore;
import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class DemoTestClass extends BaseTestUtils {

    @Test
    public void Demo() throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(FrameWorkUtilities.getUrl("RSA_SignIn"));

        driver.findElement(XpathStore.forgotPassword_rsa_Login).click();
        Thread.sleep(1000);
        driver.findElement(XpathStore.placeHolder("Name")).sendKeys("RSA");
        driver.findElement(XpathStore.placeHolder("Email")).sendKeys("RSA.com");
        driver.findElement(XpathStore.placeHolder("Phone")).sendKeys("12345679");

        driver.findElement(XpathStore.resetButton_rsa_Login).click();

        String resetPasswordText = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();

        String[] words = resetPasswordText.split(" ");
        String password = null;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase("password")) {
                password = words[i+1].replace("'", "");
                break;
            }
        }

        System.out.println(password);
        driver.findElement(XpathStore.goToLoginButton_rsa_Login).click();

    }
}
