package com.meritis.sparte.quotidien;

import com.meritis.sparte.armee.Grade;
import com.meritis.sparte.people.Citoyen;
import com.meritis.sparte.people.Competence;
import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;
import com.meritis.sparte.people.Tresante;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class AgoggeeServiceTest {

    @Test
    void jeune_citoyen_ne_fait_pas_son_agogee_et_reste_jeune_citoyen() {
        //Given
        String leonidas = "Leonidas";
        JeuneCitoyenDeleter deleter = jc -> {};
        JeuneCitoyenRetriever retriever = name -> new JeuneCitoyen(name, 10);
        CitoyenCreator citoyenCreator = c ->  {};
        SpartiateArmyManager spartiateArmyManager = c -> Grade.HOPPLYTE;

        AgoggeeService agoggeeService = new AgoggeeService(deleter,retriever, citoyenCreator, spartiateArmyManager);

        //When
        Citoyen spartiate = agoggeeService.agogee(leonidas);

        //Then
        Assertions.assertThat(spartiate).isInstanceOf(JeuneCitoyen.class);
    }

    @Test
    public void jeune_citoyen_fait_son_agogee_et_devient_un_homoioi() {
        //Given
        JeuneCitoyenRetriever retriever = AgoggeeServiceTest::createJeuneCitoyenQuiPeutPasserAggogee;
        JeuneCitoyenDeleter deleter = jeuneCitoyen -> {};
        CitoyenCreator citoyenCreator = citoyen -> {};
        SpartiateArmyManager spartiateArmyManager = citoyen -> Grade.HOPPLYTE;

        AgoggeeService agoggeeService = new AgoggeeService(deleter,retriever, citoyenCreator, spartiateArmyManager);

        //When
        Citoyen spartiate = agoggeeService.agogee("LEONIDAS");

        //Then
        Assertions.assertThat(spartiate).isInstanceOf(Homoioi.class);
    }

    @Test
    public void jeune_citoyen_fait_son_agogee_et_devient_un_tresante() {
        //Given
        JeuneCitoyenRetriever retriever = name -> new JeuneCitoyen(name, 20);
        JeuneCitoyenDeleter deleter = jeuneCitoyen -> {};
        CitoyenCreator citoyenCreator = citoyen -> {};
        SpartiateArmyManager spartiateArmyManager = citoyen -> {throw new RuntimeException("Ce n'est pas normal d'enroler dans l'armée un tresante");};

        AgoggeeService agoggeeService = new AgoggeeService(deleter,retriever, citoyenCreator, spartiateArmyManager);

        //When
        Citoyen spartiate = agoggeeService.agogee("LEONIDAS");

        //Then
        Assertions.assertThat(spartiate).isInstanceOf(Tresante.class);
        Assertions.assertThat(spartiate.aFaitSonAgogee()).isFalse();
    }

    private static JeuneCitoyen createJeuneCitoyenQuiPeutPasserAggogee(String name) {
        JeuneCitoyen jeuneCitoyen = new JeuneCitoyen(name, 20);
        jeuneCitoyen.competences.addAll(Set.of(Competence.CHANTER, Competence.ATTAQUER_LANCE, Competence.DEFENDRE_BOUCLIER));
        return jeuneCitoyen;
    }


}