package com.Practice.Selenium;

import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TopDeals_Sorting extends BaseTestUtils {

    @Test
    public void topDealsSortingOrder() {

        WebDriver driver = initializeChromeDriver(getUrl("RSA_TopDeals"));
        WebElement columnSize = driver.findElement(By.xpath("//select[@id='page-menu'][.//option]"));
        Select toSize = new Select(columnSize);
        toSize.selectByValue("20");

        List<WebElement> itemNameElement = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> list = new ArrayList<>();
        for (WebElement e : itemNameElement) {
            list.add(e.getText());
        }
        List<String> expSortedList = list.stream().sorted().toList();

        driver.findElement(By.xpath("//th[contains(@aria-label,'Veg/fruit')]")).click();
        List<WebElement> sortedItemNameElement = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> actSortedList = sortedItemNameElement.stream().map(WebElement::getText).toList();

        Assert.assertEquals(actSortedList, expSortedList);
        System.out.println("Actual Sorted Array: " + actSortedList);
        System.out.println("Expected Sorted Array: " + expSortedList);
    }
}
