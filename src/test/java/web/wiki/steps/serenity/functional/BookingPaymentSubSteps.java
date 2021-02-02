package web.wiki.steps.serenity.functional;

import net.thucydides.core.annotations.Step;
import web.wiki.pages.BookingPaymentPage;

/**
 * Created by PilarRM on 31/01/21
 */
public class BookingPaymentSubSteps {
    BookingPaymentPage bookingPaymentPage;

    @Step
    public void show_four_step_booking(){
        bookingPaymentPage.successfulPayment();
    }


}
