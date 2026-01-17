import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            LinkedList<int[]> q = new LinkedList<>();
            input = br.readLine().split(" ");

            for (int i=0; i<N; i++) {
                q.offer(new int[] {i, Integer.parseInt(input[i])});
            }

            int cnt = 0;

            while(!q.isEmpty()) {

                int[] front = q.poll();
                boolean isMax = true;   // front가 가장 큰 원소인지

                for (int i=0; i<q.size(); i++) {

                    /* 처음 뽑은 원소보다 큐에있는 i번째 원소 중요도가 클 경우
                       뽑은 원소와 i 이전의 원소들을 뒤로 보냄 */
                    if(front[1] < q.get(i)[1]) {  
                        q.offer(front);
                        for (int j=0; j<i; j++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                // front가 가장 큰 원소가 아니면 다음 반복문으로
                if(isMax == false) continue;

                cnt++;
                if(front[0] == M) break;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}