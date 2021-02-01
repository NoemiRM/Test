package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by PilarRM on 31/01/21
 */
public class BookingPage extends PageObject {
    @FindBy(id = "idDestino")
    WebElementFacade dropdownDestino;
    @FindBy(id = "idRuta")
    WebElementFacade dropdownRuta;
    @FindBy(id = "fecViajeIda")
    WebElementFacade dropdownFechIda;
    @FindBy(id = "fecViajeRegreso")
    WebElementFacade dropdownFechRegr;
    @FindBy(id = "numCupoAdulto")
    WebElementFacade dropdownAdulto;
    @FindBy(id = "numCupoNino")
    WebElementFacade dropdownNino;
    @FindBy(id = "text_btn_search")
    WebElementFacade dropdownSearch;
    @FindBy(id = "compra")
    WebElementFacade divCompra;
    @FindBy(xpath = "(//select[contains(@class,'selectRooms')])[1]")
    WebElementFacade selectSuitCabins;
    @FindBy(xpath = "(//select[contains(@class,'selectRooms')])[2]")
    WebElementFacade selectTwinBedCabins;
    @FindBy(xpath = "(//select[contains(@class,'selectRooms')])[3]")
    WebElementFacade selectBunkBedCabins;

    public void successfulSecondStep(){
        withTimeoutOf(Duration.ofSeconds(10)).find(By.id("compra"));
        divCompra.waitUntilPresent();
    }

    public String getTextOutbound(){
        return divCompra.getText();
    }

    public void selectNumberSuitCabins(String numCabin){
        selectSuitCabins.selectByValue(numCabin);
    }

    public void selectNumberTwinCabins(String numCabin){
        selectTwinBedCabins.selectByValue(numCabin);
    }

    public void selectNumberBunkCabins(String numCabin){
        selectBunkBedCabins.selectByValue(numCabin);
    }



}
