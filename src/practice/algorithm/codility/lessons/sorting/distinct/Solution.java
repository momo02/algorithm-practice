package practice.algorithm.codility.lessons.sorting.distinct;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    /**
     * HashSet 활용.
     * @param A
     * @return
     */
    public static int solution(int[] A){
        HashSet<Integer> nums = new HashSet<>();

        for(int a : A){
            nums.add(a);
        }
        return nums.size();
    }

//    public static int solution(int[] A) {
//        int rs = -1;
//
//        //우선 sort
//        for(int i = 0; i<A.length; i++){
//            for(int j =i+1; j<A.length; j++){
//                int tmp;
//                if(A[j] < A[i]){
//                    tmp = A[i];
//                    A[i] = A[j];
//                    A[j] = tmp;
//                }
//            }
//        }
//
//        //System.out.println("after sorting : " + Arrays.toString(A));
//        //sort 이후부터는 i 와 i + 1가 같지 않을 경우를 체크
//
//        int pIdx = 0;
//        for(int i = 1; i<A.length; i++) {
//            if(A[pIdx] != A[i]){
//                if(pIdx == 0){
//                    return A[pIdx];
//                } else if(i + 1 == A.length){
//                    return A[i];
//                }else if(A[pIdx] != A[pIdx-1]){
//                    return A[pIdx];
//                }else if(A[i] != A[i+1]){
//                    return A[i];
//                }
//            }
//            pIdx = i;
//        }
//        return rs;
//    }


//    public static int solution(int[] A) {
//        final int flag = 1000001;
//        int rs = -1;
//
//        for(int i=0; i<A.length; i++){
//            boolean dp = false;
//            if(A[i] == flag) continue;
//
//            for(int j=i+1; j<A.length; j++){
//                if(A[i] == A[j]){
//                    dp = true;
//                    A[j] = flag;
//                }
//            }
//            if(dp) A[i] = flag;
//        }
//
//        for(int i =0; i<A.length; i++){
//            if(A[i] != flag){
//                rs = A[i];
//                break;
//            }
//        }
//
//        return rs;
//    }

    public static void main(String[] args) {

        int[] a = {2,1,1,2,3,1}; //3
        int[] b = {2,-10,1,2,3,1,3}; //4
        int[] c = {2,-10,1,2,10,1,-3}; //5

        System.out.println( Arrays.toString(a) + " : " + solution(a));
        System.out.println( Arrays.toString(b) + " : " + solution(b));
        System.out.println( Arrays.toString(c) + " : " + solution(c));

    }
}
