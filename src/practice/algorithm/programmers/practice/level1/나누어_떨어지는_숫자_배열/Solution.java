package practice.algorithm.programmers.practice.level1.나누어_떨어지는_숫자_배열;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 나누어 떨어지는 숫자 배열
 * [문제 설명]
 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 *
 * [제한사항]
 * arr은 자연수를 담은 배열입니다.
 * 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
 * divisor는 자연수입니다.
 * array는 길이 1 이상인 배열입니다.
 *
 * [입출력 예]
 * arr	            divisor	    return
 * [5, 9, 7, 10]	5	        [5, 10]
 * [2, 36, 1, 3]	1	        [1, 2, 3, 36]
 * [3,2,6]	        10	        [-1]
 *
 * [입출력 예 설명]
 * 입출력 예#1
 * arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.
 *
 * 입출력 예#2
 * arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.
 *
 * 입출력 예#3
 * 3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
 */
public class Solution {

    /**
     * 다른 사람 풀이
     * @param arr
     * @param divisor
     * @return
     */
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) return new int[] {-1};
        Arrays.sort(answer);
        return answer;
    }

    public static int[] solution2(int[] arr, int divisor) {
        if(divisor == 1){
            Arrays.sort(arr);
            return arr;
        }

        ArrayList<Integer> narr = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if( arr[i]%divisor == 0) {
                narr.add(arr[i]);
            }
        }
        if(narr.isEmpty()){
            return new int[]{-1};
        }
        Object[] to = narr.toArray();
        Arrays.sort(to);

        int[] answer =  Arrays.stream(to).mapToInt(i -> (int) i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {5, 9, 7, 10};
        int[] b = {2, 36, 1, 3};
        int[] c = {3,2,6};

        System.out.println(Arrays.toString(solution(a,5)));
        System.out.println(Arrays.toString(solution(b,1)));
        System.out.println(Arrays.toString(solution(c,10)));

    }
}
