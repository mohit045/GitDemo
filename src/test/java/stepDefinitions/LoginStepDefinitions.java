package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class LoginStepDefinitions {

	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
		System.out.println("Navigate to login URL");
	}

	@When("^User enter username and password$")
	public void user_enter_username_and_password() throws Throwable {
		System.out.println("Entered username and pasd");
	}

	@Then("^Home page populated$")
	public void home_page_populated() throws Throwable {
		System.out.println("page updated");
	}

	@And("^Cards are displayed$")
	public void cards_are_displayed() throws Throwable {
		System.out.println("Card displayed  updated");
	}

}
