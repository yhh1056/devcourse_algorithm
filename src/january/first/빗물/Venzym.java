package january.first.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Venzym {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] hw = reader.readLine().split(" ");
        int w = Integer.parseInt(hw[1]);

        int[] block = new int[w];

        String[] heights = reader.readLine().split(" ");
        for (int i = 0; i < heights.length; i++) {
            block[i] = Integer.parseInt(heights[i]);
        }

        int result = 0;
        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            //왼쪽
            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(left, block[j]);
            }

            //우측
            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, block[j]);
            }

            int minHeight = Math.min(left, right);

            //자신 위치에서 채워야할 빗물
            //왼쪽과 오른쪽 모든 높이보다 작아야 빗물 채울 수 있음
            if (block[i] < left && block[i] < right) {
                result += (minHeight - block[i]);
            }
        }

        System.out.println(result);
    }
}
