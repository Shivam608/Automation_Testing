package com.Practice.RestAssured.Places.Pojos;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CommaSeparatedStringDeserializer extends JsonDeserializer<String[]> {
    @Override
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getValueAsString();
        return value != null? value.split(",") : new String[0];
    }
}
