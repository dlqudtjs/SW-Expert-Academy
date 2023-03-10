import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] { 0, 0, -1 };
    static int[] dy = new int[] { -1, 1, 0 };
    static int answer = 0;
    static boolean flag;

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            map = new int[100][100];
            visited = new boolean[100][100];

            int T;
            T = sc.nextInt();

            flag = false;
            int endPoint = 0;

            for (int i = 0; i < 100; i++) {

                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();

                    if (map[i][j] == 2) {
                        endPoint = j;
                    }
                }
            }

            dfs(99, endPoint); // 도착지 좌표(여기서 부터 시작함)

            sb.append('#').append(T).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int startX, int startY) {
        for (int i = 0; i < 3; i++) {
            if (flag) {
                return;
            }

            int x = startX + dx[i];
            int y = startY + dy[i];

            if (x < 0 || x >= 100 || y < 0 || y >= 100) {
                continue;
            }

            if (map[x][y] == 1 && !visited[x][y]) {
                if (x == 0) {
                    answer = y;
                    flag = true;
                    return;
                }
                visited[startX][startY] = true;
                dfs(x, y);
            }
        }
    }
}