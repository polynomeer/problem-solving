package codingtest.in2021;

class DevMatching2Solution {
    public int solution(int leave, String day, int[] holidays) {
        if (leave >= 30) {
            return 30;
        }

        int answer = 0;
        String[] days = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int _start = 1;
        int _count = 0;
        for (int i = 1; i <= 7; i++) {
            if (days[i - 1].equals("SAT") || days[i - 1].equals("SUN") || isHoliday(i, holidays)) {
                _count++;
                _start++;
            } else {
                break;
            }
        }

        for (int start = _start; start <= 30 - leave; start++) {
            int daysIndex = 0;
            int count = _count;
            int rest = leave;

            for (; daysIndex < 7; daysIndex++) {
                if (days[daysIndex].equals(day)) break;
            }

            int index = start;
            for (; index <= 30; index++, daysIndex++) {
                if (daysIndex > 6) daysIndex %= 7;
                if (rest == 0) break;
                if (days[daysIndex].equals("SAT") || days[daysIndex].equals("SUN") || isHoliday(index, holidays)) {
                    count++;
                } else {
                    count++;
                    rest--;
                }
            }

            for (int i = index; i <= 30; i++) {
                if (daysIndex > 6) daysIndex %= 7;
                if (days[daysIndex].equals("SAT") || days[daysIndex].equals("SUN") || isHoliday(i, holidays)) {
                    count++;
                } else {
                    break;
                }
            }

            if (answer < count) answer = count;
        }

        return answer;
    }

    private boolean isHoliday(int i, int[] holidays) {
        for (int holiday : holidays) {
            if (i == holiday) return true;
        }
        return false;
    }
}

public class DevMatching2 {
    public static void main(String[] args) {
        DevMatching2Solution sol = new DevMatching2Solution();
        System.out.println(sol.solution(4, "FRI", new int[]{6, 21, 23, 27, 28}));
        System.out.println(sol.solution(3, "SUN", new int[]{2, 6, 17, 29}));
    }
}
