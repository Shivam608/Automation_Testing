package com.Practice.Selenium;

import Components.XpathStore;
import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class DropDowns extends BaseTestUtils {

    @Test(invocationCount = 2)
    public void dropDowns() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-cookies");
        WebDriver driver = new ChromeDriver(options);

        driver.get(getUrl("RSA_DropDownPractice"));

        /// Static
        WebElement staticDropdowns = driver.findElement(XpathStore.staticDropDown);
        Select select = new Select(staticDropdowns);
        select.selectByValue("USD");

        /// Dynamic
        WebElement dynamicDropDowns = driver.findElement(XpathStore.dynamicDropDown);
        dynamicDropDowns.sendKeys("Ind");

        staticWait(2);
        List<WebElement> listOfAutoSuggestTextElements = driver.findElements(XpathStore.autoSuggestDropDownlist);
        listOfAutoSuggestTextElements.stream()
                .filter(element -> element.getText().equalsIgnoreCase("India"))
                .forEach(WebElement::click);

        ///  Selecting CheckBoxes
        WebElement element = driver.findElement(XpathStore.SelectCheckBoxDropdown("Minor"));
        element.click();
        System.out.println(element.isEnabled());

        driver.quit();

    }
}
