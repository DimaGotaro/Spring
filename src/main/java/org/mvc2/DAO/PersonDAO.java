package org.mvc2.DAO;

import org.mvc2.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;


    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Maik"));
        people.add(new Person(++PEOPLE_COUNT, "Greta"));
        people.add(new Person(++PEOPLE_COUNT, "Rox"));
    }

    public int p_count() {
        return ++PEOPLE_COUNT;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void edit(Person person) {
        if (0 < person.getId() & person.getId() <= PEOPLE_COUNT & person.getName() != null) {
//            Objects.requireNonNull(people.stream().filter(d -> d.getId() == person.getId()).
//                    findAny().orElse(null)).setName(person.getName());
            show(person.getId()).setName(person.getName());
        }
    }

    public void delete(Person person) {
        if (0 < person.getId() & person.getId() <= PEOPLE_COUNT) {
            people.remove(show(person.getId()));
        }
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(d -> d.getId() == id).findAny().orElse(null);
        // из списка ищем элемент у котороко id равен принимаемому id, находим его,
        // если нет возвращаем null
    }
    public static int getPeopleCount() {
        return PEOPLE_COUNT;
    }

    public static void setPeopleCount(int peopleCount) {
        PEOPLE_COUNT = peopleCount;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
