import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.*;

public class GeneralTests3 extends TestBase{
    @BeforeEach
    void setUp() {
        open("https://petstore.octoperf.com/actions/Catalog.action");
    }

    @CsvFileSource(resources = "test_data/categories.csv", numLinesToSkip = 1)
    @Tag("WEB")
    @ParameterizedTest (name = "Проверка наличия категорий на странице")
    public void testCategoryIdentifierCsv(String category) {

        open("https://petstore.octoperf.com/actions/Catalog.action");


        $("div#QuickLinks a[href*='categoryId=" + category + "']").click();


        $("div#Catalog h2").shouldHave(Condition.text(category));
    }
}
