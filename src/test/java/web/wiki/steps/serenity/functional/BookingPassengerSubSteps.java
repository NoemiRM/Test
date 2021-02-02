package web.wiki.steps.serenity.functional;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import web.wiki.pages.BookingPage;
import web.wiki.pages.BookingPassengerPage;

import java.util.List;

/**
 * Created by PilarRM on 31/01/21
 */
public class BookingPassengerSubSteps {
    BookingPassengerPage bookingPassengerPage;

    @Step
    public void show_three_step_booking(){
        bookingPassengerPage.successfulPassenger();
    }

    @Step
    public void next_payment_process(){
        bookingPassengerPage.clickNextToPayment();
    }

    @Step
    public void put_name_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sNamePassenger){
        bookingPassengerPage.putFirstNamePassenger(sCabinTypeName,sCabinNum,sPassengerNum,sNamePassenger);

    }

    @Step
    public void put_lastname_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sLastnamePassenger){
        bookingPassengerPage.putLastNamePassenger(sCabinTypeName,sCabinNum,sPassengerNum,sLastnamePassenger);
    }

    @Step
    public void select_birth_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sBirthPassenger){
        bookingPassengerPage.selectBirthDatePassenger(sCabinTypeName,sCabinNum,sPassengerNum,sBirthPassenger);
    }

    @Step
    public void select_nationality_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sNationalityPassenger){
        bookingPassengerPage.selectNationalityPassenger(sCabinTypeName,sCabinNum,sPassengerNum,sNationalityPassenger);
    }

    @Step
    public void select_type_doc_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sTypeDocPassenger){
        bookingPassengerPage.selectDocumentIdPassenger(sCabinTypeName,sCabinNum,sPassengerNum,sTypeDocPassenger);
    }

    @Step
    public void put_num_doc_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sDocumentPassenger){
        bookingPassengerPage.putDocNumberPassenger(sCabinTypeName,sCabinNum,sPassengerNum,sDocumentPassenger);
    }

    @Step
    public void select_sexo_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sSexoPassenger){
        bookingPassengerPage.selectSexoPassenger(sCabinTypeName,sCabinNum,sPassengerNum,sSexoPassenger);
    }

    @Step
    public void put_phone_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sPhonePassenger){
        bookingPassengerPage.putPhonePassenger(sCabinTypeName,sCabinNum,sPassengerNum,sPhonePassenger);
    }

    @Step
    public void put_email_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sEmailPassenger){
        bookingPassengerPage.putEmailPassenger(sCabinTypeName,sCabinNum,sPassengerNum,sEmailPassenger);
    }

    @Step
    public void put_reemail_passenger(String sCabinTypeName, String sCabinNum, String sPassengerNum, String sReEmailPassenger){
        bookingPassengerPage.putConfirmEmailPassenger(sCabinTypeName,sCabinNum,sPassengerNum,sReEmailPassenger);
    }


}
