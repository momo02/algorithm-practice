package practice.algorithm.codesignal.arcade.rateride;

public class Solution {

    public static int lateRide(int n) {
        int h = (n/60);
        int m = (n%60);
        return (h/10 + h%10 + m/10 + m%10);
    }

    public static void main(String[] args) {
        if(4 == lateRide(240) && 14 == lateRide(808)){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}