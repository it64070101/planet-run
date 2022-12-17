public class Ship {
    public static BodyPart noseCone;
    public static BodyPart shockcord;
    public static BodyPart recoveryWadding;
    public static FinPart leftFin;
    public static FinPart rightFin;
    public static int partFixed;

    public Ship() {
        partFixed = 0;
        noseCone = new BodyPart("Nose Cone");
        shockcord = new BodyPart("Shockcord");
        recoveryWadding = new BodyPart("Recovery Wadding");
        leftFin = new FinPart("Left Fin");
        rightFin = new FinPart("Right Fin");
    }
    
}
