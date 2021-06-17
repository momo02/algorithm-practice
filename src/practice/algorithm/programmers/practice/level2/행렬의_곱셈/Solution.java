package practice.algorithm.programmers.practice.level2.행렬의_곱셈;

import java.util.Arrays;

public class Solution {


    public static int[][] solution2(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][];

        for(int i=0; i<arr1.length; i++){
            answer[i] = new int[arr1[i].length];
            for(int j=0; j<arr1[i].length; j++){
                int sum = 0;
                for(int k=0; k<arr1[i].length; k++){
                    sum +=  arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][];

        for(int i=0; i<arr1.length; i++){
            answer[i] = new int[arr1[i].length];

            for(int j=0; j<arr1[i].length; j++){
                System.out.println(">>>>>>>>> i , j  : " + i + "," + j);

                int sum = 0;
                 for(int k=0; k<arr1[i].length; k++){
                     System.out.println(">>>> i , k  : " + i + "," + k);
                     System.out.println(">>>> k , j  : " + k + "," + j);

                     System.out.println(">>>> arr1[i][k]  : " + arr1[i][k]);
                     System.out.println(">>>> arr2[k][j]  : " + arr2[k][j]);
                     sum +=  arr1[i][k] * arr2[k][j];
                 }
                answer[i][j] = sum;
                System.out.println(">>>> sum : " + sum);
            }
            System.out.println("/");
        }
        return answer;
    }

//        public static int[][] solution(int[][] arr1, int[][] arr2) {
//        int[][] answer = new int[arr1.length][];
//
//        for(int i=0; i<arr1.length; i++){
//            //answer[i] = new int[arr1[i].length];
//            for(int j=0; j<arr1[i].length; j++){
//                System.out.print(arr1[i][j]);
//
//                int sum = 0;
////                for(int k=0; k<arr1[i].length; k++){
////                    System.out.println(">>>> i, j : " + i + ","  +j);
////                    System.out.println(">>>> k, j : " + k + ","  +j);
////
////                    System.out.println(">>>> arr1[i][j]  : " + arr1[i][j] );
////                    System.out.println(">>>> arr2[k][j]  : " + arr2[k][j] );
////                    sum += (arr1[i][j] * arr2[k][j]);
////                }
//                System.out.println(">>>> sum : " + sum);
//            }
//            System.out.println("/");
//        }
//        return answer;
//    }

    public static void main(String[] args) {

        int[][] rs = solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        //int[][] rs = solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});

        for(int[] rss : rs){
            System.out.println(Arrays.toString(rss));
        }

    }
}
