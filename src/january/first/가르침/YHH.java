package january.first.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 참고 주소 : https://moonsbeen.tistory.com/188
public class YHH {
    static int N;
    static int K;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            words[i] = str.replace("anta", "").replace("tica", "");
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        backtracking(0, 0);
        System.out.println(max);
    }

    public static void backtracking(int word, int len) {
        if (len == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean read = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = word; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, len + 1);
                visited[i] = false;
            }
        }
    }
}
