package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OutputFormComponent {

    private final SelenideElement root = $("#output"),
            name = $("#output #name"),
            email = $("#output #email"),
            currentAddress = $("#output #currentAddress"),
            permanentAddress = $("#output #permanentAddress");

    public void shouldBeVisible() {
        this.root.shouldBe(visible);
    }

    public void shouldHaveName(String name) {
        this.name.shouldHave(text(name));
    }

    public void shouldHaveEmail(String email) {
        this.email.shouldHave(text(email));
    }

    public void shouldHaveCurrentAddress(String currentAddress) {
        this.currentAddress.shouldHave(text(currentAddress));
    }

    public void shouldHavePermanentAddress(String permanentAddress) {
        this.permanentAddress.shouldHave(text(permanentAddress));
    }
}
