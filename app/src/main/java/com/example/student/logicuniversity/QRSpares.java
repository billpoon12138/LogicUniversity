package com.example.student.logicuniversity;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johnson Dell laptop on 16-Sep-16.
 */
public class QRSpares extends java.util.HashMap<String,String> {


    //Note that the web server IP address, http://172.23.135.219 changes when you move your WiFi laptop around; assume that your laptop is holding
    // Visual Studio program (acting as Web Server and holding Visual Studio files like Service.cs + IService.cs for WCF JSON)
    // If using desktop PC (LAN), then IP address will be fixed.
    // Always check your laptop IP address using command prompt (CMD: ipconfig)
    final static String host = "http://172.23.135.219/MyInventoryWCF/Service.svc/";

    // Default constructor
    public QRSpares()
    {}

    // Constructor with parameters
    public QRSpares(String partid, String description, String location, String vendor, String vendorid, String documentid, String targetlevel, String reorderlevel, String balance)
    {
        put("Partid", partid);
        put("Description", description);
        put("Location", location);
        put("Vendor", vendor);
        put("Vendorid", vendorid);
        put("Documentid", documentid);
        put("Targetlevel", targetlevel);
        put("Reorderlevel", reorderlevel);
        put("Balance", balance);
    }

    // Create listSpares method
    public static List<String> listSpares() {
        List<String> list = new ArrayList<String>();
        try {
            JSONArray a = JSONParser.getJSONArrayFromUrl(host+"Spares");
            for (int i=0; i<a.length(); i++) {
                String c = a.getString(i);
                list.add(c);
            }
        }
        catch (Exception e)
        {
        }
        return list;
    }

    // Create getSpares method for ListActivity
    public static QRSpares getSpares(String partid)
    {
        QRSpares spa = null;
        try
        {
            JSONObject c = JSONParser.getJSONFromUrl("http://172.23.135.219/MyInventoryWCF/Service.svc/spares/"+partid);
            spa = new QRSpares(c.getString("Partid"),
                    c.getString("Description"),
                    c.getString("Location"),
                    c.getString("Vendor"),
                    c.getString("Vendorid"),
                    c.getString("Documentid"),
                    Integer.toString(c.getInt("Targetlevel")),
                    Integer.toString(c.getInt("Reorderlevel")),
                    Integer.toString(c.getInt("Balance")));
        }
        catch (Exception e)
        {
            // Prints out system error for troubleshooting
            System.err.println("This Part ID does not exists ! " + e.getMessage());
        }
        return spa;
    }

    // Create updateSpare method
    public static void updateSpares(QRSpares spa)
    {
        JSONObject jcustomer = new JSONObject();
        try {
            jcustomer.put("Partid", spa.get("Partid"));
            jcustomer.put("Description", spa.get("Description"));
            jcustomer.put("Location", spa.get("Location"));
            jcustomer.put("Vendor", spa.get("Vendor"));
            jcustomer.put("Vendorid", spa.get("Vendorid"));
            jcustomer.put("Documentid", spa.get("Documentid"));
            jcustomer.put("Targetlevel", Integer.parseInt(spa.get("Targetlevel")));
            jcustomer.put("Reorderlevel", Integer.parseInt(spa.get("Reorderlevel")));
            jcustomer.put("Balance", Integer.parseInt(spa.get("Balance")));
        } catch (Exception e) {}
        String result = JSONParser.postStream(host+"Update", jcustomer.toString());
    }

}
