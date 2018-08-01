import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestJira {
    public static LoginPage loginPage=new LoginPage();

    @BeforeTest
    public void setup(){
        Configuration.browser = "chrome";
        open("http://jira.hillel.it:8080/login.jsp");
       loginPage.enterLogin("webinar5");
       loginPage.enterPassword("webinar5");
       loginPage.submitButton();
    }

    @Test
    public void testMainPage(){
        $(".aui-page-header-main").shouldHave(visible, text("System Dashboard"));
    }
}
