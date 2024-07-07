import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()"); //скрытие банеров
        executeJavaScript("$('footer').remove()"); //скрытие банеров
        $("#firstName").setValue("Yuliya");
        $("#lastName").setValue("QAGURU");
        $("#userEmail").setValue("test@gmail.com");
        $("#genterWrapper").$(byText("Female")).click(); //пол
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click(); //календарь
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1991");
        $("div.react-datepicker__month div.react-datepicker__day.react-datepicker__day--015").click();
        $(".subjects-auto-complete__control.css-yk16xz-control").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click(); //хобби
        $("#uploadPicture").uploadFromClasspath("207.png"); //загрузка файла
        $("#currentAddress").setValue("Street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        //Проверка введенного

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Values"),
                Condition.text("Yuliya QAGURU"),
                Condition.text("test@gmail.com"),
                Condition.text("Female"),
                Condition.text("1234567890"),
                Condition.text("15 April,1991"),
                Condition.text("Computer Science"),
                Condition.text("Sports"),
                Condition.text("207.png"),
                Condition.text("Street 1"),
                Condition.text("Rajasthan Jaipur")
                );
    }
}