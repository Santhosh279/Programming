package com.framework.selenium.Hybrid_Framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.base.GenericWrappers;

public class KervDigitalTestCase extends GenericWrappers {

	@BeforeTest
	public void setValues() {
		testCaseName = "Kerv Digital";
		testDescription = "Create Profile with mandatory fields";
		authors = "Santhosh";
		category = "Load Testing";

	}

	@Test(invocationCount = 250)
	public void createProfile() throws Exception {
		invokeApp("Chrome", "https://kerv.com/about-kerv/kerv-dividons/kerv-digital");
		clickByXpath("(//a[contains(text(), 'Accept all')])[1]");
		clickByActions("(//a[contains(text(), 'Careers')])[1]");
		clickByXpath("//a[text()='Job Opportunities']");
		pageDown("//div[contains(text(), 'Test Engineer (Hybrid Manual/Automation)')]");
		clickUsingJavascriptXpath("(//div[contains(text(), 'UX Designer')])[1]");
		switchToWindow(1);
		scrollDownUsingJS("//input[@id='candidate_first_name']");
		enterById("candidate_first_name", "Santhosh");
		enterById("candidate_last_name", "PV");
		enterById("candidate_email", "sanzany07@gmail.com");
		enterById("candidate_phone", "9874562314");
		Thread.sleep(2000);
		fileUploadUsingId("resume");
		System.out.println("Resume is Clicked ");
		scrollDownUsingJS("(//label[contains(text(), 'Yes, I agree')])[1]");
		Thread.sleep(2000);
		// scrollDownUsingJS();
		clickUsingJavascriptXpath("(//label[contains(text(), 'Yes, I agree')])[1]");
		clickByXpath("(//label[contains(text(), 'Yes, I agree')])[2]");
		clickByXpath("//button[@name='_job_application_form']");
		threadSleep(4000);
		verifyPartialText("//p[contains(text(), 'Thank you for your application.')]",
				"Thank you for your application.");
		quitBrowser();

	}

}
