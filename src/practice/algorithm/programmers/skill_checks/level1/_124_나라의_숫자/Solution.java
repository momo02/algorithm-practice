package practice.algorithm.programmers.skill_checks.level1._124_나라의_숫자;

/**
 * [문제 설명]
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 *
 * 124 나라에는 자연수만 존재합니다.
 * 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 * 예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
 *
 * 10진법	124 나라	10진법	124 나라
 * 1	    1	    6	    14
 * 2	    2	    7	    21
 * 3	    4	    8	    22
 * 4	    11	    9	    24
 * 5	    12	    10	    41
 * 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 *
 * [제한사항]
 * n은 500,000,000이하의 자연수 입니다.
 *
 * [입출력 예]
 * n	result
 * 1	1
 * 2	2
 * 3	4
 * 4	11
 */
public class Solution {

    /**
     * 다른 풀이
     *
     * 1) n % 3 == 0 일 때는 4로 변환해줘야했는데, 여기서는 배열로 처리.
     * 필요한 값만 배열에 넣어두고, 나머지 값을 배열의 인덱스로 하여 원하는 값을 꺼냄.
     *
     * 2) 3으로 나눴을 때, 나머지가 0인 경우에만 몫(n)에서 -1을 해야하는데
     * n = (n-1) / 3 하면 따로 예외 처리 하지 않아도 됨.
     * -> 3으로 나눴을 때 나머지가 1,2 인 경우에는 n-1 을 하고 다시 3으로 나눠도 몫의 값이 변함이 없기 때문.
     *    3으로 나눠을 때 나머지가 0 인 경우에만 n-1 을 하고 다시 3으로 나눴을때 몫의 값 -1 이 됨.
     * @param n
     * @return
     */
    public static String solution2(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }

    /**
     * 풀이 참조
     */
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int m = n;
        while(m / 3 != 0){
            //예외 처리
            if(m%3 == 0){
                sb.insert(0,4);
                m = (m/3) -1;
            }else {
                sb.insert(0,m % 3);
                m /= 3;
            }
        }
        if(m != 0) sb.insert(0,m);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(14));
        System.out.println(solution(17));
    }
}
