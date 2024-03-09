package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitFlicTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void createNewJavaProjectTest() {
        open("https://gitflic.ru/");
        $("[data-barba-prevent=self]").click();
        $("#email").setValue("testuser.freeman@gmail.com");
        $("#password").setValue("user91test24");
        $("[type=submit]").click();
        $("a[href='/project']").click();
        $("span[class='d-none d-md-block']").click();
        $("#title").setValue("My new project");
        $("#vs1__combobox").click();
        //$("[input.vs__search]").setValue("Java").click();
        //$(".vs__selected-options").setValue("Java");
        $("button[class*='btn-success']").click();
        sleep(5000);

    }
    @Disabled
    @Test
    void createNewPythonProjectTest() {
        open("https://gitflic.ru/");
        $("[data-barba-prevent=self]").click();
        $("#email").setValue("testuser.freeman@gmail.com");
        $("#password").setValue("user91test24");
        $("[type=submit]").click();
        $("a[href='/project']").click();
        $("span[class='d-none d-md-block']").click();
        $("#title").setValue("My new project");
        $("#vs1__combobox").click();
        $(".vs__selected-options").setValue("Python");
        //$("[button type='submit']").click();
        sleep(5000);
    }
    @Disabled
    @Test
    void createNewTeamTest() {
        open("https://gitflic.ru/");
        $("[data-barba-prevent=self]").click();
        $("#email").setValue("testuser.freeman@gmail.com");
        $("#password").setValue("user91test24");
        $("[type=submit]").click();
        $("a[href='/team']").click();
        $("span[class='d-none d-md-block']").click();
        $("#title").setValue("My new team 1");
        $("#description").setValue("Team new my");
        $("[button type='submit']").click();
        sleep(3000);

    }
}