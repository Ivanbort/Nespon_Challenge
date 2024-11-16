package Steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MainPage {
	WebDriver driver;
	WebDriverWait wait;
	By locatorRecruitmentButton = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[5]/a[1]");
	WebElement recruitmentButton;
	
	public MainPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void recruitment() {
	    // Enter to Recruitment module
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorRecruitmentButton));
		recruitmentButton = driver.findElement(locatorRecruitmentButton);
		recruitmentButton.click();
	}
}
