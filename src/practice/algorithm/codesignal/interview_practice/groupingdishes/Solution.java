package practice.algorithm.codesignal.interview_practice.groupingdishes;

import practice.algorithm.codesignal.interview_practice.removekfromlist.ListNode;

import java.util.Arrays;

public class Solution {

    public static String[][] groupingDishes(String[][] dishes) {
        String[][] rs = new String[0][];
        for(int i = 0; i<dishes.length; i++){

        }
        return rs;
    }


    public static void main(String[] args) {

        String[][] dishes = {
                {"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}
        };

//        groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
//                            ["Salad", "Salad", "Sandwich"],
//                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
//                            ["Tomato", "Pizza", "Salad", "Sandwich"]]

        String[][] dishes2 = {
                {"Pasta", "Tomato Sauce", "Onions", "Garlic"},
                {"Chicken Curry", "Chicken", "Curry Sauce"},
                {"Fried Rice", "Rice", "Onions", "Nuts"},
                {"Salad", "Spinach", "Nuts"},
                {"Sandwich", "Cheese", "Bread"},
                {"Quesadilla", "Chicken", "Cheese"}};

//        groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
//                            ["Chicken", "Chicken Curry", "Quesadilla"],
//                            ["Nuts", "Fried Rice", "Salad"],
//                            ["Onions", "Fried Rice", "Pasta"]]

        String rs[][] = groupingDishes(dishes);
        String rs2[][] = groupingDishes(dishes2);

        System.out.println(Arrays.toString(rs));
        System.out.println(Arrays.toString(rs2));

    }
}

