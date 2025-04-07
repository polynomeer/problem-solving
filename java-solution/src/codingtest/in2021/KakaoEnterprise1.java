package codingtest.in2021;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class KakaoEnterprise1Result {

    /*
     * Complete the 'cardinalitySort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY nums as parameter.
     */

    static class Number implements Comparable<Number> {
        private int num;
        private int cardinality;

        public Number(int num, int cardinality) {
            this.num = num;
            this.cardinality = cardinality;
        }

        @Override
        public int compareTo(KakaoEnterprise1Result.Number n) {
            if (cardinality < n.cardinality) {
                return -1;
            } else if (cardinality > n.cardinality) {
                return 1;
            } else {
                if (num < n.num) {
                    return -1;
                } else if (num > n.num) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static List<Integer> cardinalitySort(List<Integer> nums) {
        List<Number> list = new ArrayList<>();
        for (Integer num : nums) {
            int cardinality = calculateCardinality(num);
            list.add(new Number(num, cardinality));
        }

        Collections.sort(list);

        List<Integer> answer = new ArrayList<>();
        for (Number number : list) {
            answer.add(number.num);
        }

        return answer;
    }

    private static int calculateCardinality(Integer num) {
        int cardinality = 0;
        while (num > 0) {
            if (num % 2 != 0) {
                cardinality++;
            }
            num /= 2;
        }
        return cardinality;
    }

}


public class KakaoEnterprise1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int numsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> nums = IntStream.range(0, numsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = KakaoEnterprise1Result.cardinalitySort(nums);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
