package codingtest.in2021;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class KakaoEnterprise2Result {

    /*
     * Complete the 'validateAddresses' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY addresses as parameter.
     */

    public static List<String> validateAddresses(List<String> addresses) {
        List<String> answer = new ArrayList<>();

        for (String address : addresses) {
            boolean isEither = false;
            String[] tokens = address.split("\\.");
            if (tokens.length == 4 && address.charAt(0) != '.' && address.charAt(address.length() - 1) != '.') {
                if (isIPv4(tokens)) {
                    answer.add("IPv4");
                    isEither = true;
                }
            }


            String[] sarr = address.split("::");
            int count = 0;
            for (String s : sarr) {
                if (address.equals(s)) {
                    count++;
                }
            }

            if (count > 2) {
                answer.add("Neither");
                break;
            }

            tokens = address.replace("::", "").split(":");
            if (tokens.length == 8 || address.contains("::")) {
                if (isIPv6(tokens)) {
                    answer.add("IPv6");
                    isEither = true;
                }
            }

            if (!isEither) {
                answer.add("Neither");
            }
        }
        return answer;
    }

    private static boolean isIPv4(String[] tokens) {
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (token.length() > 3 || token.length() == 0) return false;
                if (number < 0 || number > 255) return false;
                if (token.toCharArray()[0] == '0' && number >= 8) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIPv6(String[] tokens) {
        for (String token : tokens) {
            char[] chars = token.toCharArray();
            if (token.length() == 0) return false;
            if (chars[0] == '0' && token.length() < 4 && token.length() > 1) return false;
            for (char c : chars) {
                if (c > 'f' || c < '0') return false;
            }
        }
        return true;
    }

}

public class KakaoEnterprise2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int addressesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> addresses = IntStream.range(0, addressesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = KakaoEnterprise2Result.validateAddresses(addresses);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
