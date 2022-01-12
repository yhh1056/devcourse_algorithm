package january.second.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class YHH {
    static int[] X = new int[] {0, 0, -1, 1};
    static int[] Y = new int[] {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N][M];
        int[][] visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(line[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int mx = x + X[i];
                int my = y + Y[i];

                if (mx >= 0 && mx < N && my >= 0 && my < M) {
                    if (miro[mx][my] == 1 && visited[mx][my] == 0) {
                        visited[mx][my] = visited[x][y] + 1;
                        queue.add(new int[] {mx, my});
                    }
                }
            }
        }

        System.out.println(visited[N - 1][M - 1]);
    }
}
