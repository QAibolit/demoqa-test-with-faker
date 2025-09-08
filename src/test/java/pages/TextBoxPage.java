package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.OutputFormComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement header = $(".text-center"),
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    private final OutputFormComponent outputForm = new OutputFormComponent();

    public TextBoxPage openPage() {
        open("/text-box");
        this.header.shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage closeBanners() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        this.fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        this.emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        this.currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        this.permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage submit() {
        this.submitButton.click();
        return this;
    }

    public TextBoxPage checkOutputFormIsVisible() {
        outputForm.shouldBeVisible();
        return this;
    }

    public TextBoxPage checkNameInOutputForm(String name) {
        outputForm.shouldHaveName(name);
        return this;
    }

    public TextBoxPage checkEmailInOutputForm(String email) {
        outputForm.shouldHaveEmail(email);
        return this;
    }

    public TextBoxPage checkCurrentAddressInOutputForm(String currentAddress) {
        outputForm.shouldHaveCurrentAddress(currentAddress);
        return this;
    }

    public TextBoxPage checkPermanentAddressInOutputForm(String permanentAddress) {
        outputForm.shouldHavePermanentAddress(permanentAddress);
        return this;
    }
}
