package practice.algorithm.programmers.practice.level2.N개의_최소공배수;

/**
 * N개의 최소공배수
 * [문제 설명]
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다.
 * 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * [제한 사항]
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 *
 * [입출력 예]
 * arr	        result
 * [2,6,8,14]	168
 * [1,2,3]	    6
 */
public class Solution {

    /**
     * 풀이 참고
     * cf) 유클리드 호제법 (https://tech.lonpeach.com/2017/11/12/Euclidean-algorithm/)
     */
    public static int gcd(int a, int b){
        //System.out.println(">>> a : b : " +  a + ":"+  b);
        if(a % b == 0){
            return b;
        }else{
            return gcd(b, a%b);
        }
    }

   public static int lcs(int a, int b){
        return a * b / gcd(a,b);
   }

    public static  int solution(int[] arr) {
        int answer = arr[0];

        for(int i =1; i<arr.length ; i++){
            answer = lcs(answer, arr[i]);
        }
        return answer;
    }

// 오답 ..
//    public static  int solution3(int[] arr) {
//        int answer = 1;
//
//        boolean stop = false;
//        int d = 2;
//        //int or = 1;
//
//        ArrayList<Integer> arrList = new ArrayList<>();
//
//        int[] tmp = new int[arr.length];
//        while(!stop){
//            boolean allD = true;
//
//            for(int i =0; i<arr.length; i++){
//                if(!arrList.contains(arr[i])) arrList.add(arr[i]);
//                //or *= arr[i];
//                if(!stop) {
//                    if ((arr[i] % d) != 0) {
//                        allD = false;
//                        if (arr[i] / d < 1) {
//                            stop = true;
//                        } else {
//                            d++;
//                            break;
//                        }
//                    } else {
//                        tmp[i] = arr[i] / d;
//                        //or *= arr[i];
//                    }
//                }
//            }
//
//            if(!stop){  //모든 수가 d로 나누어짐.
//                if(allD){
//                    arr = tmp;
//                    answer *= d;
//                }
//                //or = 1;
//                arrList.clear();
//            }else{
//                //answer *= or;
//                for(int i=0; i< arrList.size(); i++){
//                    answer *= arrList.get(i);
//                }
//
//            }
//        }
//        return answer;
//    }

    public static void main(String[] args) {
        System.out.println( solution(new int[]{1,3,4,7}));
        System.out.println( solution(new int[]{2,6,8,14}));
        System.out.println( solution(new int[]{1,2,3}));
        System.out.println( solution(new int[]{3,6,9}));
        System.out.println( solution(new int[]{9, 6, 3}));
        System.out.println( solution(new int[]{1, 2, 1, 2}));
    }
}
