package com.example.martinsalcedo.miradio.io;

import com.example.martinsalcedo.miradio.io.model.ArtistResponse;

import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by martinsalcedo on 13/08/16.
 */

public interface LastFMApiService {

    @GET(ConstansApi.URL_ARTISTS)
//    Recib
//    void getArtists (HipedArtistFragment serveResponse);
    void getArtists(Callback<ArtistResponse> serverResponse);
}
