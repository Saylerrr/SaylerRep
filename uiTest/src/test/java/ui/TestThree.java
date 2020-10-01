package ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pageElements.WileyElements;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class TestThree {

    SelenideElement[] selEl = new SelenideElement[10];

    @Test
    void enterInSearch() {
        open("https://www.wiley.com/en-us");

        WileyElements.yesButton.click();
        WileyElements.searchField.setValue("Java");
        WileyElements.searchButton.click();

        //There are 10 titles on the page
        WileyElements.elements.shouldHave(size(10));
        for (int i = 0; i<selEl.length; i++) {
            selEl[i] = WileyElements.elements.get(i);
        }

        //Only titles containing “Java” are displayed
        for(SelenideElement se : selEl) {
            se.find(byText("Java")).shouldBe(visible);
        }

        //Each title has at least one “Add to Cart” button for E-Book/Print version and “VIEW ON WILEY ONLINE LIBRARY” for O-BOOK version
        for(SelenideElement se : selEl) {
            if (se.find(byText("O-Book")).exists()) {
                se.find(byText("O-Book")).click();
                se.find(byText("View on Wiley Online Library")).shouldBe(visible);
            }
        }
        //Не на всех книгах есть кнопка
        for(SelenideElement se : selEl) {
            se.find(byText("Add to cart")).shouldBe(visible);
        }
    }
}
