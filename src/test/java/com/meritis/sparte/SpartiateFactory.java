package com.meritis.sparte;

import com.meritis.sparte.people.Competence;
import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;

import java.util.Set;

public class SpartiateFactory {
    private static final String LEONIDAS = "Leonidas";

    public static Homoioi leonidas() {
        return new Homoioi(LEONIDAS);
    }

    public static JeuneCitoyen jeuneLeonidas() {
        return jeuneCitoyenAgeDeEtNom(20, LEONIDAS);
    }

    public static  JeuneCitoyen jeuneLeonidasAgeDe(int age) {
        return jeuneCitoyenAgeDeEtNom(age, LEONIDAS);
    }

    public static  JeuneCitoyen jeuneCitoyenAgeDeEtNom(int age, String name) {
        JeuneCitoyen jeuneCitoyen = new JeuneCitoyen(name, age);
        jeuneCitoyen.competences.addAll(Set.of(Competence.values()));
        return jeuneCitoyen;
    }

    public static  JeuneCitoyen jeuneCitoyenAgeDeEtNomPeuStudieux(int age, String name) {
        return new JeuneCitoyen(name, age);
    }
}
