package tests;

import org.junit.jupiter.api.Test;
import pages.CompletionFormsPage;
import pages.components.ResultTableComponent;

import static utils.RandomUtils.*;


public class DemoqaLes7WithFakerTests extends TestBase {

    CompletionFormsPage completionForms = new CompletionFormsPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Test
    void fillFormTest() {
        completionForms.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthDay, birthMonth,birthYear)
                .setSubjects(userSubject)
                .setHobbiesWrapper(userHobbiesWrapper)
                .setUploadPicture("test.png")
                .setCurrentAddress(streetAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit();

        //Проверки
        resultTableComponent.successfullyCompletedCase()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobbiesWrapper)
                .checkResult("Picture", "test.png")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", userState + " " + userCity);
    }

}
