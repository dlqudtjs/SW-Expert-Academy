import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            sc.nextLine();

            int colCnt = 0;
            int startX = -1;
            int startY = -1;
            boolean flag = false;

            char[][] map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String str = sc.nextLine();

                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);

                    if (str.charAt(j) == '#' && !flag) { // 처음나오는 #
                        if (startX == -1) {
                            startX = i;
                            startY = j;
                            flag = true;

                            while (true) {
                                if (startY + colCnt < N && map[startX][startY + colCnt] == '#') {
                                    colCnt++;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            char[][] copyMap = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copyMap[i][j] = '.';
                }
            }

            int copyY = startY;

            for (int i = 0; i < colCnt; i++) {
                startY = copyY;

                for (int j = 0; j < colCnt; j++) {
                    copyMap[startX][startY] = '#';
                    startY++;
                }
                startX++;
            }

            flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (copyMap[i][j] != map[i][j]) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    break;
                }
            }

            String answer;

            if (!flag) {
                answer = "yes";
            } else {
                answer = "no";
            }

            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }
}