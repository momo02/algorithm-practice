package practice.algorithm.codility.lessons.stacks_and_queues.fish;


import java.util.Stack;

/**
 * N 개의 정수로 구성된 두 개의 비어 있지 않은 배열 A와 B
 *
 *
 * 배열 A와 B는 강의 흐름을 따라 하류로 정렬 된 강에있는 N 개의 탐욕스러운 물고기를 나타냅니다.
 * 물고기는 0에서 N-1까지 번호가 매겨집니다. P와 Q가 두 물고기이고 P <Q이면 물고기 P는 처음에 물고기 Q의 상류에 있습니다. 처음에는 각 물고기가 고유 한 위치를 갖습니다.
 *
 *
 * 물고기 수 P는 A [P]와 B [P]로 표시됩니다. 배열 A는 물고기의 크기를 포함합니다. 모든 요소는 고유합니다. 배열 B는 물고기의 방향을 포함합니다. 0 및 / 또는 1 만 포함합니다.
 *
 * 0은 상류로 흐르는 물고기를 나타내고,
 * 1은 하류로 흐르는 물고기를 나타냅니다.
 *
 * 두 물고기가 반대 방향으로 움직이고 그들 사이에 다른 (살아있는) 물고기가 없으면 결국 서로 만날 것입니다.
 *
 * 그러면 한 마리의 물고기 만 살아남을 수 있습니다. 큰 물고기가 작은 물고기를 먹습니다.
 *
 * 보다 정확하게는 P <Q, B [P] = 1, B [Q] = 0 일 때 두 물고기 P와 Q가 서로 만나고 그 사이에 살아있는 물고기가 없다고 말합니다
 *
 * A [P]> A [Q]이면 P는 Q를 먹고 P는 여전히 하류로 흐르고
 * A [Q]> A [P]이면 Q가 P를 먹고 Q는 여전히 상류로 흐릅니다.
 *
 * 우리는 모든 물고기가 같은 속도로 흐르고 있다고 가정합니다. 즉, 같은 방향으로 움직이는 물고기는 만나지 않습니다. 목표는 살아남을 물고기의 수를 계산하는 것
 *
 *   A[0] = 4    B[0] = 0
 *   A[1] = 3    B[1] = 1
 *   A[2] = 2    B[2] = 0
 *   A[3] = 1    B[3] = 0
 *   A[4] = 5    B[4] = 0
 *
 * 처음에는 모든 물고기가 살아 있고 1 번 물고기를 제외한 모든 물고기가 상류로 이동하고 있습니다.
 *
 * 1 번 물고기가 2 번 물고기를 만나 먹다가 3 번 물고기를 만나서 먹습니다
 *
 * 마지막으로 물고기 번호 4를 만나서 먹힘 당한다.
 * 남아있는건 0번째 4번째
 * 같은 방향이니까 (위로가는) 절대 안만나 서 살아남음. Return 2
 *
 * N 개의 정수로 구성된 두 개의 비어 있지 않은 배열 A와 B가 주어지면 살아남을 물고기의 수를 반환합니다
 *
 * 가정
 * N은 [1..100,000] 범위 내의 정수
 * 배열 A의 각 요소는 [0..1,000,000,000] 범위 내의 정수
 * 배열 B의 각 요소는 다음 값 중 하나를 가질 수있는 정수입니다. 0, 1;
 * A의 요소는 모두 구별(다 다른값)
 */
public class Solution {

    // best case 참고
    public static int solution2(int[] A, int[] B) {
        // write your code in Java SE 8
        Stack<Integer> down = new Stack<>();
        int lastSize;
        int aliveCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) down.push(A[i]);
            else {
                while (!down.isEmpty()) {
                    lastSize = down.peek();
                    if (lastSize > A[i]) break;
                    else down.pop();
                }
                //stack 이 비었다면 상류로 가는 해당 물고기가 살아남은 것.
                if (down.isEmpty()) aliveCount++;
            }
        }
        return aliveCount + down.size();
    }

    public static int solution(int[] A, int[] B) {
        // write your code in Java SE 8

        Stack<Integer> alive = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            System.out.println(">>>> i : " + i);
            System.out.println(">>>> A[i] : " + A[i]);

            if (B[i] == 0) { //상류 방향 물고기라면
                if (alive.empty()){
                    alive.push(i);
                }else{
                   Integer prevIdx = alive.get(alive.size()-1);

                   if(B[prevIdx] == 0){ //방향이 같으면 그냥 push
                       alive.push(i);
                   }else{
                        // 다음 상류방향 물고기가 더 크면
                        if(A[prevIdx] < A[i]){
                            alive.pop();

                            boolean isEaten = false;
                            //stack 살아있는 물고기 체크
                            while (!isEaten){
                               if(alive.empty()) break;
                                Integer prevIdx2 = alive.get(alive.size()-1);
                                System.out.println(">>> prevIdx2 : " + prevIdx2);
                                 //방향이 다르면
                                if(B[prevIdx2] == 1){
                                    if(A[prevIdx2] > A[i]){
                                        isEaten = true;
                                        break;
                                    }else{
                                        alive.pop();
                                    }
                                }else break;
                            }

                            if(!isEaten) alive.push(i);
                        }
                   }
                }

            } else { //하류 방향 물고기라면
                alive.push(i);
            }
            System.out.println(">>>> alive : " + alive.toString());
        }
        return alive.size();
    }

    public static void main(String[] args) {
        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};

        int[] C = {4,3,2,1,5};
        int[] D = {1,1,0,0,0};

        int[] E = {6,5,4,3,1,7};
        int[] F = {1,0,0,0,0,1};

        System.out.println( solution2(A,B)); // 2
        System.out.println( solution2(C,D)); // 1
        System.out.println( solution2(E,F)); // 2
    }
}
