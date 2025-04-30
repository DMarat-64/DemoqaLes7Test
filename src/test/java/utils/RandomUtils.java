package utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RandomUtils {

    private static final Faker faker = new Faker(new Locale("en-GB"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.numerify("7#########"),
            birthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            birthMonth = faker.options().option("January", "February", "March", "April", "May", "June",
                                                 "July", "August", "September", "October", "November", "December"),
            birthYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            userSubject = faker.options().option("Chemistry", "Maths", "Physics", "Arts", "English",
                                                 "Biology", "History", "Economics", "Computer Science", "Commerce", "Accounting"),
            userHobbiesWrapper = faker.options().option("Sports", "Reading", "Music"),
            streetAddress = faker.address().streetAddress(),
            userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            userCity = getRandomCitySelectPoint(userState);

    public static String getRandomCitySelectPoint(String userState) {
        String result = "";
        switch (userState) {
            case "NCR" -> result = faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> result = faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> result = faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> result = faker.options().option("Jaipur", "Jaiselmer");
            }
        return result;
    }

}




