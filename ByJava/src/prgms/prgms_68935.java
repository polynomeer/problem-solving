package prgms;

class Solution_68935 {
    public int solution(int n) {
        if (n == 0) return n;
        String reversed = "";
        while (n > 0) {
            reversed += Integer.toString(n % 3);
            n /= 3;
        }
//        System.out.println(reversed);
        int reversedInt = Integer.parseInt(reversed);
        int answer = 0;
        int power = 0;
        while (reversedInt > 0) {

            int multi = 1;
            for (int i = 0; i < power; i++) {
                multi *= 3;
            }
            int temp = (reversedInt % 10) * multi;
//            System.out.println("multi = " + multi + " temp = " + temp + " reversedInt = " + reversedInt + " power = " + power);
            answer += temp;
            power++;
            reversedInt /= 10;
        }

        return answer;
    }
}

public class prgms_68935 {
    public static void main(String[] args) {
        Solution_68935 sol = new Solution_68935();
        System.out.println(sol.solution(45));
        System.out.println(sol.solution(125));
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(1));
        System.out.println(sol.solution(0));
        System.out.println(sol.solution(100000000));
    }
}
