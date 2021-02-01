package web.wiki.steps.serenity.functional;

import web.wiki.pages.CalendarPage;
import web.wiki.pages.SearchTripPage;
import net.thucydides.core.annotations.Step;
/**
 * Created by PilarRM on 31/01/21
 */
public class SearchTripSubSteps {
    SearchTripPage searchTripPage;
    CalendarPage calendarPage;

    @Step
    public void select_round_trip(){
       searchTripPage.selectOptionRoundtrip();
    }

    @Step
    public void select_trip_type(String tripType){
        searchTripPage.selectTripType(tripType);
    }

    @Step
    public void select_destination(String typeDestiantion){
        searchTripPage.selectTypeDropdownValues(typeDestiantion);
    }

    @Step
    public void select_route(String route){
        searchTripPage.selectRouteDropdownValues(route);
    }

    @Step
    public void select_train(String train){
        searchTripPage.selectTrenDropdownValues(train);
    }

    @Step
    public void select_number_of_tickets(String nAdult, String nChild){
        searchTripPage.showAdultChildModal();
        searchTripPage.selectTicketForAdult(nAdult);
        searchTripPage.selectTicketForChild(nChild);
        searchTripPage.closeAdultChildModal();
    }

    @Step
    public void request_to_search(){
        searchTripPage.search();
    }

    @Step
    public void enter_start_date_trip(int iYear, String sMonth, int iDay){
        searchTripPage.selectStartDate();
        calendarPage.selectDateInCalendar(iYear,sMonth,iDay);
    }
}
