package practice.algorithm.codesignal.interview_practice.grouping_dishes;

import practice.algorithm.utils.StopWatch;

import java.util.*;

public class Solution {

    /**
     * Popular case
     *
     * 속도(ns):57164655
     * 속도(ns):75974499
     * 속도(ns):55908830
     * 속도(ns):62184779
     * 속도(ns):80540038
     * 속도(ns):69807234
     */
    public static String[][] groupingDishes2(String[][] dishes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String[] ingred: dishes){
            for(int i = 1; i < ingred.length; i++){
                if(map.containsKey(ingred[i])){
                    ArrayList<String> foods = map.get(ingred[i]);
                    foods.add(ingred[0]);
                    map.put(ingred[i],foods);
                }else{
                    ArrayList<String> foods = new ArrayList<>();
                    foods.add(ingred[0]);
                    map.put(ingred[i],foods);
                }
            }
        }

        ArrayList<String[]> list = new ArrayList<>();
        for(String ingred:map.keySet()){
            ArrayList<String> foods = map.get(ingred);
            if(foods.size()>1){
                Collections.sort(foods);
                String[] fin = new String[foods.size()+1];
                fin[0]=ingred;
                for(int i = 0; i < foods.size(); i++)
                    fin[i+1]=foods.get(i);
                list.add(fin);
            }
        }

        Collections.sort(list, (a, b) -> a[0].compareTo(b[0]));

        // TODO new String[4][] 가 아니라  String[0][] 으로 해도 왜 되는건지.. ?
        return list.toArray(new String[0][]);
    }

    /**
     * 내 풀이
     * 속도(ns):686485
     * 속도(ns):584978
     * 속도(ns):697891
     * 속도(ns):856315
     * 속도(ns):624207
     * 속도(ns):921382
     * 속도(ns):652849
     *
     * @param dishes
     * @return
     */
    public static String[][] groupingDishes(String[][] dishes) {
        HashMap<String, ArrayList<String>> m = new HashMap<>();
        int r_cnt = 0;
        for(int i = 0; i<dishes.length; i++){
            for(int j=1; j<dishes[i].length; j++){
                String ds = dishes[i][0];
                String id = dishes[i][j];

                ArrayList<String> al = null;
                if(m.containsKey(id)){
                    al = m.get(id);
                    al.add(ds);
                    if(al.size() == 2) r_cnt++;
                }else{
                    al = new ArrayList<>();
                    al.add(ds);
                }
                m.put(id , al);
            }
        }

        //System.out.println(r_cnt);
        String[][] rs = new String[r_cnt][];

        int y = 0;
        String[] ci = new String[r_cnt];

        for(String key : m.keySet()) {
            ArrayList<String> dss = (ArrayList<String>) m.get(key);
            if(dss.size() > 1){
                ci[y++] = key;
            }
        }

        // 공통 재료 정렬
        sort(ci);
//        System.out.println("////공통 재료 정렬 이후 : ");
//        System.out.println(Arrays.toString(ci));

        // 요리 정렬
        for(int i =0; i<ci.length; i++){
            ArrayList<String> dss = m.get(ci[i]);

            // ArrayList -> String[]
            String[] dss2 = new String[dss.size()];
            for(int j=0; j<dss2.length; j++){
                dss2[j] = dss.get(j);
            }
            sort(dss2);

            rs[i] = new String[dss2.length + 1];
            rs[i][0] = ci[i];
            for(int j =0; j<dss2.length; j++){
                rs[i][j+1] = dss2[j];
            }
        }
        return rs;
    }

    public static  void sort(String[] ci) {
        for(int i =0; i<ci.length; i++){
            for(int j=i+1; j<ci.length; j++){
                String tmp = null;
                if(ci[i].compareTo(ci[j]) > 0){
                    tmp = ci[i];
                    ci[i] =  ci[j];
                    ci[j] = tmp;
                }
            }
        }
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

        //System.out.println("Salad".compareTo("Tomato"));

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

        StopWatch.play();

        String rs[][] = groupingDishes(dishes);
        String rs2[][] = groupingDishes(dishes2);

        StopWatch.stop();

        rsChk(rs);
        rsChk(rs2);
    }

    public static void rsChk(String[][] rs) {
        System.out.println("============ 결과 확인 ============");
        for(String[] s : rs){
            System.out.println(Arrays.toString(s));
        }
    }
}

