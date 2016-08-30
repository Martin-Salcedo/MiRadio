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
import java.util.ArrayList;

/**
 * Created by josemartinsalcedo on 28/08/16.
 */

public class ArtistDeserializer implements JsonDeserializer<ArtistResponse>{

    @Override
    public ArtistResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        ArtistResponse response =  gson.fromJson(json, ArtistResponse.class);
// obtenemos el objeto Artist
        JsonObject artistResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.TOPARTIST_RESULT);//elemtos del JsonElement Global
//        obtener el array de Artist
        JsonArray artistArray = artistResponseData.getAsJsonArray(JsonKeys.ARTIST_ARRAY);//arreglos
//        convertir el jsonArrayArtist a objetos de la clase Artist
        response.SetArtist(ExtractArtristFromJson(artistArray));

        return response;
    }

//    metodo para obtener el nombre del artist
    private ArrayList<Artist> ExtractArtristFromJson(JsonArray array){

        ArrayList<Artist> artists =  new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {

            JsonObject arrayData = array.get(i).getAsJsonObject();

            Artist currentArtist = new Artist();
//            obtenemos el nombre del artista
            String name = arrayData.get(JsonKeys.ARTIST_NAME).toString();
//            obtenemos el array de las url de los artistas
            JsonArray imageArray = arrayData.getAsJsonArray(JsonKeys.IMAGE_ARRAY);
//              Regresa las imagenes
            String[] images = ExtractArtistImageFromArrayList(imageArray);

//            objeto de salida con toda la informacion seteada
            currentArtist.setNombre(name);
            currentArtist.setMediumImage(images[0]);
            currentArtist.setUrlLargeImage(images[1]);

            artists.add(currentArtist);

        }
        return artists;
    }
//metodo para obtener
    private String[] ExtractArtistImageFromArrayList(JsonArray imageArray){

        String[] images = new String[2];

        for (int i = 0; i < imageArray.size(); i++) {

            JsonObject imageData = imageArray.get(i).getAsJsonObject();

            String size = imageData.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = imageData.get(JsonKeys.IMAGE_URL).getAsString();

            if (url.isEmpty())
                url= null;
            else
                url = url.replace("\\/", "/");

            if (size.matches(JsonKeys.IMAGE_MEDIUM)){
                images[0] = url;
            }else if (size.matches(JsonKeys.IMAGE_BIG)){
                images[1] = url;
            }
        }

        return  images;
    }
}
