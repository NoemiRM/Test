package web.wiki.steps.functional;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import web.wiki.steps.serenity.functional.BookingSubSteps;

public class BookingFeatureSteps {

    @Steps
    BookingSubSteps bookingSteps;

    @Given("El sistema muestra la 2 paso del proceso")
    public void showSecondStepOnBooking() {
        bookingSteps.show_second_step_booking();

    }

}
