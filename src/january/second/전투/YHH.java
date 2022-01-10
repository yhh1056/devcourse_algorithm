package january.second.전투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class YHH {

    static int M;
    static int N;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[][] zone = new String[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                zone[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int[] answer = solution(zone);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static int[] solution(String[][] zone) {
        int[] answer = new int[2];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {         // 방문한적이 없다면
                    visit[i][j] = true;     // 방문도장 찍고
                    queue.add(new int[] {i, j});  // 해당 좌표 추가하고
                    String color = zone[i][j];  // 해당 좌표 색깔 알아내고
                    int count = bfs(zone, queue, color); // queue 돌면서 같은 색들의 수를 찾는다

                    if (color.equals("W")) {
                        answer[0] += Math.pow(count, 2);
                    } else {
                        answer[1] += Math.pow(count, 2);
                    }

                }
            }
        }
        return answer;
    }

    private static int bfs(String[][] zone, Queue<int[]> queue, String color) {
        int[] x = new int[] {0, 0, -1, 1};
        int[] y = new int[] {-1, 1, 0, 0};

        int count = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int k = 0; k < 4; k++) {
                int moveX = x[k] + poll[0];
                int moveY = y[k] + poll[1];

                if (moveX < M && moveY < N && moveX >= 0 && moveY >= 0) {   // 이동이 가능한지
                    if (!visit[moveX][moveY]) {
                        if (zone[moveX][moveY].equals(color)) {
                            count += 1;
                            visit[moveX][moveY] = true;
                            queue.add(new int[] {moveX, moveY});
                        }
                    }
                }
            }
        }

        return count;
    }
}
