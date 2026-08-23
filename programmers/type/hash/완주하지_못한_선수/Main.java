import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] participant = new String[N];
        for (int i=0; i<N; i++) {
            participant[i] = st.nextToken();
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        String[] completion = new String[M];
        for (int i=0; i<M; i++) {
            completion[i] = st.nextToken();
        }

        // 풀이
        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        String answer = "";
        for (String p : participant) {
            if (map.get(p) > 0) {
                answer = p;
                break;
            }
        }

        System.out.println(answer);
    }
}