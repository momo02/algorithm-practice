package practice.algorithm.codility.lessons.counting_elements.frog_river_one;

/**
 * FrogRiverOne
 * - 1번에 통과
 * - https://app.codility.com/demo/results/training264EGC-SGR/
 *
 * [문제 설명 요약]
 * 작은 개구리가 강 건너편으로 가고 싶어함.
 * 개구리는 처음에 강의 한 둑 (위치 0)에 있으며 반대쪽 둑 (위치 X + 1)에 도달하려 함.
 * 낙엽이 나무에서 강 표면으로 떨어지는데, 개구리는 1에서 X까지 모든 위치가 잎으로 덮여있을 경우에만 강을 건널 수 있음.
 *
 * 낙엽을 나타내는 N 개의 정수로 구성된 배열 A가 제공.
 * A[K]는 초 단위로 측정 된 시간 K에서 한 잎이 떨어지는 위치.
 *
 * 목표는 개구리가 강 반대편으로 점프 할 수있는 가장 빠른 시간을 찾는 것.
 * N 개의 정수로 구성된 비어 있지 않은 배열 A 와 Integer X가 주어지면 개구리가 강 반대편으로 점프 할 수있는 가장 빠른 시간을 반환.
 * 개구리가 강 반대편으로 점프 할 수없는 경우 함수는 −1을 반환.
 *
 * [예시]
 *  X = 5 이고 배열 A가 다음과 같다면 :
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * 함수는 6을 리턴.
 *
 * [가정]
 * N 과 X는 [1..100,000] 범위 내의 정수들.
 * 배열 A의 각 요소는 [1..X] 범위 내의 정수.
 */
public class Solution {

    public int solution(int X, int[] A) {
        int rs = -1;
        // write your code in Java SE 8
        int[] a = new int[X];
        int cnt = X;

        for(int i = 0; i <A.length; i++){
            if(a[A[i]-1] == 0){
                a[A[i]-1] = 1;
                cnt--;
            }
            if(cnt == 0){
                rs = i;
                break;
            }
        }
        return rs;
    }
}
