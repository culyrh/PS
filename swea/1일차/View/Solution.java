import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i=1; i<=10; i++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int k=2; k<N-2; k++) {
				int around = Math.max(Math.max(arr[k-2], arr[k-1]), Math.max(arr[k+1], arr[k+2]));
				if (arr[k] > around) cnt += arr[k] - around;
			}
			System.out.println("#"+ i + " " + cnt);
		}
	}
}
