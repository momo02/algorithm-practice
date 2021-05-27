package practice.algorithm.codility.binarygap;

public class Solution {

    public static int solution(int N) {
        int idx = 0;
        int st = -1;
        int max0 = 0;

        while(N/2 > 0 || (N/2 == 0 && N % 2 ==1)){
            if(N % 2 == 1){
                if (st != -1) {
                    if (idx - st - 1 > max0) {
                        max0 = (idx - st - 1);
                    }
                }
                st = idx;
            }
            N /= 2;
            idx++;
        }
        return max0;
    }

    public static void main(String[] args) {

        System.out.println(solution(1041)); //5
        System.out.println(solution(529)); //4
        System.out.println(solution(32)); //0
        System.out.println(solution(15)); //0
        System.out.println(solution(20)); //1
        System.out.println(solution(9)); //2
    }
}
