package com.lucine.toread.model;

import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ToReads {
    private List<ToReadItem> items = new ArrayList<>();

    public ToReads(String content) throws JSONException {

        JSONArray jsonArray = new JSONArray(content);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject itemObject = jsonArray.getJSONObject(i);

            ToReadItem item = new ToReadItem();
            item.title = itemObject.getString("title");;
            item.doubanStar = itemObject.getDouble("douban");

            this.items.add(item);
        }
    }

    public List<ToReadItem> GetItems() {
        return this.items;
    }
}
