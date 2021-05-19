package practice.algorithm.programmers.codingtest.bruteforce.모의고사;

import java.util.Arrays;

public class Solution {

    /**
     * 수행 시간 : 696021ns(나노타임/세크)
     * 수행 시간 : 982417ns(나노타임/세크)
     * 수행 시간 : 757264ns(나노타임/세크)
     * 수행 시간 : 1040080ns(나노타임/세크)
     * 수행 시간 : 1375593ns(나노타임/세크)
     * 수행 시간 : 1176014ns(나노타임/세크)
     * 수행 시간 : 572227ns(나노타임/세크)
     *
     */
    public int[] solution4(int[] answers) {

        int[][] p = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        int[] g = new int[3];

        for(int i=0; i<p.length; i++){
            //g[i] = getGrade(p[i], answers);
            int grade = 0;
            for(int j=0; j<answers.length; j++){
                if( p[i][j % p[i].length] == answers[j] ) {
                    grade++;
                }
            }
            g[i] = grade;
        }

        int a = g[0], b= g[1], c = g[2];

        if(a > b){
            if(a > c){
                return new int[]{1};
            }else if(a == c){
                return new int[]{1,3};
            }else {
                return new int[]{3};
            }
        }else if(a == b){
            if(a > c) {
                return new int[]{1,2};
            }else if(a == c){
                return new int[]{1,2,3};
            }else {
                return new int[]{3};
            }
        }else {
            if(b > c) {
                return new int[]{2};
            }else if(b == c){
                return new int[]{2,3};
            }else {
                return new int[]{3};
            }
        }
    }

    public int[] solution3(int[] answers){
        int[][] types = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5},
        };
        int[] sums = new int[3], answer=null;
        int max=0, cnt=0;
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<types.length; j++){
                int idx = (i%types[j].length);
                if(answers[i] == types[j][idx]){
                    sums[j] += 1;
                    if(max < sums[j]) max = sums[j];
                }
            }
        }

        for(int i=0; i<sums.length; i++){
            if(sums[i] >0 && max == sums[i]) cnt++;
        }

        answer = new int[cnt];

        for(int i=0, anCnt=0; i<sums.length; i++){
            if(sums[i]>0 && max == sums[i]){
                answer[anCnt] = i+1;
                anCnt++;
            }
        }
        return answer;
    }



    /**
     * 수행 시간 : 1000835ns(나노타임/세크)
     * 수행 시간 : 874283ns(나노타임/세크)
     * 수행 시간 : 736252ns(나노타임/세크)
     * 수행 시간 : 752409ns(나노타임/세크)
     * 수행 시간 : 1005931ns(나노타임/세크)
     * 수행 시간 : 1095245ns(나노타임/세크)
     */
    public int[] solution1(int[] answers) {

        int[][] p = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        int[] g = new int[3];

        //max 점수 구하기
        int max = 0;
        for(int i=0; i<p.length; i++){
            g[i] = getGrade(p[i], answers);
            if(g[i] > max) max = g[i];
        }

        //System.out.println(max);

        int mCnt = 0;
        for(int i=0; i<g.length; i++){
            if(g[i] == max) mCnt++;
        }

        int[] rs = new int[mCnt];
        int j=0;
        for(int i=0; i<g.length; i++){
            if(g[i] == max) rs[j++] = i+1;
        }

        //System.out.println(Arrays.toString(rs));
        return rs;

//        if(g[1] > g[2]){
//            if(g[1] > g[3]){
//                return new int[]{1};
//            }else if(a == c){
//                return new int[]{1,3};
//            }else {
//                return new int[]{3};
//            }
//        }else if(a == b){
//            if(a > c) {
//                return new int[]{1,2};
//            }else if(a == c){
//                return new int[]{1,2,3};
//            }else {
//                return new int[]{3};
//            }
//        }else {
//            if(b > c) {
//                return new int[]{2};
//            }else if(b == c){
//                return new int[]{2,3};
//            }else {
//                return new int[]{3};
//            }
//        }
    }

    /**
     * 수행 시간 : 610027ns(나노타임/세크)
     * 수행 시간 : 867474ns(나노타임/세크)
     * 수행 시간 : 774547ns(나노타임/세크)
     * 수행 시간 : 750938ns(나노타임/세크)
     * 수행 시간 : 690539ns(나노타임/세크)
     * 수행 시간 : 557267ns(나노타임/세크)
     */
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int a = getGrade(p1, answers);
        int b = getGrade(p2, answers);
        int c = getGrade(p3, answers);

//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        if(a > b){
            if(a > c){
                return new int[]{1};
            }else if(a == c){
                return new int[]{1,3};
            }else {
                return new int[]{3};
            }
        }else if(a == b){
            if(a > c) {
                return new int[]{1,2};
            }else if(a == c){
                return new int[]{1,2,3};
            }else {
                return new int[]{3};
            }
        }else {
            if(b > c) {
                return new int[]{2};
            }else if(b == c){
                return new int[]{2,3};
            }else {
                return new int[]{3};
            }
        }
    }

    public int getGrade(int[] p, int[] answers){
        int grade = 0;
        for(int i=0; i<answers.length; i++){
//            int pIdx;
//            if(i >= p.length) {
//                pIdx = i % p.length;
//            }else{
//                pIdx = i;
//            }
//            System.out.println(" >>" + pIdx);
            if( p[i % p.length] == answers[i] ) {
                grade++;
            }
        }
        return grade;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] commands = {
                {1,2,3,4,5},
                {1,3,2,4,2},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int[][] returns = {
                {1},
                {1,2,3},
                {3},
                {1,2,3}
        };

        long startTime = System.nanoTime();
        for(int i=0; i<commands.length; i++){
          if(Arrays.equals(returns[i], s.solution(commands[i]))){
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