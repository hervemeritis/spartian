import com.meritis.sparte.equipement.Armure;
import com.meritis.sparte.people.Citoyen;
import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Les4InterfacesFonctionelles {

    @Test
    public void creation_predicate_pour_savoir_s_il_peut_faire_son_agogee() {
        //Given
        JeuneCitoyen leonidas = SpartiateFactory.jeuneLeonidas();
        // Un jeune spartiate doit avoir au moins 20 ans pour faire son agogee
        Predicate<JeuneCitoyen> testPourAgogee = JeuneCitoyen::isAgogee;

        //When
        boolean resultatTestAgogee = testPourAgogee.test(leonidas);

        //Then
        Assertions.assertThat(resultatTestAgogee).isTrue();
    }

    @Test
    public void verification_citoyen_a_fait_son_agogee() {
        //Given
        Citoyen citoyenJeune = SpartiateFactory.jeuneLeonidas();
        Citoyen citoyenHomioi = SpartiateFactory.leonidas();
        Predicate<Citoyen> evaluationAgogee = Citoyen::aFaitSonAgogee;

        //When
        boolean jeunePasFaitSonAgogee = evaluationAgogee.test(citoyenJeune);
        boolean homioiFaitSonAgogee = evaluationAgogee.test(citoyenHomioi);

        //Then
        Assertions.assertThat(jeunePasFaitSonAgogee).isFalse();
        Assertions.assertThat(homioiFaitSonAgogee).isTrue();

    }

    @Test
    public void creation_function_pour_faire_passer_l_agogee_a_un_jeune() {
        //Given
        JeuneCitoyen leonidas = SpartiateFactory.jeuneLeonidas();
        Function<JeuneCitoyen, Homoioi> agogee = JeuneCitoyen::agogee;

        //When
        Homoioi homoioi = agogee.apply(leonidas);

        //Then
        Assertions.assertThat(homoioi.name()).isEqualTo("Homioi Leonidas");
    }

    @Test
    public void creation_consumer_pour_equiper_leonidas_d_un_bouclier() {
        //Given
        Homoioi leonidas = SpartiateFactory.leonidas();
        Consumer<Homoioi> armurerie = Homoioi::equipeFromHomoi;

        //When
        armurerie.accept(leonidas);

        //Then
        Assertions.assertThat(leonidas.estEquipe()).isTrue();
    }

    @Test
    public void leonidas_fait_son_hurlement() {
        //Given
        Homoioi leonidas = SpartiateFactory.leonidas();
        // Leonidas doit hurler son nom en majuscule suivi du AHOU !
        Supplier<String> cri = leonidas::faitSonHurlement;

        //When
        String criLeonidas = cri.get();

        //Then
        Assertions.assertThat(criLeonidas).isEqualTo("HOMIOI LEONIDAS AHOU !");
    }


}
