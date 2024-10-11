package org.example;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ExistingMailPage {
    private SHAFT.GUI.WebDriver driver;

    public ExistingMailPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By HomePage = By.xpath("//a[@style=\"color: orange;\"]");
    private By SignupPageButton = By.xpath("//a[@href=\"/login\"]//i[@class=\"fa fa-lock\"]");
    private By NewUserSignup = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By NameTextField = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By EmailTextField = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By SignupButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By ErrorMessage = By.xpath("//p[@style=\"color: red;\"]");

    public ExistingMailPage navigateToURL(String URL) {
        driver.browser().navigateToURL(URL);
        return this;
    }

    public ExistingMailPage clickOnSignupPageButton() {
        driver.element().click(SignupPageButton);
        return this;
    }

    public ExistingMailPage fillNameTextField(String name) {
        driver.element().type(NameTextField, name);
        return this;
    }

    public ExistingMailPage fillEmailTextField(String email) {
        driver.element().type(EmailTextField, email);
        return this;
    }

    public ExistingMailPage clickOnSignupButton() {
        driver.element().click(SignupButton);
        return this;
    }


    @Step("Validate that the user is on Home Page")
    public ExistingMailPage ValidateHomePage() {
        driver.element().verifyThat(HomePage).text().contains("Home");
        return this;
    }

    @Step("Validate that the user is on Signup Page")
    public ExistingMailPage ValidateNewUserSignup() {
        driver.element().verifyThat(NewUserSignup).text().contains("New User Signup!");
        return this;
    }

    @Step("Validate that the user is on Signup Page")
    public ExistingMailPage ValidateErrorMessage() {
        driver.element().verifyThat(ErrorMessage).text().contains("Email Address already exist!");
        return this;
    }



}