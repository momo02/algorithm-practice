package practice.algorithm.codility.lessons.arrays.odd_occurrences_in_array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * [문제]
 * N개의 정수로 구성된 비어있지 않은 배열 A.
 * 배열은 홀수의 수로 구성되어있고 배열의 각 요소는 짝을 이루지않는 한 요소를 제외하고
 * 동일한 값을 가진 다른 요소와 짝을 이룰 수 있다.
 * 배열 A에서 짝을 이루지 않는 한 요소의 값을 리턴.
 *
 * [예시]
 * 배열 A가
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * 일 경우, 인덱스 5의 요소는 값 7을 가지며 짝을 이루지 않으므로 7을 리턴.
 *
 * [조건]
 * N은 [1..1,000,000] 범위 내의 홀수 정수
 * 배열 A의 각 요소는 [1..1,000,000,000] 범위 내의 정수
 * A의 값 중 하나를 제외하고 모두 짝수 번 발생
 *
 * [결과]
 * 1번째 -> https://app.codility.com/demo/results/trainingXG67UC-JKY/
 * 2번째 -> https://app.codility.com/demo/results/training8TSSHG-KD8/
*/
public class Solution {

    public static int solution(int[] A) {
        HashSet<Integer> s = new HashSet<>();

        for(int i=0; i<A.length; i++){
            if(s.contains(A[i])){
                s.remove(A[i]);
            }else{
                s.add(A[i]);
            }
        }
        return (int) s.toArray()[0];
    }

//    public static int solution(int[] A) {
//        int rs = 0;
//        // write your code in Java SE 8
//        HashMap<Integer, Integer> m = new HashMap<>();
//
//        for(int i=0; i<A.length; i++){
//            m.put(A[i], m.getOrDefault(A[i],0) + 1);
//        }
//
//        System.out.println(m);
//
//        for(Integer key : m.keySet()){
//            if(m.get(key) == 1){
//                rs = key;
//                break;
//            }
//        }
//        return rs;
//    }

    public static void main(String[] args) {

        System.out.println( solution(new int[]{9,3,9,3,9,7,9}));
        System.out.println( solution(new int[]{1,11,11,11,11}));
    }
}
