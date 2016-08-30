package com.example.martinsalcedo.miradio.io;

/**
 * Created by josemartinsalcedo on 27/08/16.
 */

public class ConstansApi {
//http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country=mexico&api_key=e832156f0dadacec033448bf900832b8&format=json
    public static final String API_KEY = "e832156f0dadacec033448bf900832b8";

    public static final String URL_BASE = "http://ws.audioscrobbler.com";
    public static final String VERSION = "/2.0/";
    public static final String METHOD = "method";
    public static final String PARAM_METHOD = "geo.gettopartists";
    public static final String COUNTRY = "country";
    public static final String PARAM_COUNTRY = "mexico";
    public static final String PARAM_API = "api_key";
    public static final String FORMAT = "format";
    public static final String PARAM_FORMAT = "json";

    public static final String URL_ARTISTS = VERSION + "?" + METHOD + "="+ PARAM_METHOD
            + "&" + COUNTRY + "=" + PARAM_COUNTRY + "&" + PARAM_API + "=" +API_KEY + "&" + FORMAT + "=" + PARAM_FORMAT;

}
