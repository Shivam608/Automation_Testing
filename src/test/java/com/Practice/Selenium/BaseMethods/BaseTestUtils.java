package com.Practice.Selenium.BaseMethods;

import Utils.BaseTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
}
