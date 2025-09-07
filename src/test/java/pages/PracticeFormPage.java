package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultModalComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final SelenideElement header = $(".text-center"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            submitButton = $("#submit");


    private final ElementsCollection genderRadioButtons = $$(".custom-radio .custom-control-label"),
            hobbiesCheckboxes = $$(".custom-checkbox"),
            stateOptions = $$("[id*= select-3-option]"),
            cityOptions = $$("[id*= select-4-option]");

    private final CalendarComponent calendar = new CalendarComponent();

    private final ResultModalComponent resultModalWindow = new ResultModalComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        this.header.shouldHave(text("Practice Form"));
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        this.firstNameInput.setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        this.lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderRadioButtons.findBy(text(gender)).parent().click();
        return this;
    }

    public PracticeFormPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public PracticeFormPage setBirthdayDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.shouldBeVisible();
        calendar.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbiesCheckboxes.findBy(text(hobby)).click();
        }
        return this;
    }

    public PracticeFormPage uploadPicture(String pathToPicture) {
        uploadPictureInput.uploadFromClasspath(pathToPicture);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public PracticeFormPage selectState(String state) {
        stateSelect.scrollTo().click();
        stateOptions.findBy(text(state)).click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        citySelect.click();
        cityOptions.findBy(text(city)).click();
        return this;
    }

    public PracticeFormPage submit() {
        submitButton.scrollTo().click();
        return this;
    }

    public PracticeFormPage checkFirstNameFieldColor(String expectedColor) {
        this.firstNameInput.shouldHave(cssValue("border-color", expectedColor));
        return this;
    }

    public PracticeFormPage checkLastNameFieldColor(String expectedColor) {
        this.lastNameInput.shouldHave(cssValue("border-color", expectedColor));
        return this;
    }

    public PracticeFormPage checkPhoneFieldColor(String expectedColor) {
        this.phoneInput.shouldHave(cssValue("border-color", expectedColor));
        return this;
    }

    public PracticeFormPage checkGenderRadiobuttonsColor(String expectedColor) {
        this.genderRadioButtons.shouldHave(CollectionCondition.allMatch(
                "Все элементы коллекции должны иметь атрибут 'border-color' со значением " + expectedColor,
                element -> element.getCssValue("border-color").equals(expectedColor)));
        return this;
    }

    public PracticeFormPage checkResultModalIsVisible() {
        resultModalWindow.shouldBeVisible();
        return this;
    }

    public PracticeFormPage checkNameInResultModal(String name) {
        resultModalWindow.shouldHaveName(name);
        return this;
    }

    public PracticeFormPage checkEmailInResultModal(String email) {
        resultModalWindow.shouldHaveEmail(email);
        return this;
    }

    public PracticeFormPage checkGenderInResultModal(String gender) {
        resultModalWindow.shouldHaveGender(gender);
        return this;
    }

    public PracticeFormPage checkPhoneInResultModal(String phone) {
        resultModalWindow.shouldHavePhone(phone);
        return this;
    }

    public PracticeFormPage checkBirthdayInResultModal(String birthday) {
        resultModalWindow.shouldHaveBirthday(birthday);
        return this;
    }

    public PracticeFormPage checkSubjectsInResultModal(String subjects) {
        resultModalWindow.shouldHaveSubjects(subjects);
        return this;
    }

    public PracticeFormPage checkHobbiesInResultModal(String hobbies) {
        resultModalWindow.shouldHaveHobbies(hobbies);
        return this;
    }

    public PracticeFormPage checkPictureNameInResultModal(String pictureName) {
        resultModalWindow.shouldHavePictureName(pictureName);
        return this;
    }

    public PracticeFormPage checkAddressInResultModal(String address) {
        resultModalWindow.shouldHaveAddress(address);
        return this;
    }

    public PracticeFormPage checkStateAndCityInResultModal(String stateAndCity) {
        resultModalWindow.shouldHaveStateAndCity(stateAndCity);
        return this;
    }
}
