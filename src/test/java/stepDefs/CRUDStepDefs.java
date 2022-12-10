package stepDefs;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDStepDefs {

	Response response;
	RequestSpecification request;
	Map<String, Object> MapObj;
	
	@Given("The Base URI is {string}")
	public void the_Base_URI_is(String URI) {
		request = RestAssured.given().baseUri(URI);
	}

	@When("I perform the GET Operation")
	public void i_perform_the_GET_Operation() {
		response = request.get();
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int ExpResponseCode) {
		Assert.assertEquals(ExpResponseCode, response.getStatusCode());
	}
	
	@When("I provide with name {string} and salary {string}")
	public void i_provide_with_name_and_salary(String name, String salary) {
		MapObj = new HashMap<String, Object>();
		MapObj.put("name", name);
		MapObj.put("salary", salary);
	}

	@When("I perform POST operation")
	public void i_perform_POST_operation() {
		response = request
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(MapObj)
					.post("/create");
	}
	
}
