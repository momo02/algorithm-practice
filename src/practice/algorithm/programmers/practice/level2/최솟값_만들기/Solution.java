package practice.algorithm.programmers.practice.level2.최솟값_만들기;

import java.util.Arrays;

/**
 * 최솟값 만들기
 *
 * 길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
 * 배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
 * 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
 *
 * 예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면
 *
 * A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
 * A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
 * A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
 * 즉, 이 경우가 최소가 되므로 29를 return 합니다.
 *
 * 배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
 *
 * [제한사항]
 * 배열 A, B의 크기 : 1,000 이하의 자연수
 * 배열 A, B의 원소의 크기 : 1,000 이하의 자연수
 * 입출력 예
 * A	        B	        answer
 * [1, 4, 2]	[5, 4, 4]	29
 * [1,2]	    [3,4]	    10
 *
 * [입출력 예 설명]
 * 입출력 예 #1
 * 문제의 예시와 같습니다.
 *
 * 입출력 예 #2
 * A에서 첫번째 숫자인 1, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 4)
 * 다음, A에서 두번째 숫자인 2, B에서 첫번째 숫자인 3을 뽑아 곱하여 더합니다. (누적된 값 : 4 + 6 = 10)
 * 이 경우가 최소이므로 10을 return 합니다.
 */
public class Solution {
    /**
     * 다른 사람 풀이
     * - 내가 문제를 너무 복잡하게 생각했다.
     *   오름 차순으로 정렬한 뒤
     *   두 배열을 대각선 방향으로 (A배열 인덱스 1일때 B배열 마지막 요소, A배열 인덱스 2일때 B배열 마지막 요소-1..) 서로 곱해주면
     *   그 결과는 항상 최소값이 되는 특징을 이용하면 쉽게 풀 수 있다.
     */
    public static int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - 1 - i];
        }

        return answer;
    }

    public static int solution2(int []A, int []B)
    {
        int answer = 0;
        //오름 차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int a_minIdx = 0, b_minIdx = 0;
        int a_maxIdx = A.length -1, b_maxIdx = B.length -1;

        while(a_minIdx != a_maxIdx){
            if(A[a_maxIdx] > B[b_maxIdx]){
                answer += (B[b_minIdx++] * A[a_maxIdx--]);
            }else if(A[a_maxIdx] < B[b_maxIdx]){
                answer += (A[a_minIdx++] * B[b_maxIdx--]);
            }else { //최댓값 같을 경우
                if(A[a_minIdx] > B[b_minIdx]){
                    answer += (A[a_maxIdx--] * B[b_minIdx++]);
                }else if(A[a_minIdx] < B[b_minIdx]){
                    answer += (B[b_maxIdx--] * A[a_minIdx++]);
                }else{ //최솟값도 같을 경우
                    answer += (B[b_minIdx++] * A[a_maxIdx--]);
                    //answer += (A[a_minIdx++] * B[b_maxIdx--]); //이렇게 하면 에러
                }
            }
        }
        answer += (A[a_maxIdx] * B[b_maxIdx]);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,4,2}, new int[]{5,4,4,}));
        System.out.println(solution(new int[]{1,2}, new int[]{3,4}));
    }
}
