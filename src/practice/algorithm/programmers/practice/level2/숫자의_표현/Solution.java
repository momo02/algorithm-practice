package practice.algorithm.programmers.practice.level2.숫자의_표현;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 숫자의 표현
 * [문제 설명]
 * Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
 * 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
 *
 *
 * 1 + 2 + 3 + 4 + 5 = 15
 * 4 + 5 + 6 = 15
 * 7 + 8 = 15
 * 15 = 15
 * 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 *
 * [제한사항]
 * n은 10,000 이하의 자연수 입니다.
 * [입출력 예]
 * n	result
 * 15	4
 */
public class Solution {

    public static int solution(int n) {
        int rsCnt = 1; //자기자신만 더한 1가지 경우는 항상 존재하므로 결과값은 1 이상.

        Queue<Integer> stack = new LinkedList<>(); //int형 queue 선언

        int total = 0, i = 1;

        while(i<= n){
//            System.out.println(">>>>> i : " + i);
//            System.out.println(">>>>> total : " + total);
//            System.out.println(">>>>> stack : " + stack);
//            System.out.println(">>>>> rsCnt : " + rsCnt);

            if(total == n){
                rsCnt++;
                if(stack.size() == 2) break; // 연속된 수 2개가 n과 같다면, 그 다음의 경우는 자기자신만 더한 1가지의 경우일 것으므로 반복문을 빠져나온다.
            }else if(total > n){

                total -= stack.poll();
                while(total > n){
                    total -= stack.poll();
                }
                continue;
            }

            total += i;
            stack.offer(i);
            i++;
        }
        return rsCnt;
    }

    public static void main(String[] args) {
            System.out.println(solution(15));
    }
}
