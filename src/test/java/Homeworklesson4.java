import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homeworklesson4 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1200x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
   void selenographer() {
        // открываем страницу selenide на гите
        open("https:github.com/selenide/selenide");
        // Переходим в раздел Wiki проекта
        $("#wiki-tab").click();
        // Нажмем на кнопку и найдем нужный элемент
        $("#wiki-pages-box").$(".wiki-more-pages-link").$(".f6").click();
                // Переходим на страницу SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
               // Проверим, есть ли пример кода для JUnit5
        $("a#user-content-3-using-junit5-extend-test-class").parent().sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n"
                      + "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}")
        );
        // Проверяем прмиер кода junit 5
        $(".markdown-body").$("#user-content-3-using-junit5-extend-test-class").closest("h4").sibling(2).shouldHave(
                text("class Tests {\n" +
                        "  @RegisterExtension \n" +
                        "  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();\n" +
                        "\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}")
        );
    }
}



