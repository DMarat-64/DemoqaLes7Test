package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.CompletionFormsPage;
import pages.components.ResultTableComponent;

import java.util.Locale;


public class DemoqaLes7WithFakerTests extends TestBase {

    CompletionFormsPage completionForms = new CompletionFormsPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    Faker faker = new Faker(new Locale("en-GB"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userGender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.numerify("7#########");

    String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
    String birthMonth = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    String birthYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    String subject = faker.options().option(
            "Chemistry", "Maths", "Physics", "Arts", "English",
            "Biology", "History", "Economics", "Computer Science", "Commerce", "Accounting"
    );
    String userSubject = faker.options().option(
            "Chemistry", "Maths", "Physics", "Arts", "English",
            "Biology", "History", "Economics", "Computer Science", "Commerce", "Accounting"
    );
    String userobbiesWrapper = faker.options().option("Sports", "Reading", "Music");
    String streetAddress = faker.address().streetAddress();
    String userState = "Haryana";
    String userCity = "Karnal";



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
                .setHobbiesWrapper(userobbiesWrapper)
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
                .checkResult("Hobbies", userobbiesWrapper)
                .checkResult("Picture", "test.png")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", userState + " " + userCity);
    }

}
