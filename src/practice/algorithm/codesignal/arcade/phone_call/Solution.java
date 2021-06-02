package practice.algorithm.codesignal.arcade.phone_call;

public class Solution {

    /**
     * Best Case
     */
    public static int phoneCall2(int min1, int min2_10, int min11, int s) {
        int t1=min1+ min2_10*9;
        if (s>=t1){
            return 10+(s-t1)/min11;
        }
        if (s>=min1){
            return (s-min1)/min2_10+1;
        }
        return 0;
    }

    public static int phoneCall(int min1, int min2_10, int min11, int s) {
        int m = 1;
        int cur_s = s - min1;
        if(cur_s < 0) return 0;

        if((cur_s / min2_10) < 9){
            m += (cur_s / min2_10);
            return m;
        }else{
            m += 9;
            cur_s -= (min2_10 * 9);
            m += (cur_s / min11);
            return m;
        }
    }

    public static void main(String[] args) {
        if(14 == phoneCall2(3,1,2,20) ){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}