package org.mvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class FirstContr {
    @GetMapping("/hello_p")
    public String helloP(HttpServletRequest request) { // если ничего не передаёт, то ложит null
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println(name + " " + surname);

        return "first/hello";
    }
    @GetMapping("/bye_p")
    public String byeP(@RequestParam(value = "name", required = false) String name, // другой способ, если ничего не передаём,
                       // то ошибка 400(без required)
                       @RequestParam(value = "surname", required = false) String surname,
                       Model model) {
//        System.out.println(name + " " + surname);
        model.addAttribute("mess", name + " " + surname);

        return "first/bye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "c", required = false) String c,
                             Model model) {
        Integer d = 0;
        if (a != null) {
            if (Objects.equals(c, "multiplication")) {
                d = a * b;
            }
            else if (Objects.equals(c, "division")) {
                d = a / b;
            }
            else if (Objects.equals(c, "addition")) {
                d = a + b;
            }
            else if (Objects.equals(c, "subtraction")) {
                d = a - b;
            }
        }
        model.addAttribute("d", d);
        return "first/calculator";
    }
}
