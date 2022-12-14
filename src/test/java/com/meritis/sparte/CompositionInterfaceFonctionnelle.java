package com.meritis.sparte;

import com.meritis.sparte.equipement.Armure;
import com.meritis.sparte.equipement.Bouclier;
import com.meritis.sparte.equipement.Lance;
import com.meritis.sparte.people.Citoyen;
import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CompositionInterfaceFonctionnelle {

    @Test
    public void equipons_completement_leonidas() {
        //Given
        Homoioi leonidas = SpartiateFactory.leonidas();
        Consumer<Homoioi> equiperBouclier = spartiate -> spartiate.equipeBouclier(new Bouclier());
        //Leonidas est complétement équipé s'il a une lance, un bouclier, une armure
        Consumer<Homoioi> armurerie = equiperBouclier.andThen(spartiate -> spartiate.equipeLance(new Lance()))
                                                     .andThen(spartiate -> spartiate.equipeArmure(new Armure()));

        //When
        armurerie.accept(leonidas);

        //Then
        Assertions.assertThat(leonidas.estCompletementEquipe())
                  .isTrue();
    }

    @Test
    public void verifions_que_leonidas_fait_sa_formation_militaire() {
        //Given
        JeuneCitoyen homioiLeonidas = SpartiateFactory.jeuneLeonidasAgeDe(20);
        JeuneCitoyen jeuneLeonidas = SpartiateFactory.jeuneLeonidasAgeDe(15);
        JeuneCitoyen enfantLeonidas = SpartiateFactory.jeuneLeonidasAgeDe(6);
        // Un jeune militaire est en formation militaire entre 7 ans et 20 ans
        Predicate<JeuneCitoyen> elligibiliteFormationMilitaire = Predicate.not(JeuneCitoyen::isAgogee)
                                                                          .and(c -> c.age > 7);

        //When
        boolean enFormationMilitaireHomioi = elligibiliteFormationMilitaire.test(homioiLeonidas);
        boolean enFormationMilitaireJeune = elligibiliteFormationMilitaire.test(jeuneLeonidas);
        boolean enFormationMilitaireEnfant = elligibiliteFormationMilitaire.test(enfantLeonidas);

        //Then
        Assertions.assertThat(enFormationMilitaireHomioi)
                  .isFalse();
        Assertions.assertThat(enFormationMilitaireJeune)
                  .isTrue();
        Assertions.assertThat(enFormationMilitaireEnfant)
                  .isFalse();
    }

    @Test
    public void faire_passer_l_agogee_a_leonidas_puis_le_faire_crier_son_nom() {
        //Given
        JeuneCitoyen jeuneCitoyen = SpartiateFactory.jeuneLeonidas();
        Function<JeuneCitoyen, Citoyen> agogee = JeuneCitoyen::agogee;
        Function<JeuneCitoyen, String> criLeonidas = agogee.andThen(Citoyen::faitSonHurlement);

        //When
        String cri = criLeonidas.apply(jeuneCitoyen);

        //Then
        Assertions.assertThat(cri)
                  .isEqualTo("HOMIOI LEONIDAS AHOU !");
    }

    @Test
    public void et_si_on_partait_de_la_fonction_cri_en_premier() {
        //Given
        JeuneCitoyen jeuneCitoyen = SpartiateFactory.jeuneLeonidas();
        Function<Citoyen, String> crier = Citoyen::faitSonHurlement;
        Function<JeuneCitoyen, String> criLeonidas = crier.compose(JeuneCitoyen::agogee);

        //When
        String cri = criLeonidas.apply(jeuneCitoyen);

        //Then
        Assertions.assertThat(cri)
                  .isEqualTo("HOMIOI LEONIDAS AHOU !");
    }

    @Test
    public void fonction_patielle() {
        //Given
        JeuneCitoyen jeuneCitoyen = SpartiateFactory.jeuneLeonidas();
        BiFunction<JeuneCitoyen, String, String> prefixLeNom = (jc, prefix) -> prefix + jc.name();
        Function<JeuneCitoyen, String> faireDireBonjourAvecSonNomAUnSpartiate = jc -> prefixLeNom.apply(jc, "Bonjour ");

        //When
        String bonjour = faireDireBonjourAvecSonNomAUnSpartiate.apply(jeuneCitoyen);

        //Then
        Assertions.assertThat(bonjour)
                  .isEqualTo("Bonjour Leonidas");
    }
}
