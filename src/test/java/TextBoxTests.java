import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alex@egorov.com");
       //$("#gender-radio-1").click(); //выбор пола
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
       // $("#dateOfBirthInput").click(); //выбор даты календаря
        // $("#subjectsContainer").click(); //субьект
        // $("#hobbies-checkbox-3").click(); /хобби
        // $("#uploadPicture").click(); // файл
        $("#currentAddress").setValue("Some street 1");
        //$("#state").click();
       // $("#city").click();



        $("#output #firstName").shouldHave(text("Alex"));
        $("#output #lastName").shouldHave(text("Ivanov"));
        $("#output #userEmail").shouldHave(text("alex@egorov.com"));
        $("#output #userNumber").shouldHave(text("1234567890"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));

        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}