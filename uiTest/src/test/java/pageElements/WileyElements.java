package pageElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.elements;

public class WileyElements {
    public static SelenideElement whoWeServeButton = $x("//a[contains(text(),'WHO WE SERVE')]");
    public static SelenideElement yesButton = $x("//button[text()='YES']");
    public static SelenideElement whoWeServe = $x("//a[contains(text(),'WHO WE SERVE')]/../div/ul");
    public static SelenideElement searchField = $x("//input[@placeholder='Search by Title, Author, Keyword or ISBN']");
    public static SelenideElement result = $x("//input[@placeholder='Search by Title, Author, Keyword or ISBN']/../../aside");
    public static SelenideElement searchButton = $x("//button[text()='Search']");
    public static SelenideElement subjectsButton = $x("//a[contains(text(),'SUBJECTS')]");
    public static SelenideElement educationButton = $x("//a[contains(text(),'Education')]");
    public static SelenideElement educationText = $x("//h1//span[text()='Education']");
    public static ElementsCollection elements = elements(byXpath("//div[@class='products-list']/section"));
    public static ElementsCollection subjectsList = elements(byXpath("//h4[text()='Subjects']/../../..//li"));
}
