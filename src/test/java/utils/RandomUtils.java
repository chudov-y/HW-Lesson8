package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    Faker faker = new Faker(Locale.US);
    final Date birthDate = faker.date().birthday(0, 120);

    final Map<String, String[]> states = new HashMap<>();{
        states.put("NCR", (new String[]{"Delhi", "Gurgaon", "Noida"}));
        states.put("Uttar Pradesh", (new String[]{"Agra", "Lucknow", "Merrut"}));
        states.put("Haryana", (new String[]{"Karnal", "Panipat"}));
        states.put("Rajasthan", (new String[]{"Jaipur", "Jaiselmer"}));
    }

    public String firstName = faker.name().firstName(),
      lastName = faker.name().lastName(),
      email = faker.internet().emailAddress(),
      gender = getRandomGender(),
      phoneNumber = faker.phoneNumber().subscriberNumber(10),
      bYear = dateFormat("yyyy", birthDate),
      bMonth = dateFormat("MMMM", birthDate),
      bDay = dateFormat("dd", birthDate),
      subjects = getRandomSubject(),
      hobbies = getRandomHobbies(),
      picture = getRandomPicture(),
      address = faker.address().streetAddress(),
      chooseState = getRandomStates(),
      chooseCity = getRandomStateCities(chooseState);



    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    private String dateFormat(String pattern, Date date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return simpleDate.format(date);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Arts", "Biology"};

        return getRandomItemFromArray(subjects);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"1.png", "2.png", "3.png"};

        return getRandomItemFromArray(pictures);
    }
    public String getRandomStates(){

        return faker.options().option(states.keySet().toArray()).toString();

    }
    public String getRandomStateCities(String state){
        return faker.options().option(states.get(state));
    }

}

