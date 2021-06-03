package practice.algorithm.codesignal.arcade.tennis_set;

/**
 * [문제]
 * 테니스에서 세트의 승자는 각 플레이어가 이기는 게임 수에 따라 결정.
 *
 * 상대방이 이미 5게임을 이긴 경우가 아니면, 6게임을 먼저 이긴 플레이어가 승자.
 * 상대방이 5게임을 이긴 경우 플레이어 중 한명이 7게임을 이길 때까지 세트가 계속됨.
 *
 * score1과 score2의 두 정수가 주어지면,
 * 당신의 임무는 최종 점수가 score1 : score2 인 테니스 세트가 끝날 수 있는지 결정하는 것.
 *
 * [예시]
 * 1) score1 = 3 및 score2 = 6의 경우 tennisSet (score1, score2) = true.
 * 플레이어 1이 5 승에 도달하지 못했 플레이어 2가 6게임을 이겼으므로.
 *
 * 2) score1 = 8 및 score2 = 5의 경우 tennisSet (score1, score2) = false.
 * 두 선수 모두 최소 5승 이상을 이겼기 때문에 한 명이 7승을 거두면 세트가 종료되었을 것.
 *
 * 3) score1 = 6 및 score2 = 5의 경우 tennisSet (score1, score2) = false.
 * 이 세트는이 플레이어 중 한 명이 7 번째 게임에서 이길 때까지 계속되므로 최종 점수가 될 수 없다.
 *
 * [조건]
 * [input] integer score1 : 첫 번째 플레이어가이긴 게임 수, 음이 아닌 정수
 * 0 ≤ score1 ≤ 10.
 * [input] integer score2 :  번째 플레이어가이긴 게임 수, 음이 아닌 정수
 * 0 ≤ score2 ≤ 10.
 * [output] boolean
 * score1 : score2 가 종료 된 세트의 가능한 점수를 나타내는 경우 true, 그렇지 않으면 false.
 *
 * cf) 문제가 좀 헷갈렸다.
 * score1, score2 점수가 게임을 종료시킬 수 있는 위 조건에 정확히 부합하는 '종료 시점'의 점수일 경우에만 true를 반환.
 * 예시를 봐야 이해가 되는데, 예를 들어 2번 예시 처럼 8 : 5 로 이미 종료 시점이 지난 점수의 경우는 true가 아닌 false를 반환.
 */
public class Solution {

    /**
     * Best case
     *  -> Math max,min함수 로 이긴 플레이어와 진 플레이어의 점수를 구해서 조건을 줄임.
     *  -> w(이긴 플레이어 점수)가 7일 경우 l(진 플레이어 점수)는 5나 6일 경우만 체크함.
     *     -> 5보다 작을 경우엔 이긴 플레이어가 6승일 때 세트가 종료되었을 것이기 때문.
     */
    static boolean tennisSet2(int sc1, int sc2) {
        int w = Math.max(sc1, sc2), l = Math.min(sc1, sc2);
        return w == 6 && l < 5 || w == 7 && (l == 5 || l == 6);
    }

    /**
     * 종료될 조건 :
     * 1) score 중 1개가 5보다 작고, 1개는 6일 경우,
     * 2) score 둘 다 5 이상이고, 둘 중 1개가 7일 경우
     * cf) 예외케이스 주의
     *   7:7 로 동점일 경우에는 게임이 종료 될 수 없음.
     *   (문제에서 세트는 플레이어 중 한 명이 7 번째 게임에서 승리 할 때까지 계속된다고 했으므로)
     */
    static boolean tennisSet(int sc1, int sc2) {
        return  (sc1 >= 5 && sc2 >= 5 && sc1 == 7 && sc2 < 7) ||
                (sc1 >= 5 && sc2 >= 5 && sc2 == 7 && sc1 < 7) ||
                (sc1 < 5 && sc2 == 6) || (sc2 < 5 && sc1 == 6);
    }

    public static void main(String[] args) {
        boolean ex1 =  tennisSet2(3,6);
        boolean ex2 =  !tennisSet2(8,5);
        boolean ex3 =  !tennisSet2(6,5);
        boolean ex4 =  tennisSet2(7,5);

        if(ex1 && ex2 && ex3 && ex4){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}