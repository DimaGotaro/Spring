package org.mvc2.controllers;

import org.mvc2.DAO.PersonDAO;
import org.mvc2.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people") // ссылки на методы в классе будут начинаться с /people/
public class PeopleContoller {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleContoller(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping() // если пусто, то адрес - /people
    public String index(Model model) { // метод для возвращения всех пользователей(списка)
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}") // с помощью @PathVariable получим id из адресной строки
    public String show(@PathVariable("id") int id, Model model) {
        // метод для возврата инф о конкретном пользователе
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newG() {
        return "people/new";
    }

    @PostMapping() // POST должен быть определён отдельно, нельзя вызвать без отправки данных в POST
    public String newP(@RequestParam("pers") String pers) {
        personDAO.getPeople().add(new Person(personDAO.p_count(), pers));
        return "people/success";
    }
}
