package web.wiki.steps.functional;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import web.wiki.steps.serenity.functional.BookingPassengerSubSteps;
import web.wiki.steps.serenity.functional.BookingPaymentSubSteps;

import java.util.List;
import java.util.Map;

/**
 * Created by PilarRM on 31/01/21
 */
public class BookingPaymentFeatureSteps {

    @Steps
    BookingPaymentSubSteps bookingPaymentSubSteps;

    @Given("El sistema muestra el paso número 4 del proceso")
    public void showFourStepOnBooking() {
        bookingPaymentSubSteps.show_four_step_booking();

    }



}
