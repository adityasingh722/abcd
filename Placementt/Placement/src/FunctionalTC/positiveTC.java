package FunctionalTC;

import java.io.IOException;
import java.util.Properties;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import pages.Kpi;
import pages.Login;
import pages.Vacancy;
import utility.base;
import utility.commonactions;


public class positiveTC extends base{
	
	Properties pro;
		

	@Test
	public void tc1() throws InterruptedException, IOException {
		
		
		logger = extent.createTest("Tc1");
		commonactions action = new commonactions();
		pro = action.readProperty();
		
		SoftAssert soft = new SoftAssert();
		logger.log(Status.INFO, "Calling Login class");
		Login obj = new Login(driver);
		logger.log(Status.INFO, "Calling doLogin");
		obj.doLogin(pro.getProperty("username1"), pro.getProperty("psd1"));
		logger.log(Status.INFO, "Checking assertion");
		soft.assertEquals(obj.isSuccessfulLogin(), true);
		logger.log(Status.INFO, "Calling Kpi class");
		Kpi obj1 = new Kpi(driver);
		logger.log(Status.INFO, "Clicking doKpi");
		obj1.doKpi();
		logger.log(Status.INFO, "Asserting doKpi");
		soft.assertEquals(obj1.isSuccessfuldoKpi(), true);
		logger.log(Status.INFO, "calling addKpi");
		obj1.addKpi(pro.getProperty("jobTitle"), pro.getProperty("keyperformanceind"), pro.getProperty("minimumRating"), pro.getProperty("maximumRating"));
		logger.log(Status.INFO, "Asserting addKpi");
		soft.assertEquals(obj1.isSuccessfuladdKpi(pro.getProperty("keyperformanceind")), true);
		soft.assertAll();
	}
	
	@Test
	public void tc2() throws InterruptedException {
    logger = extent.createTest("Tc2");
	SoftAssert soft = new SoftAssert();
	logger.log(Status.INFO, "Calling Login class");
	Login obj = new Login(driver);
	logger.log(Status.INFO, "Calling doLogin");
	obj.doLogin(pro.getProperty("username1"), pro.getProperty("psd1"));
	logger.log(Status.INFO, "Checking assertion");
	soft.assertEquals(obj.isSuccessfulLogin(), true);
	logger.log(Status.INFO, "Calling Vacancy class");
	Vacancy obj2 = new Vacancy(driver);
	logger.log(Status.INFO, "Clicking doVacancy");
	obj2.doVacancy();
	logger.log(Status.INFO, "Asserting doVacancy");
	soft.assertEquals(obj2.isSuccessfuldoVacancy(), true);
	logger.log(Status.INFO, "calling addVacancy");
	obj2.addVacancy(pro.getProperty("jobtitle"), pro.getProperty("vacancyname"), pro.getProperty("hiringmanager"), pro.getProperty("positions"));;
	logger.log(Status.INFO, "Asserting addVacancy");
	soft.assertEquals(obj2.isSuccessfuladdVacancy(pro.getProperty("vacancyname")), true);
	soft.assertAll();
}
	



	
}
