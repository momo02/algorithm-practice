package practice.algorithm.programmers.codingtest.array.K번째_수;

import java.util.Arrays;

public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] a = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(a);
            answer[i] = a[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        int[] answer = {5, 6, 3};

        int[] result = s.solution(array, commands);
        for(int i=0; i<result.length; i++) {
            if(answer[i] == result[i]) {
                System.out.println((i+1) + ". 정답!");
            }else {
                System.out.println((i+1) + ". 오답!");
            }
        }
    }
}