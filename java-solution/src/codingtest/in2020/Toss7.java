package codingtest.in2020;

import java.util.stream.Stream;

class SolutionToss7 {
    String solution(String s) {
        String[] token = s.split(";");
        int pointer = Integer.parseInt(token[0]);
        int[] src = Stream.of(token[1].trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dest = new int[8];
        int i = 0;
        while (true) {
            if (src[pointer] == 0) {
                dest[i++] = src[pointer];
                dest[i++] = i;
                pointer = src[pointer + 1];
            } else if (src[pointer] == 1) {
                dest[i++] = src[pointer];
                dest[i] = src[pointer + 1];
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0;");
        for (int data : dest) {
            sb.append(" ").append(data);
        }
        return sb.toString().trim();
    }
}

public class Toss7 {
    public static void main(String[] args) {
        SolutionToss7 sol = new SolutionToss7();
        System.out.println(sol.solution("4; 1 30 0 6 0 2 1 3"));
    }
}
