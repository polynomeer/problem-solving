package codingtest.in2021;

import java.util.*;

class Kakao1Solutuion {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 신고 처리 결과 메일을 받은 횟수

        Map<String, Map<String, Integer>> countMap = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> reportMap = new LinkedHashMap<>();

        for (String id : id_list) {
            countMap.put(id, new LinkedHashMap<>());
            reportMap.put(id, new LinkedHashMap<>());
        }

        for (String r : report) {
            String[] token = r.split(" ");

            Map<String, Integer> temp = reportMap.get(token[0]);
            temp.put(token[1], 0);
            reportMap.put(token[0], temp);

            Map<String, Integer> map = countMap.getOrDefault(token[1], new LinkedHashMap<>());
            map.put(token[0], 1);
            countMap.put(token[1], map);
        }

        int index = 0;
        for (Map.Entry<String, Map<String, Integer>> stringListEntry : reportMap.entrySet()) {
            Map<String, Integer> temp = stringListEntry.getValue();
            for (String s : temp.keySet()) {
                if (countMap.get(s).size() >= k) {
                    answer[index]++;
                }
            }
            index++;
        }

        return answer;
    }
}

public class Kakao1 {
    public static void main(String[] args) {
        Kakao1Solutuion kakao1Solutuion = new Kakao1Solutuion();
        int[] answer1 = kakao1Solutuion.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        System.out.println("=================");
        int[] answer2 = kakao1Solutuion.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        System.out.println("=================");
        int[] answer3 = kakao1Solutuion.solution(new String[]{"con", "ryan", "muzi"}, new String[]{"ryan con", "muzi con", "muzi ryan", "con ryan"}, 2);
        System.out.println("=================");
        int[] answer4 = kakao1Solutuion.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "muzi frodo", "apeach frodo", "apeach frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "neo muzi"}, 2);
        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
        System.out.println("answer3 = " + Arrays.toString(answer3));
        System.out.println("answer4 = " + Arrays.toString(answer4));
    }
}
