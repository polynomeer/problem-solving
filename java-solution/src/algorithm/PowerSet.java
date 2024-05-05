package algorithm;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        boolean[] visited = new boolean[n];

        powerSet(arr, visited, n, 0);
        bit(arr, n);
    }

    /**
     * @param arr     부분집합을 구할 대상 집합의 배열
     * @param visited 방문여부를 체크할 배열
     * @param n       배열의 크기
     * @param idx     현재 인덱스
     */
    static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
        if (idx == n) {
            print(arr, visited, n);
            return;
        }

        visited[idx] = false;
        powerSet(arr, visited, n, idx + 1);

        visited[idx] = true;
        powerSet(arr, visited, n, idx + 1);
    }

    /**
     * @param arr 부분집합을 구할 대상 집합의 배열
     * @param n   배열의 크기
     */
    static void bit(int[] arr, int n) {
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0)
                    System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
