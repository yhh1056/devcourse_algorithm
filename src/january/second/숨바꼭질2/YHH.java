package january.second.숨바꼭질2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class YHH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        solution(N, K, visited);
    }

    private static void solution(int N, int K, boolean[] visited) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(N);

        int cost = 0;
        int count = 0;

        while (!bfs.isEmpty()) {
            if (count != 0) {
                break;
            }
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                int now = bfs.poll();
                visited[now] = true;
                int m1 = now + 1;
                int m2 = now - 1;
                int m3 = now * 2;

                if (m1 == K) {
                    count++;
                } else if (m1 < 100001 && !visited[m1]) {
                    bfs.add(m1);
                }

                if (m2 == K) {
                    count++;
                } else if (m2 > 0 && !visited[m2]) {
                    bfs.add(m2);
                }

                if (m3 == K) {
                    count++;
                } else if (m3 < 100001 && !visited[m3]) {
                    bfs.add(m3);
                }
            }
            cost += 1;
        }

        System.out.println(cost);
        System.out.println(count);
    }
}
