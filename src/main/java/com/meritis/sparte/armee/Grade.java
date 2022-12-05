package com.meritis.sparte.armee;

import com.meritis.sparte.equipement.Armure;
import com.meritis.sparte.equipement.Bouclier;
import com.meritis.sparte.equipement.Lance;
import com.meritis.sparte.people.Citoyen;
import com.meritis.sparte.people.Homoioi;

import java.util.function.Consumer;

public enum Grade {
    ROI,
    STRATEGE,
    POLEMARQUES,
    PENTECOSTERE,
    ENOMOTARQUE,
    HOPPLYTE,
    ;

    public void equipe(Citoyen citoyen) {
        if (citoyen instanceof Homoioi homioi) {
            ((Consumer<Homoioi>) h -> h.equipeLance(new Lance())).andThen(h -> h.equipeArmure(new Armure()))
                                                                 .andThen(h -> h.equipeBouclier(new Bouclier()))
                                                                 .accept(homioi);
        }
    }
}
