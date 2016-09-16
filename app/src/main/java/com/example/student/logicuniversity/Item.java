package com.example.student.logicuniversity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by billpoon on 7/9/16.
 */
public class Item extends HashMap<String, String> {

    // Url
    final static String host = "http://10.10.2.81/WCFService_LU/Service.svc/";

    public Item(String id, String bin, String name, String requested, String actual, String row1, String row2) {
        put("id", id);
        put("bin", bin);
        put("name", name);
        put("requested", requested);
        put("actual", actual);
        put("row1",row1);
        put("row2", row2);
    }

    public static List<Item> getRequisition() {
        List<Item> items = new ArrayList<Item>();

        try{
            JSONArray jsons = JSONParser.getJSONArrayFromUrl(host + "Items");
            int nnn = jsons.length();
            for(int i = 0; i < jsons.length(); i ++){
                JSONObject json = jsons.getJSONObject(i);
                String id = json.getString("Id");
                String name = json.getString("Name");
                String bin = json.getString("Bin");
                int requested = json.getInt("Requested");
                int actual = json.getInt("Actual");
                String row1 = "Bin#" + bin + " " + name;
                String row2 = "Requested: " + Integer.toString(requested) + " " + "Actual: " + Integer.toString(actual);
                Item item = new Item(id, bin, name, Integer.toString(requested), Integer.toString(actual), row1, row2);
                items.add(item);
            }
        } catch (Exception e) {
            Log.e("Exception", StackTrace.trace(e));
        }

//        items.add(new Item("A10001", "1", "pencil 2B", "11", "11"));
//        items.add(new Item("A10002", "2", "pen", "20", "19"));
//        items.add(new Item("A10003", "3", "pen highlight", "12", "10"));
//        items.add(new Item("A10004", "4", "pen blue", "13", "13"));

        return items;
    }







}
