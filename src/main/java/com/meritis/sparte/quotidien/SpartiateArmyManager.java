package com.meritis.sparte.quotidien;

import com.meritis.sparte.armee.Grade;
import com.meritis.sparte.people.Citoyen;

@FunctionalInterface
public interface SpartiateArmyManager {
    Grade enrole(Citoyen citoyen);
}
