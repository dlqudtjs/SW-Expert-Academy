import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    static int[] arr, permutation;
    static boolean[] visited;
    static int n, cnt;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            permutation = new int[n];
            visited = new boolean[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            permutation(0);

            System.out.println("#" + test_case + " " + cnt);
        }
    }

    private static void permutation(int depth) {
        if (depth == n) { // 순열이 완성되면
            combination(0, 0, 0);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = arr[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void combination(int depth, int left, int right) {
        if (right > left) {
            return;
        }
        if (depth == n) {
            cnt++;
            return;
        }

        // 정해진 수열의 앞쪽부터 오른쪽에 올린후 오른쪽 > 왼쪽이라면
        // 왼쪽에 올린다. (왼쪽 4 1 오른쪽 2는 되지만 오른쪽2 왼쪽 4 1은 불가능함.)
        // 올릴 때도 왼쪽이 항상 커야한다.
        combination(depth + 1, left, right + permutation[depth]);
        combination(depth + 1, left + permutation[depth], right);
    }
}