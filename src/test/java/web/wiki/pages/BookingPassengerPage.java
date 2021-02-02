package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import web.wiki.HelperClass;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by PilarRM on 31/01/21
 */
public class BookingPassengerPage extends PageObject {
    @FindBy(id = "datos-pasajeros-bae")
    WebElementFacade formPassenger;
    @FindBy(id = "itm1-1")
    WebElementFacade labelAdultTitle;
    @FindBy(id = "itm1-2")
    WebElementFacade labelChildTitle;
    @FindBy(xpath = "//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-month']")
    WebElementFacade monthBirthDate;
    @FindBy(xpath = "//div[@id='ui-datepicker-div']//select[@class='ui-datepicker-year']")
    WebElementFacade yearBirthDate;

    public void successfulPassenger(){
        withTimeoutOf(Duration.ofSeconds(10)).find(By.id("datos-pasajeros-bae"));
        formPassenger.waitUntilPresent();
    }

    public void clickNextToPayment(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElementFacade element = find("//button[@id='btnContinuarPas']").waitUntilEnabled();
        if (element.isPresent()) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }else{
            fail("Element not present while scrolling: " + element);
        }
        element.click();
    }

    public void selectCabin(int iCabinNum){

    }

    public void putFirstNamePassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String firstName){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//input[@name='txt_nombre["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.clear();
        element.sendKeys(firstName);
    }

    public void putLastNamePassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String lastName){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//input[@name='txt_apellido["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.clear();
        element.sendKeys(lastName);
    }

    public void selectBirthDatePassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String birthDate){
        String[] arrayBirth = birthDate.split(" ");
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//input[@name='txt_fecha_nacimiento["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.click();
        monthBirthDate.selectByVisibleText(arrayBirth[1]);
        yearBirthDate.selectByVisibleText(arrayBirth[0]);
        selectDayInCurrentMonth(arrayBirth[2]);

    }

    public void selectNationalityPassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String sNationality){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//select[@name='sel_nacion["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.selectByVisibleText(sNationality);
    }

    public void selectDocumentIdPassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String sDocumentId){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//select[@name='sel_tpdoc["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.selectByVisibleText(sDocumentId);
    }

    public void putDocNumberPassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String docNumber){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//input[@name='txt_nroid["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.clear();
        element.sendKeys(docNumber);
    }

    public void selectSexoPassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String sSexo){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//select[@name='sel_sexo["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.selectByVisibleText(sSexo);
    }

    public void putPhonePassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String sPhone){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//input[@name='txt_telefono["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.clear();
        element.sendKeys(sPhone);
    }

    public void putEmailPassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String email){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//input[@name='txt_mail["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.clear();
        element.sendKeys(email);
    }

    public void putConfirmEmailPassenger(String cabinTypeName, String iCabinNum, String iPassengerNum, String emailConfirm){
        String shortName = HelperClass.getShortNameCabin(cabinTypeName);
        WebElementFacade element = find("//input[@name='txt_mail_conf["+shortName+"][cab"+iCabinNum+"]["+iPassengerNum+"]']");
        element.clear();
        element.sendKeys(emailConfirm);
    }

    public List<WebElementFacade> getDaysOfMonth(){
        return  findAll("//div[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']//a");
    }

    public void selectDayInCurrentMonth(String dayNumber){
        List<WebElementFacade> enabledDays = getDaysOfMonth();
        for(WebElementFacade enabledDay:enabledDays){
            if(enabledDay.getText().equals(dayNumber)){
                enabledDay.click();
                return;
            }
        }
        fail("Not found day in " + getClass().getName());
    }

}
