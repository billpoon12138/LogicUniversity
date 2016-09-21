package com.example.student.logicuniversity.model;

import android.util.Log;

import com.example.student.logicuniversity.tool.JSONParser;
import com.example.student.logicuniversity.tool.StackTrace;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Item extends HashMap<String, String>
{

    // Url
    final static String host = "http://10.10.2.81/WebSite/LogicUniversity/Service.svc/";

    // Constructor with parameters
    public Item(String id, String bin, String name, String requested, String actual, String row1, String row2)
    {
        put("id", id);
        put("bin", bin);
        put("name", name);
        put("requested", requested);
        put("actual", actual);
        put("row1",row1);
        put("row2", row2);
    }

    public Item(String id, String bin, String name, String requested, String actual, String row1, String row2, String status)
    {
        put("id", id);
        put("bin", bin);
        put("name", name);
        put("requested", requested);
        put("actual", actual);
        put("row1",row1);
        put("row2", row2);
        put("status", status);
    }

    public Item(String id, String bin, String name, String requested, String actual)
    {
        put("id", id);
        put("bin", bin);
        put("name", name);
        put("requested", requested);
        put("actual", actual);
    }

    // Constructor with parameters
    public Item(String code, String name, String uom, String bin, String reOrderLevel, String balance)
    {
        put("code", code);
        put("name", name);
        put("uom", uom);
        put("bin", bin);
        put("reOrderLevel", reOrderLevel);
        put("balance",balance);
    }

    public Item(String name, String requested, String row1, String row2)
    {
        put("name", name);
        put("requested", requested);
        put("row1",row1);
        put("row2", row2);
    }

    public static List<Item> getRequisition()
    {
        List<Item> items = new ArrayList<Item>();

        try{
            JSONArray jsons = JSONParser.getJSONArrayFromUrl(host + "Items");
            int nnn = jsons.length();
            for(int i = 0; i < jsons.length(); i ++)
            {
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
        return items;
    }

    public static List<Item> getRequisitionByDepartmentId(String departmentId){

        List<Item> items = new ArrayList<Item>();

        try{
            JSONArray jsons = JSONParser.getJSONArrayFromUrl(host + "Requisition/" + departmentId);
            int nnn = jsons.length();
            for(int i = 0; i < jsons.length(); i ++)
            {
                JSONObject json = jsons.getJSONObject(i);
                String id = json.getString("Id");
                String name = json.getString("Name");
                String bin = json.getString("Bin");
                int requested = json.getInt("Requested");
                int actual = json.getInt("Actual");
                String status = json.getString("Status");
                String row1 = "Bin#" + bin + " " + name;
                String row2 = "Requested: " + Integer.toString(requested) + " " + "Actual: " + Integer.toString(actual);
                Item item = new Item(id, bin, name, Integer.toString(requested), Integer.toString(actual), row1, row2, status);
                items.add(item);
            }
        } catch (Exception e) {
            Log.e("Exception", StackTrace.trace(e));
        }
        return items;
    }

    public static List<Item> getItem()
    {
        List<Item> items = new ArrayList<Item>();

        try{
            JSONArray jsons = JSONParser.getJSONArrayFromUrl(host + "Item");
            int nnn = jsons.length();
            for(int i = 0; i < jsons.length(); i ++)
            {
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


        return items;
    }

    /*public static Item getItemById(String ItemId)
    {
        Item item = null;

        try{
                JSONObject json = JSONParser.getJSONFromUrl(host + "Item/" + ItemId);
                String code = json.getString("Code");
                String name = json.getString("Name");
                String uom = json.getString("Uom");
                String bin = json.getString("Bin");
                int reOrderLevel = json.getInt("ReOrderLevel");
                int balance = json.getInt("Balance");

                item = new Item(code, name, uom, bin, Integer.toString(reOrderLevel), Integer.toString(balance));

        } catch (Exception e)
        {
            Log.e("Exception", StackTrace.trace(e));
        }
        return item;
    }*/

    public static Item getItemByCode(String ItemCode)
    {
        Item item = null;

        try{
            JSONObject json = JSONParser.getJSONFromUrl(host + "ScanItem/" + ItemCode);
            String code = json.getString("Code");
            String name = json.getString("Name");
            String uom = json.getString("Uom");
            String bin = json.getString("Bin");
            int reOrderLevel = json.getInt("ReOrderLevel");
            int balance = json.getInt("Balance");

            item = new Item(code, name, uom, bin, Integer.toString(reOrderLevel), Integer.toString(balance));

        } catch (Exception e)
        {
            Log.e("Exception", StackTrace.trace(e));
        }
        return item;
    }

    public static List<Item> getRequisitionByEmployeeId(String employeeId)
    {
        List<Item> items = new ArrayList<Item>();

        try{
            JSONArray jsons = JSONParser.getJSONArrayFromUrl(host + "EmployeeRequisitions/" + employeeId);
            for(int i = 0; i < jsons.length(); i ++)
            {
                JSONObject json = jsons.getJSONObject(i);
                String id = json.getString("Id");
                String name = json.getString("Name");
                int requested = json.getInt("Requested");
                String row1 = name;
                String row2 = "Requested: " + Integer.toString(requested);
                Item item = new Item(name, Integer.toString(requested), row1, row2);
                items.add(item);
            }
        } catch (Exception e) {
            Log.e("Exception", StackTrace.trace(e));
        }
        return items;
    }
}
