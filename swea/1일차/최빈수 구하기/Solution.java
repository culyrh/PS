import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i=0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[101];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<1000; j++) {
				int prev = Integer.parseInt(st.nextToken());
				arr[prev] ++;
			}

			int max = 0;
			for (int k=1; k<=100; k++) {
				if(arr[k] >= arr[max]) max = k;
			}
			System.out.println("#" + num + " " + max);
		}
	}
}
