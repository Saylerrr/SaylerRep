package ui;

import org.junit.jupiter.api.Test;
import pageElements.WileyElements;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TestTwo {

    @Test
    void checkSearch() {
        open("https://www.wiley.com/en-us");

        WileyElements.yesButton.click();
        WileyElements.searchField.setValue("Java");

        //Area with related content is displayed right under the search header
        WileyElements.result.shouldBe(visible);
    }
}
