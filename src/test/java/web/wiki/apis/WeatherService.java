package web.wiki.apis;

import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pilar07 on 2020-02-22.
 */
public class WeatherService {
    public static void weatherApi(String city){
        Map<String, String> params = new HashMap<>();
        params.put("q", city);
        params.put("APPID", "b1fb33ebcd6ffc92508e4dfaf0208976");
        SerenityRest.given().contentType("application/json")
                .and().params(params)
                .when().get("http://api.openweathermap.org/data/2.5/forecast");
    }

}
