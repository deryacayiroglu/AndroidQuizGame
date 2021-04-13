package com.h5190004.derya_cayiroglu.utils;

import com.google.gson.Gson;
import com.h5190004.derya_cayiroglu.model.OyuncuModel;

public class ObjectUtil {
    public static String oyuncuToJsonString(OyuncuModel oyuncu)
    {
        Gson gson = new Gson();
        return gson.toJson(oyuncu);
    }
    public static OyuncuModel jsonStringToOyuncu(String jsonString)
    {
        Gson gson = new Gson();
        return gson.fromJson(jsonString,OyuncuModel.class);
    }
}
