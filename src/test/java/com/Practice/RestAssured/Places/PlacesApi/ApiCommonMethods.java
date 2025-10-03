package com.Practice.RestAssured.Places.PlacesApi;

import com.Practice.RestAssured.Places.Pojos.PlaceDetails;
import com.Practice.RestAssured.Places.Pojos.PostResponsePayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.lessThan;

public class ApiCommonMethods extends ApiCommonSpecifications{

    public PostResponsePayload restApiPost() {
        return RestAssured.given()
                .queryParam("key", key)
                .spec(resSpecPost())
                .when().get("/maps/api/place/add/json")
                .then()
                .assertThat().statusCode(200)
                .time(lessThan(5000L))
                .extract().response()
                .as(PostResponsePayload.class);
    }

    public PlaceDetails restApiGetById(String placeId) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("key", key);
        queryParams.put("place_id", placeId);
        return RestAssured.given()
                .spec(resSpecGet())
                .queryParams(queryParams)
                .when().get("/maps/api/place/get/json")
                .then().extract().response()
                .as(PlaceDetails.class);
    }

    public boolean restApiDeleteByID(String place_Id) {
        String status = RestAssured.given()
                .spec(resSpecDelete(place_Id))
                .when().delete("/maps/api/place/delete/json")
                .then().extract().response().then().extract().path("status");

        return status.toLowerCase().contains("ok");
    }
}
