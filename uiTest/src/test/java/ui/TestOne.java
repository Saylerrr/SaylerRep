package ui;

import org.junit.jupiter.api.Test;
import pageElements.WileyElements;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class TestOne {

    String[] whoWeServeList = new String[] {
            "Students",
            "Instructors",
            "Book Authors",
            "Professionals",
            "Researchers",
            "Institutions",
            "Librarians",
            "Corporations",
            "Societies",
            "Journal Editors",
            "Bookstores",
            "Government"};
    int i = 0;

    @Test
    void checkItems() {
        open("https://www.wiley.com/en-us");

        WileyElements.yesButton.click();
        WileyElements.whoWeServeButton.click();
        WileyElements.whoWeServe.shouldBe(visible);

        //There are 11 items under resources sub-header (Похоже, уже стало 12)
        elements(byXpath("//a[contains(text(),'WHO WE SERVE')]/../div/ul/li")).shouldHave(size(12));

        //Titles are “Students”, “Instructors”, “Book Authors”, “Professionals”, “Researchers”,
        // “Institutions”, “Librarians”, “Corporations”, “Societies”, “Journal Editors”, “Government”
        // Добавилось "Bookstores"
        for(String s : whoWeServeList) {
            elements(byXpath("//a[contains(text(),'WHO WE SERVE')]/../div/ul/li")).get(i).getText().equals(s);
            i++;
        }
    }
}
