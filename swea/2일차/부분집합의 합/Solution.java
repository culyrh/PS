import java.io.*;
import java.util.*;

class Solution {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int scount = 0;
			
			for (int j=0; j<4096; j++) {
				int temp = j;
				int cnt = 0;
				int sum = 0;
				
				// num번째 비트가 1 = 해당자리 숫자 num 포함
				for (int num=1; num<=12; num++) {
					if (temp % 2 == 1) {
						cnt++;
						sum += num;
					}
					temp /= 2;
				}
				if (cnt == N && sum == K) scount++;
			}
			System.out.println("#" + i + " " + scount);
		}
	}
}