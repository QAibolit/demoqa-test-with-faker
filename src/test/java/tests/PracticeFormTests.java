package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.DataUtils;

import java.time.LocalDate;

public class PracticeFormTests extends BaseTest {

    LocalDate birthdayDate = DataUtils.getRandomBirthdayDate();

    String firstName = DataUtils.getRandomFirstName(),
            lastName = DataUtils.getRandomLastName(),
            email = DataUtils.getRandomEmail(),
            gender = DataUtils.getRandomItem("Male", "Female", "Other"),
            phone = DataUtils.getRandomPhoneNumber(),
            birthdayDateAsString = DataUtils.getBirthdayDateAsString(birthdayDate),
            fullName = firstName + " " + lastName,
            subject = DataUtils.getRandomItem("English", "Maths", "Physics", "Economics"),
            hobby = DataUtils.getRandomItem("Sports", "Reading", "Music"),
            picture = DataUtils.getRandomItem("hedgehog.jpg", "dino.jpeg", "fire.jpeg"),
            address = DataUtils.getRandomAddress(),
            state = DataUtils.getRandomItem("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = DataUtils.getRandomCity(state),
            redColor = "rgb(220, 53, 69)";

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Проверка полного заполнения формы регистрации")
    public void fillInAllFieldsOfPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthdayDate(birthdayDate)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture("uploadFiles/" + picture)
                .setCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .submit()
                .checkResultModalIsVisible()
                .checkNameInResultModal(fullName)
                .checkEmailInResultModal(email)
                .checkGenderInResultModal(gender)
                .checkPhoneInResultModal(phone)
                .checkBirthdayInResultModal(birthdayDateAsString)
                .checkSubjectsInResultModal(subject)
                .checkHobbiesInResultModal(hobby)
                .checkPictureNameInResultModal(picture)
                .checkAddressInResultModal(address)
                .checkStateAndCityInResultModal(state + " " + city);
    }

    @Test
    @DisplayName("Проверка заполнения обязательных полей формы регистрации")
    public void fillInRequiredFieldsOfPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhone(phone)
                .submit()
                .checkResultModalIsVisible()
                .checkNameInResultModal(fullName)
                .checkGenderInResultModal(gender)
                .checkPhoneInResultModal(phone);

    }

    @Test
    @DisplayName("Проверка частичного заполнения обязательных полей формы регистрации")
    public void fillInRequiredFieldsOfPracticeFormPartiallyTest() {
        practiceFormPage.openPage()
                .submit()
                .checkFirstNameFieldColor(redColor)
                .checkLastNameFieldColor(redColor)
                .checkPhoneFieldColor(redColor)
                .checkGenderRadiobuttonsColor(redColor);
    }
}
