package com.example.student.logicuniversity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by billpoon on 7/9/16.
 */
public class Item extends HashMap<String, String> {
    public Item(String id, String bin, String name, String requested, String actual) {
        put("id", id);
        put("bin", bin);
        put("name", name);
        put("requested", requested);
        put("actual", actual);
    }

    public static List<Item> getRequisition() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("A10001", "1", "pencil 2B", "11", "11"));
        items.add(new Item("A10002", "2", "pen", "20", "19"));
        items.add(new Item("A10003", "3", "pen highlight", "12", "10"));
        items.add(new Item("A10004", "4", "pen blue", "13", "13"));

        return items;
    }





}
