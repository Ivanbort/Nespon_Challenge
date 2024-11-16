package Steps;

//import java.io.File;

//import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCandidatePage {
	WebDriver driver;
	WebDriverWait wait;
	By locatorFirstName = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
	WebElement inputFirstName;
	By  locatorMiddleName = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/input[1]");
	WebElement inputMiddleName;
	By  locatorLastName = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]");
	WebElement inputLastName;
	By  locatoreMail = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]");
	WebElement inputeMail;
	By locatorDrpVacancy = By.xpath("//div[contains(text(),'-- Select --')]");
	WebElement drpVacancy;
	By locatorConsent = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[7]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/span[1]/i[1]");
	WebElement checkConsent;
	By locatorResume = By.xpath("//div[contains(text(),'Browse')]");
	WebElement resume;
	//File file = new File("D:\\test_resume.txt");
	//String path = file.getAbsolutePath();
	By locatorSave = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[8]/button[2]");
	WebElement buttonSave;
	
	public AddCandidatePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void fillCandidateInfo(String firstName, String middleName, String lastName, String eMail) {
	    // Complete first name
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorFirstName));
		inputFirstName = driver.findElement(locatorFirstName);
		inputFirstName.sendKeys(firstName);

		// Complete middle name
		inputMiddleName = driver.findElement(locatorMiddleName);
		inputMiddleName.sendKeys(middleName);
		
		// Complete last name
		inputLastName = driver.findElement(locatorLastName);
		inputLastName.sendKeys(lastName);
		
		// Complete email
		inputeMail = driver.findElement(locatoreMail);
		inputeMail.sendKeys(eMail);

		// Complete Vacancy
		drpVacancy = driver.findElement(locatorDrpVacancy);
		drpVacancy.click();
		drpVacancy.sendKeys(Keys.DOWN);
		drpVacancy.sendKeys(Keys.RETURN);
		
		// Check consent
		checkConsent = driver.findElement(locatorConsent);
		checkConsent.click();
				
	}
	
	public void saveCandidateInfo() {
		// Click Save
		buttonSave = driver.findElement(locatorSave);
		buttonSave.click();
				
	}
}
