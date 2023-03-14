import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int chage = sc.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                list.add(sc.nextInt());
            }

            Collections.sort(list);

            while (chage > 0) {
                int first = list.remove(0);
                int end = list.remove(list.size() - 1);

                if (first == end) {
                    break;
                }

                list.add(++first);
                list.add(--end);

                Collections.sort(list);

                chage--;
            }

            int answer = list.get(list.size() - 1) - list.get(0);

            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
}