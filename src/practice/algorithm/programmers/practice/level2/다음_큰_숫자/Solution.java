package practice.algorithm.programmers.practice.level2.다음_큰_숫자;

/**
 * 다음 큰 숫자
 *
 * [문제 설명]
 * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
 *
 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
 *
 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 *
 * [제한 사항]
 * n은 1,000,000 이하의 자연수 입니다.
 *
 * [입출력 예]
 * n	result
 * 78	83
 * 15	23
 *
 * [입출력 예 설명]
 * 입출력 예#1
 * 문제 예시와 같습니다.
 * 입출력 예#2
 * 15(1111)의 다음 큰 숫자는 23(10111)입니다.
 */
public class Solution {

    /**
     * 2진수 변환 시, 1의 갯수 리턴
     * @param n
     * @return
     */
    public static int getOneCnt(int n) {
        int cnt1 = 0;
        while(n > 1){
            if(n%2 == 1) cnt1++;
            n = n/2;
            if(n == 1) cnt1++;
        }
        return cnt1;
    }

    public static int solution(int n) {
        int answer = 0;
        int t_cnt = getOneCnt(n);

        while(true){
            if(t_cnt == getOneCnt(++n)){
                answer = n;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
        System.out.println(solution(78));
    }
}
