import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        int answer = 1;

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] clothes = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            clothes[i][0] = st.nextToken(); // 의상 이름
            clothes[i][1] = st.nextToken(); // 의상 종류
        }

        // 풀이
        HashMap<String, Integer> map = new HashMap<>();
        
        // clothes =[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"],
        // ["green_turban", "headgear"]]
        // map = {headgear=2, eyewear=1}
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (int cnt : map.values()) {
            answer *= (cnt + 1);
        }

        answer -= 1;

        System.out.println(answer);
    }
}