package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShortListCandidate {
	WebDriver driver;
	WebDriverWait wait;
	By locatorNotesInput = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/textarea[1]");
	WebElement notesInput;
	By locatorSaveButton = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]");
	WebElement saveButton;
	
	public ShortListCandidate(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void addNotes() {
		//Type a note
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatorNotesInput));
		notesInput = driver.findElement(locatorNotesInput);
		notesInput.sendKeys("OK");;
	}
	
	public void save() {
	    //Click Save
		saveButton = driver.findElement(locatorSaveButton);
		saveButton.click();
	}
	
}
