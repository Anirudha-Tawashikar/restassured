package stepdefination;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import demo.Addplace;
import demo.Location;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resourses.Apiresourses;
import resourses.testdatabulid;
import resourses.utillities;

public class deifination1 extends utillities{

	 RequestSpecification res;
	 ResponseSpecification responspec;
	 Response response;
	 testdatabulid data = new testdatabulid();
	  String place_id;
	
	 
	 @Given("Add place payload {string} {string} {string}")
	 public void add_place_payload(String name, String language, String adderss) throws IOException{
	    // Write code here that turns the phrase above into concrete actions
	    

		   responspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		    res = given().spec(requestspecification())
		   .body(data.addplacepayload(name,language,adderss));
		   
	}

	 
		 @When("user calls {string} with {string} http request")
		 public void user_calls_with_http_request(String resourses, String method) {
	    // Write code here that turns the phrase above into concrete actions
		
		Apiresourses resourseAPI=Apiresourses.valueOf(resourses);
		System.out.println(resourseAPI.getresourses());
		
		if(method.equalsIgnoreCase("POST"))
			 response= res .when().post(resourseAPI.getresourses());
		else if (method.equalsIgnoreCase("GET"))
		 response= res .when().get(resourseAPI.getresourses());
		
		 }
				  
		   
	

	@Then("the API call is the success with the status code {int}")
	public void the_api_call_is_the_success_with_the_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
		
		 
		assertEquals(getJsonPath(response,keyvalue),expectedvalue);
	
		
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resourse) throws IOException {
		
		
		//specification
		 place_id = getJsonPath(response,"place_id");
		res = given().spec(requestspecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(resourse,"GET");
		 String actualName = getJsonPath(response, "name");
		 assertEquals(actualName, "ajhjhj");
		 
}
	

	@Given("delete payload")
	public void delete_payload() throws IOException {
	  
		res =given().spec(requestspecification()).body(data.deleteplacepayload(place_id));
	
}
}

