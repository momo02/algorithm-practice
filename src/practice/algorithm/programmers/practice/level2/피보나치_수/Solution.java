package practice.algorithm.programmers.practice.level2.피보나치_수;

/**
 * 피보나치 수
 * [문제 설명]
 * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
 * 예를들어
 *
 * F(2) = F(0) + F(1) = 0 + 1 = 1
 * F(3) = F(1) + F(2) = 1 + 1 = 2
 * F(4) = F(2) + F(3) = 1 + 2 = 3
 * F(5) = F(3) + F(4) = 2 + 3 = 5
 * 와 같이 이어집니다.
 *
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 *
 * [제한 사항]
 * * n은 1이상, 100000이하인 자연수입니다.
 *
 * [입출력 예]
 * n	return
 * 3	2
 * 5	5
 *
 * 입출력 예 설명
 * 피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
 */
public class Solution {

    /**
     * - 다른 사람 풀이
     * -> 배열을 이용한 풀이
     */
    public static int solution(int n) {
        int[] s = new int[n+1];
        s[0] = 0;
        s[1] = 1;
        for(int i=2; i<n+1; i++) {
            s[i] = (s[i - 1] % 1234567) + (s[i-2] % 1234567);
        }
        return s[n] % 1234567;
    }

    /**
     * - 풀이 참고
     * cf) 숫자 A, B, C가 있다고 하면 (A + B) % C의 값은 ( ( A % C ) + ( B % C) ) % C와 같다는 성질을 이용하여
     * int의 범위를 넘겨 에러가 나는 것을 해결.
     */
    public static int solution3(int n) {
        int f1 = 0, f2 = 1;
        for(int i = 1; i<n; i++){
            int tmp = f2;
            f2 = (f1 % 1234567) + (f2 % 1234567);
            f1 = tmp;
        }
        return f2 % 1234567;
    }

    /**
     * 이렇게하면 실패
     * 이유는 피보나치 수는 엄청나게 빠르게 증가하여 44번째 피보나치 수만 가도 2,971,215,073로 int 범위를 넘어버리기 때문.
     * 이대로면 피보나치의 수를 구하라는 문제는 int를 사용할 수가 없겠지만 아래와 같은 성질을 이용해서 해결할 수 있다!
     * ==> 숫자 A, B, C가 있다고 하면 (A + B) % C의 값은 ( ( A % C ) + ( B % C) ) % C와 같다는 성질.
     */
    public static int solution2(int n) {
        int f1 = 0, f2 = 1;
        for(int i = 1; i<n; i++){
            int tmp = f2;
            f2 = (f1 + f2);
            f1 = tmp;
        }
        return f2 % 1234567;
    }



    public  static int getF(int n){
        if(n == 0 || n == 1){
            return n;
        }else{
            return getF(n-1) + getF(n-2);
        }
    }

    /**
     * 재귀 함수 호출 -> 시간 초과
     * 정확성: 42.9
     * 합계: 42.9 / 100.0
     */
    public static int solution1(int n) {
        return  getF(n) % 1234567;
    }

    public static void main(String[] args) {
       System.out.println(2 == solution(3) ? "정답" : "오답..");
       System.out.println(5 == solution(5) ? "정답" : "오답..");
    }
}
