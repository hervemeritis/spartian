import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;

public class SpartiateFactory {
    private static final String LEONIDAS = "Leonidas";

    public static Homoioi leonidas() {
        return new Homoioi(LEONIDAS);
    }

    public static JeuneCitoyen jeuneLeonidas() {
        return new JeuneCitoyen(LEONIDAS, 20);
    }

    public static  JeuneCitoyen jeuneLeonidasAgeDe(int age) {
        return new JeuneCitoyen(LEONIDAS, age);
    }
}
