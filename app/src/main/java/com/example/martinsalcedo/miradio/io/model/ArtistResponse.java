package com.example.martinsalcedo.miradio.io.model;


import com.example.martinsalcedo.miradio.domain.Artist;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by josemartinsalcedo on 28/08/16.
 */

public class ArtistResponse {

//    String donde encontrara en la respuesta del JSON del servidor
    @SerializedName(JsonKeys.TOPARTIST_RESULT)
    TopArtistRespnse response;
    public ArrayList<Artist> getArtist(){
        return response.artists;
    }
// Modelo de clase para obtener ls artistas, se crea de manera
    private class TopArtistRespnse{
        @SerializedName(JsonKeys.ARTIST_ARRAY)
        ArrayList<Artist> artists;
    }


}
