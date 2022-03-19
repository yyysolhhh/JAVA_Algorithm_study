import java.util.Scanner;

public class BJ_1924 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		in.close();
		int day = y - 1;
		String[] weekday = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		for (int i = 1; i < x; i++) {
			if (i == 2) {
				day += 28;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				day += 30;
			} else {
				day += 31;
			}
		}
		day %= 7;
		System.out.println(weekday[day]);
	}

}
