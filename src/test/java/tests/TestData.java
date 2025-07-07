package tests;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker(new Locale("en-GB"));

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String phone = faker.phoneNumber().subscriberNumber(10);
    public static String address = faker.address().streetAddress();

    public static String day = String.format("%02d", faker.number().numberBetween(1, 30));
    public static String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public static String year = String.valueOf(faker.number().numberBetween(1980, 2005));

    public static String gender = faker.options().option("Male", "Female", "Other");
    public static String subject = faker.options().option("Maths", "Arts", "Computer Science", "Biology");
    public static String hobby = faker.options().option("Sports", "Reading", "Music");
    public static String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static String city = getRandomCityForState(state);

    public static String getRandomCityForState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Delhi";
        };
    }
}
