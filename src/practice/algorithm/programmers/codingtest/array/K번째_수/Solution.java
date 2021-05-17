package practice.algorithm.programmers.codingtest.array.K번째_수;

import java.util.Arrays;

public class Solution {

    /**
     * Arrays.copyOfRange 함수 사용하지 않고 구현.
     *
     * 수행 시간 : 1022221ns(나노타임/세크)
     * 수행 시간 : 599184ns(나노타임/세크)
     * 수행 시간 : 961552ns(나노타임/세크)
     * 수행 시간 : 874044ns(나노타임/세크)
     * 수행 시간 : 1182645ns(나노타임/세크)
     */
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] c = new int[commands[i][1] - commands[i][0] + 1];

            int j = 0;

            for(int k=0; k<array.length; k++){
                if(k >= commands[i][0]-1 && k < commands[i][1]){
                    c[j++] = array[k];
                }
            }

            Arrays.sort(c);
            answer[i] = c[commands[i][2]-1];
        }
        return answer;
    }


    /**
     * Arrays.copyOfRange 함수 사용
     *
     * 수행 시간 : 222988ns(나노타임/세크)
     * 수행 시간 : 343527ns(나노타임/세크)
     * 수행 시간 : 269829ns(나노타임/세크)
     * 수행 시간 : 251365ns(나노타임/세크)
     * 수행 시간 : 290685ns(나노타임/세크)
     */
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

        long startTime = System.nanoTime();
        int[] result = s.solution2(array, commands);
        long endTime = System.nanoTime();

        for(int i=0; i<result.length; i++) {
            if(answer[i] == result[i]) {
                System.out.println((i+1) + ". 정답!");
            }else {
                System.out.println((i+1) + ". 오답!");
            }
        }
        long resultTime = (endTime - startTime);
        System.out.println("수행 시간 : " + resultTime +"ns(나노타임/세크)");
    }

}