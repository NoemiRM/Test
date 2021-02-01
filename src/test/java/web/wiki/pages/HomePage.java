package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.time.Duration;

/**
 * Created by pilar07 on 2020-03-20.
 */
@DefaultUrl("page:home.page")
public class HomePage extends PageObject {
    @FindBy(id = "btn_search")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//div[@class='opciones-y-cargo']//select[@class ='hasCustomSelect']")
    private WebElementFacade selectIdiom;

    public void successful_load() {
        withTimeoutOf(Duration.ofSeconds(20)).find(By.id("btn_search"));
        searchButton.waitUntilPresent();

    }

    public void select_idiom_english(){
        selectIdiom.selectByVisibleText("En");
    }
}
