package com.meritis.sparte.people;

import com.meritis.sparte.equipement.Tunique;

public final class Tresante implements Citoyen {
    private final String name;
    private final long age;
    private final Tunique tunique = new Tunique();

    public Tresante(String name, long age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean aFaitSonAgogee() {
        return false;
    }

    @Override
    public String faitSonHurlement() {
        return "je me fait tout petit pleutre que je suis " + name;
    }

    @Override
    public String name() {
        return "Tresante " + name;
    }
}
