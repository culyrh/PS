import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean answer = true;

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] phone_book = new String[N];
        for (int i=0; i<N; i++) {
            phone_book[i] = st.nextToken();
        }

        // 풀이
        HashSet<String> set = new HashSet<>();

        for (String phone : phone_book) {
            set.add(phone);
        }

        for (String phone : phone_book) {
            String prefix = "";

            for (int i = 0; i < phone.length(); i++) {
                prefix += phone.charAt(i);
                
                // 순회중인 전호번호(prefix)가 hashset에 존재하고, 
                // 현재 순회중인 전화번호가 아닌 경우 answer->false
                if (set.contains(prefix) && !prefix.equals(phone)) {
                    answer = false;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}