package practice.algorithm.programmers.practice.level1.제일_작은_수_제거하기;


import practice.algorithm.utils.StopWatch;

import java.util.Arrays;

/**
 * 제일 작은 수 제거하기
 * [문제 설명]
 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
 * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 *
 * [제한 조건]
 * arr은 길이 1 이상인 배열입니다.
 * 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
 *
 * [입출력 예]
 * arr	         return
 * [4,3,2,1]	[4,3,2]
 * [10]	        [-1]
 */
public class Solution {
    /**
     * 다른 사람 풀이
     * -> 코드는 간결하지만 평균 수행시간이 오래 걸림.
     * 테스트 1 〉	통과 (10.95ms, 62.7MB)
     * 테스트 2 〉	통과 (4.88ms, 52.5MB)
     * 테스트 3 〉	통과 (5.85ms, 52.3MB)
     * 테스트 4 〉	통과 (3.37ms, 52.3MB)
     * 테스트 5 〉	통과 (4.11ms, 53.1MB)
     * 테스트 6 〉	통과 (13.35ms, 53.5MB)
     * 테스트 7 〉	통과 (13.01ms, 64.7MB)
     * 테스트 8 〉	통과 (8.41ms, 52.2MB)
     * 테스트 9 〉	통과 (5.18ms, 53.3MB)
     * 테스트 10 〉 통과 (3.40ms, 53.3MB)
     * 테스트 11 〉 통과 (3.16ms, 53.4MB)
     * 테스트 12 〉 통과 (10.13ms, 53MB)
     * 테스트 13 〉 통과 (5.03ms, 54.4MB)
     * 테스트 14 〉 통과 (4.00ms, 52.2MB)
     * 테스트 15 〉 통과 (5.61ms, 52.7MB)
     * 테스트 16 〉 통과 (5.81ms, 52.9MB)
     */
    public static int[] solution(int[] arr) {
        if(arr.length <= 1) return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

    /**
     * 테스트 1 〉	통과 (2.38ms, 62.3MB)
     * 테스트 2 〉	통과 (0.04ms, 53.2MB)
     * 테스트 3 〉	통과 (0.06ms, 54MB)
     * 테스트 4 〉	통과 (0.04ms, 53.1MB)
     * 테스트 5 〉	통과 (0.03ms, 52.8MB)
     * 테스트 6 〉	통과 (0.06ms, 52.6MB)
     * 테스트 7 〉	통과 (0.09ms, 54.2MB)
     * 테스트 8 〉	통과 (0.02ms, 51.8MB)
     * 테스트 9 〉	통과 (0.02ms, 52.8MB)
     * 테스트 10 〉 통과 (0.02ms, 52.9MB)
     * 테스트 11 〉 통과 (0.02ms, 52.9MB)
     * 테스트 12 〉 통과 (0.02ms, 52MB)
     * 테스트 13 〉 통과 (0.04ms, 52.9MB)
     * 테스트 14 〉 통과 (0.08ms, 53.3MB)
     * 테스트 15 〉 통과 (0.05ms, 52.7MB)
     * 테스트 16 〉 통과 (0.07ms, 53MB)
     */
    public static int[] solution2(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int[] answer = new int[arr.length-1];

        int min = arr[0];

        for(int i =1; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }

        int j=0;
        for(int i = 0; i< answer.length; i++){
            if(arr[j] == min && j != arr.length){
                j++;
            }
            answer[i] = arr[j++];
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] a = new int[]{4,3,2,1};
        int[] b = new int[]{10};
        StopWatch.play();
        System.out.println(Arrays.toString(solution(a)));
        System.out.println(Arrays.toString(solution(b)));
        StopWatch.stop();
    }
}