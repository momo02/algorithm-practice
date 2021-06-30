package practice.algorithm.codility.lessons.maximum_slice_problem.max_profit;

/**
 * MaxProfit
 * - 1번에 통과
 * - https://app.codility.com/demo/results/training4X96ZN-UM2/
 *
 * [문제 설명 요약]
 * N 개의 정수로 구성된 배열 A가 제공된다. 연속 N 일 동안 주식의 일일 가격을 포함한다.
 * 단일 주식이 P 일에 매수되어 Q 일에 매각 된 경우
 * 0 ≤ P ≤ Q <N 인 경우  거래의 이익은 A [Q] ≥ A [P] 인 경우 A [Q] - A [P]와 같다.
 * 그렇지 않으면 거래는 A [P]-A [Q]의 손실을 가져온다.
 * 연속 N 일 동안 주식 주식의 일일 가격을 포함하는 N 개의 정수로 구성된 배열 A가 주어진 경우, 이 기간 동안 한 거래에서 가능한 최대 이익을 반환하라.
 *
 * [예시]
 *  6 개의 요소로 구성된 배열 A가 다음과 같다면 :
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * 가능한 최대 이익은 356 이므로 356을 리턴. (주식이 1 일에 매수되고 5 일에 판매 된 경우 발생)
 *
 * [가정]
 * N은 [0..400,000] 범위 내의 정수들.
 * 배열 A의 각 요소는 [0..200,000] 범위 내의 정수.
 */
public class Solution {

    public int solution(int[] A) {
        int minIdx = 0, maxDiff = 0;
        for(int i=1; i<A.length; i++){
            int diff = A[i] - A[minIdx];
            if(diff <= 0){
                minIdx = i;
            }else{
                if(diff > maxDiff) maxDiff = diff;
            }
        }
        return maxDiff;
    }
}
