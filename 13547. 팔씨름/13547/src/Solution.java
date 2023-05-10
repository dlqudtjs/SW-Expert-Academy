import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String result = "";
        for (int test_case = 1; test_case <= T; test_case++) {
            int cnt = 0;
            String match = br.readLine();

            for (int i = 0; i < match.length(); i++) {
                if (match.charAt(i) == 'x') {
                    cnt++;
                }
            }

            if (cnt >= 8) {
                result = "NO";
            } else {
                result = "YES";
            }

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }
}