package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MuzikPlayer muzikPlayer;

    @Autowired
    public Computer(MuzikPlayer muzikPlayer) {
        this.id =1;
        this.muzikPlayer = muzikPlayer;
    }

    @Override
    public String toString() {
        return "Компьютер" + id + "\n" + muzikPlayer.playMuzR();
    }
}
