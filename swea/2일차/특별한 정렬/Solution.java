import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[N];
			for (int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int max[] = new int[N/2];
			int min[] = new int[N/2];
			int mid = 0;
			for (int l=0; l<N/2; l++) {
				min[l] = arr[l];   // 0 1 2 3 4
				max[l] = arr[N-l-1];   // 10 9 8 7 6 
			}
			if (N%2 == 1) mid = arr[N/2];   // 5
			for (int m=0; m<N/2; m++) {
				arr[2*m] = max[m];
				arr[2*m+1] = min[m];
			}
			if (N%2 == 1) arr[N-1] = mid;
			
			System.out.print("#" + i + " ");
			for (int res = 0; res < 10; res++) {
				System.out.print(arr[res] + " ");
			}
			System.out.println();
		}
	}
}