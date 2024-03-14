package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import tests.data.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LanguageTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void closeBrowser() {
        closeWindow();
    }

    @EnumSource(Language.class)
    @ParameterizedTest
    void podhoditLangTest(Language chooseLang) {
        open("https://podhodit.com");
        $(".lang-panel").$(byText(chooseLang.name())).click();
        $(".fadeInDown").shouldHave(text(chooseLang.description));
    }
}
