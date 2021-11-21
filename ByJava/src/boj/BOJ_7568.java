package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_7568 {
    static class Person {
        int weight;
        int height;
        int rank;

        public Person(int weight, int height, int rank) {
            this.weight = weight;
            this.height = height;
            this.rank = rank;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int weight = scanner.nextInt();
            int height = scanner.nextInt();
            people.add(new Person(weight, height, 1));
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && people.get(j).weight > people.get(i).weight
                        && people.get(j).height > people.get(i).height) {
                    people.get(i).rank++;
                }
            }
        }

        for (Person person : people) {
            System.out.print(person.rank + " ");
        }
    }
}
