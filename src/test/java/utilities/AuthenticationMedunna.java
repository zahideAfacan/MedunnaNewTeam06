package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {

    public static void main(String[] args) {
        System.out.println("generateToken() = " + generateToken());
        System.out.println("generateStaffToken() = " + generateStaffToken());
        System.out.println("generateHastaToken() = " + generateHastaToken());
        System.out.println("generateAdminToken() = " + generateAdminToken());
    }
    public static String generateToken() {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("password", "Mark.123");
        hashMap.put("rememberMe", true);
        hashMap.put("username", "mark_twain");

        Response response = given().contentType(ContentType.JSON).body(hashMap).when().post("https://medunna.com/api/authenticate");

        String token = response.jsonPath().getString("id_token");

        return token;

    }


    public static String generateStaffToken() {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("password", "Stafkisi123");
        hashMap.put("rememberMe", true);
        hashMap.put("username", "stafkisi");

        Response response = given().contentType(ContentType.JSON).body(hashMap).when().post("https://medunna.com/api/authenticate");

        String tokenStaff = response.jsonPath().getString("id_token");

        return tokenStaff;

    }

    public static String generateHastaToken() {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("password", "hastayikurcalama");
        hashMap.put("rememberMe", true);
        hashMap.put("username", "hastayikurcalama");

        Response response = given().contentType(ContentType.JSON).body(hashMap).when().post("https://medunna.com/api/authenticate");

        String tokenHasta = response.jsonPath().getString("id_token");

        return tokenHasta;

    }

    public static String generateAdminToken() {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("password", "Team06+");
        hashMap.put("rememberMe", true);
        hashMap.put("username", "AdminTeam06");

        Response response = given().contentType(ContentType.JSON).body(hashMap).when().post("https://medunna.com/api/authenticate");

        String tokenAdmin = response.jsonPath().getString("id_token");

        return tokenAdmin;

    }




}
