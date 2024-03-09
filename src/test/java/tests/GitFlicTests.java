package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class GitFlicTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://gitflic.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
    }

    @Test
    void createNewJavaProjectTest() {
        open("/auth/login");
        //$("[data-barba-prevent=self]").click();

        //----логинимся

        $("#email").setValue("testuser.freeman@gmail.com");
        $("#password").setValue("user91test24");
        $("[type=submit]").click();

        open("/project/testuserfreeman/my-new-project");


        //----создаем новый проект

        //$("a[href='/project']").click();
//        $("span[class*='d-none d-md-block']").click();
//        $("#title").setValue("My new project");

        //----выбираем язык программирования

        //$("#vs1__combobox").click();
        //$("[input.vs__search]").setValue("Java").click();
        //$(".vs__selected-options").setValue("Java");

        //$("button.btn-success").click();

        //----проверяем результат
//        $("div[class*='project__settings-links']").shouldHave(text("testuserfreeman" + " / " + "My new project"));



        //-----удаляем новый проект

        $("a[href='/project/testuserfreeman/my-new-project/setting']").click();
        $("button[data-target='deleteProject']").click();


        $("input[class*='form-control-sm']").click();


                //setValue("testuserfreeman/my-new-project");
//        $("div input[name=controlString]").setValue("testuserfreeman/my-new-project");
//        sleep(4000);
//        $$("div.modal-footer").findBy(text("Удалить")).click();
//        //$("button[class*='btn-sm']").click();
//        sleep(6000);

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