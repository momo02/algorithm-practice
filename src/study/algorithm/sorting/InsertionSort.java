package study.algorithm.sorting;

import java.util.Arrays;

/**
 * 삽입 정렬
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {7,5,9,0,3,1,6,2,4,8};

        for(int i=1; i<array.length; i++){
            for(int j= i; j> 0; j--){
                if(array[j-1] > array[j]){
                    //스와프(Swap)
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
                // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤.
                else break;
            }
        }
        //출력
        System.out.println(Arrays.toString(array));
    }
}
