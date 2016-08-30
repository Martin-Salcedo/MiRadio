package com.example.martinsalcedo.miradio.domain;

import com.example.martinsalcedo.miradio.io.model.JsonKeys;
import com.google.gson.annotations.SerializedName;

/**
 * Created by martinsalcedo on 10/08/16.
 */

public class Artist {

    @SerializedName(JsonKeys.ARTIST_NAME)
    String name;
    String urlLargeImage;
    String MediumImage;

    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public String getMediumImage() {
        return MediumImage;
    }

    public void setMediumImage(String mediumImage) {
        MediumImage = mediumImage;
    }

    public Artist(String nombre) {
        this.name = nombre;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }
}
