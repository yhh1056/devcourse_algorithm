package january.first.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Youji2 {

    static int answer;
    static boolean[] myAlphabet;
    public static int Solution(int n, int k, String[] arr){
        answer=0;
        if(k < 5) return 0;   //최소 5개는 알아야 한다.
        if(k == 26) return n; //최대 26개 알면 다 안다.

        myAlphabet = new boolean[26];
        myAlphabet['a'-'a'] = true;
        myAlphabet['c'-'a'] = true;
        myAlphabet['i'-'a'] = true;
        myAlphabet['n'-'a'] = true;
        myAlphabet['t'-'a'] = true;

        BF(0, k,5, Arrays.stream(arr).collect(Collectors.toList()));
        return answer;
    }

    public static void BF(int index, int k, int cnt, List<String> list){
        if(cnt == k){
            int readCount=0;
            for(String s : list){
                boolean check = true;
                for(int i=4;i<s.length()-4;i++){
                    char c = s.charAt(i);
                    if(!myAlphabet[c-'a']){
                        check = false;
                        break;
                    }
                }
                if (check) readCount++;
            }
            answer = Math.max(answer,readCount);
            return;
        }
        else if(cnt > k) return;

        for(int i=index;i<26;i++){
            if(!myAlphabet[i]){
                myAlphabet[i] = true;
                BF(i+1, k,cnt+1, list);
                myAlphabet[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        System.out.println(Solution(n, k, arr));
    }
}
