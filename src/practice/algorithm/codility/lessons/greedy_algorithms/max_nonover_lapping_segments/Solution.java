package practice.algorithm.codility.lessons.greedy_algorithms.max_nonover_lapping_segments;

/**
 *  MaxNonoverlappingSegments
 *  - 1차 시도 (50점)
 *  https://app.codility.com/demo/results/trainingVAER67-GFJ/
 *  - 2차 시도 (100점)
 *  https://app.codility.com/demo/results/trainingES6W85-K3Q/
 *
 *  - 풀이 참조
 *  https://mirae-kim.tistory.com/136
 *
 *  [문제 설명 요약]
 *  한 줄에는 0에서 N-1까지 번호가 매겨진 N 개의 세그먼트가 있으며 그 위치는 배열 A와 B에 지정된다.
 *  각 I (0 ≤ I <N)에 대해 세그먼트 I의 위치는 A[I]부터  B[I]까지이다.(포함)
 *  세그먼트는 끝으로 정렬된다. 즉, K에 대해 B[K] ≤ B[K + 1]이 0 ≤ K <N-1이 되도록 한다.
 *
 *  I ≠ J 인 두 세그먼트 I와 J는 적어도 하나의 공통된 점을 공유하는 경우 겹친다.
 *  =>  A [I] ≤ A [J] ≤ B [I] 또는 A [J] ≤ A [I] ≤ B [J] 인 경우 겹친다.
 *  두 개의 겹치는 세그먼트가 없으면 세그먼트 세트가 겹치지 않는것.
 *
 *  => 목표는 최대 세그먼트 수를 포함하는 겹치지 않는 집합의 크기를 찾는 것.
 *  N 개의 정수로 구성된 두 개의 배열 A와 B가 주어지면 최대 세그먼트 수를 포함하는 겹치지 않는 집합의 크기를 반환.
 *
 * [예시]
 *
 *
 * [가정]
 * - N은 [0..30,000] 범위 내의 integer.
 * - 배열 A, B의 각 요소는 [0..1,000,000,000] 범위 내의 integer.
 * - A[I] ≤ B[I], for each I (0 ≤ I < N);
 * - B[K] ≤ B[K + 1], for each K (0 ≤ K < N − 1).
 *  */
public class Solution {

    public int solution(int[] A, int[] B) {
        // 배열 사이즈 0일 경우, 예외 처리
        if(A.length == 0) return 0;

        int maxNum = A.length;
        int endPoint = B[0];

        for(int i=1; i<A.length; i++){
            // overlapping
            if( A[i] <= endPoint ){
                maxNum--;
            }else{
                endPoint = B[i];
            }
        }
        return maxNum;
    }

    public int solution_bak2(int[] A, int[] B) {
        // write your code in Java SE 8
        int maxNum = A.length;
        for(int i=0; i<A.length -1; i++){
            //overlapping
            if( A[i + 1] <= B[i] ){
                maxNum--;
            }
        }
        return maxNum;
    }

    public int solution_bak1(int[] A, int[] B) {
        // write your code in Java SE 8
        int maxNum = A.length;
        for(int i=0; i<A.length -1; i++){
            //overlapping
            if( (A[i] <= A[i+1] && A[i+1] <= B[i])){
            //if( (A[i] <= A[i+1] && A[i+1] <= B[i]) || (A[i+1] <= A[i] && A[i] <= B[i+1]) ){
                maxNum--;
            }
        }
        return maxNum;
    }
}
