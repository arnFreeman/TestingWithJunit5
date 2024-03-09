package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitFlicTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://gitflic.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void autorization() {
        open("/auth/login");
        $("#email").setValue("testuser.freeman@gmail.com");
        $("#password").setValue("user91test24");
        $("[type=submit]").click();
    }

    @AfterEach
    void closedBrowser() {
        closeWindow();
    }

    @CsvSource(value = {
            "Java, mynewjavaproject",
            "Python, mynewpythonproject",
    })
    @ParameterizedTest(name = "Проверка создания проекта с параметрами language и nameProject")
    void createNewJavaProjectTest(String language, String nameProject) {

        //----создаем новый проект
        $("a[href='/project']").click();
        $("span[class*='d-none d-md-block']").click();
        //----Вводим данные проекта
        $("#title").setValue(nameProject);
        $("#vs1__combobox").click();
        actions().sendKeys(language).perform();
        sleep(3000);
        actions().sendKeys(Keys.ENTER).perform();
        $("button.btn-success").click();
        //----проверяем результат
        $("a[href='/project']").click();
        $(".projects").shouldHave(text("testuserfreeman/" + nameProject));
        $(".projects .align-items-center").shouldHave(text(language));
        //-----удаляем новый проект
        open("/project/testuserfreeman/" + nameProject + "/setting");
        $("button[data-target='deleteProject']").click();
        $("#deleteProject").$("input[name='controlString']").setValue("testuserfreeman/" + nameProject);
        $("#deleteProject").$("button[class*='btn-sm']").click();
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