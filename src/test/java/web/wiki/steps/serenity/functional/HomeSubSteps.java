package web.wiki.steps.serenity.functional;

import net.thucydides.core.annotations.Step;
import web.wiki.pages.HomePage;

/**
 * Created by pilar07 on 2020-03-20.
 */
public class HomeSubSteps {
    HomePage homePage;

    @Step
    public void open_home_page() {
        homePage.open();
    }

    @Step
    public void successful_home(){
        homePage.successful_load();
        //homePage.select_idiom_english();
    }


}
