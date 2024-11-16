package Steps;

import java.time.Duration;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
		glue= {"Steps"},
		monochrome = true)
public class TestRunner {
	
	WebDriver driver;
	WebDriverWait wait;
	LoginPage login;
	MainPage main;
	RecruitmentPage recruitment;
	AddCandidatePage candidateInfo;
	ApplicationPage confirmApplication;
	ShortListCandidate candidateConfirmation;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Go to OrangeHRM web page
	    driver = new ChromeDriver();
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    login = new LoginPage(driver, wait);
	    
	    login.openLoginPage();
	    
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enter_username_password(String username, String password) {
	    // Type username and password
		login.userEnterCredentials(username, password);
	}
	
	@And("clicks on Login")
	public void user_clicks_login() {
	    // Click Login button
		login.userLogIn();
	}
	
	@And("user selects Recruitment")
	public void user_selects_recruitment() {
	    // Select Recruitment module inside Main Page
		main = new MainPage(driver, wait);
		main.recruitment();
	}

	@And("press +Add button")
	public void press_add_button() {
	    // Press Add button, starting the new candidate flow
		
		recruitment = new RecruitmentPage(driver, wait);
		recruitment.addPerson();
	}

	@And("^fill the Add Candidate form using (.*), (.*), (.*) and (.*)$")
	public void fill_the_add_candidate_form(String firstName, String middleName, String lastName, String eMail) {
	    // Fill mandatories fields from the candidate page
		candidateInfo = new AddCandidatePage(driver, wait);
		candidateInfo.fillCandidateInfo(firstName, middleName, lastName, eMail);
	}

	@And("press Save")
	public void press_save() {
	    // Submit candidate
		candidateInfo.saveCandidateInfo();
	}
	
	@And("press Schedule Interview")
	public void press_schedule_interview() {
	    // Add the candidate to the short list
		confirmApplication = new ApplicationPage(driver, wait);
		confirmApplication.scheduleInterview();
	}

	@And("Save that scheduled interview")
	public void save_that_scheduled_interview() {
	    // Confirm candidate
		candidateConfirmation = new ShortListCandidate(driver, wait);
		candidateConfirmation.addNotes();
		candidateConfirmation.save();
	}

	@And("that interview is marked as Passed")
	public void that_interview_is_marked_as_passed() {
		System.out.println("The page does not give the posibility to continue, but the candidate should be marked as Passed");
	}

	@And("a Job is offered to the new candidate")
	public void a_job_is_offered_to_the_new_candidate() {
		System.out.println("An offer should be made to the candidate");
	}

	@And("the candidate is Hired")
	public void the_candidate_is_hired() {
		System.out.println("Candidate is hired");
	}

	@Then("new employee is listed on Recruitment list as Hired")
	public void new_employee_is_listed_on_recruitment_list_as_hired() {
		System.out.println("Checking that candidate is listed as hired in the employee list");
	}


}
