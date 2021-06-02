package practice.algorithm.codesignal.interview_practice.has_path_with_given_sum;

public class Solution {

    /**
     * Best Case
     * - 답 참조..
     * @param t
     * @param s
     * @return
     */
    public static boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        //If just one of left or right was null, then it was not a child node and false can be returned safely
        if(t == null) return false;

        //If this is a child AND sum is input, then we have a path
        if(t.left == null && t.right == null) {
            return (s == t.value);
        }

        return hasPathWithGivenSum(t.left, s-t.value) || hasPathWithGivenSum(t.right, s-t.value);
    }

    public static void main(String[] args) {
        Tree<Integer> rt = new Tree<>(4);

        Tree<Integer> rt_l = new Tree<>(1);
        Tree<Integer> rt_l_l =  new Tree<>(-2);
        Tree<Integer> rt_l_l_r =  new Tree<>(3);

        rt_l_l_r.left = null;
        rt_l_l_r.right = null;

        rt_l_l.left = null;
        rt_l_l.right = rt_l_l_r;

        rt_l.left = rt_l_l;
        rt_l.right = null;

        Tree<Integer> rt_r = new Tree<>(3);
        Tree<Integer> rt_r_l = new Tree<>(1);
        Tree<Integer> rt_r_r = new Tree<>(2);

        Tree<Integer> rt_r_r_1 = new Tree<>(-2);
        Tree<Integer> rt_r_r_r = new Tree<>(-3);

        rt_r_l.left = null;
        rt_r_l.right = null;

        rt_r_r_1.left = null;
        rt_r_r_1.right = null;

        rt_r_r_r.left = null;
        rt_r_r_r.right = null;

        rt_r_r.left = rt_r_r_1;
        rt_r_r.right = rt_r_r_r;

        rt_r.left = rt_r_l;
        rt_r.right = rt_r_r;

        rt.left = rt_l;
        rt.right = rt_r;

        if(true == hasPathWithGivenSum(rt, 7)){
            System.out.print("정답!");
        }else{
            System.out.print("오답!");
        }
    }

}
