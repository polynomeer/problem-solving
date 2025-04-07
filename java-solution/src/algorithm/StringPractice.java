package algorithm;

public class StringPractice {
    static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        print(Integer.toString(3));
        print(String.valueOf(3));
        print(3 + "");
    }
}
