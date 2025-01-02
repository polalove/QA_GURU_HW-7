package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String mobileNumber = faker.phoneNumber().subscriberNumber(10);
    public String dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28));
    public String monthOfBirth = faker.options().option("June", "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = String.format("%s", faker.number().numberBetween(1924, 2024));
    public String subject = faker.options().option("Math", "Chemistry", "Computer Science", "Commerce", "Economics");
    public String hobbies = faker.options().option("Sports", "Reading", "Music");
    public String picture = faker.options().option("imageForTest.jpg", "secondImageForTest.jpg", "thirdImageForTest.jpg");
    public String address = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getCity(state);

    public String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}