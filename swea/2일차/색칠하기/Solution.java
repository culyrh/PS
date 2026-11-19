import java.io.*;
import java.util.*;

class Solution {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			int line = Integer.parseInt(br.readLine());
			boolean red[][] = new boolean[10][10];
			boolean blue[][] = new boolean[10][10];
			for (int j=0; j<line; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken());
				int c1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());

				if (color == 1) {
					for (int k=r1; k<=r2; k++) {
						for (int l=c1; l<=c2; l++) {
							red[k][l] = true;
						}
					}
				} else {
					for (int k=r1; k<=r2; k++) {
						for (int l=c1; l<=c2; l++) {
							blue[k][l] = true;
						}
					}
				}
				
			}
			int cnt = 0;
			for (int k=0; k<10; k++) {
				for (int l=0; l<10; l++) {
					if (red[k][l] && blue[k][l]) cnt++;
				}
			}
			System.out.println("#" + i + " " + cnt);
		}
	}
}

