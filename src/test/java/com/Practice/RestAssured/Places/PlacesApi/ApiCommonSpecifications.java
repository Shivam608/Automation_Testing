package com.Practice.RestAssured.Places.PlacesApi;

import com.Practice.RestAssured.Places.Pojos.DeletePlaceById;
import com.Practice.RestAssured.Places.Pojos.Location;
import com.Practice.RestAssured.Places.Pojos.PlaceDetails;
import com.Practice.Selenium.BaseMethods.BaseTestUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiCommonSpecifications extends BaseTestUtils {

    String baseUri = "https://rahulshettyacademy.com";
    public RequestSpecBuilder genericSpec = new RequestSpecBuilder().setBaseUri(baseUri).setContentType(ContentType.JSON);
    protected static final String key = "qaclick123";


    public RequestSpecification resSpecPost() {

        return new RequestSpecBuilder().setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .setBody(placeDetails())
                .build();
    }

    public PlaceDetails placeDetails() {
        Location location = new Location("32.345654", "45.33452");
        return new PlaceDetails(
                location,
                50,
                "TestSubject",
                "91234565432",
                "Test Address",
                new String[]{"Test_1", "Test_2"},
                "Test.co.in",
                "English"
        );
    }

    public RequestSpecification resSpecGet() {
        return new RequestSpecBuilder().setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation().build();
    }

    public RequestSpecification resSpecDelete(String place_Id) {
        DeletePlaceById deletePlaceById = new DeletePlaceById();
        deletePlaceById.setPlace_id(place_Id);
        return genericSpec
                .addQueryParam("key", key)
                .setBody(deletePlaceById)
                .build();
    }


}
