import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=1; i<=10; i++) {
			int dump = Integer.parseInt(br.readLine());
			int arr[] = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			while (dump > 0) {
				Arrays.sort(arr);
				if ((arr[99] - arr[0]) <=1) break;
				arr[99]--;
				arr[0]++;
				dump--;
			}
			Arrays.sort(arr);
			System.out.println("#" + i + " " + (arr[99]-arr[0]));
		}
	}
}