package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.CompletionFormsPage;
import pages.components.ResultTableComponent;

import java.util.Locale;

public class DemoqaLes7WithFakerTests extends TestBase {
    CompletionFormsPage completionForms = new CompletionFormsPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Test
    void fillFormTest() {

        Faker faker = new Faker(new Locale("ru"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();

        completionForms.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("14", "August","1980")
                .setSubjects("Biology")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("2025-04-24_13-53-15.png")
                .setCurrentAddress(streetAddress)
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();
        //Проверки
        resultTableComponent.successfullyCompletedCase()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "14 August,1980")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "2025-04-24_13-53-15.png")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", "Haryana Karnal");
    }

}
