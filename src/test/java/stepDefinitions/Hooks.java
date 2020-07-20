package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable {
		
		PlaceValidationStepDefinitions psd = new PlaceValidationStepDefinitions();
		if(PlaceValidationStepDefinitions.place_id==null) {
		psd.add_place_payload("Pragya","Odia","Rambha ganjam");
		psd.user_calls_something_with_post_http_request("addPlaceAPI", "POST");
		psd.verify_pace_id("Pragya", "getPlaceAPI");
		}
		
	}
}
