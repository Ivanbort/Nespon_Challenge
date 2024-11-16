package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationPage {
	WebDriver driver;
	WebDriverWait wait;
	By locatorScheduleInterview = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/button[2]");
	WebElement scheduleInterviewButton;
	
	public ApplicationPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void scheduleInterview() {
	    // According to documentation the button should be called Schedule Interview, but in reality is called Short List.
		// Add to Short List
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorScheduleInterview));
		scheduleInterviewButton = driver.findElement(locatorScheduleInterview);
		scheduleInterviewButton.click();
	}
}
