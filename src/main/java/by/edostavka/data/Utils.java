package by.edostavka.data;


import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class Utils {
    private static final Logger logger = LogManager.getLogger();

    public static String getPhoneNumber(){
        String randomPhoneNumber = "29";
        for (int i = 0; i<7; i++) {
            int nextDigit = (int) (Math.random() * 10);
            randomPhoneNumber += nextDigit;
        }
        logger.info("Сгенерирован номер: +375{}", randomPhoneNumber);
        return randomPhoneNumber;
    }

    private static final Faker faker = new Faker(new Locale("ru"));
    private static final Faker fakerEn = new Faker(new Locale("en"));

    public static String getName() {
        return faker.name().firstName();
    }

    public static String getMiddleName() {
        return faker.resolve("name.male_middle_name");
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return fakerEn.internet().emailAddress();
    }

    public static String getPassword() {
        return faker.regexify("[a-z][A-Z][0-9][!@#$&*][A-Za-z0-9!@#$&*]{4,12}");
    }


}

