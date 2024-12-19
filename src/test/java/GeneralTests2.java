import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GeneralTests2 extends TestBase{
    @BeforeEach
    void setUp() {
        open("https://petstore.octoperf.com/actions/Catalog.action");
    }
    static Stream<String> categoryProvider() {
        return Stream.of("FISH", "DOGS", "CATS", "REPTILES");
    }

    @MethodSource("categoryProvider")
    @Tag("WEB")
    @ParameterizedTest (name = "Проверка наличия категорий на странице")
    public void testCategoryIdentifier(String category) {

        open("https://petstore.octoperf.com/actions/Catalog.action");


        $("div#QuickLinks a[href*='categoryId=" + category + "']").click();


        $("div#Catalog h2").shouldHave(Condition.text(category));
    }
}
