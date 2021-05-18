package practice.algorithm.programmers.codingtest.bruteforce.모의고사;

import java.util.Arrays;

public class Solution {

    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int a = getGrade(p1, answers);
        int b = getGrade(p2, answers);
        int c = getGrade(p3, answers);

//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        if(a > b){
            if(a > c){
                return new int[]{1};
            }else if(a == c){
                return new int[]{1,3};
            }else {
                return new int[]{3};
            }
        }else if(a == b){
            if(a > c) {
                return new int[]{1,2};
            }else if(a == c){
                return new int[]{1,2,3};
            }else {
                return new int[]{3};
            }
        }else { //a <b
            if(b > c) {
                return new int[]{2};
            }else if(b == c){
                return new int[]{2,3};
            }else {
                return new int[]{3};
            }
        }
    }

    public int getGrade(int[] p, int[] answers){
        int grade = 0;
        for(int i=0; i<answers.length; i++){
//            int pIdx;
//            if(i >= p.length) {
//                pIdx = i % p.length;
//            }else{
//                pIdx = i;
//            }
//            System.out.println(" >>" + pIdx);
            if( p[i % p.length] == answers[i] ) {
                grade++;
            }
        }
        return grade;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] commands = {
                {1,2,3,4,5},
                {1,3,2,4,2},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int[][] returns = {
                {1},
                {1,2,3},
                {3},
                {1,2,3}
        };

        long startTime = System.nanoTime();
        for(int i=0; i<commands.length; i++){
          if(Arrays.equals(returns[i], s.solution(commands[i]))){
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