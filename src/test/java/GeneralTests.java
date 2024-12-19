
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTests extends TestBase {

    @BeforeEach
    void setUp() {
        open("https://petstore.octoperf.com/actions/Catalog.action");
    }
    @ValueSource(strings = {"FISH", "DOGS", "CATS", "REPTILES"})
    @Tag("WEB")
    @ParameterizedTest (name = "Проверка наличия категорий на странице")
    public void testCategoryNavigation(String category) {
        // Открываем главную страницу
        open("https://petstore.octoperf.com/actions/Catalog.action");

        // Переход по категории
        $("div#QuickLinks a[href*='categoryId=" + category + "']").click();
        $("div#Catalog h2").shouldHave(Condition.text(category));
    }

}
