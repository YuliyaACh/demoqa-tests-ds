import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Yuliya");
        $("#lastName").setValue("Cherevichenko");
        $("#userEmail").setValue("test@gmail.com");
        $("#genterWrapper").$(byText("Female")).click(); //пол
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click(); //календарь
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1991");
        $("div.react-datepicker__month div.react-datepicker__day.react-datepicker__day--015").click();

        $(".subjects-auto-complete__control.css-yk16xz-control").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("#hobbiesWrapper").setValue("Sports").click(); //хобби

        File testFile = new File("src/test/resources/test.pdf");
        $("#uploadPicture").uploadFile(testFile);

        $("#uploadPicture").click(); // файл
        $("#currentAddress").setValue("Some street 1");
        //$("#state").click();
       // $("#city").click();



      //  $("#output #firstName").shouldHave(text("Alex"));
        $("#output #lastName").shouldHave(text("Ivanov"));
        $("#output #userEmail").shouldHave(text("alex@egorov.com"));
        $("#output #userNumber").shouldHave(text("1234567890"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));

        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}