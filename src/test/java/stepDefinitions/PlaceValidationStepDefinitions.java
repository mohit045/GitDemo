package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class PlaceValidationStepDefinitions extends Utils {

	RequestSpecification req;
	ResponseSpecification responsespec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;

	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name,String language,String address) throws IOException {
		req = given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_something_with_post_http_request(String api,String method) throws Throwable {
		APIResources respurceAPI = APIResources.valueOf(api);
		System.out.println(respurceAPI.getResource());
		
		//responsespec = responseSpecification();
		responsespec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST")) {
		response = req.when().post(respurceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("GET")) {
			response = req.when().get(respurceAPI.getResource());
		}
		String rescorrect = response.asString();
		System.out.println(rescorrect);
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code_200(int value) throws Throwable {
		assertEquals(value, response.getStatusCode());
	}

	@And("{string} in response body is {string}")
	public void something_in_response_body_is_something(String key, String value) {
		//String realtest = response.asString();
		//js = new JsonPath(realtest);
		assertEquals(value, getJsonPath(response, key));
	}
	
	@And("verify place_id created maps to {string} using {string}")
	public void verify_pace_id(String expectedName,String api) throws Throwable {
		//prepare requestspec
		place_id= getJsonPath(response, "place_id");
		//getAPI call
		req = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_something_with_post_http_request(api,"GET");
		String actualName = getJsonPath(response, "name");
		assertEquals(expectedName, actualName);
		
		//
		//validate name
		
	}
	
		@Given("DeletePlace payload")
		public void delete_place_payload() throws IOException {
		    // Write code here that turns the phrase above into concrete actions
			req = given().spec(requestSpecification()).body(data.deletePayload(place_id));
		}




}
