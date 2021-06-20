package practice.algorithm.programmers.practice.level2.행렬의_곱셈;

import java.util.Arrays;

/**
 * 행렬의 곱셈
 * [문제 설명]
 * 2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 *
 * [제한 조건]
 * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
 * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
 * 곱할 수 있는 배열만 주어집니다.
 *
 * [입출력 예]
 * arr1	                                arr2	                            return
 * [[1, 4], [3, 2], [4, 1]]	            [[3, 3], [3, 3]]	                [[15, 15], [15, 15], [15, 15]]
 * [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
 */
public class Solution {
    /**
     * 행렬의 곱셈에 대한 개념을 알고 있어야 풀 수 있는 문제!
     * @param arr1
     * @param arr2
     * @return
     */
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
