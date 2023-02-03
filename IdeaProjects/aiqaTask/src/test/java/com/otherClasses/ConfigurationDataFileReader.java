package com.otherClasses;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;


public class ConfigurationDataFileReader {
    private final static String configPath = "src/test/java/com/configFiles/configurationData.json";

    static JSONParser parser = new JSONParser();
    static Object obj;

    static {
        try {
            obj = parser.parse(new FileReader(configPath));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
     static JSONObject jsonObject = (JSONObject) obj;
    public static String availableBrowsers(String browserName){
        JSONArray jsonArray = (JSONArray) jsonObject.get("available browsers");
        for(int i=0;i<jsonArray.size();i++){
            if(Objects.equals((String) jsonArray.get(i), browserName)){
                return browserName;
            }
        }
        return "chrome";
    }
    public static String linkToMainPage(){
        return (String) jsonObject.get("main page link");
    }
    public static Long timeOfWait(){
        return (Long) jsonObject.get("time of wait");
    }
}


