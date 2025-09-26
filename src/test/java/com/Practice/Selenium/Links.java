package com.Practice.Selenium;

import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Links extends BaseTestUtils {

    @Test
    public void validateLinksAndCounts() {

        WebDriver driver = initializeChromeDriver(getUrl("RSA_AutomationPractice"));
        driver.manage().window().maximize();
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        System.out.println(listOfLinks.size());

        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
        System.out.println(footerLinks.size());

        String parentWindow = driver.getWindowHandle();

        for (WebElement e : footerLinks) {
            String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
            e.sendKeys(keys);
            staticWait(1);
        }

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        Stack<String> titles = new Stack<>();
        while(it.hasNext()) {
            titles.push(driver.switchTo().window(it.next()).getTitle());
        }

        System.out.println(titles);

        /// Validate Broken Links
        driver.switchTo().window(parentWindow);
        ArrayList<String> list = new ArrayList<>();
        for (WebElement e: footerLinks) {
            try {
                String url = e.getDomAttribute("href");
                System.out.println(url);
                HttpURLConnection conn = (HttpURLConnection) new URL(Objects.requireNonNull(url)).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                if (conn.getResponseCode() != 200) {
                    list.add(url);
                }
            }catch (Exception i) {
                i.printStackTrace();
            }
        }

        System.out.println(list);
        driver.quit();
    }
}
