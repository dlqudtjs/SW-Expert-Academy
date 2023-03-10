import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.nextLine();
            int cnt = 0;
            char alpha = 'a';

            for (int i = 0; i < str.length(); i++) {
                char inputAlpha = str.charAt(i);

                if (inputAlpha == alpha) {
                    cnt++;
                } else {
                    break;
                }

                alpha++;
            }

            sb.append('#').append(test_case).append(' ').append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}