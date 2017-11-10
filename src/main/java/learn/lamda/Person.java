package learn.lamda;

import java.time.LocalDate;
import java.util.List;

public class Person {

    public static List<Person> createRoster() {

        return null;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public enum Sex {
                     MALE, FEMALE
    }

    String    name;
    LocalDate birthday;
    Sex       gender;
    String    emailAddress;

    public int getAge() {
        return birthday.getYear();
    }

    public void printPerson() {
        System.out.println(name);
    }
}