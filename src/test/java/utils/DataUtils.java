package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataUtils {

    private static final Faker faker = new Faker(new Locale("en-GB"));

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomFullName() {
        return faker.name().fullName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomItem(String... options) {
        return faker.options().option(options);
    }

    public static LocalDate getRandomBirthdayDate() {
        return faker.date().birthday(1, 70).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String getBirthdayDateAsString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        return date.format(formatter);
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> getRandomItem("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> getRandomItem("Agra", "Lucknow", "Merrut");
            case "Haryana" -> getRandomItem("Karnal", "Panipat");
            case "Rajasthan" -> getRandomItem("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Передано несуществующее значение: " + state);
        };
    }
}
