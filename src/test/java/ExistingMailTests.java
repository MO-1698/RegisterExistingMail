import com.shaft.driver.SHAFT;
import jdk.jfr.Description;
import org.example.ExistingMailPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExistingMailTests {
    private SHAFT.GUI.WebDriver driver;
    @BeforeMethod
    @Description("this is a setup class for our test")
    public void setup (){
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Validate user Registers with an existing email")
    private void validateRegisterExistingEmail(){
        new ExistingMailPage(driver).navigateToURL("https://automationexercise.com/")
                .ValidateHomePage().clickOnSignupPageButton().ValidateNewUserSignup().fillNameTextField("Sam")
                .fillEmailTextField("Sam@yahoo.com").clickOnSignupButton().ValidateErrorMessage();

    }
}