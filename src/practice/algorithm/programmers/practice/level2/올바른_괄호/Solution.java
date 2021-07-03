package practice.algorithm.programmers.practice.level2.올바른_괄호;

import java.util.Stack;

public class Solution {

    //stack을 이용하지 않은 풀이
    static boolean solution(String s) {
        char[] cs = s.toCharArray();

        int open_cnt = 0;

        for(int i = 0; i<cs.length; i++){
            if(cs[i] == '(') open_cnt++;
            else open_cnt--;
            if(open_cnt < 0) return false;
        }
        if(open_cnt != 0) return false;
        else return true;
    }

    //한번에 통과. stack을 이용한 풀이.
    static boolean solution2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();

        for(int i = 0; i<cs.length; i++){
            char c = cs[i];

            if('(' == c) {
                stack.add(c);
            }else if(')' == c) {
                if(stack.isEmpty()) return false;
                char c_pop = stack.pop();
                if('(' != c_pop) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
        System.out.println(solution("())(()"));
    }
}
