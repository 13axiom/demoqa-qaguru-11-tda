package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        com.codeborne.selenide.Configuration.baseUrl= "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void successFillTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Dima");
        $("#userEmail").setValue("dima@mailinator.com");
        $("#currentAddress").setValue("Current address");
        $("#permanentAddress").setValue("Main street,90210");
        $("#submit").click();

        $("#output").shouldHave(text("Dima"),text("dima@mailinator.com"),
                text("Current address"),text("Main street,90210"));
    }
}

