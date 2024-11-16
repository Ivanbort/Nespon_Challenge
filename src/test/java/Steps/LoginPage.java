package Steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	
		WebDriver driver = null;
		WebDriverWait wait = null;
		String projectPath;
		String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		By inputUserName = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]");
		By inputPassword = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
		By loginButton = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]");
		WebElement weInputUserName;
		WebElement weInputPassword;
		WebElement weLoginButton;
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		
		projectPath = System.getProperty("user.dir");
		this.driver = driver;
		this.wait = wait;
	}
	

	public void openLoginPage() {
		
	    System.getProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
	    
	    //Navigate to the OrangeHRM WebPage
	    
	    driver.navigate().to(URL);	    
	}


	public void userEnterCredentials(String username, String password) {
	    // Enter username credential
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inputUserName));
		weInputUserName = driver.findElement(inputUserName);
		
		
		weInputUserName.sendKeys(username);
		
		// Enter password credential
		weInputPassword = driver.findElement(inputPassword);
		weInputPassword.sendKeys(password);
	}
	
	public void userLogIn() {
	    // Submit login
		
		weLoginButton = driver.findElement(loginButton);
		weLoginButton.click();
	}

	

	
}
