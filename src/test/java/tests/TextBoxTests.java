package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        open("https://demoqa.com/text-box");

        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Sergey");
        $("#userEmail").setValue("Lukichev_s@mail.ru");
        $("#currentAddress").setValue("currentAddress here");
        $("#permanentAddress").setValue("permanentAddress here");
        $("#submit").click();

        $("#output").shouldHave(text("Sergey"), text("Lukichev_s@mail.ru"));
    }

}
