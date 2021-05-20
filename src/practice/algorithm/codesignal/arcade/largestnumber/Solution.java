package practice.algorithm.codesignal.arcade.largestnumber;

public class Solution {

    /**
     * Best Case
     * cf) 제곱함수 Math.pow 사용 (입출력이 모두 실수인 double형)
     * - Math.pow(밑, 지수)
     * - ex) Math.pow(2,4) -> 결과 16
     */
    public static int largestNumber2(int n) {
        return (int)Math.pow(10,n) - 1;
    }

    /**
     * Given an integer n, return the largest number that contains exactly n digits.
     * 정수 n이 주어지면 정확히 n 자리를 포함하는 가장 큰 숫자를 반환.
     * ex) n = 2 이면, largestNumber(n) = 99.
     */
    public static int largestNumber(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("9");
        }
        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) {

        int[] commands = {
                2,
                3,
                4,
                5
        };
        int[] answer = {99,999,9999,99999};

        long startTime = System.nanoTime();

        for(int i =0; i< commands.length; i++){
            if(answer[i] == largestNumber2(commands[i])){
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
