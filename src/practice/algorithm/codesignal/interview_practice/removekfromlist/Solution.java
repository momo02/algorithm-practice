package practice.algorithm.codesignal.interview_practice.removekfromlist;

public class Solution {


    public static ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> fl = null, nl = null;
        ListNode<Integer> tl = l;

        while(tl != null){
            if(tl.value != k) {
                if(nl == null){
                    nl = new ListNode<>(tl.value);
                    fl = nl;
                } else {
                    nl.next = new ListNode<>(tl.value);
                    nl = nl.next;
                }
            }
            tl = tl.next;
        }
        return fl;
    }

    public static void main(String[] args) {

        int[] ks = {
                3,10,5
        };

        int[][] cmd = {
                {3, 1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 5, 6, 7},
        };
        int[][] rs = {
                {1, 2, 4, 5},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4, 6, 7},
        };


        for(int i=0; i<cmd.length; i++){
            // add ListNode
            ListNode<Integer> f = new ListNode<Integer>(cmd[i][0]);
            ListNode<Integer> tf = f;
            for(int j=1; j<cmd[i].length; j++) {
                tf.next = new ListNode<Integer>(cmd[i][j]);
                tf = tf.next;
            }

            System.out.print(">>>> k : " +  ks[i] + ", ");

            ListNode<Integer> rmRs = removeKFromList(f, ks[i]);

            // check
            ListNode<Integer> tnxt = rmRs;

            while(null != tnxt){
                System.out.print(tnxt.value);
                tnxt = tnxt.next;

            }
        }



//        long startTime = System.nanoTime();
//
//        for(int i =0; i< commands[i].length; i++){
//            if(answer[i] == removeKFromList(commands[i], ks[i])){
//                System.out.println((i+1) + ". 정답!");
//            }else{
//                System.out.println((i+1) + ". 오답!");
//            }
//        }
//        long endTime = System.nanoTime();
//
//        long resultTime = (endTime - startTime);
//        System.out.println("수행 시간 : " + resultTime +"ns(나노타임/세크)");
    }
}
