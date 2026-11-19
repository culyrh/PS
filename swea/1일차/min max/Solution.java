import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i=1; i<=T; i++) {
			int num = Integer.parseInt(br.readLine());
			int arr[] = new int[num];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<num; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			System.out.println("#" + i + " " + (arr[num-1]-arr[0]));
		}
	}
}