package practice.algorithm.codesignal.interview_practice.firstduplicate;

/**
 * Given an array a that contains only numbers in the range from 1 to a.length,
 * find the first duplicate number for which the second occurrence has the minimal index.
 * In other words, if there are more than 1 duplicated numbers,
 * return the number for which the second occurrence has a smaller index than the second occurrence of the other number does.
 * If there are no such elements, return -1.
 */
public class Solution {

    public static int firstDuplicate(int[] a) {
        int min_sdo_idx = 0;
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if(a[i] == a[j]){
                    if(min_sdo_idx == 0){
                        min_sdo_idx = j;
                    }else{
                        if( j < min_sdo_idx ) min_sdo_idx = j;
                    }
                    break;
                }
            }
        }
        return (min_sdo_idx != 0 ? a[min_sdo_idx] : -1);
    }

    public static void main(String[] args) {

        int[][] commands = {
                {2, 1, 3, 5, 3, 2},
                {2, 2},
                {2, 4, 3, 5, 1},
                {1}
        };
        int[] answer = {3,2,-1,-1};

        long startTime = System.nanoTime();

        for(int i =0; i< commands[i].length; i++){
            if(answer[i] == firstDuplicate(commands[i])){
                System.out.println((i+1) + ". 정답!");
            }else{
                System.out.println((i+1) + ". 오답!");
            }
        }
        long endTime = System.nanoTime();

        long resultTime = (endTime - startTime);
        System.out.println("수행 시간 : " + resultTime +"ns(나노타임/세크)");
    }
}
