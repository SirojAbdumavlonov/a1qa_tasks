package com.otherClasses;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;


public class TestDataFileReader {
    private final static String testPath = "src/test/java/com/configFiles/testData.json";
    static JSONParser parser = new JSONParser();
    static ArrayList<String> detail = new ArrayList<String>();
    static Object obj;
    static {
        try {
            obj = parser.parse(new FileReader(testPath));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private static JSONObject jsonObject = (JSONObject) obj;

    public static ArrayList<String> readingDataOfUser1(){
        JSONArray jsonArray = (JSONArray) jsonObject.get("user 1");
        for(int i = 0; i < jsonArray.size();i++){
            detail.add(jsonArray.get(i).toString());
        }
        return detail;
    }
    public static ArrayList<String> readingDataOfUser2(){
        JSONArray jsonArray = (JSONArray) jsonObject.get("user 2");
        for(int i = 0; i < jsonArray.size();i++){
            detail.add(jsonArray.get(i).toString());
        }
        return detail;
    }
    public static String outerFramesOutput(){
        return (String) jsonObject.get("text of outer frame");
    }
    public static String innerFrameOutput(){
       return (String) jsonObject.get("text of inner frame");
    }



}
