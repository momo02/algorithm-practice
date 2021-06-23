package practice.algorithm.programmers.practice.level2.땅따먹기;

/**
 *
 */
public class Solution {

    public static int solution(int[][] land){
        int answer = 0, prevRowMaxIdx = -1;
        for(int i =0; i<land.length; i++){
            int max = 0, maxIdx = -1, sameMaxCnt = 0;
            for(int j=0; j<land[i].length; j++){
                if(land[i][j] >= max){
                    if(j == prevRowMaxIdx && sameMaxCnt <= 1) continue;
                    if(land[i][j] == max) sameMaxCnt ++;
                    max = land[i][j];
                    maxIdx = j;
                }
            }
            System.out.println(max);
            answer += max;
            prevRowMaxIdx = maxIdx;
        }
        return answer;
    }

//    public static int solution(int[][] land){
//        int answer = 0, prevRowMaxIdx = -1;
//        for(int i =0; i<land.length; i++){
//            int max = 0, maxIdx = -1;
//            for(int j=0; j<land[i].length; j++){
//                if(j != prevRowMaxIdx && land[i][j] > max){
//                    max = land[i][j];
//                    maxIdx = j;
//                }
//            }
//            System.out.println(max);
//            answer += max;
//            prevRowMaxIdx = maxIdx;
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
        System.out.println(solution(new int[][]{{4,3,2,1},{2,2,2,1},{6,6,6,4},{8,7,6,5}}));
    }
}
