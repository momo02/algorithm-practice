package practice.algorithm.programmers.codingtest.hash.완주하지_못한_선수;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public String solution2(String[] participant, String[] completion){
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i=0; i<completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        answer = participant[i];
        return answer;
    }

    public String solution1(String[] participant, String[] completion){
        String answer = "";
        for(int i=0; i<participant.length; i++){
            boolean isC = false;
            for(int j=0; j<completion.length; j++){
                if(!"".equals(completion[j]) && participant[i].equals(completion[j])){
                    completion[j] = "";
                    isC = true;
                    break;
                }
            }
            if(!isC) answer += participant[i];
        }
        return answer;
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] participant = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };
        String[][] completion = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };
        String[] answer = {"leo","vinko","mislav"};

        for(int i=0; i<participant.length; i++) {
            String result = s.solution2(participant[i], completion[i]);
            if(answer[i].equals(result)) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }
}