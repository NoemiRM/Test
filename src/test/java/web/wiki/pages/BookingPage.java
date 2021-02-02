package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import web.wiki.HelperClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

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

    public void searchCabin(String sNameCabin){
        String sCabinNumber = HelperClass.getNumberCabin(sNameCabin);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElementFacade element = find("(//select[contains(@class,'selectRooms')])['"+sCabinNumber+"']").waitUntilEnabled();
        if (element.isPresent()) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }else{
            fail("Element not present while scrolling: " + element);
        }
    }

    public void selectQuantityOfCabin(String sNameCabin, int iNum){
        String sCabinNumber = HelperClass.getNumberCabin(sNameCabin);
        WebElementFacade element = find("(//select[contains(@class,'selectRooms')])['"+sCabinNumber+"']");
        element.selectByValue(Integer.toString(iNum));
    }

    public void selectNumberOfAdult(String sNameCabin, int iNum){
        String sCabinNumber = HelperClass.getNumberCabin(sNameCabin);
        WebElementFacade element = find("(//select[contains(@class,'baeRoomAdult1')])['"+sCabinNumber+"']");
        element.selectByValue(Integer.toString(iNum));
    }

    public void selectNumberOfChild(String sNameCabin, String iNum){
        String sCabinNumber = HelperClass.getNumberCabin(sNameCabin);
        WebElementFacade element = find("(//select[contains(@class,'baeRoomChild1')])['"+sCabinNumber+"']");
        element.selectByValue(iNum);
    }

    public void selectNext(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElementFacade element = find("//input[@id='continuar_bae']").waitUntilEnabled();
        if (element.isPresent()) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }else{
            fail("Element not present while scrolling: " + element);
        }
        element.click();
    }


}
