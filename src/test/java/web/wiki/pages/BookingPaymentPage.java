package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import web.wiki.HelperClass;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by PilarRM on 31/01/21
 */
public class BookingPaymentPage extends PageObject {
    @FindBy(id = "forma-pago")
    WebElementFacade formPayment;

    public void successfulPayment(){
        withTimeoutOf(Duration.ofSeconds(10)).find(By.id("forma-pago"));
        formPayment.waitUntilPresent();
    }

}
