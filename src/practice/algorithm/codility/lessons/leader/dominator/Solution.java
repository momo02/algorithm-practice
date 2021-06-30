package practice.algorithm.codility.lessons.leader.dominator;

import java.util.HashMap;

/**
 * Dominator
 * -1차 시도.(91점)
 * https://app.codility.com/demo/results/trainingH5B3YC-JS7/
 * -2차 시도.(100점)
 * https://app.codility.com/demo/results/trainingHBJGYD-XTX/
 *
 * [문제 설명 요약]
 * A의 지배자(dominator)는 A배열 요소에서 절반이상 나타나는 값.
 * N개의 정수로 구성된 A배열에서 A의 dominator가 발생하는 배열 A의 요소들 중 하나의 인덱스를 반환하라.
 * 없으면 -1을 리턴.
 *
 * [예시]
 * 주어진 배열 A가 다음과 같다면,
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * 함수는 0, 2, 4, 6 or 7 을 리턴
 *
 * [가정]
 * N은 [0..100,000] 범위 내의 정수(integer)
 * A 배열의 각 요소는 [−2,147,483,648..2,147,483,647]범위 내의 정수(integer)
 */
public class Solution {
    //2차
    public int solution(int[] A) {
        int rs = -1;
        // 배열 A의 사이즈가 1일 경우에 대한 예외 처리 필요
        if(A.length == 1) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++){
            if(map.containsKey(A[i])){
                int cnt = map.get(A[i]);
                if(cnt >= A.length/2){
                    rs = i; break;
                }else map.put(A[i], cnt + 1);
            }else{
                map.put(A[i],1);
            }
        }
        return rs;
    }

    //1차
    public int solution_bak(int[] A) {
        int rs = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<A.length; i++){
            if( map.containsKey(A[i])){
                int cnt = map.get(A[i]);
                if(cnt >= A.length/2){
                    rs = i; break;
                }else map.put(A[i], cnt + 1);
            }else{
                map.put(A[i],1);
            }
        }
        return rs;
    }

}
