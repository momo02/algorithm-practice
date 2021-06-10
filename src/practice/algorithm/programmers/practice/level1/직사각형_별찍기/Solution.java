package practice.algorithm.programmers.practice.level1.직사각형_별찍기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 직사각형 별찍기
 * [문제 설명]
 * 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
 * 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
 *
 * [제한 조건]
 * n과 m은 각각 1000 이하인 자연수입니다.
 *
 * [예시]
 * -입력
 * 5 3
 *
 * -출력
 * *****
 * *****
 * *****
 */
public class Solution {

    /**
     * 테스트 1 〉	통과 (203.32ms, 47.6MB)
     * 테스트 2 〉	통과 (197.08ms, 48.1MB)
     * 테스트 3 〉	통과 (224.89ms, 48.1MB)
     * 테스트 4 〉	통과 (201.78ms, 47.4MB)
     * 테스트 5 〉	통과 (200.41ms, 47.8MB)
     * 테스트 6 〉	통과 (185.44ms, 47.4MB)
     * 테스트 7 〉	통과 (201.52ms, 47.8MB)
     * 테스트 8 〉	통과 (275.93ms, 50.1MB)
     * 테스트 9 〉	통과 (374.90ms, 55.5MB)
     * 테스트 10 〉 통과 (245.76ms, 48.7MB)
     * 테스트 11 〉 통과 (278.89ms, 52.3MB)
     */
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(inputs[0]); //가로
            int m = Integer.parseInt(inputs[1]); //세로

            for(int i =0; i< m; i++){
                for(int j=0; j<n; j++){
                    System.out.print('*');
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
}
