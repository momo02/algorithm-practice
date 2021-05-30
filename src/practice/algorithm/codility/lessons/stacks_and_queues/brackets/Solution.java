package practice.algorithm.codility.lessons.stacks_and_queues.brackets;

import practice.algorithm.utils.StopWatch;

import java.util.Stack;
/**
 * - N개의 문자들로 구성된 문자열 S
 * - 다음 조건중 하나라도 참이면 적절하게 중첩된것으로 간주.
 *
 * 1. S가 empty
 * 2. "(U)", "[U]"또는 "{U}"형식을 가지며 여기서 U는 적절하게 중첩 된 문자열입니다.
 * 3. S는 "VW"형식을 가지며 여기서 V와 W는 적절하게 중첩 된 문자열입니다.
 *
 * N 개의 문자로 구성된 문자열 S가 주어지면 S가 적절하게 중첩되면 1을 반환하고 그렇지 않으면 0을 반환
 * 예를 들어 S = "{[()()]}"이면 함수는 1을 반환하고 S = "([)()]"이면 함수는 위에서 설명한대로 0을 반환
 *
 * - 제한조건
 * N은 [0..200,000] 범위 내의 정수
 * 문자열 S는 "(", "{", "[", "]", "}"및 / 또는 ")"문자로만 구성
 */
public class Solution {

    public static int solution1(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i =0; i<S.length(); i++) {
            char c = S.charAt(i);
            //System.out.println(stack);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }else if (c == ')' || c == ']' || c == '}') {
                if(stack.empty()) return 0;
                char lastChar = stack.pop();
                if (c == ')' && lastChar != '(') return 0;
                else if (c == ']' && lastChar != '[') return 0;
                else if (c == '}' && lastChar != '{') return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    //속도(ns):792710
    //속도(ns):585534
    //속도(ns):1046706
    //속도(ns):1043929
    //속도(ns):721403
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            //System.out.println(stack);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            else if (c == ')' || c == ']' || c == '}') {
                if(stack.empty()) return 0;
                char lastChar = stack.pop();
                if (c == ')' && lastChar != '(') return 0;
                else if (c == ']' && lastChar != '[') return 0;
                else if (c == '}' && lastChar != '{') return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        StopWatch.play();
        System.out.println( solution1("{[()()]}"));
        System.out.println(  solution1("([)()]"));
        StopWatch.stop();
    }
}
