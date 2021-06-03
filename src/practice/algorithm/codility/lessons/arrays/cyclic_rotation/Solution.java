package practice.algorithm.codility.lessons.arrays.cyclic_rotation;

import java.util.Arrays;

/**
 * [문제]
 * N개의 정수로 구성된 배열 A.
 * 배열의 회전은 각 요소가 하나의 인덱스만큼 오른쪽으로 이동 함을 의미. 배열의 마지막 요소가 처음으로 이동.
 *
 * N개의 정수들로 구성된 배열 A 와 정수 k(회전 횟수) 가 주어지면 K번 회전된 배열 A를 반환하라.
 *
 * [예시]
 * 1) A = [3, 8, 9, 7, 6], K = 3 일 때 함수는 [9, 7, 6, 3, 8] 를 반환.
 *
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 *
 * 2) A = [0, 0, 0], K = 1 일 때 함수는 [0, 0, 0] 를 반환.
 *
 * 3) A = [1, 2, 3, 4], K = 4 일 때 함수는 [1, 2, 3, 4] 를 반환.
 *
 * [조건]
 * N 및 K는 [0..100] 범위 내의 정수.
 * 배열 A의 각 요소는 [-1,000..1,000] 범위 내의 정수.
 */
class Solution {
    public static int[] solution(int[] A, int K) {
        int[] rs = new int[A.length];

        if(A.length == K) return A;

        for(int i=0; i<A.length; i++){
            if(i+K < A.length) {
                rs[i+K] = A[i];
            }else{
                rs[(i+K)%A.length] = A[i];
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] answer1 = new int[]{9, 7, 6, 3, 8};
        int[] answer2 = new int[]{0, 0, 0};
        int[] answer3 = new int[]{1, 2, 3, 4};
        boolean ex1 = Arrays.equals( answer1, solution(new int[]{3, 8, 9, 7, 6},3) );
        boolean ex2 = Arrays.equals( answer2, solution(new int[]{0,0,0},1) );
        boolean ex3 = Arrays.equals( answer3, solution(new int[]{1,2,3,4},4) );

        if(ex1 && ex2 && ex3){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}
