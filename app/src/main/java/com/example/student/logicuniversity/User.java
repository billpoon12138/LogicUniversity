package com.example.student.logicuniversity;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by student on 13/9/16.
 */
public class User {

    String Username;
    String UserId;
    String Email;
    String Password;
    String Role;

    public void setPassword(String password) {
        Password = password;
    }

    // Url for Login
    final static String host = "http://10.10.2.81/WebSite/LogicUniversity/Service.svc/";

    public User(String email, String role) {
        Email = email;
        Role = role;
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
            User userResult = new User(result.getString("Email"), result.getString("Role"));
            return userResult;
        } catch (Exception e) {
            Log.e("Login error", e.toString());
            return null;
        }
    }


}
