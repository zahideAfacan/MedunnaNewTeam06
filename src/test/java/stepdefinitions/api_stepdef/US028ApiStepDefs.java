package stepdefinitions.api_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.US028Messages111Pojo;

import java.io.IOException;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.generateAdminToken;
import static utilities.ReusableMethods.waitFor;


public class US028ApiStepDefs {

    US028Messages111Pojo message=new US028Messages111Pojo();
    Faker faker=new Faker();

    String name=faker.name().fullName();

    Response response;
    Response getResponse;

    int id;


    @Given("user sends post request for creating message and validate")
    public void user_sends_post_request_for_creating_message_and_validate() throws IOException {   // https://medunna.com/api/c-messages
        spec.pathParams("first", "api", "second", "c-messages");

        message.setEmail("api@US028.tr");
        message.setName(name);
        message.setSubject("creating api message");
        message.setMessage("Bir gül açılmaz yüzün tek verse bin gül-zare su");

        response=given().
                header("Authorization","Bearer "+ generateAdminToken()).
                contentType(ContentType.JSON).
                spec(spec).
                body(message).
                post("/{first}/{second}");

        response.prettyPrint();

        id=response.jsonPath().getInt("id");


        //Validation

        assertEquals(201,response.getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();

        US028Messages111Pojo actualMessage= objectMapper.readValue(response.asString(),US028Messages111Pojo.class);

        assertEquals(message.getName(),actualMessage.getName());
        assertEquals(message.getEmail(),actualMessage.getEmail());
        assertEquals(message.getSubject(),actualMessage.getSubject());
        assertEquals(message.getMessage(),actualMessage.getMessage());


    }
    @When("user sends get request for reading message and validate")
    public void user_sends_get_request_for_reading_message_and_validate() throws IOException {
        System.out.println("id = " + id);

        spec.pathParams("first", "api", "second","c-messages","third", id);

        //https://https://medunna.com/api/c-messages/id

        response=given().header("Authorization", "Bearer "+generateAdminToken()).spec(spec).get("/{first}/{second}/{third}");

        response.prettyPrint();



        //Validation

        assertEquals(200, response.getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();

        US028Messages111Pojo actualMessage= objectMapper.readValue(response.asString(),US028Messages111Pojo.class);

        assertEquals(message.getName(),actualMessage.getName());
        assertEquals(message.getEmail(),actualMessage.getEmail());
        assertEquals(message.getSubject(),actualMessage.getSubject());
        assertEquals(message.getMessage(),actualMessage.getMessage());
        waitFor(3);

        //olusturulan mesaji silelim kalabalik yapmasin

  //      response=given().header("Authorization", "Bearer "+generateAdminToken()).spec(spec).delete("/{first}/{second}/{third}");
  //      assertEquals(204,response.getStatusCode());

    }
    @Given ("user sends get request for reading all message and validate")
    public void user_sends_get_request_for_reading_all_message_and_validate() {

        spec.pathParams("first", "api", "second","c-messages").queryParams("page",1, "size",50);

        //https://medunna.com/api/c-messages?page=1&size=200

        response=given().spec(spec).header("Authorization", "Bearer "+generateAdminToken()).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(200, response.getStatusCode());


    }


}
