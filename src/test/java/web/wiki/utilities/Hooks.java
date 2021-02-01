package web.wiki.utilities;
import web.wiki.helper.DatabaseHelper;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

/**
 * Created by PilarRM on 2/24/20.
 */
public class Hooks {
    @Before("@smoke")
    public void beforeSanitySmoke(){
        System.out.println("*******before test*******");
    }

    @Before("@LoadData")
    public void before(Scenario scenario) {
        DatabaseHelper.create_user("user.yml");
    }


}
