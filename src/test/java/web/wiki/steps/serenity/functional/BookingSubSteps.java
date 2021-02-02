package web.wiki.steps.serenity.functional;

import net.bytebuddy.build.ToStringPlugin;
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

    @Step
    public void search_cabin(String sNameCabin){
        bookingPage.searchCabin(sNameCabin);
    }

    @Step
    public void select_number_of_cabin(String sNameCabin, int num){
        bookingPage.selectQuantityOfCabin(sNameCabin, num);
    }

    @Step
    public void select_number_of_adult(String sNameCabin, int num){
        bookingPage.selectNumberOfAdult(sNameCabin, num);
    }

    @Step
    public void select_number_of_child(String sNameCabin, String num){
        if (!num.equals("0")){
            bookingPage.selectNumberOfChild(sNameCabin, num);
        }else {
            System.out.println("No select ticket for child");
        }
    }

    @Step
    public void next_continue_booking(){
        bookingPage.selectNext();
    }
}
