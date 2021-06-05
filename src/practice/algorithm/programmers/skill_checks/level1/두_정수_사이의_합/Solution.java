package practice.algorithm.programmers.skill_checks.level1.두_정수_사이의_합;


/**
 * [문제 설명]
 * 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
 * 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
 *
 * [제한 조건]
 * a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
 * a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
 * a와 b의 대소관계는 정해져있지 않습니다.
 */
public class Solution {


    /**
     * 두 수 사이의 합을 구할 때 '가우수 방식' 이용.
     * 가우스 방식 : 양쪽 두 수를 더한 것에, 두 수 사이의 숫자 수 + 1을 곱하고 나누기 2.
     * @param a
     * @param b
     * @return
     */
    public static long solution(int a, int b) {
        return (a + b) * ((a > b ? a - b : b - a) + 1) / 2;
    }

//    public static long solution(int a, int b) {
//        long max = a, min = b;
//        if(a == b) return a;
//
//        if(a < b){
//            max = b;
//            min = a;
//        }
//
//       long cnt = 0;
//       for(long i= min; i<=max; i++){
//           cnt += i;
//       }
//       return cnt;
//    }

    public static void main(String[] args) {
        System.out.println( solution(3,5));
        System.out.println( solution(3,3));
        System.out.println( solution(5,3));
        System.out.println( solution(1,2));
        System.out.println( solution(-2,1));
        System.out.println( solution(-1,-1));
        System.out.println( solution(-1,-3));
    }
}
