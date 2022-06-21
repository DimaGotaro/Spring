package org.mvc1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sec") // дополнительная дирректория в ссылке
public class SecondContr {
    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}
