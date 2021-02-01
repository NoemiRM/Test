package web.wiki.steps.serenity.functional;

import net.thucydides.core.annotations.Step;
import web.wiki.pages.BookingPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BookingSubSteps {
    BookingPage bookingPage;

    @Step
    public void show_second_step_booking(){
        bookingPage.successfulSecondStep();
    }
}
