package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResponsiveTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public static SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            userPictureUpload = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            userStateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            userCityInput = $("#city"),
            submitButton = $("#submit"),
            validationCheck = $("#userForm");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResponsiveTableComponent responsiveTableComponent = new ResponsiveTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value){
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value){
        userPictureUpload.uploadFile(new File(value));

        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        userCurrentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value){
        userStateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value){
        userCityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public void clickSubmit(){
        submitButton.click();

    }

    public RegistrationPage checkResult(String key, String value){
        responsiveTableComponent.checkTable(key, value);

        return this;
    }

    public RegistrationPage checkFailResult(){
        validationCheck.shouldHave(cssClass("was-validated"));
        $("#app").shouldNotHave(cssClass("table-responsive"));
        return this;
    }
}
