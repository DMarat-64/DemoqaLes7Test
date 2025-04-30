package tests;

import org.junit.jupiter.api.Test;
import pages.CompletionFormsPage;
import pages.components.ResultTableComponent;

import static utils.RandomUtils.*;

public class RequiredFieldsLes7Test extends TestBase {
    CompletionFormsPage completionForms = new CompletionFormsPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Test
    void fillFormRequiredFieldsTest () {
        completionForms.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthDay, birthMonth,birthYear)
                .setHobbiesWrapper(userHobbiesWrapper)
                .setCurrentAddress(streetAddress)
                .clickSubmit();
        //Проверки
        resultTableComponent.successfullyCompletedCase()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkResult("Hobbies", userHobbiesWrapper)
                .checkResult("Address", streetAddress);
    }
}
