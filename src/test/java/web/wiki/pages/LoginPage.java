package web.wiki.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

/**
 * Created by pilar07 on 2020-03-20.
 */
public class LoginPage extends PageObject {
    @FindBy(id = "wpName1")
    private WebElementFacade inputUser;

    @FindBy(id = "wpPassword1")
    private WebElementFacade inputPassword;

    @FindBy(id = "wpLoginAttempt")
    private WebElementFacade btnLogin;

    public void putUser(String user){
        inputUser.clear();
        inputUser.sendKeys(user);
    }

    public void putPassword(String password){
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void requestLogin(){
        btnLogin.click();
    }


}
