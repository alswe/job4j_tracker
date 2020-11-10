package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        var result = new ArrayList<Person>();
        Predicate<Person> containsAddress = person -> person.getAddress().contains(key);
        Predicate<Person> containsName = person -> person.getName().contains(key);
        Predicate<Person> containsPhone = person -> person.getPhone().contains(key);
        Predicate<Person> containsSurname = person -> person.getSurname().contains(key);
        var combine = containsAddress.or(containsName.or(containsPhone.or(containsSurname)));

        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }

//        for (Person person : persons) {
//            if (person.getAddress().contains(key) || person.getName().contains(key)
//                    || person.getPhone().contains(key) || person.getSurname().contains(key)) {
//                result.add(person);
//            }
//        }
        return result;
    }
}