package com.example.student.logicuniversity.model;


import android.util.Log;

import com.example.student.logicuniversity.tool.JSONParser;
import com.example.student.logicuniversity.tool.StackTrace;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Employee extends HashMap<String, String>
{

    // Url
    final static String host = "http://10.10.2.81/WebSite/LogicUniversity/Service.svc/";

    public Employee(String id, String bin, String name, String requested, String actual)
    {
        put("id", id);
        put("bin", bin);
        put("name", name);
        put("requested", requested);
        put("actual", actual);
    }

    public Employee(String id, String name)
    {
        put("id", id);
        put("name", name);
    }

    public Employee(String id, String name, String retrieveStatus, String employeeReqId)
    {
        put("id", id);
        put("name", name);
        put("retrieveStatus", retrieveStatus);
        put("employeeReqId", employeeReqId);
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
                Item item = new Item(id, bin, name, Integer.toString(requested), Integer.toString(actual));
                items.add(item);
            }
        } catch (Exception e) {
            Log.e("Exception", StackTrace.trace(e));
        }

        return items;
    }

    public static List<Employee> getEmployee(String departmentId)
    {
        List<Employee> employees = new ArrayList<Employee>();

        try{
            JSONArray jsons = JSONParser.getJSONArrayFromUrl(host + "EmployeeRequisition/" + departmentId);
            for(int i = 0; i < jsons.length(); i ++)
            {
                JSONObject json = jsons.getJSONObject(i);
                String id = json.getString("Id");
                String name = json.getString("Name");
                // EmployeeRequisition
                String retrieveStatus = json.getString("RetrieveStatus");
                String employeeReqId = json.getString("EmployeeReqId");
                Employee employee = new Employee(id, name, retrieveStatus, employeeReqId);
                employees.add(employee);
            }
        } catch (Exception e) {
            Log.e("Exception", StackTrace.trace(e));
        }

        return employees;
    }

}