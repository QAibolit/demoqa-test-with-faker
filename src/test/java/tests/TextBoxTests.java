package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.DataUtils;

public class TextBoxTests extends BaseTest {

    String fullName = DataUtils.getRandomFullName(),
            email = DataUtils.getRandomEmail(),
            currentAddress = DataUtils.getRandomAddress(),
            permanentAddress = DataUtils.getRandomAddress();

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Проверка полного заполнения формы")
    public void fillInAllFieldsOfTextBoxFormTest() {
        textBoxPage.openPage()
                .closeBanners()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .checkOutputFormIsVisible()
                .checkNameInOutputForm(fullName)
                .checkEmailInOutputForm(email)
                .checkCurrentAddressInOutputForm(currentAddress)
                .checkPermanentAddressInOutputForm(permanentAddress);
    }
}
