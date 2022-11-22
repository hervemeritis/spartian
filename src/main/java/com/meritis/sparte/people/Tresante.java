package com.meritis.sparte.people;

import com.meritis.sparte.equipement.Tunique;

public class Tresante implements Citoyen {
    private final String name;
    private final Tunique tunique = new Tunique();

    public Tresante(String name) {
        this.name = name;
    }

    @Override
    public boolean aFaitSonAgogee() {
        return false;
    }

    @Override
    public String name() {
        return "Tresante " + name;
    }
}
