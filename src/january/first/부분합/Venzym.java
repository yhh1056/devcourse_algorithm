package january.first.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Venzym {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int start = 0; start < N; start++) {
            while (sum < S && end < N) {
                sum += arr[end++];
            }

            if (sum >= S) {
                result = Math.min(result, end - start);
            }

            sum -= arr[start];
        }

        if (result == Integer.MAX_VALUE) {
            result = 0;
        }

        System.out.println(result);
    }
}
