package practice.algorithm.codesignal.arcade.axtra_number;


public class Solution {

    /**
     * Best Case
     * cf) 자바 비트 논리연산자를 이용
     *  동일한 수는 비트 XOR 연산을 하면 0 이 되기때문에
     *  같은 두 수와 다른 수 를 XOR 연산을 했을 때, 다른 나머지 수를 구할 수 있다.
     */
    static int extraNumber(int a, int b, int c) {
        return a^b^c;
    }

    static int extraNumber2(int a, int b, int c) {
        return (a == b) ? c : (b == c) ? a : b;
    }



    public static void main(String[] args) {
        if(7 == extraNumber(2,2,7) && 3 == extraNumber(10,3,10)){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}