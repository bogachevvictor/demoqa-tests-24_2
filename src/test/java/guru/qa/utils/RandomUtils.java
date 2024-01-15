package guru.qa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public static String getRandomFirstName() {
        Faker faker = new Faker(new Locale("ru"));
        String firstName = faker.name().firstName();

        return firstName;
    }

    public static String getRandomLastName() {
        Faker faker = new Faker(new Locale("ru"));
        String lastName = faker.name().lastName();

        return lastName;
    }

    public static String getRandomEmail() {
        Faker faker = new Faker(new Locale("en"));
        String userEmail = faker.internet().emailAddress();

        return userEmail;
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);

        return genders[index];
    }

    public static String getRandomPhone() {
        return String.format("%s%s%s%s",getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomSubjects() {
        String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        int index = getRandomInt(0, subjects.length - 1);

        return subjects[index];
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int index = getRandomInt(0, hobbies.length - 1);

        return hobbies[index];
    }

    public static String getRandomCurrentAddress() {
        Faker faker = new Faker(new Locale("ru"));
        String userCurrentAddress = faker.address().streetAddress();

        return userCurrentAddress;
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int index = getRandomInt(0, states.length - 1);

        return states[index];
    }

    public static String[] getRandomStateAndCity() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int index = getRandomInt(0, states.length - 1);
        String city;

        if (index == 0) {
            String[] cities = {"Delhi", "Gurgaon", "Noida"};
            int index0 = getRandomInt(0, cities.length - 1);
            city = cities[index0];
        } else if (index == 1) {
            String[] cities1 = {"Agra", "Lucknow", "Merrut"};
            int index1 = getRandomInt(0, cities1.length - 1);
            city = cities1[index1];
        } else if (index == 2) {
            String[] cities2 = {"Karnal", "Panipat"};
            int index2 = getRandomInt(0, cities2.length - 1);
            city = cities2[index2];
        } else  {
            String[] cities3 = {"Jaipur", "Jaiselmer"};
            int index3 = getRandomInt(0, cities3.length - 1);
            city = cities3[index3];
        }

        String stateAndCity[] = {states[index], city};

        return stateAndCity;
    }
}
