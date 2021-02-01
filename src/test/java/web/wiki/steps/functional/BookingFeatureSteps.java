package web.wiki.steps.functional;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import web.wiki.steps.serenity.functional.BookingSubSteps;

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

    @And("Usuario selecciona (\\d+) niño en (.*)")
    public void selectNumberOfChild(int nChild, String sNameCabin) {
        bookingSteps.select_number_of_child(sNameCabin,nChild);
    }

    @And("Usuario continua con el proceso de booking")
    public void nextStep() {
        bookingSteps.next_continue_booking();
    }
}
