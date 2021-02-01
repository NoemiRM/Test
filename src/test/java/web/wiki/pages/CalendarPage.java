package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import web.wiki.HelperClass;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Created by PilarRM on 31/01/21
 */
public class CalendarPage extends HomePage {
    @FindBy(xpath = "//*[@id ='ui-datepicker-div']//a[contains(@class,'ui-datepicker-prev')]")
    WebElementFacade btnPreviousCalendar;

    @FindBy(xpath = "//*[@id ='ui-datepicker-div']//a[contains(@class,'ui-datepicker-next')]")
    WebElementFacade btnNextCalendar;

    @FindBy(xpath = "//*[@id ='ui-datepicker-div']//span[contains(@class,'ui-datepicker-month')]")
    WebElementFacade btnCurrentMonth;

    @FindBy(xpath = "//*[@id ='ui-datepicker-div']//span[contains(@class,'ui-datepicker-year')]")
    WebElementFacade btnCurrentYear;

    public void movePreviousMonth(){
        btnPreviousCalendar.waitUntilEnabled().click();
    }

    public void moveNextMonth(){
        btnNextCalendar.waitUntilEnabled().click();
    }

    public String getCurrentMonthName(){
        return btnCurrentMonth.waitUntilEnabled().getText().trim();
    }

    public String getCurrentYear(){
        return btnCurrentYear.waitUntilEnabled().getText();
    }

    public void navigateSearchMonthYear(String monthName, String year){
        String yearOfCalendar;
        String monthOfCalendar;
        for(int i=0;i<13;i++){
            yearOfCalendar = getCurrentYear().trim();
            monthOfCalendar = getCurrentMonthName().trim();
            if(yearOfCalendar.equals(year) && monthOfCalendar.equals(monthName)){
                return;
            }else{
                moveNextMonth();
            }
        }
        fail("Not found moth, year" + getClass().getName());
    }

    public void navigateSearchMonth(String monthName ){
        String nameMonthCal;
        for(int i=0;i<12;i++){
            nameMonthCal = getCurrentMonthName().trim();
            if(nameMonthCal.equals(monthName)){
                return;
            }else{
                movePreviousMonth();
            }
        }
        fail("Not found moth in " + getClass().getName());
    }

    public void selectDayInCurrentMonth(String dayNumber){
        List<WebElementFacade> enabledDays = getEnabledDaysCurrentMonth();
        for(WebElementFacade enabledDay:enabledDays){
            if(enabledDay.getText().equals(dayNumber)){
                enabledDay.click();
                return;
            }
        }
        fail("Not found day in " + getClass().getName());
    }

    public List<WebElementFacade> getEnabledDaysCurrentMonth(){
        return  findAll("//td[contains(@data-handler,'selectDay')]");
    }

    public void selectDateInCalendar(int iYear, String sMonth, int iDay){
        System.out.println("fecha");
        System.out.println(iYear + sMonth + iDay);
        navigateSearchMonthYear(sMonth,Integer.toString(iYear));
        selectDayInCurrentMonth(Integer.toString(iDay));
    }


}
