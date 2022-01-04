package january.first.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class YHH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Word> words = new PriorityQueue<>();

        Set<String> learn = new HashSet<>();
        learn.add("a");
        learn.add("n");
        learn.add("t");
        learn.add("i");
        learn.add("c");

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (String s : learn) {
                word = word.replace(s, "");
            }

            words.offer(new Word(word));
        }

        int result = 0;

        while (!words.isEmpty()) {
            Word word = words.poll();
            for (int i = 0; i < word.name.length(); i++) {
                String s = Character.toString(word.name.charAt(i));
                learn.add(s);
            }
            int max = learn.size();

            if (max > K) {
                break;
            } else {
                result++;
            }
        }

        System.out.println(result);
    }
}

class Word implements Comparable<Word> {
    String name;

    public Word(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Word o) {
        return this.name.length() - o.name.length();
    }

}