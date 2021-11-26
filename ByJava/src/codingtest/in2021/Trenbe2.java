package codingtest.in2021;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class TrenbeSolution2 {
    public String solution(String p, int n) {
        String pattern = "a hh:mm:ss";
        String resultPattern = "HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        LocalTime localTime = LocalTime.parse(p, formatter);
        localTime = localTime.plusSeconds(n);

        formatter = DateTimeFormatter.ofPattern(resultPattern);
        return localTime.format(formatter);
    }
}

public class Trenbe2 {
    public static void main(String[] args) {
        TrenbeSolution2 sol = new TrenbeSolution2();
        System.out.println(sol.solution("PM 01:00:00", 10).equals("13:00:10"));
        System.out.println(sol.solution("PM 11:59:59", 1).equals("00:00:00"));
    }
}
