import java.io.*;

class Solution {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			String str1 = br.readLine();
			String str2 = br.readLine();
			
			int max = 0;
			for (int j=0; j<str1.length(); j++) {
				int cnt = 0;
				for (int k=0; k<str2.length(); k++) {
					if (str1.charAt(i) == str2.charAt(k)) cnt++;
				}
				if (cnt > max) max = cnt;
			}
			System.out.println("#" + i + " " + max);
		}
	}
}