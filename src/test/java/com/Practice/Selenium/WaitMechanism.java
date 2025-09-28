package com.Practice.Selenium;

import Components.XpathStore;
import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitMechanism extends BaseTestUtils {

    /// Global Declaration
    WebDriver driver = initializeChromeDriver(getUrl("HeroKuApp"));

    @BeforeMethod
    public void beforeMethod() {
        try {
            herokuNavigateToContent(driver, "Dynamic Loading");
        } catch (StaleElementReferenceException e) {}
    }

//    @Test
    public void usingImplicitWait() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(XpathStore.dynamicLoadingContent(1)).click();

        driver.findElement(By.xpath("//div[@id='start'][.//text()='Start']//following-sibling::button")).click();

        WebElement element = driver.findElement(By.xpath("//div[@id='finish']/h4[contains(text(),'Hello World')]"));
        staticWait(5); /// compulsory wait to achieve Pass
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void usingExplicitWaits() {

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.findElement(XpathStore.dynamicLoadingContent(1)).click();

        driver.findElement(By.xpath("//div[@id='start'][.//text()='Start']//following-sibling::button")).click();
        WebElement element = driver.findElement(By.xpath("//div[@id='finish']/h4[contains(text(),'Hello World')]"));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());

    }

    @Test
    public void usingFluentWaits() {

        driver.findElement(XpathStore.dynamicLoadingContent(1)).click();
        WebElement element = driver.findElement(By.xpath("//div[@id='finish']/h4[contains(text(),'Hello World')]"));
        driver.findElement(By.xpath("//div[@id='start'][.//text()='Start']//following-sibling::button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(driver1 -> {
            if (element.isDisplayed()) {
                System.out.println("Text Found");
                return element;
            } else  {
                System.out.println("Text Not found");
                return null;
            }
        });

        Assert.assertTrue(element.isDisplayed());

    }
}
