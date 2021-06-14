package practice.algorithm.programmers.practice.level2.JadenCase_문자열_만들기;

/**
 * JadenCase 문자열 만들기
 * [문제 설명]
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 *
 * [제한 조건]
 * s는 길이 1 이상인 문자열입니다.
 * s는 알파벳과 공백문자(" ")로 이루어져 있습니다.
 * 첫 문자가 영문이 아닐때에는 이어지는 영문은 소문자로 씁니다. ( 첫번째 입출력 예 참고 )
 *
 * [입출력 예]
 * s	                    return
 * "3people unFollowed me"	"3people Unfollowed Me"
 * "for the last week"	    "For The Last Week"
 */
public class Solution {
    /** 방법2
     * 테스트 1 〉	통과 (0.06ms, 52.2MB)
     * 테스트 2 〉	통과 (0.08ms, 52.2MB)
     * 테스트 3 〉	통과 (0.06ms, 52.3MB)
     * 테스트 4 〉	통과 (0.07ms, 51.9MB)
     * 테스트 5 〉	통과 (0.09ms, 52.9MB)
     * 테스트 6 〉	통과 (0.07ms, 51.9MB)
     * 테스트 7 〉	통과 (0.07ms, 54MB)
     * 테스트 8 〉	통과 (0.10ms, 52.6MB)
     * 테스트 9 〉	통과 (0.07ms, 53.6MB)
     * 테스트 10 〉	통과 (0.07ms, 52.9MB)
     * 테스트 11 〉	통과 (0.07ms, 51.8MB)
     * 테스트 12 〉	통과 (0.06ms, 52MB)
     * 테스트 13 〉	통과 (0.06ms, 53.3MB)
     * 테스트 14 〉	통과 (0.07ms, 52.1MB)
     * 테스트 15 〉	통과 (0.09ms, 52.1MB)
     * 테스트 16 〉	통과 (0.07ms, 51.7MB)
     */
    public static String solution(String s) {
        //처음에 다 소문자로 만들기
        char[] cs =  s.toLowerCase().toCharArray();

        boolean fst = true; // 첫번째 문자인지 아닌지만 구분하면 되므로 flag로 boolean 타입 값 사용.
        for(int i=0; i<cs.length; i++){
            if(cs[i] == ' '){
                fst = true;
                continue;
            }
            if(fst){
                cs[i] = Character.toUpperCase(cs[i]);
                fst = false;
            }
        }
        return String.valueOf(cs);
    }

    /**
     * 방법1
     * 테스트 1 〉	통과 (0.06ms, 53.7MB)
     * 테스트 2 〉	통과 (0.33ms, 52.4MB)
     * 테스트 3 〉	통과 (0.10ms, 51.9MB)
     * 테스트 4 〉	통과 (0.10ms, 52.2MB)
     * 테스트 5 〉	통과 (0.08ms, 51.9MB)
     * 테스트 6 〉	통과 (0.12ms, 52.2MB)
     * 테스트 7 〉	통과 (0.09ms, 52.6MB)
     * 테스트 8 〉	통과 (0.04ms, 51.8MB)
     * 테스트 9 〉	통과 (0.06ms, 52.8MB)
     * 테스트 10 〉	통과 (0.03ms, 52.7MB)
     * 테스트 11 〉	통과 (0.04ms, 52.6MB)
     * 테스트 12 〉	통과 (0.07ms, 53.8MB)
     * 테스트 13 〉	통과 (0.07ms, 51.7MB)
     * 테스트 14 〉	통과 (0.07ms, 52.2MB)
     * 테스트 15 〉	통과 (0.08ms, 52.5MB)
     * 테스트 16 〉	통과 (0.08ms, 52.2MB)
     */
    public static String solution2(String s) {
        char[] cs = s.toCharArray();

        int idx = 0;
        for(int i=0; i<cs.length; i++){
            if(cs[i] == ' '){
                idx = 0;
                continue;
            }
            if(idx++ == 0){
                cs[i] = Character.toUpperCase(cs[i]);
            }else{
                cs[i] = Character.toLowerCase(cs[i]);
            }
        }
        return String.valueOf(cs);
    }

    public static String solution3(String s) {
        char[] cs = s.toCharArray();

        int idx = 0;
        for(int i=0; i<cs.length; i++){
            if(cs[i] == ' '){
                idx = 0;
                continue;
            }
            //조건 잘못됨 (마지막 케이스)
//            if(idx++ == 0 &&  cs[i] >= 'a' &&  cs[i] <= 'z'){
//                cs[i] = Character.toUpperCase(cs[i]);
//            }else if(cs[i] >= 'A' &&  cs[i] <= 'Z') {
//                cs[i] = Character.toLowerCase(cs[i]);
//            }
            if(idx++ == 0){
                if(cs[i] >= 'a' &&  cs[i] <= 'z') cs[i] = Character.toUpperCase(cs[i]);
            }else{
                if(cs[i] >= 'A' &&  cs[i] <= 'Z') cs[i] = Character.toLowerCase(cs[i]);
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me")); //"3people Unfollowed Me"
        System.out.println(solution("for the last week")); //"For The Last Week"
        System.out.println(solution("222fFr2   the 11lasTTT 222wee2k"));
        System.out.println(solution("   2ddd d"));
        System.out.println(solution("d 2d 1fff fd2dfdf    d2323s   "));
        System.out.println(solution("AAAAAAaaaaAA BBB CCCCC"));
    }
}
