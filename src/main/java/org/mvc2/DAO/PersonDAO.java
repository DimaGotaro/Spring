package org.mvc2.DAO;

import org.mvc2.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(d -> d.getId() == id).findAny().orElse(null);
        // из списка ищем элемент у котороко id равен принимаемому id, находим его,
        // если нет возвращаем null
    }
}
