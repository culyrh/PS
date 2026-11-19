import java.io.*;
import java.util.*;

class Solution {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<10; i++) {
			int T = Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
			for (int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k=0; k<100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int j=0; j<100; j++) {
				int width = 0;
				int depth = 0;
				for (int k=0; k<100; k++) { width += arr[j][k]; }
				if (width > max) max = width;
				for (int l=0; l<100; l++) { depth += arr[l][j]; }
				if (depth > max) max = depth;
			}

			int lside = 0;
			int rside = 0;
			for (int m=0; m<100; m++) {
				lside += arr[m][m];
				rside += arr[m][99-m];
			}
			if (lside > max) max = lside;
			if (rside > max) max = rside;
			System.out.println("#" + T + " " + max);
		}
	}
}
