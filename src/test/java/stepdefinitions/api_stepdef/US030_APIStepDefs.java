package stepdefinitions.api_stepdef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebElement;
import pojos.Room;
import pojos.RoomPut;
import pojos.US028Messages111Pojo;

import java.io.IOException;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.generateAdminToken;
import static utilities.AuthenticationMedunna.generateToken;


public class US030_APIStepDefs {
    Response response;
    Room room=new Room();
    int roomNumber= Faker.instance().number().numberBetween(1000,1000000);
    int iD;
    RoomPut roomPut=new RoomPut();
    @Then("user sends post request for creating room")
    public void user_sends_post_request_for_creating_room() throws IOException {
         spec.pathParams("first", "api", "second", "rooms");

        room.setRoomNumber(roomNumber);
        room.setRoomType("TWIN");
        room.setStatus(true);
        room.setPrice(100);
        room.setDescription("This room is created by API");

        response=given(). headers("Authorization","Bearer "+ generateAdminToken()).
                contentType(ContentType.JSON).
                spec(spec).
                body(room).
                when().
                post("/{first}/{second}");
        response.prettyPrint();
        iD=response.jsonPath().getInt("id");
        System.out.println("id = " + iD);


        ObjectMapper objectMapper=new ObjectMapper();
        Room actualDataPojo=objectMapper.readValue(response.asString(),Room.class);
        System.out.println("actualDataPojo="+actualDataPojo);

        assertEquals(201, response.getStatusCode());
        assertEquals(room.getRoomNumber(),actualDataPojo.getRoomNumber());
        assertEquals(room.getRoomType(),actualDataPojo.getRoomType());
        assertEquals(room.getStatus(),actualDataPojo.getStatus());
        assertEquals(room.getDescription(),actualDataPojo.getDescription());



    }
    @Then("user sends get request for reading room")
    public void user_sends_get_request_for_reading_room() throws IOException {

       System.out.println("id = " + iD);

        spec.pathParams("first", "api", "second", "rooms","third", iD);
        //https://medunna.com/api/rooms/1455

        response=given().header("Authorization", "Bearer "+generateAdminToken()).spec(spec).when().get("/{first}/{second}/{third}");

        response.prettyPrint();

        assertEquals(200, response.getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        Room actualDataGetPojo=objectMapper.readValue(response.asString(),Room.class);
        System.out.println("actualDataPojo="+actualDataGetPojo);

        assertEquals(room.getRoomNumber(),actualDataGetPojo.getRoomNumber());
        assertEquals(room.getRoomType(),actualDataGetPojo.getRoomType());
        assertEquals(room.getStatus(),actualDataGetPojo.getStatus());
        assertEquals(room.getDescription(),actualDataGetPojo.getDescription());



    }
    @Then("user sends put request for updating room")
    public void user_sends_put_request_for_updating_room() throws IOException {
        spec.pathParams("first", "api", "second", "rooms");
        RoomPut roomPut=new RoomPut();
        roomPut.setRoomNumber(roomNumber);
        roomPut.setRoomType("TWIN");
        roomPut.setStatus(true);
        roomPut.setPrice(200);
        roomPut.setId(iD);
        roomPut.setDescription("This room is TWIN room");

        response=given().header("Authorization","Bearer "+ generateAdminToken()).
                contentType(ContentType.JSON).
                spec(spec).
                body(roomPut).
                when().
                put("/{first}/{second}");
        response.prettyPrint();

        System.out.println(response.jsonPath().getString("roomNumber"));
        assertEquals(200, response.getStatusCode());

        ObjectMapper objectMapper=new ObjectMapper();
        RoomPut actualDataPojo=objectMapper.readValue(response.asString(),RoomPut.class);
        System.out.println("actualDataPojo="+actualDataPojo);

        assertEquals(roomPut.getRoomNumber(),actualDataPojo.getRoomNumber());
        assertEquals(roomPut.getRoomType(),actualDataPojo.getRoomType());
        assertEquals(roomPut.getStatus(),actualDataPojo.getStatus());
        assertEquals(roomPut.getDescription(),actualDataPojo.getDescription());

    }
    @Then("user sends delete request for deleting room")
    public void user_sends_delete_request_for_deleting_room() {

        spec.pathParams("first", "api", "second", "rooms","third", iD);
        //https://medunna.com/api/rooms/1455

        response=given().header("Authorization", "Bearer "+generateAdminToken()).spec(spec).when().delete("/{first}/{second}/{third}");

        response.prettyPrint();

        assertEquals(204, response.getStatusCode());
        System.out.println("US030 API done");


    }

}
