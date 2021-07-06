package com.sentient.poc.config;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;

public class extentReports {
	public static String Report_Path = null;
	private static ExtentHtmlReporter htmlReporter;

	public static ExtentHtmlReporter createInstance(String fileName) {
		htmlReporter = new ExtentHtmlReporter(fileName);
       /* String Report_Timestamp;
        Report_Timestamp = "Extent_Report" + (LocalDateTime.now()).getHour() + "_"
                + (LocalDateTime.now()).getMinute() + "_" + (LocalDateTime.now()).getSecond();

        Report_Path = System.getProperty("user.dir") + "//Report//" + Report_Timestamp;
        File f1 = new File(Report_Path);
        f1.mkdir();
        File F2 = new File(Report_Path + "//" + "Snapshot");
        F2.mkdir();
        htmlReporter = new ExtentHtmlReporter(Report_Path + "//STMExtentReport" + "_" + Report_Timestamp + ".html");*/

		// Chart location - top, bottom
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);

		// Make the charts visible on report open
		htmlReporter.config().setChartVisibilityOnOpen(true);

		// Theme - standard, dark
		htmlReporter.config().setTheme(Theme.STANDARD);

		// Report title
		htmlReporter.config().setDocumentTitle("Automation Report - PrimeBpmApp");

		// Append Tests to Existing Report
		htmlReporter.setAppendExisting(true);

		// Protocol (http, https)
		htmlReporter.config().setProtocol(Protocol.HTTPS);

		// Encoding, default = UTF-8
		htmlReporter.config().setEncoding("utf-8");

		// Report or build name
		htmlReporter.config().setReportName("PrimeBpmApp Report");

		// Set timeStamp format
//        htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");

		return htmlReporter;
	}
}