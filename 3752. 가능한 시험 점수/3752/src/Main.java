import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            HashSet<Integer> hs = new HashSet<>();

            hs.add(0); // 0점은 항상 존재한다.

            for (int i = 1; i < N + 1; i++) {
                int num = sc.nextInt();

                // hashset을 반복하며 값을 추가하면 반복문 오류가 나오기 때문에 copy hash를 생성한다.
                HashSet<Integer> copy = new HashSet<>();
                copy.addAll(hs); // copy에 hs 복사

                Iterator<Integer> iter = copy.iterator(); // 복사한 copy iter로 돌린다.
                while (iter.hasNext()) {
                    hs.add(iter.next() + num);
                }
            }

            int answer = hs.size();

            sb.append('#').append(test_case).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }
}

/*
 * N = 1 // A 일 땐 0, 0 + A
 * N = 2 // A, B 일 땐, 0, 0 + A, 0 + B, 0 + A + B
 * N = 3 // A, B, C 일땐, 0, 0 + A, 0 + B, 0 + A + B, 0 + C, 0 + A + C, 0 + B + C,
 * 0 + A + B + C 로 값이 추가 될 때마다 지금까지 구했던 방식에 + value를 해주면 된다.
 * 중복된 값은 hashset에서 처리된다.
 * 
 * 참고 블로그 https://greatepig.tistory.com/43
 */