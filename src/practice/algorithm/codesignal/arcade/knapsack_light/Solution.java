package practice.algorithm.codesignal.arcade.knapsack_light;


public class Solution {

    /**
     * Best Case
     */
    public static int knapsackLight2(int value1, int weight1, int value2, int weight2, int maxW) {
        int val = 0;

        if (weight1 + weight2 <= maxW) return value1 + value2;

        if (weight1 <= maxW) {val = value1;}

        if (weight2 <= maxW && value2 > val) val = value2;

        return val;
    }

    public static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {

        if(weight1 + weight2 > maxW){ //value 큰거 1개만
            //수용가능한지 체크
            if(weight1 <= maxW && weight2 <= maxW){
                return (value1 > value2 ? value1 : value2);
            } else if(weight1 <= maxW){
                return value1;
            } else if(weight2 <= maxW) {
                return value2;
            } else return 0;

        }else{
            return value1 + value2;
        }
    }

    public static void main(String[] args) {
        if(7 == knapsackLight2(5,3,7,4,6) &&
           16 == knapsackLight2(10,5,6,4,9)){
            System.out.println("정답!");
        }else{
            System.out.println("오답!");
        }
    }
}