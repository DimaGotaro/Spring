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
//    @GetMapping("/new2") // то же самое
//    public String newG2(Model model) {
//        model.addAttribute("persModel", new Person());
//        return "people/new2";
//    }
    @GetMapping("/new2") // то же самое
    public String newG2(@ModelAttribute("persModel") Person person) {
        return "people/new2";
    }
    @PostMapping("/p") // два post запроса не должны указывать на один URL
    public String newP2(@ModelAttribute("persMatt") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }

    @ModelAttribute("modA") // добавляет ко всем моделям пару ключ(modA)-значение(Hello),
    // доступен во всех методах контроллера
    public String hey() {
        return "Hello";
    }
}
