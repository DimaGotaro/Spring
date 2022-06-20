package org.example;

import org.springframework.stereotype.Component;

@Component
public class ClassikMuzik implements Muzik{
    @Override
    public String[] getSong() {
        return new String[] {"Лунная соната", "4 сезона", "Свадебный марш"};
    }
}
