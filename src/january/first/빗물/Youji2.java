package january.first.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Youji2 {

    public static int Solution(int H, int W, int[] blocks){
        int left=0;
        int right=0;
        int answer=0;
        int count =0;

        //왼쪽기둥 시작점 잡기
        for(int i=0;i<W;i++){
            if(blocks[i] > 0){
                left = i;
                break;
            }
        }

        //Left 기둥 보다 큰것 == 제일 높은 기둥 찾기
        for(int i=left+1;i<W;i++){
            if(blocks[left] <= blocks[i]){
                answer += count;
                count=0;
                left = i;
            }else{
                count += blocks[left]-blocks[i];
            }
        }

        count=0;
        right = W-1;
        while (left < right){
            for(int i=right-1;i>=left;i--){      //left(=제일 높은 기둥) 기둥까지
                if(blocks[right] <= blocks[i]){  //맨 오른쪽 기둥보다 작을시
                    right = i;                   //right 갱신
                }else{
                    count += blocks[right] - blocks[i];
                }
            }
        }
        answer += count;
        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(token.nextToken());
        int W = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());

        int[] arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        System.out.println(Solution(H, W, arr));

    }

}
