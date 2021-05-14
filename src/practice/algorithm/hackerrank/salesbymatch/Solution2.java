package practice.algorithm.hackerrank.salesbymatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result2 {

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
        for(int i = 0; i < ar.size(); i++){

            int t = ar.get(i);
            //System.out.println(">>>>>t " + t);
            boolean findPairs = false;

            for(int j = i+1; j<ar.size(); j++){
                int t2 = ar.get(j);
                //System.out.println(">>>>>t2 " + t2);
                if(t == t2){
                    ar.remove(j);
                    findPairs = true;
                    break;
                }
            }
            if(findPairs) {
                //ar.remove(i);
                rs++;
                continue;
            }
        }
        return rs;
    }

}

public class Solution2 {
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

        int result = Result2.sockMerchant(n, ar);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();

        System.out.println(result);
    }
}
