package practice.algorithm.codility.lessons.dynamic_programming.min_abs_sum;

/**
 * MinAbsSum
 */
public class Solution {


//    public static void get(int min, int k, int[] A, int i) {
//        if(i >= A.length-1) {
//            int abs_k = Math.abs(k);
//            System.out.println("abs_k : " + abs_k);
//            System.out.println("min : " + min);
//            if(min == -1 || Math.abs(k) < min) {
//                System.out.println("왜 여기 안타");
//                min = abs_k;
//            }
//            System.out.println("after min : " + min);
//            return;
//        }
//        int a = k + A[i + 1];
//        int b = k - A[i + 1];
//
//        get(min, a, A, i + 1);
//        get(min, b, A, i + 1);
//    }

//    public static int get(int k, int[] A, int i) {
//        if(i == A.length-1) {
//            return Math.abs(k);
//        }
//        int a = k + A[i + 1];
//        int b = k - A[i + 1];
//
//        int aa = get(a, A, i + 1);
//        int bb = get(b, A, i + 1);
//
//        return aa < bb ? aa : bb;
//    }


    // 정확상 테스트 통과, 효율성 테스트 실패
    // https://app.codility.com/demo/results/trainingR2N2UG-V8C/
    public static int get(int k, int[] A, int i) {
        if(i == A.length-1) {
            return Math.abs(k);
        }
        int a = k + A[i + 1];
        int b = k - A[i + 1];
        System.out.println(">>>> a : " + a);
        System.out.println(">>>> b : " + b);
        int aa = get(a, A, i + 1);
        int bb = get(b, A, i + 1);
        System.out.println(">>>>>> aa : " + aa);
        System.out.println(">>>>>> bb : " + bb);
        return aa < bb ? aa : bb;
    }


    public static int solution(int[] A) {
        if(A.length == 0) return 0;
        return get(A[0],A,0);
    }


//    public static void get(HashSet<Integer> arr, int k, int[] A, int i) {
//        if(i >= A.length-1) {
//
//            arr.add(Math.abs(k));
//            return;
//        }
//        int a = k + A[i + 1];
//        int b = k - A[i + 1];
//
//        get(arr, a, A, i + 1);
//        get(arr, b, A, i + 1);
//    }
//
//    public static int solution(int[] A) {
//        if(A.length == 0) return 0;
//
//        HashSet<Integer> arr = new HashSet<>();
//        get(arr,A[0],A,0);
//
//        Object[] s = arr.toArray();
//        Arrays.sort(s);
//
//        System.out.println(">>>> arr" + arr);
//        //System.out.println(">>>> min : " + s[0]);
//        return (int) s[0];
//    }

//    public static void get(ArrayList<Integer> arr, int k, int[] A, int i) {
//       // if(i >= A.length) return;
//
//        if(i >= A.length-1) {
//            arr.add(k);
//            return;
//        }
//
//        int a = k + A[i + 1];
//        int b = k - A[i + 1];
//
//        get(arr, a, A, i + 1);
//        get(arr, b, A, i + 1);
//    }
//
//    public static int solution(int[] A) {
//
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        get(arr,A[0],A,0);
//
//        OptionalInt min = arr.stream().mapToInt(i -> Math.abs(i)).min();
//
//        System.out.println(">>>> arr" + arr);
//        //System.out.println(">>>> int : " + min.getAsInt());
//        return min.getAsInt();
//    }

    public static int solution_1(int[] A) {
        // write your code in Java SE 8
        int rs = 0;
        for(int i=0; i<A.length; i++){
           rs = Math.min(Math.abs(rs - A[i]), Math.abs(rs + A[i]));
           //System.out.println(">>>> rs : " + rs);
        }
        return rs;
    }

    public static void main(String[] args) {
       // System.out.println( solution(new int[]{1, 5, 2, -2}));
        //System.out.println( solution(new int[]{-1, -5, -2, -2}));
        System.out.println( solution(new int[]{-100, -5, -2, -2, -100})); //  1이 나와야해
        //System.out.println( solution(new int[]{-100, -5, -2}));
       // System.out.println( solution(new int[]{})); //
    }
}
