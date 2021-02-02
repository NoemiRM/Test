package web.wiki.steps.functional;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import web.wiki.steps.serenity.functional.BookingPassengerSubSteps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PilarRM on 31/01/21
 */
public class BookingPassengerFeatureSteps {

    @Steps
    BookingPassengerSubSteps bookingPassengerSteps;

    @Given("El sistema muestra el paso número 3 del proceso")
    public void showThreeStepOnBooking() {
        bookingPassengerSteps.show_three_step_booking();

    }

    @And("Usuario continua hacia el proceso de pago")
    public void nextToPaymentProcess() {
        bookingPassengerSteps.next_payment_process();

    }

    @When("Usuario ingresa datos de los pasajeros:")
    public void putPassengersData(DataTable dataTable) {
        List<Map<String, String>> passengersDataValuesList = dataTable.transpose().asMaps(String.class, String.class);
        //ArrayList<Object> lstDatesCodeVariable = new ArrayList<>();

        for (Map<String, String> passengerDataValues: passengersDataValuesList) {

            bookingPassengerSteps.put_name_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("nombre"));
            bookingPassengerSteps.put_lastname_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("apellido"));
            bookingPassengerSteps.select_birth_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("fecha_nacimiento"));
            bookingPassengerSteps.select_nationality_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("nacional"));
            bookingPassengerSteps.select_type_doc_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("tipo_doc"));
            bookingPassengerSteps.put_num_doc_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("num_doc"));
            bookingPassengerSteps.select_sexo_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("sexo"));
            bookingPassengerSteps.put_phone_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("telefono"));
            bookingPassengerSteps.put_email_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("email"));
            bookingPassengerSteps.put_reemail_passenger(
                    passengerDataValues.get("nombre_cabina"),
                    passengerDataValues.get("numero_cabina"),
                    passengerDataValues.get("numero_pasajero"),
                    passengerDataValues.get("re_email"));


        }
    }
}
