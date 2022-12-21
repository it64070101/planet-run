
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Area {

    private static Sector getA;
    private static Sector B;
    private static Sector C;
    private static Sector D;
    private static int areaExplored;
    private static ArrayList<Sector> areaDeck;
    private static HashMap<String, Sector> sectorMap;
    

    public Area() {
        areaExplored = 0;
        areaDeck = new ArrayList<Sector>();
        areaDeck.add(new Sector("Forest", 3, Storage.getTriangle()));
        areaDeck.add(new Sector("Desert", 3, Storage.getCircle()));
        areaDeck.add(new Sector("Mountain", 3, Storage.getSquare()));
        areaDeck.add(new Sector("Altar", 3, Storage.getStar()));
        Collections.shuffle(areaDeck);
        getA = areaDeck.get(0);
        B = areaDeck.get(1);
        C = areaDeck.get(2);
        D = areaDeck.get(3);
        sectorMap = new HashMap<String, Sector>();
        sectorMap.put(getA.getName(), getA);
        sectorMap.put(B.getName(), B);
        sectorMap.put(C.getName(), C);
        sectorMap.put(D.getName(), D);

    }

    public static Sector getA() {
        return getA;
    }

    public static void setA(Sector A) {
        Area.getA = A;
    }

    public static Sector getB() {
        return B;
    }

    public static void setB(Sector B) {
        Area.B = B;
    }

    public static Sector getC() {
        return C;
    }

    public static void setC(Sector C) {
        Area.C = C;
    }

    public static Sector getD() {
        return D;
    }

    public static void setD(Sector D) {
        Area.D = D;
    }

    public static int getAreaExplored() {
        return areaExplored;
    }

    public static void setAreaExplored(int areaExplored) {
        Area.areaExplored = areaExplored;
    }

    public static ArrayList<Sector> getAreaDeck() {
        return areaDeck;
    }

    public static void setAreaDeck(ArrayList<Sector> areaDeck) {
        Area.areaDeck = areaDeck;
    }

    public static HashMap<String, Sector> getSectorMap() {
        return sectorMap;
    }

    public static void setSectorMap(HashMap<String, Sector> sectorMap) {
        Area.sectorMap = sectorMap;
    }
    
    public static void countExplore(){
        setAreaExplored(getAreaExplored()+1);
    }
    
    
}
