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

        people.add(new Person(++PEOPLE_COUNT, "Tom", 23, "asd@tut.by"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 56, "sldk@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Maik", 27, "oekf@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Greta", 35, "owdm@tut.by"));
        people.add(new Person(++PEOPLE_COUNT, "Rox", 61, "ndjlk@tut.by"));
    }

    public int p_count() {
        return ++PEOPLE_COUNT;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void edit(int id,Person person) {
//        if (0 < person.getId() & person.getId() <= PEOPLE_COUNT & person.getName() != null) {
//            Objects.requireNonNull(people.stream().filter(d -> d.getId() == person.getId()).
//                    findAny().orElse(null)).setName(person.getName());
            show(id).setName(person.getName());
            show(id).setAge(person.getAge());
            show(id).setEmail(person.getEmail());
//        }
    }

    public void delete(int id) {
            people.remove(show(id));
//            people.removeIf(p -> p.getId() == id); // можно так
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
