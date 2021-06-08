package practice.algorithm.programmers.practice.level1.수박수박수박수박;

/**
 * 수박수박수박수박수박수?
 * [문제 설명]
 * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
 * 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 *
 * [제한 조건]
 * n은 길이 10,000이하인 자연수입니다.
 * 입출력 예
 * n	return
 * 3	"수박수"
 * 4	"수박수박"
 */
public class Solution {

    public static String solution(int n) {
        char[] c = {'수','박'}; // 0 ,1
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            sb.append(c[i % 2]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
