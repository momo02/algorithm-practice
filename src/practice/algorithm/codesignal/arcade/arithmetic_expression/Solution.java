package practice.algorithm.codesignal.arcade.arithmetic_expression;

/**
 * [문제]
 * a#b=c 형식의 산술 표현식을 고려하라.
 * #을 +,-, * 또는 /의 네 가지 기호 중 하나로 대체하여 올바른 표현식을 얻을 수 있으면 true, 아니면 false 반환.
 *
 * [예시]
 * a = 2, b = 3, and c = 5 이면 true (#을 +로 대체하여 2 + 3 = 5를 얻을 수 있으므로)
 * a = 8, b = 2, and c = 4 이면 true (#을 /로 대체하여 8 / 2 = 4를 얻을 수 있으므로)
 * a = 8, b = 3, and c = 2 이면 false
 *
 * 8 + 3 = 11 ≠ 2;
 * 8 - 3 = 5 ≠ 2;
 * 8 * 3 = 24 ≠ 2;
 * 8 / 3 = 2.(6) ≠ 2.
 *
 * [조건]
 * [input] integer a
 * 1 ≤ a ≤ 20.
 *
 * [input] integer b
 * 1 ≤ b ≤ 20.
 *
 * [input] integer c
 * 0 ≤ c ≤ 20.
 *
 * [output] boolean
 * true if the desired replacement is possible, false otherwise.
 */
public class Solution {

    static boolean arithmeticExpression(int a, int b, int c) {
        return (a + b == c || a - b == c || a * b == c || (a * 1.0)/ b == c);
    }

    /**
     * Best case
     */
    boolean arithmeticExpression2(int A, int B, int C) {
        return A+B==C || A-B==C || A*B==C || A == B*C;
    }

    public static void main(String[] args) {

        if(!arithmeticExpression(8,3,2) && arithmeticExpression(2,3,5)){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}