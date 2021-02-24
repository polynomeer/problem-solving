package prgms;

class Solution_12919 {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        int i = 0;
        for(i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) break;
        }
        return answer + i + "에 있다";
    }
}

public class prgms_12919 {


    public static void main(String[] args) {
        Solution_12919 sol = new Solution_12919();
        System.out.println(sol.solution(new String[]{"Jane", "Kim"}));
    }
}
