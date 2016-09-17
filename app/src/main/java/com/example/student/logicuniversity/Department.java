package com.example.student.logicuniversity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 13/9/16.
 */
public class Department extends HashMap<String, String> {

    // Url
    final static String host = "http://10.10.2.81/WebSite/LogicUniversity/Service.svc/";

    public Department(String id, String code, String name, String contact, String phone, String fax, String email, String collectionPointId) {
        put("id", id);
        put("code", code);
        put("name", name);
        put("contact", contact);
        put("phone", phone);
        put("fax", fax);
        put("email", email);
        put("collectionPointId", collectionPointId);
    }


    public static List<Department> getDepartments() {
        List<Department> departments = new ArrayList<Department>();

        try{
            JSONArray jsons = JSONParser.getJSONArrayFromUrl(host + "Departments");
            int nnn = jsons.length();
            for(int i = 0; i < jsons.length(); i ++){
                JSONObject json = jsons.getJSONObject(i);
                String id = json.getString("Id");
                String code = json.getString("Code");
                String name = json.getString("Name");
                String contact = json.getString("Contact");
                String phone = json.getString("Phone");
                String fax = json.getString("Fax");
                String email = json.getString("Email");
                String collectionPointId = json.getString("CollectionpointId");
                Department department = new Department(id, code, name, contact, phone, fax, email, collectionPointId);
                departments.add(department);
            }
        } catch (Exception e) {
            Log.e("Exception", StackTrace.trace(e));
        }

        return departments;
    }

}
