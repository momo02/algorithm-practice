package practice.algorithm.hackerrank.salesbymatch;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int rs = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
           Integer k = ar.get(i);
            if(map.containsKey(k)){
                int cnt = (int)map.get(k);
                map.put(k, cnt+1);
           }else {
                map.put(k, 1);
            }
        }

        for(Integer ks : map.keySet()){
            rs += (map.get(ks) / 2);
        }
        return rs;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = Result.sockMerchant(n, ar);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();

        System.out.println(result);
    }
}
