package com.lucine.toread.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Utils {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getToReads() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://39.98.113.183/reads/")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String searchToReads(String key) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://39.98.113.183/reads/search/" + key)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
