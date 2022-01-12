import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_1330 {

	public static void main(String[] args) throws IOException {
		
		// 1
//		Scanner scanner = new Scanner(System.in);
//		int A = scanner.nextInt();
//		int B = scanner.nextInt();
//		scanner.close();
//		if (A > B) {
//			System.out.println(">");
//		} else if (A < B) {
//			System.out.println("<");
//		} else {
//			System.out.println("==");
//		}
		
		// 2
//		Scanner scanner = new Scanner(System.in);
//		int A = scanner.nextInt();
//		int B = scanner.nextInt();
//		scanner.close();
//		String str = A > B ? ">" : (A < B) ? "<" : "==";
//		System.out.println(str);
		
		// 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str3 = br.readLine();
		StringTokenizer st = new StringTokenizer(str3, " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		System.out.println((A > B) ? ">" : ((A < B) ? "<" : "=="));
		
		// 4
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String[] str4 = br2.readLine().split(" ");
		int a = Integer.parseInt(str4[0]);
		int b = Integer.parseInt(str4[1]);
		System.out.println((a > b) ? ">" : ((a < b) ? "<" : "=="));
		
	}

}
