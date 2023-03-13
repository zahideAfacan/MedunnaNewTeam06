package stepdefinitions.api_stepdef;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.generateAdminToken;

public class US031ApiStepDefs {

    Response response;

    @Given("user sends get request for getting all physicians and validate")
    public void user_sends_get_request_for_getting_all_physician_and_validate() {



        spec.pathParams("first", "api", "second","physicians").queryParams("page",1, "size",30);

        //  https://medunna.com/api/physicians?page=1&size=20

        response=given().spec(spec).header("Authorization", "Bearer "+generateAdminToken()).get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(200, response.getStatusCode());

    }

}
