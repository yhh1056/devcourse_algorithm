package january.first.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YHH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        boolean[][] visit = new boolean[h][w];

        for (int i = 0; i < w; i++) {
            int depth = Integer.parseInt(st.nextToken());
            full(i, visit, depth);
        }

        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result += find(visit, i, j);
            }
        }

        System.out.println(result);

    }

    private static void full(int index, boolean[][] visit, int depth) {
        int temp = 0;
        for (int i = 0; i < depth; i++) {
            visit[temp][index] = true;
            temp++;
        }
    }

    private static int find(boolean[][] visit, int x, int y) {
        if (visit[x][y]) {
            return 0;
        }

        if (isExistRight(visit, x, y) && isExistLeft(visit, x, y)) {
            visit[x][y] = true;
            return 1;
        }

        return 0;
    }

    private static boolean isExistRight(boolean[][] visit, int x, int y) {
        for (int i = y; i < visit[0].length; i++) {
            if (visit[x][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isExistLeft(boolean[][] visit, int x, int y) {
        for (int i = y; i >= 0; i--) {
            if (visit[x][i]) {
                return true;
            }
        }
        return false;
    }
}
