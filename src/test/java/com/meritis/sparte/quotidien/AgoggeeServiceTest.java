package com.meritis.sparte.quotidien;

import com.meritis.sparte.SpartiateFactory;
import com.meritis.sparte.people.Citoyen;
import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgoggeeServiceTest {

    @Test
    void jeune_citoyen_ne_fait_pas_son_agogee_et_reste_jeune_citoyen() {
        //Given

        //When
        Citoyen spartiate = null;

        //Then
        Assertions.assertThat(spartiate).isInstanceOf(JeuneCitoyen.class);
    }

    @Test
    public void jeune_citoyen_fait_son_agogee_et_devient_un_homoioi() {
        //Given
        AgoggeeService agoggeeService = null;

        //When
        Citoyen spartiate = agoggeeService.agogee("LEONIDAS");

        //Then
        Assertions.assertThat(spartiate).isInstanceOf(Homoioi.class);
    }


}