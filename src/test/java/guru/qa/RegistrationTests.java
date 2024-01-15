package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.utils.RandomUtils.*;


public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userNumber = getRandomPhone(),
            userSubject = getRandomSubjects(),
            userHobby = getRandomHobbies(),
            userCurrentAddress = getRandomCurrentAddress();
    String userStateAndCity[] = getRandomStateAndCity();


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth("10", "October", "1989")
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture("src/test/data/Image_test.png")
                .setCurrentAddress(userCurrentAddress)
                .setState(userStateAndCity[0])
                .setCity(userStateAndCity[1])
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userNumber)
                .checkResult("Date of Birth","30 October,1989")
                .checkResult("Subjects",userSubject)
                .checkResult("Hobbies",userHobby)
                .checkResult("Picture","Image_test.png")
                .checkResult("Address",userCurrentAddress)
                .checkResult("State and City",userStateAndCity[0] + " " + userStateAndCity[1]);
    }

    @Test
    void successfulRegistrationTestWithMinimumParams() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userNumber);

    }

    @Test
    void unsuccessfulRegistrationTestWithoutRequiredField() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.checkFailResult();
    }
}
