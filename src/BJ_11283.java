import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 맞음
public class BJ_11283 {
    static char letter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        letter = br.readLine().charAt(0);
        System.out.println(letter - '가' + 1);

    }
}
