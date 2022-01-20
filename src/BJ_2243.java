package Day04.BJ_2243;
// 맞음
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2243 {

    static int n;
    static int A, B, C;

    static int[] tree;

    static int MAX = 1000000;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        S = 1;
        while (S < MAX) {
            S *= 2;
        }
        tree = new int[S * 2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 사탕 넣을 때
            if (A == 2) {
                C = Integer.parseInt(st.nextToken());
                update(1, S, 1, B, C);
            }
            // 사탕 뺄 때
            else if (A == 1) {
                int index = query(1, S, 1, B);
                update(1, S, 1, index, -1);
                System.out.println(index);
            }
        }
    }

    static int query(int left, int right, int node, int count) {
        // leaf 도달 -> 노드(사탕 번호) 반환
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        // 왼쪽 개수 >= count -> 왼쪽으로 Q
        if (tree[node * 2] >= count) {
            return query(left, mid, node * 2, count);
        }
        // 왼쪽 개수 < count -> 오른쪽으로 Q - 왼쪽개수
        else {
            return query(mid + 1, right, node * 2 + 1, count - tree[node * 2]);
        }
//        // 왼쪽 >= query -> 왼쪽으로 Q
//        int mid = (left + right) / 2;
//        long sum = 0;
//        if (query <= tree[left]) {
//            long leftResult = query(left, mid, node * 2, query);
//            target = node;
//            return tree[node];
//        }
//        // 왼쪽 < query -> 오른쪽으로 Q-leftResult
//        else if (tree[left] < query){
//            query -= tree[left];
//            long rightResult = query(mid + 1, right, node * 2 + 1, query);
//            return rightResult;
//        }
    }

    static void update(int left, int right, int node, int target, int diff) {
        if (left <= target && target <= right) {
            tree[node] += diff;
            if (left!= right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
