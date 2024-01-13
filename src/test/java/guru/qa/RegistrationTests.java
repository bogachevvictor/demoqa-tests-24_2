package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Travolta")
                .setEmail("johntravolta@gmail.com")
                .setGender("Other")
                .setUserNumber("9001112233")
                .setDateOfBirth("10", "October", "1989")
                .setSubject("Arts")
                .setHobby("Sports")
                .uploadPicture("src/test/data/Image_test.png")
                .setCurrentAddress("Saint-Petersburg, st. Nevskiy 85")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmit();

        registrationPage.checkResult("Student Name", "John Travolta")
                .checkResult("Student Email","johntravolta@gmail.com")
                .checkResult("Gender","Other")
                .checkResult("Mobile","9001112233")
                .checkResult("Date of Birth","30 October,1989")
                .checkResult("Subjects","Arts")
                .checkResult("Hobbies","Sports")
                .checkResult("Picture","Image_test.png")
                .checkResult("Address","Saint-Petersburg, st. Nevskiy 85")
                .checkResult("State and City","NCR Noida");
    }

    @Test
    void successfulRegistrationTestWithMinimumParams() {
        registrationPage.openPage()
                .setFirstName("Cindy")
                .setLastName("Lacazete")
                .setGender("Female")
                .setUserNumber("9001112244")
                .clickSubmit();

        registrationPage.checkResult("Student Name", "Cindy Lacazete")
                .checkResult("Gender","Female")
                .checkResult("Mobile","9001112244");
    }

    @Test
    void unsuccessfulRegistrationTestWithoutRequiredField() {
        registrationPage.openPage()
                .setFirstName("Cindy")
                .setGender("Female")
                .setUserNumber("9001112244")
                .clickSubmit();

        registrationPage.checkFailResult();
    }
}
