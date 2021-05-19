package practice.algorithm.swea.problem.간단한_소인수분해;

import practice.algorithm.utils.StopWatch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution2 {
        /**
         * Best case
         * - 문자열을 입력받을 때 Scanner 클래스 보다 상대적으로 속도가 빠른 BufferedReader 클래스를 사용.
         * - for 문 최소 사용.
         *
         * 속도(ns):2024249
         * 속도(ns):1368676`
         * 속도(ns):1479581
         * 속도(ns):1344661
         * 속도(ns):1169451
         */
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
//                Scanner sc = new Scanner(System.in);
//                int T;
//                T=sc.nextInt();

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int T = Integer.parseInt(br.readLine());

        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */

                for(int test_case = 1; test_case <= T; test_case++)
                {
                        StringBuilder sb = new StringBuilder();
                        sb.append("# " + test_case);
                        int N = Integer.parseInt(br.readLine());

                        int[] arr = {2,3,5,7,11};
                        for(int i=0; i<5; i++){
                                int cnt = 0;
                                int tmpN = N;

                                while(true){
                                        if(tmpN % arr[i] == 0){
                                                cnt++;
                                                tmpN /= arr[i];
                                        }else{
                                                break;
                                        }
                                }
                                sb.append(" " + cnt);
                        }
                        System.out.println(sb);
                }

                /////////////////////////////////////////////////////////////////////////////////////////////
                StopWatch.stop();
        }
}
