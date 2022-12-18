public class Ship {
    private static BodyPart noseCone;
    private static BodyPart shockcord;
    private static BodyPart recoveryWadding;
    private static FinPart leftFin;
    private static FinPart rightFin;
    private static int partFixed;

    public Ship() {
        partFixed = 0;
        noseCone = new BodyPart("Nose Cone");
        shockcord = new BodyPart("Shockcord");
        recoveryWadding = new BodyPart("Recovery Wadding");
        leftFin = new FinPart("Left Fin");
        rightFin = new FinPart("Right Fin");
    }

    public static BodyPart getNoseCone() {
        return noseCone;
    }

    public static void setNoseCone(BodyPart noseCone) {
        Ship.noseCone = noseCone;
    }

    public static BodyPart getShockcord() {
        return shockcord;
    }

    public static void setShockcord(BodyPart shockcord) {
        Ship.shockcord = shockcord;
    }

    public static BodyPart getRecoveryWadding() {
        return recoveryWadding;
    }

    public static void setRecoveryWadding(BodyPart recoveryWadding) {
        Ship.recoveryWadding = recoveryWadding;
    }

    public static FinPart getLeftFin() {
        return leftFin;
    }

    public static void setLeftFin(FinPart leftFin) {
        Ship.leftFin = leftFin;
    }

    public static FinPart getRightFin() {
        return rightFin;
    }

    public static void setRightFin(FinPart rightFin) {
        Ship.rightFin = rightFin;
    }

    public static int getPartFixed() {
        return partFixed;
    }

    public static void setPartFixed(int partFixed) {
        Ship.partFixed = partFixed;
    }
    
    public static void countFixed(){
        setPartFixed(getPartFixed()+1);
    }
    
    
    
}
