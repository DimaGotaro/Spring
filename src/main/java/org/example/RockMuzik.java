package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class RockMuzik implements Muzik{
    @Override
    public String[] getSong() {
        return new String[] {"Numb", "Highway to hell", "Кукушка"};
    }

    // фабричный метод
//    private RockMuzik() {} // нельзя создать объект класса

    public static RockMuzik getInstance() { // получим объект с помощью метода
        return new RockMuzik(); // если singleton, то полчим ссылку на один и тот же объект
    }
    @PostConstruct
    public void doMyInit() {
        System.out.println("Инициализация...");
    }
    @PreDestroy
    public void doMyDesrtroy() {
        System.out.println("Уничтожение бина!");
    }
}