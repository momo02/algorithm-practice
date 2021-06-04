package practice.algorithm.codility.lessons.time_complexity.frog_jmp;


/**
 * [문제]
 * 개구리는 현재 위치 X에 있고 Y보다 크거나 같은 위치에 도달하려한다.
 * 작은 개구리는 항상 고정 된 거리 D를 점프한다.
 * 작은 개구리가 목표에 도달하기 위해 수행해야하는 최소 점프 수를 세라.
 *
 * 세 개의 정수 X, Y, D가 주어지면
 * 위치 X에서 Y보다 크거나 같은 위치로의 최소 점프 수를 반환.
 *
 * [예시]
 *  X = 10 -> 위치
 *  Y = 85 -> 목표 위치
 *  D = 30 -> 1번에 점프하는 거리
 *
 *  개구리는 다음과 같이 위치하므로 3을 반환.
 *  첫 번째 점프 후 위치 10 + 30 = 40
 *  두 번째 점프 후 위치 10 + 30 + 30 = 70
 *  세 번째 점프 후 위치 10 + 30 + 30 + 30 = 100
 *
 *  [조건]
 *  X, Y 및 D는 [1..1,000,000,000] 범위 내의 정수
 *  X ≤ Y
 */
public class Solution {
    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        return (Y-X) / D + ((Y-X) % D > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        if( 3 == solution(10,85,30)) {
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
    }
}
