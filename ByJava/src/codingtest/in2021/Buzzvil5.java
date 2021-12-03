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


class BuzzvilResult5 {

    public static int largestArea(List<List<Integer>> samples) {
        int length = samples.size();
        for (; length > 0; length--) {
            if (isSquare(samples, length)) break;
        }
        return length;
    }

    private static boolean isSquare(List<List<Integer>> matrix, int n) {
        for (int i = 0; i < matrix.size() - n; i++) {
            for (int j = 0; j < matrix.size() - n; j++) {
                if (mask(matrix, n, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean mask(List<List<Integer>> matrix, int n, int i, int j) {
        for (int row = i; row < i + n; row++) {
            for (int col = j; col < j + n; col++) {
                if (matrix.get(row).get(col) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

}

public class Buzzvil5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int samplesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int samplesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> samples = new ArrayList<>();

        IntStream.range(0, samplesRows).forEach(i -> {
            try {
                samples.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = BuzzvilResult5.largestArea(samples);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
