package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void firstFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Travolta");
        $("#userEmail").setValue("johntravolta@gmail.com");

        //Gender (radiobutton)
        $x("//*[@for='gender-radio-1']").click();

        //Mobile
        $("#userNumber").setValue("9001112233");

        //Date of Birth (datepicker)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("October");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day.react-datepicker__day--010").click();

        //Subjects (autocomplete)
        $("#subjectsInput").setValue("Arts").pressEnter();

        //Hobbies (checkboxes)
        $x("//*[@for='hobbies-checkbox-1']").click();
        $x("//*[@for='hobbies-checkbox-3']").click();

        //Picture (load file)
        $("#uploadPicture").uploadFile(new File("src/test/data/Image_test.png"));

        //Current Address
        $("#currentAddress").setValue("Saint-Petersburg, st. Nevskiy 85");

        //State and City (autocomplete)
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        //Submit (button)
        $("#submit").click();

        //Verifying
        $(".table tbody tr:nth-child(1)").shouldHave(text("John Travolta"));
        $(".table tbody tr:nth-child(2)").shouldHave(text("johntravolta@gmail.com"));
        $(".table tbody tr:nth-child(3)").shouldHave(text("Male"));
        $(".table tbody tr:nth-child(4)").shouldHave(text("9001112233"));
        $(".table tbody tr:nth-child(5)").shouldHave(text("10 October,1989"));
        $(".table tbody tr:nth-child(6)").shouldHave(text("Arts"));
        $(".table tbody tr:nth-child(7)").shouldHave(text("Sports, Music"));
        $(".table tbody tr:nth-child(8)").shouldHave(text("Image_test.png"));
        $(".table tbody tr:nth-child(9)").shouldHave(text("Saint-Petersburg, st. Nevskiy 85"));
        $(".table tbody tr:nth-child(10)").shouldHave(text("NCR Noida"));
    }
}
