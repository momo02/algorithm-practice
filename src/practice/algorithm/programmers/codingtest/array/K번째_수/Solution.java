package practice.algorithm.programmers.codingtest.array.K번째_수;

import java.util.Arrays;

public class Solution {

    /**
     * 20210605 해당 문제 다시 풀게되어 정리
     */
    public static int[] solution4(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i =0; i<commands.length; i++){

            int[] a = commands[i];

            int length = a[1] - a[0] + 1 ;
            int[] t = new int[length];

            System.arraycopy(array, a[0]-1, t,0,length);

            Arrays.sort(t);
            //System.out.println(Arrays.toString(t));

            answer[i] = t[a[2]-1];
        }
        return answer;
    }

    /**
     * Arrays.copyOfRange,Arrays.sort 함수 사용하지 않고 구현.
     *
     * 수행 시간 : 8549ns(나노타임/세크)
     * 수행 시간 : 10639ns(나노타임/세크)
     * 수행 시간 : 8610ns(나노타임/세크)
     * 수행 시간 : 10370ns(나노타임/세크)
     * 수행 시간 : 7630ns(나노타임/세크)
     */
    public int[] solution3(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] c = new int[commands[i][1] - commands[i][0] + 1];

            int j = 0;

            for(int k=0; k<array.length; k++){
                if(k >= commands[i][0]-1 && k < commands[i][1]){
                    c[j++] = array[k];
                }
            }
            //Arrays.sort(c);
            //System.out.println(Arrays.toString(c));
            sort(c);

            answer[i] = c[commands[i][2]-1];
        }
        return answer;
    }

    /** sort 함수 직접 구현 **/
    public void sort(int[] array) {
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

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
        int[] result = s.solution4(array, commands);
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