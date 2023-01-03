package com.example.seleniumtest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FoundContentPage {

    public void writingToFile(DataOfGames dt, String[] arr1,DataOfGames dt2, String[] arr2) throws JSONException, IOException {
        dt.setName(arr1[0]);
        dt.setPrice(arr1[1]);
        dt.setPositiveReviews(arr1[2]);
        dt.setReleaseDate(arr1[3]);

        Map<String,String> map = new HashMap<>();
        map.put("name",dt.getName());
        map.put("price",dt.getPrice());
        map.put("release data",dt.getReleaseDate());
        map.put("reviews",dt.getPositiveReviews());

        dt2.setName(arr2[0]);
        dt2.setPrice(arr2[1]);
        dt2.setPositiveReviews(arr2[2]);
        dt2.setReleaseDate(arr2[3]);

        Map<String,String> map2 = new HashMap<>();
        map2.put("name",dt2.getName());
        map2.put("price",dt2.getPrice());
        map2.put("release data",dt2.getReleaseDate());
        map2.put("reviews",dt2.getPositiveReviews());


        JSONArray jsonArray = new JSONArray();
        jsonArray.put(map);
        jsonArray.put(map2);


        FileWriter file = new FileWriter("C:\\Users\\Sirojiddin\\IdeaProjects\\SeleniumTest\\src\\test\\java\\com\\example\\seleniumtest\\Data.json",false);
        file.write(jsonArray.toString(2));
        file.close();
    }
    public String[] readingFromJson() throws IOException, JSONException {
        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\Sirojiddin\\IdeaProjects\\SeleniumTest\\src\\test\\java\\com\\example\\seleniumtest\\Data.json")));

        JSONArray jsonArray = new JSONArray(data);

            JSONObject jsonObject = jsonArray.getJSONObject(1);

            String name = jsonObject.getString("name");
            String reviews = jsonObject.getString("reviews");
            String date = jsonObject.getString("release data");
            String price = jsonObject.getString("price");

            return new String[]{name,price,reviews,date};

    }



}
