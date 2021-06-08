package practice.algorithm.programmers.practice.level1.최대공약수와_최소공배수;

import java.util.Arrays;

public class Solution {


    /**
     * 풀이 참고
     * cf) 유클리드 호제법 (https://tech.lonpeach.com/2017/11/12/Euclidean-algorithm/)
     * @param n
     * @param m
     * @return
     */
    public static int[] solution(int n, int m) {
        int gcd = 0;
        if(n > m){
            gcd = gcd(n,m);
        }else{
            gcd = gcd(m,n);
        }
        //System.out.println(gcd);
        return new int[]{ gcd, (n*m) /gcd};
    }

    // 재귀함수 사용
    public static int gcd(int a, int b) {
       int r = a % b;
       if(r == 0) return b;
       return gcd(b, r);
    }

//    public static int gcd(int a, int b) {
//        while(b != 0){
//            int r = (a % b);
//            a = b;
//            b = r;
//        }
//        return a;
//    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,12)));
        System.out.println(Arrays.toString(solution(2,5)));
    }
}
