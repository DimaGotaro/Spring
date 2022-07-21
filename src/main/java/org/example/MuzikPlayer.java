package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component
public class MuzikPlayer {
//    @Autowired // через поле
    private Muzik muzik;
    private Muzik muzik2;
    @Value("${muzikPlayer2.name}")
    private String name;
    @Value("${muzikPlayer2.volume}")
    private int volume;
    @Autowired
    @Order // упорядочить
    private List<Muzik> muz = new ArrayList<>();
//    @Autowired
    private RockMuzik rockMuzik;
//    @Autowired
    private ClassikMuzik classikMuzik;

    private List<Muzik> muzikList;

    public MuzikPlayer(List<Muzik> muzikList) {
        this.muzikList = muzikList;
    }

    public void playT() {
        Random random = new Random();
        int i = random.nextInt(muzikList.size());
        int o = random.nextInt(muzikList.get(i).getSong().length);
        System.out.println(muzikList.get(i).getSong()[o]);
    }
//    @Autowired
//    public MuzikPlayer(RockMuzik rockMuzik, ClassikMuzik classikMuzik) {
//        this.rockMuzik = rockMuzik;
//        this.classikMuzik = classikMuzik;
//    }
//    @Autowired
    public MuzikPlayer(@Qualifier("classikMuzik") Muzik muzik) {
        this.muzik = muzik;
    }

//    @Autowired // видит все классы применяющие интерфейс Muzik, должен быть только один
    public MuzikPlayer(@Qualifier("classikMuzik") Muzik muzik,
                       @Qualifier("rockMuzik") Muzik muzik2) {
        this.muzik = muzik;
        this.muzik2 = muzik2;
    }

    public void playMuzMass() {
        for (String r:
                muzik.getSong()) {
            System.out.println(r);
        }
        for (String r:
                muzik2.getSong()) {
            System.out.println(r);
        }
    }

    public void playType(muzikType b) {
        Random random = new Random();
        int i = random.nextInt(3);
        if (b == muzikType.CLASSIC) {
            System.out.println(muzik.getSong()[i]);
        }
        else if (b == muzikType.ROCK) {
            System.out.println(muzik2.getSong()[i]);
        }
    }
    public String playMuzR() {
        String a1 = "Проиграть: " + rockMuzik.getSong();
        String a2 = "Проиграть: " + classikMuzik.getSong();
        return a1 + "\n" + a2;
//        System.out.println("Проиграть: " + classikMuzik.getSong());
    }

    public void playMuz() {
        System.out.println("Проиграть: " + muzik.getSong());
        System.out.println("Проиграть: " + muzik2.getSong());
    }

    public Muzik getMuzik() {
        return muzik;
    }

    public void playMuzList() {
        for (Muzik v:
             muz) {
            System.out.println(v.getSong());
        }
    }

    public void setMuz(List<Muzik> muz) {
        this.muz = muz;
    }

    public List<Muzik> getMuz() {
        return muz;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


//    @Autowired // через сеттер
    public void setMuzik(Muzik muzik) {
        this.muzik = muzik;
    }
}