package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Drive2ruTests {
    @ParameterizedTest
    @ValueSource(strings = {"Ford Mondeo IV", "Subaru Impreza GG"})
    void searchResultsShouldNotBeEmpty(String searchQuery) {
        open("https://www.drive2.ru/");
        $("input[type='search']").setValue(searchQuery).pressEnter();
        $(".o-f").shouldHave(text(searchQuery));
    }
}