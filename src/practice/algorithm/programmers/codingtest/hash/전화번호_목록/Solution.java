package practice.algorithm.programmers.codingtest.hash.전화번호_목록;

import java.util.Arrays;

public class Solution {

    /**
     * 채점 결과
     * 정확성: 83.3
     * 효율성: 16.7
     * 합계: 100.0 / 100.0a
     */
    public boolean mySolution2(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i= 0; i<phone_book.length -1; i++){
            if(phone_book[i+1].indexOf(phone_book[i]) == 0) return false;
        }
        return true;
    }

    /**
     * 채점 결과
     * 정확성: 83.3
     * 효율성: 8.3
     * 합계: 91.7 / 100.0áa
     */
    public boolean mySolution(String[] phone_book) {
        for(int i= 0; i<phone_book.length; i++){
            if(chk(i,phone_book)) {
                return false;
            }
        }
        return true;
    }

    public boolean chk(int idx, String[] a){
        String t = a[idx];
        for(int i=0; i<a.length; i++){
            if(i!= idx && (t.indexOf(a[i]) == 0 || a[i].indexOf(t) == 0)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] phone_book = {
                {"119", "97674223", "1195524421"},
                {"123","456","789"},
                {"12","123","1235","567","88"}
        };

        Boolean[] answer = {false,true,false};

        for(int i=0; i<phone_book.length; i++) {
            Boolean result = s.mySolution2(phone_book[i]);
            if(answer[i].equals(result)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }
}