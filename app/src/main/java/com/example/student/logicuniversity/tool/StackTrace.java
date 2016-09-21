package com.example.student.logicuniversity.tool;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by student on 28/7/16.
 */
public class StackTrace {
    public static String trace(Exception ex) {
        StringWriter outStream = new StringWriter();
        ex.printStackTrace(new PrintWriter(outStream));
        return outStream.toString();
    }
}
