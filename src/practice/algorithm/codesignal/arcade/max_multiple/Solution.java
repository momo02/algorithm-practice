package practice.algorithm.codesignal.arcade.max_multiple;

/**
 * Given a divisor and a bound, find the largest integer N such that:
 *
 * N is divisible by divisor.
 * N is less than or equal to bound.
 * N is greater than 0.
 * It is guaranteed that such a number exists.
 *
 * ex) For divisor = 3 and bound = 10, the output should be
 * maxMultiple(divisor, bound) = 9.
 *
 * The largest integer divisible by 3 and not larger than 10 is 9.
 */
public class Solution {

    /**
     * Best Case
     */
    public static int maxMultiple2(int divisor, int bound) {
        return (bound / divisor) * divisor;
    }

    public static int maxMultiple(int divisor, int bound) {
            int rs = 0;
            for(int i=bound; i > 0; i--){
                if(i%divisor == 0){
                    rs = i;
                    break;
                }
            }
            return rs;
    }

    public static void main(String[] args) {
        int[][] input = {
                {3, 10},
                {2,5},
                {5,26}
        };
        int[] answer = {9, 4, 25};

        for(int i=0; i<input.length; i++){
            if( answer[i] == maxMultiple(input[i][0],input[i][1])) {
                System.out.println(i + ". 정답!");
            }else{
                System.out.println(i + ". 오답!");
            }
        }

    }
}
