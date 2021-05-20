package practice.algorithm.codesignal.arcade.addTwoDigits;

import java.util.Arrays;

public class Solution {

    /**
     * Best Case
     */
    public static int addTwoDigits2(int n) {
        return n/10 + n%10;
    }

    /**
     * You are given a two-digit integer n. Return the sum of its digits.
     * 두 자리 정수 n이 제공됩니다. 각 숫자의 합을 반환합니다.
     *
     * cf) char를 int로 변환
     * 방법 1 : char - '0'을 이용하면 아스키코드값을 알 필요없이 int형으로 변환 가능.
     * 방법 2 : Character.getNumericValue(s.charAt(i)) 방법을 이용해도 형변환이 가능.
     */
    public static int addTwoDigits(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        for(int i=0; i <s.length(); i++){
            sum +=   s.charAt(i) - '0';
            //sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] commands = {
                29,
                48,
                13,
                98
        };
        int[] answer = {11,12,4,17};

        long startTime = System.nanoTime();

        for(int i =0; i< commands.length; i++){
            if(answer[i] == addTwoDigits2(commands[i])){
                System.out.println((i+1) + ". 정답!");
            }else{
                System.out.println((i+1) + ". 오답!");
            }
        }
        long endTime = System.nanoTime();

        long resultTime = (endTime - startTime);
        System.out.println("수행 시간 : " + resultTime +"ns(나노타임/세크)");
    }
}
