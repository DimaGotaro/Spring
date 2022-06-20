package org.example;

import org.springframework.stereotype.Component;

@Component
public class ClassikMuzik implements Muzik{
    @Override
    public String getSong() {
        return "Лунная соната";
    }
}
