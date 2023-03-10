import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int inputNum = sc.nextInt();
            int changeNum = sc.nextInt();
            int numLength = (int) Math.log10(inputNum) + 1;

            int[] num = new int[numLength];

            for (int i = numLength - 1; i >= 0; i--) {
                num[i] = inputNum % 10;
                inputNum /= 10;
            }

            int changeCnt = 0;

            for (int i = 0; i < numLength; i++) {
                int max = num[i];
                int maxIndex = i;

                for (int searchiIndex = i; searchiIndex < numLength; searchiIndex++) {
                    if (max <= num[searchiIndex]) {
                        max = num[searchiIndex];
                        maxIndex = searchiIndex;
                    }
                }

                if (maxIndex == i) {
                    continue;
                }

                int temp = num[i];
                num[i] = num[maxIndex];
                num[maxIndex] = temp;

                changeCnt++;

                if (changeCnt == changeNum) {
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < numLength; i++) {
                sb.append(num[i]);
            }

            System.out.println(sb);
        }
    }
}