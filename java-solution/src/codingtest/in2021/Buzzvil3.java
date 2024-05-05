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


class BuzzvilResult3 {

    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        int candidate = 0;

        for (Integer skill : skills) {
            if (skill >= minLevel && skill <= maxLevel) candidate++;
        }

        if (candidate == minPlayers) return 1;
        double result = Math.pow(2, candidate) - Math.pow(2, minPlayers - 1);
        return (int) result;
    }

}

public class Buzzvil3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int skillsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> skills = IntStream.range(0, skillsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int minPlayers = Integer.parseInt(bufferedReader.readLine().trim());

        int minLevel = Integer.parseInt(bufferedReader.readLine().trim());

        int maxLevel = Integer.parseInt(bufferedReader.readLine().trim());

        int result = BuzzvilResult3.countTeams(skills, minPlayers, minLevel, maxLevel);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
