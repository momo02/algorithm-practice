package practice.algorithm.programmers.practice.level2.땅따먹기;

/**
 * 땅따먹기
 * [문제 설명]
 * 땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
 * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
 *
 * 예를 들면,
 * | 1 | 2 | 3 | 5 |
 * | 5 | 6 | 7 | 8 |
 * | 4 | 3 | 2 | 1 |
 * 로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.
 *
 * 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.
 * 위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.
 *
 * [제한사항]
 * 행의 개수 N : 100,000 이하의 자연수
 * 열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
 * 점수 : 100 이하의 자연수
 *
 * [입출력 예]
 * land	                            answer
 * [[1,2,3,5],[5,6,7,8],[4,3,2,1]]	16
 */
public class Solution {

    public static int hopscotch(int[][] board, int size) {
        return hopscotch(board, size, 0, -1);
    }

    public static int hopscotch(int[][] board, int size, int y, int idx) {
        if (y >= size) return 0;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (i != idx) {
                answer = Math.max(hopscotch(board, size, y + 1, i) + board[y][i], answer);
            }
        }
        return answer;
    }

    /**
     * 다른 사람의 풀이 (재귀 방식)
     * @param land
     * @return
     */
    public static int solution2(int[][] land){
        return hopscotch(land, land.length);
    }

    /**
     * 풀이 강의 참조
     * cf) https://programmers.co.kr/learn/courses/18/lessons/846#
     * - 동적 계획법 (Dynamic Programming) : 문제를 풀 때 하나의 문제를 여러 하위 문제로 나누어 풀고, 그것들을 결합해서 최종 목적에 도달하는 방식의 알고리즘.
     *
     * [풀이 방법]
     * 2차원 배열의 특정 위치 K = land[i][j] 라 하면, K 위치에서 최대값은
     * 바로 한 단계 위의 행(i-1)에서 동일한 열(j)을 제외(->동일 열을 밟을 수 없는 규칙 때문)한 요소들 중 누적된 값이 제일 큰 요소와 자기 자신의 값을 더하는 것.
     *
     * ex) K = land[1][0]라면, K 위치에서의 최대값은 K + Max(land[0][1], land[0][2], land[0][3])
     *
     * 따라서 1번째 행부터 각 요소마다 이전 행의 최대값을 찾고 해당 요소 값과 더하여 누적시켜나간다.
     * 마지막 행까지 이를 수행하고, 마지막 행에서는 최종적으로 누적된 값이 가장 큰 요소 찾아 리턴한다.
     */
    public static int solution(int[][] land){
        int rs = 0;
        for(int i=1; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){

                // 이전 행(i-1)의 최댓값을 찾는다.
                int max = 0;
                for(int k=0; k<4; k++){
                    if(k == j) continue; // 동일 열은 제외
                    if( land[i-1][k] > max){
                        max = land[i-1][k];
                    }
                }
                // 찾은 최댓값을 해당 요소 값과 더하여 누적시킨다.
                land[i][j] += max;
                // 마지막 행에서 누적된 값이 가장 큰 요소를 찾아 이를 결과값에 저장한 뒤 리턴.
                if((i == land.length-1) && (land[i][j] > rs)){
                    rs = land[i][j];
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
        System.out.println(solution(new int[][]{{4,3,2,1},{2,2,2,1},{6,6,6,4},{8,7,6,5}}));
        System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,100},{4,3,2,200}}));
    }
}
