import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int cnt = 0;

            for (int i = 0; i < str.length() - 1; i++) {
                if (str.substring(i, i + 2).equals("()")
                        || str.substring(i, i + 2).equals("(|")
                        || str.substring(i, i + 2).equals("|)")) {
                    cnt++;
                }
            }

            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}