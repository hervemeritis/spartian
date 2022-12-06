package com.meritis.sparte.people;

import java.util.HashSet;
import java.util.Set;

public final class JeuneCitoyen implements Citoyen {
    public final String name;
    public final int age;

    public final Set<Competence> competences = new HashSet<>();

    public JeuneCitoyen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Citoyen agogee() {
        return competences.size() >= 3 ? new Homoioi(name, age) : new Tresante(name, age);
    }

    public boolean isAgogee() {
        return this.age >= 20;
    }

    @Override
    public boolean aFaitSonAgogee() {
        return false;
    }

    @Override
    public String faitSonHurlement() {
        return "Moi " + name() + " J'apprend a être un Guerrier de Sparte AHOU ! ";
    }

    @Override
    public String name() {
        return name;
    }
}
