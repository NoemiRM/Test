package web.wiki.steps.functional;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import web.wiki.steps.serenity.functional.HomeSubSteps;
import web.wiki.steps.serenity.functional.LoginSubSteps;
import web.wiki.steps.serenity.functional.SearchTripSubSteps;

import java.util.Map;

/**
 * Created by pilar07 on 2020-03-20.
 */
public class SearchTripFeatureSteps {

    @Steps
    HomeSubSteps homeSteps;

    @Steps
    LoginSubSteps loginSteps;

    @Steps
    SearchTripSubSteps onboardingSteps;


    @Given("Usuario navega hasta la página home")
    public void userIsOnHomePage() {
        homeSteps.open_home_page();
        homeSteps.successful_home();
    }

    @Then("Usuario (.*) requiere login")
    public void userRequestsLogin(String usuario) {
        loginSteps.enter_user(usuario);
        loginSteps.enter_password("1234567ocho");
        loginSteps.request_to_access();
    }

    @Then("Usuario selecciona (.*) como tipo de viaje")
    public void selectTripType(String tripType){
            onboardingSteps.select_trip_type(tripType);


    }

    @Then("Usuario selecciona los parametros de su busqueda:")
    public void searchWithFollowingParameters(DataTable dataTable){
        Map<String, String> valuesOfSearch = dataTable.asMap(String.class, String.class);
        String[] startDate = valuesOfSearch.get("start_date").split(" ");
        onboardingSteps.select_trip_type(valuesOfSearch.get("tipo_viaje"));
        onboardingSteps.select_destination(valuesOfSearch.get("destino"));
        onboardingSteps.select_route(valuesOfSearch.get("ruta"));
        onboardingSteps.select_train(valuesOfSearch.get("tren"));
        onboardingSteps.enter_start_date_trip(
                Integer.parseInt(startDate[1]),
                startDate[2],
                Integer.parseInt(startDate[3]));
    }

    @And("Usuario selecciona (.*) como destino")
    public void selectDestination(String destination){
        onboardingSteps.select_destination(destination);

    }

    @And("Usuario selecciona (.*) como ruta")
    public void selectRoute(String route) {
        onboardingSteps.select_route(route);

    }

    @And("Usuario selecciona (.*) como tren")
    public void selectTrain(String train) {
        onboardingSteps.select_train(train);
    }

    @And("Usuario selecciona (.*) adultos y (.*) niños")
    public void selectAdultAndChild(String nAdult, String nChild) {
        onboardingSteps.select_number_of_tickets(nAdult,nChild);
    }

    @And("Usuario solicita realizar busqueda")
    public void requestToSearch(){
        onboardingSteps.request_to_search();
    }

    @And("Usuario selecciona (\\d+), (.*), (\\d+) como fecha de ida del viaje")
    public void selectStartDateTrip(int year, String month, int day) {
        onboardingSteps.enter_start_date_trip(year, month, day);
    }
}
