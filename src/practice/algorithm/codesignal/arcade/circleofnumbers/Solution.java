package practice.algorithm.codesignal.arcade.circleofnumbers;


public class Solution {

    /**
     * Best Case
     */
    public static int circleOfNumbers2(int n, int firstNumber) {
        return (firstNumber + n/2) % n;
    }

    public static int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber < n/2 ? firstNumber + n/2  : firstNumber - n/2);
    }

    public static void main(String[] args) {
        if(2 == circleOfNumbers2(10,7) && 7 == circleOfNumbers2(10,2)){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}