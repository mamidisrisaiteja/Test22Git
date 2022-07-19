package stepSefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import junit.framework.Assert;

public class StepDefinition1 {
	Response response,responseGet;
	RequestSpecification res;
	@Given("The info about the API baseURI")
	public void add_place_api_base_uri() {
		RestAssured.baseURI="https://rahulshettyacademy.com";//we will specify base URI
	    res=RestAssured.given(); ///here the variable res of type Response is defined within the mehtod 
		// so it inturn is a local varaibla and it cannot be resolved when used in other mehtod within the same class
		// the solution for this is to define this variable globally
	}

	@When("The user adds the new place details")  // action step
	public Response the_user_adds_the_new_place_details() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		JSONParser jsonParser=new JSONParser(); //it performs operations on jsondata
		FileReader fr=new FileReader("C:\\Users\\AN574BV\\git\\TejaToJasmiCucu1507221713\\Test22Git\\Test22\\src\\test\\java\\objectresources\\demoJson.json");//it reads jsondata butnot know how to handle with it
		Object obj=	jsonParser.parse(fr);//storing file content in java object(obj)
		JSONObject jsonobject=(JSONObject)obj;// typecasting javaobject into jsonobject
		      String strobj=jsonobject.toString();   // inorder to transport the data through network we have to serialize the data(converted into string)
		      //serialization - converting lumpsum data into series of characters
		      
		      

		response=  res.queryParam("key","qaclick123") ///here the variable response of type Response is defined within the mehtod 
				// so it inturn is a local varaibla and it cannot be resolved when used in other mehtod within the same class
				// the solution for this is to define this variable globally.
						.headers("Content-Type","application/json")
						.body(strobj)
						.post("maps/api/place/add/json");
				response.prettyPrint();
				
				return response;
				//response.jsonPath().getString("place_id");
				
				
	}

	@Then("The post API gets successfull response with status code {int}")
	public void the_post_api_gets_successfull_response_with_status_code(Integer int1) {
	   Assert.assertEquals(200,response.statusCode());
	}
	@When("The user verifies the newly added place")
	public void the_user_verifies_the_newly_added_place() throws Exception {
		responseGet=res.queryParam("place_id",the_user_adds_the_new_place_details().jsonPath().getString("place_id"))// for same classe , to access other methods no need to create an object(for non-static methods) or no need to write ClassName.methdoName(for static methods)
					             .queryParam("key", "qaclick123").headers("Content-Type","application/json") // we are using the json path int he above code to de-serailize the data from network to json formt
					             .get("/maps/api/place/get/json");
		responseGet.prettyPrint();		
			
	}
	@Then("The get API gets successfull response with status code {int}")
	public void the_get_api_gets_successfull_response_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(200,responseGet.statusCode());
	}


}
