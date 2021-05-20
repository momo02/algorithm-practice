package practice.algorithm.swea.problem.base64_decoder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Base64;

/*
 입력으로 Base64 Encoding 된 String 이 주어졌을 때, 해당 String 을 Decoding 하여, 원문을 출력하는 프로그램을 작성.
- 정답 참고 >> Base64 Decoder 라이브러리 사용..
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {

        System.setIn(new FileInputStream("src/practice/algorithm/swea/problem/base64_decoder/res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++)
        {
            String s = br.readLine();
            //System.out.println(">> input : " + s);

            Base64.Decoder dc = Base64.getDecoder();
            System.out.println("#"+ tc + " " +  new String(dc.decode(s)));
        }
    }
}