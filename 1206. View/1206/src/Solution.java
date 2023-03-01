import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();

            boolean[][] buildings = new boolean[255][N];
            int[] heights = new int[N];

            // i = 건물 수, j = 건물 높이
            for (int i = 0; i < N; i++) {
                int height = sc.nextInt();
                heights[i] = height;

                for (int j = 0; j < height; j++) {
                    buildings[j][i] = true;
                }
            }

            int answer = 0;

            for (int i = 2; i < N - 2; i++) {
                for (int j = 0; j < heights[i]; j++) {
                    if (!buildings[j][i - 1] && !buildings[j][i - 2] && !buildings[j][i + 1] && !buildings[j][i + 2]) {
                        answer++;
                    }
                }
            }

            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }
}