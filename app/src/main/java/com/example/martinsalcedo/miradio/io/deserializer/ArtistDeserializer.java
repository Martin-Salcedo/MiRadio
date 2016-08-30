package com.example.martinsalcedo.miradio.io.deserializer;

import com.example.martinsalcedo.miradio.domain.Artist;
import com.example.martinsalcedo.miradio.io.model.ArtistResponse;
import com.example.martinsalcedo.miradio.io.model.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by josemartinsalcedo on 28/08/16.
 */

public class ArtistDeserializer implements JsonDeserializer<ArtistResponse>{

    @Override
    public ArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        ArtistResponse response =  gson.fromJson(json, ArtistResponse.class);

        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTIST_ARRAY);
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTIST_ARRAY);
    }
}
