package practice.algorithm.programmers.practice.level2.행렬의_곱셈;

import java.util.Arrays;

public class Solution {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        //두 행렬을 곱한 행렬은 [1번째 행렬의 행 X 2번째 행렬의 열] 의 형태를 갖게 됨.
        int row_length = arr1.length;
        int col_length = arr2[0].length;

        int[][] answer = new int[row_length][];

        for(int i =0; i<row_length; i++){
            answer[i] = new int[col_length];
            for(int j=0; j<col_length; j++){
                int sum = 0;

                for(int k=0; k<arr1[i].length; k++){
                   sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        int[][] rs = solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        int[][] rs1 = solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
        int[][] rs2 = solution(new int[][]{{1, 2, 3}, {4, 5, 6}}, new int[][]{{1, 4}, {2, 5}, {3, 6}});


        for(int[] rss : rs){
            System.out.println(Arrays.toString(rss));
        }
        System.out.println("=======================");
        for(int[] rss : rs1){
            System.out.println(Arrays.toString(rss));
        }
        System.out.println("=======================");
        for(int[] rss : rs2){
            System.out.println(Arrays.toString(rss));
        }

    }
}
