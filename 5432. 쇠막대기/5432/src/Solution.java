import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			String str = br.readLine();
			char preC = '.';

			for (char c : str.toCharArray()) {
				if (c == '(') {
					stack.add(c);
					preC = c;
					continue;
				}

				stack.pop();

				if (preC == '(') {
					cnt += stack.size();
				} else {
					cnt += 1;
				}

				preC = c;
			}

			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}