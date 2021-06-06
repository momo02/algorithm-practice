package practice.algorithm.programmers.skill_checks.level1.가운데_글자_가져오기;

public class Solution {

    /**
     * 다른 사람의 풀이
     * @param s
     * @return
     */
    public static String solution1(String s) {
        return s.substring((s.length()-1) / 2, s.length()/2 + 1);
    }

    public static String solution(String s) {

        StringBuffer sb = new StringBuffer();
        int mIdx = (s.length() -1)/2;

        if( (s.length() -1)% 2 == 0){
            sb.append(s.charAt(mIdx));
        }else{
            sb.append(s.substring(mIdx,mIdx+2));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println( solution("qwer"));
        System.out.println( solution("qwerqwer"));
    }
}
