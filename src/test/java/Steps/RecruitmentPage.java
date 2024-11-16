package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {
	WebDriver driver;
	WebDriverWait wait;
	By locatorAddButton = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]");
	WebElement addButton;
	
	public RecruitmentPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void addPerson() {
	    // click in Add button
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorAddButton));
		addButton = driver.findElement(locatorAddButton);
		addButton.click();
	}
}
