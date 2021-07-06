package com.sentient.poc.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sentient.poc.helper.zipUtil;
import com.sentient.poc.config.*;
import com.sentient.poc.helper.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;


public class baseClass {
    public static String atest = "";
    public String space = "", hypen = "";
    int invalidLinksCount = 0;
    int invalidImageCount = 0;
    public WebDriver driver;
    public ExtentTest test;
    public static ExtentReports extent;
    public static ExtentHtmlReporter htmlReporter;
    public static String DownloadFilepath, folder, basefold;
    public static int count, Passcount, FailedCount;
    public static String Report_Path = null;
    public String Report_Timestamp;


    @Parameters({"browserType"})

    @BeforeClass
    public void setUp(String browser) throws Exception {

        int i = 0;
        while (i < 45) {
            space += " ";

            hypen += "-";

            i++;
        }
        count += 1;
        htmlReporter = com.sentient.poc.config.extentReports.createInstance("report/extent.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        Thread.sleep(1000);
        if (browser.equalsIgnoreCase("chrome")) {
            //  defineProperties defineBrowser = new defineProperties(browser);
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("window-size=1280,1024");
            String path = System.getProperty("user.dir");
            DownloadFilepath = path + "\\Test_Data\\Download";
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", DownloadFilepath);
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
            //  driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            defineProperties defineBrowser = new defineProperties(browser);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("internetexplorer")) {
            defineProperties defineBrowser = new defineProperties(browser);
            driver = new InternetExplorerDriver(defineBrowser.setIECapability());
            driver.manage().window().maximize();
            //   driver = new RemoteWebDriver(new URL(url), defineBrowser.SauceLabCapabilities());
        }
        extent.setSystemInfo("Selenium Version", "3");
        extent.setSystemInfo("Environment", "Testing");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod(timeOut = 10000L, alwaysRun = true)
    public void checkResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case FAILED", ExtentColor.RED));
            test.fail(result.getThrowable());
            test.addScreenCaptureFromPath(screenshots.takeScreenshot(driver, result.getMethod().getMethodName()));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.YELLOW));
        }
        extent.flush();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        File dir = new File(baseClass.DownloadFilepath);
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println("Deleted filename :"+ file.getName());
            file.delete();
        }
    }


    @AfterSuite
    public void afterSuite(ITestContext context) {
        printSuiteResults(context.getSuite());
    }

    private void printSuiteResults(ISuite suite) {
        Collection<ISuiteResult> suiteResults = suite.getResults().values();
        for (ISuiteResult suiteResult : suiteResults) {
            printAllResults(suiteResult.getTestContext());
        }
    }

    private void printAllResults(ITestContext context) {
        int passcount, failedCount, skipcount;
        System.err.println("Printing tests that passed.");
        printAllResults(context.getPassedTests().getAllResults());
        passcount = context.getPassedTests().getAllResults().size();
        System.err.println("Printing tests that failed.");
        printAllResults(context.getFailedTests().getAllResults());
        failedCount = context.getFailedTests().getAllResults().size();
        printAllResults(context.getSkippedTests().getAllResults());
        skipcount = context.getSkippedTests().getAllResults().size();
        zip(passcount, failedCount, skipcount);
    }

    private void printAllResults(Collection<ITestResult> results) {
        for (ITestResult result : results) {
            printResult(result);
        }
    }

    private void printResult(ITestResult result) {
        //   System.out.println(result.getStatus());
        // zip(result.getStatus());
    }

    public void zip(int Status, int failedCount, int skipcount) {
        try {
            zipUtil createZip = new zipUtil("report", ".//report//DetailedReport.zip");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}