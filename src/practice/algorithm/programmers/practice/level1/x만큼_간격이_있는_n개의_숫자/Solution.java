package practice.algorithm.programmers.practice.level1.x만큼_간격이_있는_n개의_숫자;


import java.util.Arrays;

/**
 * x만큼 간격이 있는 n개의 숫자
 * [문제 설명]
 * 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 *
 * [제한 조건]
 * x는 -10000000 이상, 10000000 이하인 정수입니다.
 * n은 1000 이하인 자연수입니다.
 *
 * [입출력 예]
 * x	n	answer
 * 2	5	[2,4,6,8,10]
 * 4	3	[4,8,12]
 * -4	2	[-4, -8]
 */
public class Solution {
    /**
     * 다른 사람 풀이
     * - x 값부터 시작이니까 처음 0번째 인덱스에 x값을 먼저 넣어주고 1부터 n까지 루프를 돌림.
     * - 배열 요소가 x씩 증가하니 i번째 요소의 값은 이전 요소인 i-1번째 요소 값에 x를 더해줌.
     * @param x
     * @param n
     * @return
     */
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x; //x부터 시작.

        for(int i= 1; i<n; i++){
            answer[i] = answer[i-1] + x;
        }
        return answer;
    }

    public static long[] solution2(int x, int n) {
        long[] answer = new long[n];
        long tx = x;
        for(int i=0; i<n; i++){
                answer[i] = tx;
                tx += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2,5)));
        System.out.println(Arrays.toString(solution(4,3)));
        System.out.println(Arrays.toString(solution(-4,2)));
    }
}
