package study.algorithm.sorting;

import java.util.Arrays;

/**
 * 선택 정렬
 */
public class SelectionSort {
    public static void main(String[] args) {

        int[] array = {7,5,9,0,3,1,6,2,4,8};

        for(int i=0; i<array.length; i++){
            for(int j= i + 1; j< array.length; j++){
                //스와이프
                if(array[j] < array[i]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        //출력
        System.out.println(Arrays.toString(array));
    }
}
