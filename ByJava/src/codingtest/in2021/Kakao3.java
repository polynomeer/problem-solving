package codingtest.in2021;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Kakao3Solution {
    static class Car {
        LocalTime time;
        int fee;
        int minutes;
        String state;

        @Override
        public String toString() {
            return "Car{" +
                    "time=" + time +
                    ", fee=" + fee +
                    ", minutes=" + minutes +
                    ", state='" + state + '\'' +
                    '}';
        }
    }


    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Map<String, Car> map = new TreeMap<>();

        for (String record : records) {
            String[] token = record.split(" ");
            Car car = map.getOrDefault(token[1], new Car());

            LocalTime temp = LocalTime.parse(token[0]);

            if (car.time != null) {
                car.minutes += temp.minusMinutes(car.time.getMinute()).getMinute();
            }
            car.state = token[2];
            car.time = temp;

            map.put(token[1], car);
        }

        for (Map.Entry<String, Car> stringCarEntry : map.entrySet()) {
            if (stringCarEntry.getValue().state.equals("IN")) {
                Car car = map.get(stringCarEntry.getKey());
                car.minutes += LocalTime.of(23,59).minusMinutes(car.time.getMinute()).getMinute();
                // 기본요금
                car.minutes -= fees[0];
                car.fee += fees[1];
                // 단위요금

            }
            System.out.println(stringCarEntry.getKey() + " : " + stringCarEntry.getValue());
        }

        return answer;
    }
}

public class Kakao3 {
    public static void main(String[] args) {
        Kakao3Solution kakao3Solution = new Kakao3Solution();
        int[] answer1 = kakao3Solution.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        System.out.println();
        int[] answer2 = kakao3Solution.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});
        System.out.println();
        int[] answer3 = kakao3Solution.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"});
        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
        System.out.println("answer3 = " + Arrays.toString(answer3));
    }
}
