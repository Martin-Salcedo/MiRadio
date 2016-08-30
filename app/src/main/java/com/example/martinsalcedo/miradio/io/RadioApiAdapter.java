package com.example.martinsalcedo.miradio.io;


import retrofit.RestAdapter;

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
                    .build();

            API_SERVICE = adapter.create(LastFMApiService.class);

        }
//regresa la intancia del objeto
        return API_SERVICE;
    }
}
