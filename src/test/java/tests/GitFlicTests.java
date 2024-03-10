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
    void authorizationForm() {
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
    @DisplayName("Тест на создание нового проекта")
    @ParameterizedTest(name = "Проверка создания и удаления нового проекта с параметрами language и nameProject")
    void createAndDeleteNewJavaProjectTest(String language, String nameProject) {
        $("span[class*='d-none d-md-block']").click();
        $("#title").setValue(nameProject);
        $("#vs1__combobox").click();
        actions().sendKeys(language).perform();
        sleep(1000);
        actions().sendKeys(Keys.ENTER).perform();
        $("button.btn-success").click();
        $("a[href='/project']").click();
        $(".projects").shouldHave(text("testuserfreeman/" + nameProject));
        $(".projects .align-items-center").shouldHave(text(language));
        open("/project/testuserfreeman/" + nameProject + "/setting");
        $("button[data-target='deleteProject']").click();
        $("#deleteProject").$("input[name='controlString']").setValue("testuserfreeman/" + nameProject);
        $("#deleteProject").$("button[class*='btn-sm']").click();
    }

    @DisplayName("Тест на изменение информации о команде")
    @Disabled("Надо реализовать проверку изменения аватарки команды")
    @Test
    void createNewSettingsForTeamTest() {
        open("/team/my-best-team-ever/setting");
        $("#title").clear();
        $("#title").setValue("My crazy team 40");
        $("#description").clear();
        $("#description").setValue("Crazy team work 40");
        //$("#imgUploader").uploadFromClasspath("1223.jpg");
        $("button.btn-success").click();
        $("a[href='/team']").click();
        $(".projects-team__list .flex-row").shouldHave(text("My crazy team 40"));
        $(".projects-team__list .flex-row").shouldHave(text("Crazy team work 40"));
    }
}