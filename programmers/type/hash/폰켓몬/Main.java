import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] pokemon = new int[N];
        
        for (int i = 0; i < N; i++) {
            pokemon[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        HashSet<Integer> set = new HashSet<>();
        for (int num : pokemon) {
            set.add(num);
        }

        // (중복 제거 후의 폰켓몬 종류 수, 선택할 수 있는 폰켓몬 수/2)
        System.out.println(Math.min(set.size(), N / 2));
    }
}
