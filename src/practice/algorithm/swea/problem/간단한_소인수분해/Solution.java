package practice.algorithm.swea.problem.간단한_소인수분해;

import practice.algorithm.utils.StopWatch;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

        /**
         * StringBuffer 사용.
         * 속도(ns):22410080
         * 속도(ns):21718618
         * 속도(ns):21333765
         * 속도(ns):30296789
         * 속도(ns):26939561
         */
        public static void solution2(Scanner sc, int test_case){
                int[][] nc = new int[][]{{2,0},{3,0},{5,0},{7,0},{11,0}};
                int[] rs = new int[5];

                int input = sc.nextInt();

                while( input > 1) {
                        for (int i = 0; i < nc.length; i++) {
                                int n = nc[i][0];
                                int cnt = nc[i][1];
                                while (input % n == 0) {
                                        input = (input / n);
                                        cnt++;
                                }
                                rs[i] = cnt;
                        }
                }

//                String result = "";
//                for(int i=0; i<rs.length; i++) {
//                        result += (" " + rs[i]);
//
//                }
                StringBuffer sb = new StringBuffer();
                for(int i=0; i<rs.length; i++) {
                        sb.append(" " + rs[i]);

                }
                System.out.println("#" + test_case + sb.toString());
        }

        /**
         * 속도(ns):35112714
         * 속도(ns):27745783
         * 속도(ns):30491615
         * 속도(ns):25107702
         * 속도(ns):26501877
         */
        public static void solution(Scanner sc, int test_case){
                int[][] nc = new int[][]{{2,0},{3,0},{5,0},{7,0},{11,0}};
                int[] rs = new int[5];

                int input = sc.nextInt();

                while( input > 1) {
                        for (int i = 0; i < nc.length; i++) {
                                int n = nc[i][0];
                                int cnt = nc[i][1];
                                while (input % n == 0) {
                                        input = (input / n);
                                        cnt++;
                                }
                                rs[i] = cnt;
                        }
                }

                String result = "";
                for(int i=0; i<rs.length; i++) {
                        result += (" " + rs[i]);

                }
                System.out.println("#" + test_case + result);
        }

        public static void main(String args[]) throws Exception
        {
                StopWatch.play();
        /*
           아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
           여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
           이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
           따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
           단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
         */
                //System.out.println(System.getProperty("user.dir"));
                System.setIn(new FileInputStream("src/practice/algorithm/swea/problem/간단한_소인수분해/res/input.txt"));

        /*
           표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
                Scanner sc = new Scanner(System.in);
                int T;
                T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

                for(int test_case = 1; test_case <= T; test_case++)
                {

                        /////////////////////////////////////////////////////////////////////////////////////////////
            /*
                 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
             */

//                        int[][] nc = new int[][]{{2,0},{3,0},{5,0},{7,0},{11,0}};
//                        int[] rs = new int[5];
//
//                        int input = sc.nextInt();
//
//                        while( input > 1) {
//                                for (int i = 0; i < nc.length; i++) {
//                                        int n = nc[i][0];
//                                        int cnt = nc[i][1];
//                                        while (input % n == 0) {
//                                                input = (input / n);
//                                                cnt++;
//                                        }
//                                        rs[i] = cnt;
//                                }
//                        }
//
//                        String result = "";
//                        for(int i=0; i<rs.length; i++) {
//                                result += (" " + rs[i]);
//
//                        }
//                        System.out.println("#" + test_case + result);
                        solution2(sc,test_case);
                }


                /////////////////////////////////////////////////////////////////////////////////////////////
                StopWatch.stop();
        }
}
