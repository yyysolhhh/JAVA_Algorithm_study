import javax.xml.ws.Holder;
import java.util.Scanner;
// 맞음
public class BJ_16394 {
    static int HONGIK = 1946;
    static int year;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        year = scanner.nextInt();
        System.out.println(year - HONGIK);
    }
}
