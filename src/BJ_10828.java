import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BJ_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		// 1 if문
//		for (int i = 0; i < N; i++) {
//			String command = br.readLine();
//			
//			if (command.contains("push")) {
//				String[] sp_cm = command.split(" ");
//				stack.push(Integer.parseInt(sp_cm[1]));
//			} else if (command.contains("pop")) {
//				if (!stack.empty()) {
//					bw.write(stack.pop() + "\n");
//				} else {
//					bw.write("-1" + "\n");
//				}
//			} else if (command.contains("size")) {
//				bw.write(stack.size() + "\n");
//			} else if (command.contains("empty")) {
//				if (!stack.empty()) {
//					bw.write("0" + "\n");
//				} else {
//					bw.write("1" + "\n");
//				}
//			} else if (command.contains("top")) {
//				if (!stack.empty()) {
//					bw.write(stack.peek() + "\n");
//				} else {
//					bw.write("-1" + "\n");
//				}
//			}
//		}
		
		// 2 swich 문
		for (int i = 0; i < N; i++) {
			String[] command2 = br.readLine().split(" ");
			
			switch (command2[0]) {
			case "push":
				stack.push(Integer.parseInt(command2[1]));
				break;
			case "pop":
				if (stack.empty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(stack.pop() + "\n");
				}
				break;
			case "size":
				bw.write(stack.size() + "\n");
				break;
			case "empty":
				if (stack.empty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
				break;
			case "top":
				if (stack.empty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(stack.peek() + "\n");
				}
				break;
			default:
				break;
			}
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
