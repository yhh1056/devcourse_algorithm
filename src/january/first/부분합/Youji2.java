package january.first.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Youji2 {

    public static int Solution(int n, int s, int[] arr){
        int length = -1;
        int left=0, right=0;
        int sum = arr[0]; //초기값 설정

        while(left <= right && right < n) {

            if(sum < s) {
                right+=1;
                if(right < n){
                    sum += arr[right];
                }
            }else if(sum >= s) { //s보다 같거나 클때 길이 비교하여 최솟값 설정
                int length2 = right - left +1;
                if(length == -1 || length2 < length) {
                    length = length2;
                }
                sum -= arr[left]; //왼쪽값 제거
                left++;           //left += 1
            }
        }
        if(length != -1) return length;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int s = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(Solution(n, s, arr));
    }
}
