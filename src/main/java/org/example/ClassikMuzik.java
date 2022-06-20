package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
@Scope("prototype")
public class ClassikMuzik implements Muzik{
    @Override
    public String[] getSong() {
        return new String[] {"Лунная соната", "4 сезона", "Свадебный марш"};
    }
}
