import java.util.Scanner;

public class BJ_5596 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int mg = 0;
		int ms = 0;
		for (int i = 0; i < 4; i++) {
			int score = in.nextInt();
			mg += score;
		}
		for (int i = 0; i < 4; i++) {
			int score = in.nextInt();
			ms += score;
		}
		in.close();
		System.out.println(mg > ms ? mg : ms);
	}

}

