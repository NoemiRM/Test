package web.wiki;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PilarRM on 1/8/20.
 */
public class HelperClass {
    public static LocalDate getAbsoluteDate(String relativeDate){
        //Example of relativeDate -> "today - 1"
        String[] arrayRelative = relativeDate.trim().split(" ");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        Long daysAux;
        String operatorAux;

        if (arrayRelative.length == 3) {
            daysAux = Long.parseLong(arrayRelative[2]);
            operatorAux = arrayRelative[1].trim();
            if (operatorAux.equals("-")){
                localDate = localDate.minusDays(daysAux);
            }else if(operatorAux.equals("+")){
                localDate = localDate.plusDays(daysAux);
            }

        }
        return localDate;
    }

    public static Map<String,String> getYearMonthNameDay(LocalDate date){
        Map<String,String> mapDate = new HashMap<String,String>();
        mapDate.put("year",Integer.toString(date.getYear()));
        mapDate.put("month",getMonthName(date.getMonthValue()).toUpperCase());
        mapDate.put("day",Integer.toString(date.getDayOfMonth()));

        return mapDate;
    }

    public static Map<String,String> getYearMontDay(LocalDate date){
        Map<String,String> mapDate = new HashMap<String,String>();
        mapDate.put("year",Integer.toString(date.getYear()));
        mapDate.put("month",Integer.toString((date.getMonthValue())));
        mapDate.put("day",Integer.toString(date.getDayOfMonth()));

        return mapDate;
    }

    public static String getMonthName(int month) {

        String monthName = null;
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }

        return monthName;
    }

    public static String getNumberCabin(String sCabinName){
        String sCabinNum = null;
        switch (sCabinName) {
            case "SUITE CABINS":
                sCabinNum = "1";
                break;
            case "TWIN BED CABINS":
                sCabinNum = "2";
                break;
            case "BUNK BED CABINS":
                sCabinNum = "3";
                break;
        }

        return sCabinNum;
    }

}
