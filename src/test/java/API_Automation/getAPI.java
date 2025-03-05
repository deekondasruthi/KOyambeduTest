package API_Automation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getAPI {
    @Test
    public void get()
    {
        given()
                .when()
                        .get("https://sk-api.babujiventures.in/price/viewall")
                .then()
                .statusCode(200)
                        .header("content-Type","application/json");


    }
}
