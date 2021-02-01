package web.wiki.steps.integration;

import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import web.wiki.apis.WeatherService;


/**
 * Created by PilarRM on 18/12/2019.
 */
public class IntegrationWeatherSteps {

    @When("Usuario requiere el clima")
    public void requestWheatherWithCity(String city){
        WeatherService.weatherApi(city);
        System.out.print("holi");
    }

    @When("Servicio responde")
    public void verifyWheatherResponse(){
        SerenityRest.then().log().all().
                statusCode(200);
    }
}