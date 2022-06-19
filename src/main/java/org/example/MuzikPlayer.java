package org.example;

import java.util.ArrayList;
import java.util.List;

public class MuzikPlayer {
    private Muzik muzik;
    private String name;
    private int volume;
    private List<Muzik> muz = new ArrayList<>();

    public MuzikPlayer(Muzik muzik) {
        this.muzik = muzik;
    }

    public MuzikPlayer() {}

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


    public void setMuzik(Muzik muzik) {
        this.muzik = muzik;
    }
}
