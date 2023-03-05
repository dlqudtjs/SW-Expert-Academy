import java.util.HashSet;
import java.util.Scanner;

class Solution {
    static int[][] map;
    static HashSet<String> hs;
    static int dx[] = new int[] { -1, 1, 0, 0 };
    static int dy[] = new int[] { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {

        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            map = new int[4][4];
            hs = new HashSet<>();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, 0, "" + map[i][j]);
                }
            }

            System.out.println("#" + test_case + " " + hs.size());
        }
    }

    static void dfs(int startX, int startY, int depth, String str) {
        if (depth == 6) { // 깊이는 0부터 시작 (총 7자리)
            hs.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if (x < 4 && x >= 0 && y < 4 && y >= 0) { // 맵 안에 있을 때
                dfs(x, y, depth + 1, str + map[x][y]);
            }
        }
    }
}