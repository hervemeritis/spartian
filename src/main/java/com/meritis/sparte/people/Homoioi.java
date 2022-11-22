package com.meritis.sparte.people;

import com.meritis.sparte.equipement.Armure;
import com.meritis.sparte.equipement.Bouclier;
import com.meritis.sparte.equipement.Lance;

import java.util.Objects;

public class Homoioi implements Citoyen {
    private final String name;
    private Armure armure;
    private Bouclier bouclier;
    private Lance lance;

    public Homoioi(String name) {
        this.name = name;
    }

    @Override
    public boolean aFaitSonAgogee() {
        return true;
    }

    @Override
    public String name() {
        return "Homioi " + name;
    }

    public void equipeArmure(Armure armure) {
        this.armure = armure;
    }

    public void equipeFromHomoi() {
        this.armure = new Armure();
    }

    public void equipeBouclier(Bouclier bouclier) {
        this.bouclier = bouclier;
    }

    public void equipeLance(Lance lance) {
        this.lance = lance;
    }

    public boolean estCompletementEquipe() {
        return Objects.nonNull(armure) && Objects.nonNull(bouclier) && Objects.nonNull(lance);
    }

    public boolean estEquipe() {
        return Objects.nonNull(armure) || Objects.nonNull(bouclier) || Objects.nonNull(lance);
    }

    public String faitSonHurlement() {
        return name().toUpperCase() + " AHOU !";
    }
}
