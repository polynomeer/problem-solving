package prgms;

class Solution12919 {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        int i = 0;
        for(i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) break;
        }
        return answer + i + "에 있다";
    }
}

public class Programmers12919 {


    public static void main(String[] args) {
        Solution12919 sol = new Solution12919();
        System.out.println(sol.solution(new String[]{"Jane", "Kim"}));
    }
}
