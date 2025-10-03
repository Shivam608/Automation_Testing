package Utils;

import Components.FrameWorkUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseTest extends FrameWorkUtilities {

     protected static ExtentSparkReporter sparkReporter;
     protected static ExtentTest extentTest;
     protected static ExtentReports extentReports;
     public static Response response;

    public WebDriver initializeChromeDriver(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    public void setExtentTest() {
        if(extentReports == null) {
            extentReports = createInstance();
        }
    }

    private ExtentReports createInstance() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH_mm_dd_MM_yyyy");
        String fileLocation = System.getProperty("user.dir") + "\\ExtentReports\\TestExecutionReport_" + format.format(date) + ".html";

        sparkReporter = new ExtentSparkReporter(fileLocation);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

    public void flushReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }


}
