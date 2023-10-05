package tests;


import org.junit.jupiter.api.Test;
import pages.components.OutputComponent;


public class TextBoxWithPageObjectsTest extends TestBase {
    OutputComponent output = new OutputComponent();

    @Test
    void fillFormTest() {
        textBoxRegistrationPage.openPage()
                .setUserName("Yuri Chudov")
                .setUserEmail("yuri@chudov.com")
                .setCurrentAddress("Some Address 1")
                .setPermanentAddress("Some Address 2")
                .submit();

        output.checkResult("Name","Yuri Chudov")
               .checkResult("Email:", "yuri@chudov.com")
               .checkResult("Current Address :", "Some Address 1")
                .checkResult("Permananet Address :", "Some Address 2");

    }
}