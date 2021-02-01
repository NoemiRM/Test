package web.wiki.steps.serenity.functional;

import net.thucydides.core.annotations.Step;
import web.wiki.pages.LoginPage;

/**
 * Created by pilar07 on 2020-03-20.
 */
public class LoginSubSteps {
    LoginPage loginPage;

    @Step
    public void enter_user(String user) {
        loginPage.putUser(user);
    }

    @Step
    public void enter_password(String password) {
        loginPage.putPassword(password);
    }

    @Step
    public void request_to_access() {
        loginPage.requestLogin();
    }
}
