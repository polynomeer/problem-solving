package codingtest.in2021;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class WoowaTechCourse2Solution {

    public String solution(String[] log) {
        String answer = "";
        int totalTime = 0;

        for (int i = 0; i < log.length - 1; i += 2) {
            String[] start = log[i].split(":");
            String[] end = log[i + 1].split(":");
            LocalTime startTime = LocalTime.of(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            LocalTime endTime = LocalTime.of(Integer.parseInt(end[0]), Integer.parseInt(end[1]));

            int runningTime = getMinuteFromLocalTime(startTime, endTime);
            int realTime = calculateRealTime(runningTime);

            totalTime += realTime;
        }

        int hour = totalTime / 60;
        int minute = totalTime % 60;
        LocalTime localTime = LocalTime.of(hour, minute);

        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("hh:mm");
        answer = localTime.format(formatter);

        return answer;
    }

    private int getMinuteFromLocalTime(LocalTime startTime, LocalTime endTime) {
        return (endTime.getHour() - startTime.getHour()) * 60
                + endTime.getMinute() - startTime.getMinute();
    }

    private int calculateRealTime(int runningTime) {
        if (runningTime < 5) return 0;
        return Math.min(runningTime, 105);
    }
}

public class WoowaTechCourse2 {
    public static void main(String[] args) {
        WoowaTechCourse2Solution sol = new WoowaTechCourse2Solution();
        System.out.println(sol.solution(new String[]{"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"}));
        System.out.println(sol.solution(new String[]{"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"}));
    }
}
