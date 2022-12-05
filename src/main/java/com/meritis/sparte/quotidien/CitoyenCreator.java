package com.meritis.sparte.quotidien;

import com.meritis.sparte.people.Citoyen;

@FunctionalInterface
public interface CitoyenCreator {
    void create(Citoyen citoyen);
}
