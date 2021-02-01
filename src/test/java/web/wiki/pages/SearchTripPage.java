package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.lang.reflect.Array;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by PilarRM on 31/01/21
 */
public class SearchTripPage extends PageObject {
    @FindBy(xpath = "//label[@for='oneway']")
    WebElementFacade selectOneway;
    @FindBy(xpath = "//label[@for='roundtrip']")
    WebElementFacade selectRoundtrip;
    @FindBy(id = "destinoSelect")
    WebElementFacade destinationDropdown;
    @FindBy(id = "rutaSelect")
    WebElementFacade routeDropdown;
    @FindBy(id = "salida")
    WebElementFacade inputSalida;
    @FindBy(id = "cbTrenSelect")
    WebElementFacade trenDropdown;
    @FindBy(xpath = "//button[@id='btn_search']/span")
    WebElementFacade btnSearch;
    @FindBy(id = "countParentsChildren")
    WebElementFacade inputShowParentsChildren;
    @FindBy(id = "adultsSelect")
    WebElementFacade inputAdult;
    @FindBy(id = "childrenSelect")
    WebElementFacade inputChildren;
    @FindBy(xpath = "//div[@class='box-passanger']/a[@class='cerrar-passanger']")
    WebElementFacade linkCloseParentsChildren;
    @FindBy(id = "adultsDism")
    WebElementFacade btnAdultsDism;
    @FindBy(id = "adultsAume")
    WebElementFacade btnAdultsAume;
    @FindBy(id = "childrenDism")
    WebElementFacade btnChildrenDism;
    @FindBy(id = "childrenAume")
    WebElementFacade btnChildrenAume;
    @FindBy(id = "salida")
    WebElementFacade inputStartDate;
    @FindBy(xpath = "//div[@id='lbContactHeaderMinimize']/div[contains(@class,'lbInvSprite')]")
    WebElementFacade divHideHelp;

    public void hideHelpDiv(){
        if(divHideHelp.isVisible()){
            divHideHelp.click();
        }
    }

    public void selectTripType(String typeTrip){
        if(typeTrip.equals("One Way")){
            selectOneway.click();
        }else{selectRoundtrip.click();}

    }

    public void selectOptionRoundtrip(){
        selectRoundtrip.click();
    }

    public void clickDestinationSelect(){
        destinationDropdown.click();
    }


    public void selectTypeDropdownValues(String typeDestination){
        hideHelpDiv();
        destinationDropdown.selectByVisibleText(typeDestination);
    }

    public void selectRouteDropdownValues(String route){
        hideHelpDiv();
        routeDropdown.selectByVisibleText(route);
    }

    public void putSalidaValue(String value){

    }

    public void selectTrenDropdownValues(String tren){
        trenDropdown.selectByVisibleText(tren);
    }

    public void showAdultChildModal(){
        inputShowParentsChildren.click();
    }

    public void closeAdultChildModal(){
        linkCloseParentsChildren.click();
    }

    public void putAdult(String nAdult){
        inputAdult.clear();
        inputAdult.sendKeys(nAdult);
    }

    public void putChild(String nChild){
        inputChildren.clear();
        inputChildren.sendKeys(nChild);
    }

    public void search(){
        hideHelpDiv();
        btnSearch.click();
    }

    public Boolean searchIsVisible(){
        return btnSearch.isVisible();
    }

    public void selectTicketForAdult(String nAdult){
        selectTicketsInModal(Integer.parseInt(nAdult),
                inputAdult,
                btnAdultsAume,
                btnAdultsDism);
    }
    public void selectTicketForChild(String nChild){
        selectTicketsInModal(Integer.parseInt(nChild),
                inputChildren,
                btnChildrenAume,
                btnChildrenDism);
    }

    public void selectTicketsInModal(
            int number,
            WebElementFacade inputToEvaluate,
            WebElementFacade btnAum,
            WebElementFacade btnMin){

        int currentValue = Integer.parseInt(inputToEvaluate.getValue());

        if(currentValue == number){
            return;
        }else if(currentValue < number){
            for (int i = 0;i < 9;i++) {
                btnAum.click();
                int updateValue = Integer.parseInt(inputToEvaluate.getValue());
                if(updateValue == number){break;}
            }
        }else{
            for (int i = 0;i < 9;i++) {
                btnMin.click();
                int updateValue = Integer.parseInt(inputToEvaluate.getValue());
                if(updateValue == number){break;}
            }
        }


    }

    public void selectStartDate(){
        inputStartDate.click();
    }



}
