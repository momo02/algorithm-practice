package practice.algorithm.programmers.skill_checks.level1.약수의_합;

public class Solution {
    /**
     * 다른 사람 풀이
     * @param n
     * @return
     */
    public static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n/2; i++){
            if(n%i == 0) answer += i;
        }
        return answer + n;
    }

    /**
     * 힌트 : https://calcproject.tistory.com/137
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int sum = 0;
        int i = 1;
        while(n/i >= i){
            if(n%i == 0){
                if(i != (n/i)){
                    sum += (i + (n/i));
                }else{
                    sum += (i);
                }
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(12));
        System.out.println(solution(5));
        System.out.println(solution(150));
        System.out.println(solution(27));
        System.out.println(solution(0));
        System.out.println(solution(1));
        System.out.println(solution(40));
        System.out.println(solution(49));
    }
}
