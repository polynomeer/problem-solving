package algorithm;

/**
 * 순열 : n 개 중에서 r 개를 순서있게 뽑기
 * 시간복잡도: O(n!)
 */
public class Permutation {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        perm(arr, output, visited, 0, n, 3);
        System.out.println();
        permutation(arr, 0, n, 3);
    }

    /**
     * 사전순으로 순열 구하기
     * 사용 예시: perm(arr, output, visited, 0, n, 3);
     *
     * @param arr     전체 요소 배열, r개를 뽑기 위한 n개의 값
     * @param output  출력할 요소를 저장할 배열, 뽑힌 r개의 값
     * @param visited 방문 배열, 중복해서 뽑지 않기 위해 체크하는 값
     * @param depth   output 에 들어간 숫자의 경로
     * @param n       전체 요소 개수
     * @param r       뽑을 요소 개수
     */
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    /**
     * 순열 구하기
     * 사용 예시: permutation(arr, 0, n, 4);
     *
     * @param arr   전체 요소 배열
     * @param depth swap 기준이 되는 인덱스
     * @param n     전체 요소 개수
     * @param r     뽑을 요소 개수
     */
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    /**
     * output 배열 출력
     *
     * @param arr 출력할 요소 배열
     * @param r   뽑을 요소 개수
     */
    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

