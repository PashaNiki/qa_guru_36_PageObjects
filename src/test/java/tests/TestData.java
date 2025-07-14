package tests;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker(new Locale("en-GB"));

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String phone = faker.phoneNumber().subscriberNumber(10);
    public final String address = faker.address().streetAddress();

    public final String day = String.format("%02d", faker.number().numberBetween(1, 29));
    public final String month = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public final String year = String.valueOf(faker.number().numberBetween(1980, 2005));

    public final String gender = faker.options().option("Male", "Female", "Other");
    public final String subject = faker.options().option("Maths", "Arts", "Computer Science", "Biology");
    public final String hobby = faker.options().option("Sports", "Reading", "Music");
    public final String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public final String city = getRandomCityForState(state);

    private String getRandomCityForState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Delhi";
        };
    }
}
