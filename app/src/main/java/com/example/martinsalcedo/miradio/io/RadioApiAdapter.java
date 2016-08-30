package com.example.martinsalcedo.miradio.io;


import com.example.martinsalcedo.miradio.io.deserializer.ArtistDeserializer;
import com.example.martinsalcedo.miradio.io.model.ArtistResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by josemartinsalcedo on 28/08/16.
 * Clase Pattern Singleton
 */

public class RadioApiAdapter {

    private static LastFMApiService API_SERVICE;

    public static LastFMApiService getApiService(){

        if (API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ConstansApi.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFMAPIGsonConverter())// metodo que tomara retrofit para el modelo del deserialized que se creo anteriormente
                    .build();

            API_SERVICE = adapter.create(LastFMApiService.class);

        }
//regresa la intancia del objeto
        return API_SERVICE;
    }

//    metodo
    public static GsonConverter buildLastFMAPIGsonConverter(){
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(ArtistResponse.class, new ArtistDeserializer())
                .create();
        return new GsonConverter(gsonConf);
    }
}
