package codingtest.in2021;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class KakaoEnterprise3Result {

    /*
     * Complete the 'minOperations' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long minOperations(long n) {
        long answer = 0;
        String binary = toBinary(n);
        System.out.println(binary);
        while (Long.parseLong(binary) != 0) {
            char[] chars = binary.toCharArray();
            if (chars[0] == '1' && chars[1] == '1') {
                String temp = Arrays.toString(chars).substring(1);
                long num = Long.parseLong(temp);

            }

        }
        return 0;
    }

    private static String toBinary(long n) {
        String binary = "";
        while (n > 0) {
            binary = (n % 2) + binary;
            n /= 2;
        }
        return binary;
    }

}

public class KakaoEnterprise3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = KakaoEnterprise3Result.minOperations(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

