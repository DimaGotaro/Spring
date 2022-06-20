package org.example;

import org.springframework.stereotype.Component;

@Component
public class RockMuzik implements Muzik{
    @Override
    public String getSong() {
        return "Numb";
    }

    // фабричный метод
    private RockMuzik() {} // нельзя создать объект класса

    public static RockMuzik getInstance() { // получим объект с помощью метода
        return new RockMuzik(); // если singleton, то полчим ссылку на один и тот же объект
    }
    public void doMyInit() {
        System.out.println("Инициализация...");
    }
    public void doMyDesrtroy() {
        System.out.println("Уничтожение бина!");
    }
}