package practice.algorithm.programmers.practice.test.p1;

import java.util.Arrays;

public class Solution {


    public static int solution(int n) {
        int cnt = n;
        int[] rs = new int[n];
        for(int i =1; i<n; i++){
            for(int j=i; j<n; j+=(i+1)){
                if((j+1)%(i+1) == 0){
                    if(rs[j] == 1){
                        rs[j] = 0;
                        cnt++;
                    }else{
                        rs[j] = 1;
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }

    public static int solution6(int n) {
        int cnt = n;
        int[] rs = new int[n];
        for(int i =1; i<n; i++){
            for(int j=i; j<n; j+=(i+1)){
                if((j+1)%(i+1) == 0){
                    if(rs[j] == 1){
                        rs[j] = 0;
                        cnt++;
                    }else{
                        rs[j] = 1;
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }

    public static int solution5(int n) {
        int cnt = n;
        int[] rs = new int[n];
        for(int i =1; i<n; i++){
            for(int j=i; j<n; j+=(i+1)){
                if((j+1)%(i+1) == 0){
                    rs[j] = (rs[j] == 1 ? 0 : 1);
                    if(rs[j] == 0){
                        cnt++;
                    }else cnt--;
                }
            }
        }
        return cnt;
    }

    public static int solution4(int n) {
        int cnt = n;
        int[] rs = new int[n];
        for(int i =1; i<n; i++){
            int j = i;
            System.out.println(">>>> i " + i);

            while(j<n){
                System.out.println(">>>> j " + j);
                if( (j+1) % (i+1) == 0){
                    rs[j] = (rs[j] == 1 ? 0 : 1);
                    if(rs[j] == 0){
                        cnt++;
                    }else cnt--;
                }
                j += (i + 1);
            }
        }
        return cnt;
    }

    public static int solution3(int n) {
        int cnt = n;
        int[] rs = new int[n];
        for(int i =1; i<n; i++){
            int j = 0;
            while(j<n){
                if( (j+1) % (i+1) == 0){
                    rs[j] = (rs[j] == 1 ? 0 : 1);
                    if(rs[j] == 0){
                        cnt++;
                    }else cnt--;
                }
                j += (i);
            }
//            for(int j=0; j<n; j++){
//                if( (j+1) % (i+1) == 0){
//                    rs[j] = (rs[j] == 1 ? 0 : 1);
//                    if(rs[j] == 0){
//                        cnt++;
//                    }else cnt--;
//                }
//            }
        }
        return cnt;
    }

    public static int solution2(int n) {
        int cnt = n;
        int[] rs = new int[n];
        for(int i =1; i<n; i++){
            for(int j=0; j<n; j++){
                if( (j+1) % (i+1) == 0){
                    rs[j] = (rs[j] == 1 ? 0 : 1);
                    if(rs[j] == 0){
                        cnt++;
                    }else cnt--;
                }
            }
        }
        return cnt;
    }

    public static int solution1(int n) {

        int[] rs = new int[n];
        for(int i =1; i<n; i++){
            //System.out.println("i>>" + i);
            //int[] rs = new int[n];
            for(int j=0; j<n; j++){
                //System.out.print("j>>" + j);

                if( (j+1) % (i+1) == 0){
                    rs[j] = (rs[j] == 1 ? 0 : 1);
                }//else{
                 //   rs[j] = 0;
                //}
            }
            //System.out.println(Arrays.toString(rs));
        }
        return (int) Arrays.stream(rs).filter(k -> k==0).count();
    }
    public static void main(String[] args) {
        System.out.println(solution(2)); //1
        System.out.println(solution(3));//1
        System.out.println(solution(5));//2
        System.out.println(solution(6));//2
        System.out.println(solution(7));//2
        System.out.println(solution(8));//2
        System.out.println(solution(9));//3
        System.out.println(solution(10));//3
        System.out.println(solution(11));//3
        System.out.println(solution(12));//3

       // System.out.println(solution(6));
        //System.out.println(solution(7));
        Test2 t2 = new Test2();
        t2.sabun = 1234;
        t2.name = "박정하";

        System.out.println(t2.test1());
        System.out.println(t2.test2());

    }
}
