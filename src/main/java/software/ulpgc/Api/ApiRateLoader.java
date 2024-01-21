package software.ulpgc.Api;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;



public class ApiRateLoader {

    private final static String API_KEY = "d8bd6d3259933d0f0d1d8ddfe15eb042";
    private final static String Url = "http://api.exchangeratesapi.io/v1/latest?access_key=:API_KEY:&base=:FROM:&symbols=:TO:";

    public double load(String from, String to) {
        try {
            return getAmountFromRequest(request(from,to));
        } catch (IOException e) {
            return -1;
        }
    }

    private double getAmountFromRequest(String json) {
        return Double.parseDouble(new Gson()
                .fromJson(json, JsonObject.class)
                .get("rates")
                .getAsJsonObject()
                .asMap()
                .values()
                .toArray()[0]
                .toString());
    }

    private String request(String from, String to) throws IOException {
        try (InputStream is = new URL(Url.replace(":API_KEY:", API_KEY)
                .replace(":FROM:",from)
                .replace(":TO:",to))
                .openStream())
        {
            return new String(is.readAllBytes());
        }
    }
}

