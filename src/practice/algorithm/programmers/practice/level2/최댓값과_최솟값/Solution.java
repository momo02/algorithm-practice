package practice.algorithm.programmers.practice.level2.최댓값과_최솟값;

import java.util.Arrays;

/**
 * 최댓값과 최솟값
 * [문제 설명]
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 *
 * [제한 조건]
 * s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 *
 * [입출력 예]
 * s	return
 * "1 2 3 4"	"1 4"
 * "-1 -2 -3 -4"	"-4 -1"
 * "-1 -1"	"-1 -1"
 */
public class Solution {

    /**
     * 풀이과정
     * -> 1. 먼저 공백을 구분으로 문자열을 나누고,
     *    2. int 타입 배열로 변경한 뒤,
     *    3. Arrays.sort를 이용하여 정렬한 뒤 첫번째 요소(최솟값)와 마지막요소(최댓값)을 붙여 리턴.
     * ** 주의 : string 타입 배열을  int 타입 배열로 변경해야 함.
     *          이유는 String 타입으로 정렬을 할 경우 음수 값 정수일 때 -부호가 단순히 String으로 인식되기 때문에
     *          값의 크기 비교가 제대로 수행되지 않기 때문.
     *          (ex -4 -1 정렬 시, -4가 -1보다 더 작은 수 있지만 앞의 부호가 고려되지 않아 -1 이 먼저 오게 됨)
     */
    public static String solution(String s) {
        String[] a =  s.split("\\s");

        int[] ints = Arrays.stream(a).mapToInt(i -> Integer.parseInt(i)).toArray();
        Arrays.sort(ints);

        return ints[0] + " " + ints[ints.length-1];
    }

    public static void main(String[] args) {
        System.out.println(solution("7 2 3 1"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));
        System.out.println(solution("1 2 3 4"));
    }
}
