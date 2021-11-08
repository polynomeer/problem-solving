package codingtest.in2021;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class WoowaTechCourse6Solution {

    /**
     * @param time  휴가시간 (시)
     * @param plans 여행계획 목록, "여행지_출발시간_도착시간"
     * @return 최종 선택 여행지
     */
    public String solution(double time, String[][] plans) {
        String answer = "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ha");
        LocalTime startWorkTimeOfWeek = LocalTime.parse("1PM", formatter);
        LocalTime endWorkTimeOfWeek = LocalTime.parse("6PM", formatter);

        for (String[] plan : plans) {
            int rest = (int) (time * 60);
            String destination = plan[0];
            String departure = plan[1];
            String arrival = plan[2];

            LocalTime departureTime = LocalTime.parse(departure, formatter);
            LocalTime arrivalTime = LocalTime.parse(arrival, formatter);

            int startUsage = endWorkTimeOfWeek.getHour() - departureTime.getHour();
            if (startUsage < 0) startUsage = 0;
            int endUsage = arrivalTime.getHour() - startWorkTimeOfWeek.getHour();
            if (endUsage < 0) endUsage = 0;
            rest -= startUsage * 60 + endUsage * 60;

            System.out.println("rest = " + rest);
            if (rest >= 0) {
                answer = destination;
            }
        }

        return answer;
    }
}

public class WoowaTechCourse6 {
    public static void main(String[] args) {
        WoowaTechCourse6Solution sol = new WoowaTechCourse6Solution();
        System.out.println(sol.solution(3.5,
                new String[][]{{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}}));
        System.out.println(sol.solution(4.5,
                new String[][]{{"방콕", "11PM", "9AM"}, {"뉴욕", "1PM", "2PM"}}));
    }
}
