public class Dice {
    private static int face;

    public Dice(int face) {
        this.face = face;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }
    
    public static int roll(int amount){
        int sum = 0;
        for(int i=0;i<amount;i++){
            sum += ((Math.random()*10)%face)+1;
        }
        return sum;
    }
    
    public static boolean rollAgainst(int amount, int target){
        int roll = roll(amount);
        System.out.println(roll+", "+target);
        return roll >= target;
    }
}
