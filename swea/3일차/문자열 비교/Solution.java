import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			String str1 = br.readLine();
			String str2 = br.readLine();
			int answer = 0;
			
			for (int i=0; i<str2.length()-str1.length()+1; i++) {
				for (int j=0; j<str1.length(); j++) {
					if (str1.charAt(j) != str2.charAt(i+j)) break;
					if (j == str1.length()-1) answer = 1;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}