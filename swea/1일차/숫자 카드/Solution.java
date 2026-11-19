import java.io.*;

class Solution {
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			int arr[] = new int[10];
			for (int j=0; j<N; j++) {
				int num = line.charAt(j) - '0';
				arr[num]++;
			}

			int idx = 0;
			int max = 0;
			for (int k=0; k<10; k++) {
				if (arr[k] >= max) {
					idx = k;
					max = arr[k];
				}
			}
			System.out.println("#" + i + " " + idx + " " + max);
		}
	}
}
