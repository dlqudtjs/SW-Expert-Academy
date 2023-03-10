import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[] rowCheck = new boolean[8];
            boolean[] colCheck = new boolean[8];
            boolean flag = false;
            int cnt = 0;

            for (int i = 0; i < 8; i++) {
                String str = sc.nextLine();

                for (int j = 0; j < 8; j++) {
                    if (str.charAt(j) == 'O') {
                        if ((rowCheck[i] || colCheck[j] || cnt > 8)) {
                            flag = true;
                        } else {
                            rowCheck[i] = true;
                            colCheck[j] = true;
                            cnt++;
                        }
                    }
                }
            }

            String answer;

            if (cnt == 8 && !flag) {
                answer = "yes";
            } else {
                answer = "no";
            }

            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }
}