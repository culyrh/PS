import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean arr[] = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] = true;
			}
			int cnt = 0;
			int pos = 0;
			while (pos + K < N) {
				int next = pos + K;
				while (arr[next] == false && next != pos) next --;
				if (next == pos) { cnt = 0; break; }
				pos = next;
				cnt++;
				// next != pos -> if (next ==pos)는 도착 불가한 경우
			}
			System.out.println("#" + i + " " + cnt);
		}
	}
}