package practice.algorithm.codesignal.arcade.is_infinite_process;

public class Solution {
    /**
     * 문제풀이
     *
     * - a는 계속 커지고, b는 계속 작아지는 수 여서 a가 b보다 큰 경우는 절대 같아질 수 없음.(infinite true)
     * - a와 b가 같거나 b>a 이면서, 아래와 같은 경우에 같아진다.
     *    a == b
     *    a + 1 == b - 1
     *    a + 2 == b - 2
     *    a + 3 == b - 3
     *    ...
     * - 규칙
     *    b - a = 0 (0 * 2)
     *    b - a = 1 + 1 (1 * 2)
     *    b - a = 2 + 2 (2 * 2)
     *    b - a = 3 + 3 (3 * 2)
     *     --> b-a의 값이 2로 나누어 떨어짐. (b-a)%2 == 0
     **/
    static boolean isInfiniteProcess(int a, int b) {
        //return  a==b || (a<b && (b-a)%2 == 0) ? false : true;
        //return !(a==b || (a<b && (b-a)%2 == 0));
        // 더 심플하게
        return !(b >= a && (b-a)%2 == 0);
    }

    public static void main(String[] args) {
        if(!isInfiniteProcess(2,2) && !isInfiniteProcess(2,6) && isInfiniteProcess(2,3)){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}
