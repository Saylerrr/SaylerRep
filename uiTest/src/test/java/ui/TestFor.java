package ui;

import org.junit.jupiter.api.Test;
import pageElements.WileyElements;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class TestFor {

    String[] subjectsList = new String[] {
            "Information & Library Science",
            "Education & Public Policy",
            "K-12 General",
            "Higher Education General",
            "Vocational Technology",
            "Conflict Resolution & Mediation (School settings)",
            "Curriculum Tools- General",
            "Special Educational Needs",
            "Theory of Education",
            "Education Special Topics",
            "Educational Research & Statistics",
            "Literacy & Reading",
            "Classroom Management"};
    int i = 0;

    @Test
    void goToSubjects() {
        open("https://www.wiley.com/en-us");

        WileyElements.yesButton.click();
        WileyElements.subjectsButton.hover();
        WileyElements.educationButton.click();

        //Check “Education” header is displayed
        WileyElements.educationText.shouldBe(visible);

        //13 items are displayed under “Subjects” on the left side of the screen and the texts are:
        // "Information & Library Science",    "Education & Public Policy",  "K-12 General",  "Higher Education General",   
        // "Vocational Technology",   "Conflict Resolution & Mediation (School settings)",   "Curriculum Tools- General",  
        //  "Special Educational Needs",   "Theory of Education",  "Education Special Topics",  
        // "Educational Research & Statistics",  "Literacy & Reading",  "Classroom Management"
        WileyElements.subjectsList.shouldHave(size(13));
        for(String s : subjectsList) {
            WileyElements.subjectsList.get(i).find(byText(s)).shouldBe(visible);
            i++;
        }
    }
}
