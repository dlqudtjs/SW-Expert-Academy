import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    static int N;
    static int[] dx = new int[] { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static int[][] map;
    static int[][] mapValue;

    public static void main(String args[]) throws Exception {

        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();

            map = new int[N][N];
            mapValue = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = sc.next();

                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - 48;
                    mapValue[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);

            sb.append('#').append(test_case).append(' ').append(mapValue[N - 1][N - 1]).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY });
        mapValue[startX][startY] = 0;

        while (true) {
            if (queue.isEmpty()) {
                return;
            }

            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= N || x < 0 || y >= N || y < 0) { // 범위 밖일 때
                    continue;
                }

                int time = mapValue[now[0]][now[1]] + map[x][y];

                if (mapValue[x][y] == Integer.MAX_VALUE) { // 한 번도 방문하지 않은 곳이라면 map 최소 시간 갱신
                    mapValue[x][y] = time;
                } else if ((time) < mapValue[x][y]) { // 걸린 시간이 현재까지 적힌 최소 시간보다 적으면 갱신
                    mapValue[x][y] = time;
                } else { // 한 번도 방문하지 않았거나, 갱신할 필요가 없기에 continue
                    continue;
                }

                queue.add(new int[] { x, y });
            }
        }
    }
}