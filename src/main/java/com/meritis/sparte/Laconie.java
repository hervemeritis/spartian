package com.meritis.sparte;

import com.meritis.sparte.people.Spartiate;

public class Laconie {
    public static void main(String[] args) {
        Spartiate leonidas = () -> "Leonidas";
        Spartiate kratos = () -> "Kratos";
        System.out.println(leonidas.name());
        System.out.println(kratos.name());
    }
}
