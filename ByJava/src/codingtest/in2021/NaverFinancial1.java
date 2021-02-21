package codingtest.in2021;

import java.util.*;

class SolutionNaverFinancial1 {
    public int solution(String[] A) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : A) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        return list.get(list.size() - 1).getValue();
    }
}

public class NaverFinancial1 {
    public static void main(String[] args) {
        SolutionNaverFinancial1 sol = new SolutionNaverFinancial1();
        System.out.println(sol.solution(new String[]{"Cardiology", "Orthopaedics", "Neurology", "Cardiology", "Orthopaedics", "Cardiology"}));
        System.out.println(sol.solution(new String[]{"Oncology", "Gynaecology", "Orthopaedics", "Oncology", "Gynaecology", "Orthopaedics"}));
        System.out.println(sol.solution(new String[]{"Neurology", "Cardiology", "Oncology"}));
    }
}
