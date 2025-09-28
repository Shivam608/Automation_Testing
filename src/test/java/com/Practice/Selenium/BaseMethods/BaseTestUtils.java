package com.Practice.Selenium.BaseMethods;

import Components.XpathStore;
import Utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;

public abstract class BaseTestUtils extends BaseTest {

    @Override
    @BeforeSuite
    public void setExtentTest() {
        super.setExtentTest();
    }

    @Override
    @AfterSuite
    public void flushReports() {
        super.flushReports();
    }

    public void staticWait(long seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void herokuNavigateToContent(WebDriver driver, String text) {
        List<WebElement> listOfContentElements = driver.findElements(XpathStore.herokuAllContentLocator);
        listOfContentElements.stream()
                .filter(element -> element.getText().equalsIgnoreCase(text))
                .forEach(WebElement::click);
    }
}
