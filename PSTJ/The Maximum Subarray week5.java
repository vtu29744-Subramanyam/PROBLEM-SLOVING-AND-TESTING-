
import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {

        // Maximum subarray sum
        int current = arr.get(0);
        int maxSubarray = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {

            current = Math.max(arr.get(i), current + arr.get(i));

            maxSubarray = Math.max(maxSubarray, current);
        }

        // Maximum subsequence sum
        int maxSubsequence = 0;
        int largest = arr.get(0);

        for (int num : arr) {

            if (num > 0) {
                maxSubsequence += num;
            }

            largest = Math.max(largest, num);
        }

        // If all numbers are negative
        if (maxSubsequence == 0) {
            maxSubsequence = largest;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp =
                bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(arrTemp[i]));
            }

            List<Integer> result = Result.maxSubarray(arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
