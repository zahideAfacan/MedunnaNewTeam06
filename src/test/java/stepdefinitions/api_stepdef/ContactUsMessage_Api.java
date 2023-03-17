package stepdefinitions.api_stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.ContactMessagePojo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static base_urls.MedunnaBaseUrl.medunnaSetUp;
import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.generateToken;

public class ContactUsMessage_Api {
    Response response;
    String id;

    @Given("user goes to medunna message page")
    public void user_goes_to_medunna_message_page() {
        medunnaSetUp();
       spec.pathParams("first","api","second","c-messages");
    }
    @Then("posts a message and user validates message")
    public void posts_a_message() {
        Map<String , String> expectedData=new HashMap<>();
expectedData.put("id","");
expectedData.put("email","mdrky@gmailcom");
expectedData.put("message", "Postman Try Out");
expectedData.put("name", "Macit Kutlu");
expectedData.put("subject", "Postman Deneme Yanilma");
response=given().headers("Authorization","Bearer "+generateToken()+"","Accept",ContentType.JSON,"Content-Type", ContentType.JSON).
        spec(spec).body(expectedData).post("/{first}/{second}");
response.prettyPrint();
        Map<String,Object> actualData=response.as(HashMap.class);
        Assert.assertEquals(201,response.getStatusCode());
       Assert.assertEquals(expectedData.get("email"),actualData.get("email"));
       Assert.assertEquals(expectedData.get("name"),actualData.get("name"));
       Assert.assertEquals(expectedData.get("subject"),actualData.get("subject"));
       Assert.assertEquals(expectedData.get("message"),actualData.get("message"));

   id=actualData.get("id").toString() ;
        System.out.println(id);

    }
    @Given("user goes to medunna all message  page")
    public void user_goes_to_medunna_all_message_page() {
    medunnaSetUp();
    spec.pathParams("first","api","second","c-messages").queryParam("size",300);

    }
    @Then("gets all messages and validates created message")
    public void gets_all_messages_and_validates_created_message() {
        response = given().headers("Authorization", "Bearer " + generateToken() + "", "Accept", "*/*", "Content-Type", "application/json")
                .spec(spec).when().get("/{first}/{second}");

response.prettyPrint();
response.then().assertThat().statusCode(200).body("name",hasItem("Macit Kutlu"),"email",hasItem("mdrky@gmailcom"));

    }
}
