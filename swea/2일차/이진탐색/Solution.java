import java.io.*;
import java.util.*;

class Solution {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int page = Integer.parseInt(st.nextToken());
			int pa = Integer.parseInt(st.nextToken());
			int pb = Integer.parseInt(st.nextToken());
			
			int a = 0;
			int b = 0;
			int c = 0;
			int l =0, r = 0;
			
			while (c != pa) {
				if (a == 0) { 
					l = 1;
					r = page;
				}
				c = (l+r)/2;
				
				if (pa > c && pa < r) { 
					l = c;
				} else if (pa < c && pa > l) { 
					r = c; 
				}
				a++;
			}
			
			c = 0;
			while (c != pb) {
				if (b == 0) { 
					l = 1;
					r = page;
				}
				c = (l+r)/2;
				
				if (pb > c && pb < r) { 
					l = c;
				} else if (pb < c && pb > l) { 
					r = c; 
				}
				b++;
			}
			if (a<b) System.out.println("#" + i + " A");
			if (a>b) System.out.println("#" + i + " B");
			if (a==b) System.out.println("#" + i + " 0");
		}
	}
}