package com.meritis.sparte.people;

public class JeuneCitoyen implements Citoyen {
    public final String name;
    public final int age;

    public JeuneCitoyen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Homoioi agogee() {
        return new Homoioi(name);
    }

    public boolean isAgogee() {
        return this.age >= 20;
    }

    @Override
    public boolean aFaitSonAgogee() {
        return false;
    }

    @Override
    public String name() {
        return name;
    }
}
