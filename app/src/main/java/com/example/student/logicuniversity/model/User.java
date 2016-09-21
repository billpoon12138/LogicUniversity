package com.example.student.logicuniversity.model;

import android.util.Log;

import com.example.student.logicuniversity.tool.JSONParser;

import org.json.JSONObject;

/**
 * Created by student on 13/9/16.
 */
public class User {

    public String Username;
    public String UserId;
    public String Email;
    public String Password;
    public String Role;
    public String Dept;
    public String DeptId;

    public void setPassword(String password) {
        Password = password;
    }

    // Url for Login
    final static String host = "http://10.10.2.81/WebSite/LogicUniversity/Service.svc/";

    public User(String userId, String email, String role, String dept, String deptId) {
        UserId = userId;
        Email = email;
        Role = role;
        Dept = dept;
        DeptId = deptId;
    }

    public User(String email) {
        Email = email;
    }

    public static User Login(User user){
        try{

            JSONObject userJO = new JSONObject();
            userJO.put("Email", user.Email);
            userJO.put("Password", user.Password);
            String json = userJO.toString();
            JSONObject result = JSONParser.postJSONFromUrl(host + "LoginWithEmail", json);
//            result = result.substring(1, result.length() - 1);
            User userResult = new User(result.getString("UserId"), result.getString("Email"), result.getString("Role"), result.getString("Dept"), result.getString("DeptId"));
            return userResult;
        } catch (Exception e) {
            Log.e("Login error", e.toString());
            return null;
        }
    }


}
