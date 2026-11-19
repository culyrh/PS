import java.io.*;
import java.util.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] pattern = {
			"0001101", "0011001", "0010011", "0111101", "0100011",
			"0110001", "0101111", "0111011", "0110111", "0001011"
		};

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String code = "";
			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				if (code.equals("") && line.contains("1")) code = line;
			}

			int end = 0;
			for (int j = M - 1; j >= 0; j--) {
				if (code.charAt(j) == '1') {
					end = j;
					break;
				}
			}
			int start = end - 55;

			int[] num = new int[8];
			for (int k = 0; k < 8; k++) {
				String part = code.substring(start + k*7, start + k*7 + 7);
				for (int d = 0; d < 10; d++) {
					if (part.equals(pattern[d])) num[k] = d;
				}
			}

			int odd = num[0] + num[2] + num[4] + num[6];
			int even = num[1] + num[3] + num[5] + num[7];
			int answer = 0;
			if ((odd * 3 + even) % 10 == 0) answer = odd + even;

			System.out.println("#" + i + " " + answer);
		}
	}
}