
import java.util.ArrayList;
import java.util.Collections;


public class Area {

    public static Sector A;
    public static Sector B;
    public static Sector C;
    public static Sector D;
    public static int areaExplored;

    public Area() {
        areaExplored = 0;
//        Sector areaDeck[] = {new Sector("Sector A", 3, Storage.triangle), new Sector("Sector B", 3, Storage.circle), new Sector("Sector C", 3, Storage.square), new Sector("Sector D", 3, Storage.star)};
        ArrayList<Sector>areaDeck = new ArrayList<Sector>();
        areaDeck.add(new Sector("Forest", 3, Storage.triangle));
        areaDeck.add(new Sector("Desert", 3, Storage.circle));
        areaDeck.add(new Sector("Mountain", 3, Storage.square));
        areaDeck.add(new Sector("Altar", 3, Storage.star));
        Collections.shuffle(areaDeck);
        A = areaDeck.get(0);
        B = areaDeck.get(1);
        C = areaDeck.get(2);
        D = areaDeck.get(3);
    }
}
