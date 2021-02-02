package web.wiki.steps.functional;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import web.wiki.steps.serenity.functional.BookingSubSteps;

import java.util.Map;

public class BookingFeatureSteps {

    @Steps
    BookingSubSteps bookingSteps;

    @Given("El sistema muestra el paso número del proceso")
    public void showSecondStepOnBooking() {
        bookingSteps.show_second_step_booking();

    }

    @And("Usuario busca (.*) como cabina")
    public void searchSpecificCabin(String sNameCabin) {
        bookingSteps.search_cabin(sNameCabin);
    }

    @And("Usuario selecciona (\\d+) cabina en (.*)")
    public void selectNumberOfCabin(int nCabin, String sNameCabin) {
        bookingSteps.select_number_of_cabin(sNameCabin,nCabin);
    }

    @And("Usuario selecciona (\\d+) adultos en (.*)")
    public void selectNumberOfAdult(int nAdult,String sNameCabin) {
        bookingSteps.select_number_of_adult(sNameCabin,nAdult);
    }

    @And("Usuario selecciona (.*) niño en (.*)")
    public void selectNumberOfChild(String nChild, String sNameCabin) {
        bookingSteps.select_number_of_child(sNameCabin,nChild);
    }

    @And("Usuario continua con el proceso de booking")
    public void nextStep() {
        bookingSteps.next_continue_booking();
    }

    @When("Usuario selecciona los parametros del tipo de cabina:")
    public void selectParametersToCabin(DataTable dataTable) {
        Map<String, String> valuesCabinType = dataTable.asMap(String.class, String.class);
        bookingSteps.search_cabin(valuesCabinType.get("nombre_cabina"));
        bookingSteps.select_number_of_cabin(valuesCabinType.get("nombre_cabina"), Integer.parseInt(valuesCabinType.get("cantidad_cabina")));
        bookingSteps.select_number_of_adult(valuesCabinType.get("nombre_cabina"), Integer.parseInt(valuesCabinType.get("numero_adultos")));
        bookingSteps.select_number_of_child(valuesCabinType.get("nombre_cabina"), valuesCabinType.get("numero_nino"));
    }
}
