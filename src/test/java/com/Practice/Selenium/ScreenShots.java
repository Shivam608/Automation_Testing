package com.Practice.Selenium;

import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShots extends BaseTestUtils {

    @Test
    public void takeFullScreenShots() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get(getUrl("HeroKuApp"));


        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH_mm_ss_yyyy_MM_dd");
        String outputFilePath = System.getProperty("user.dir") + "\\ScreenShots\\FullScreenShot_" + format.format(date) + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(src, new File(outputFilePath));

    }

    @Test
    public void takePartialScreenShots() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get(getUrl("HeroKuApp"));

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH_mm_ss_yyyy_MM_dd");
        String outputFilePath = System.getProperty("user.dir") + "\\ScreenShots\\PartialScreenShot_" + format.format(date) + ".png";
        WebElement element = driver.findElement(By.xpath("//a[text()='Disappearing Elements']"));
        File src = element.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(src, new File(outputFilePath));
    }
}
