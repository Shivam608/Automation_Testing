package com.Practice.RestAssured.Places;

import com.Practice.RestAssured.Places.PlacesApi.ApiCommonMethods;
import com.Practice.RestAssured.Places.Pojos.PlaceDetails;
import com.Practice.RestAssured.Places.Pojos.PostResponsePayload;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestClass extends ApiCommonMethods {

    @Test
    public void addPlace() {
        PostResponsePayload postResponsePayload = restApiPost();
        System.out.println(postResponsePayload.getPlace_id());
        PlaceDetails placeDetails = restApiGetById(postResponsePayload.getPlace_id());
        System.out.println(placeDetails.getAccuracy());
        System.out.println(Arrays.toString(placeDetails.getTypes()));

        for (String s : placeDetails.getTypes()) {
            System.out.println(s);
        }

        boolean b = restApiDeleteByID(postResponsePayload.getPlace_id());
        System.out.println(b);
    }
}
