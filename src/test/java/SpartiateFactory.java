import com.meritis.sparte.people.Homoioi;
import com.meritis.sparte.people.JeuneCitoyen;

public class SpartiateFactory {
    public static Homoioi leonidas() {
        return new Homoioi("Leonidas");
    }

    public static JeuneCitoyen jeuneLeonidas() {
        return new JeuneCitoyen("Leonidas", 20);
    }
}
