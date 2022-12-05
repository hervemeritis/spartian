package com.meritis.sparte.people;

public sealed interface Citoyen extends Spartiate permits Homoioi, JeuneCitoyen, Tresante {
    boolean aFaitSonAgogee();

    String faitSonHurlement();
}
