import java.io.*;
import java.util.*;

public class BOJ1168 {
    static int[] tree;

    private static int init(int node, int start, int end) {
        if(start == end)
            tree[node] = 1;
        else {
            int mid = (start + end) / 2;
            tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
        }
        return tree[node];  
    }

    private static int find(int node, int start, int end, int order) {
        if(start == end)
            return start;
        
        int mid = (start + end) / 2;
        if(order <= tree[node*2])
            return find(node*2, start, mid, order);
        else
            return find(node*2+1, mid+1, end, order-tree[node*2]);
    }

    private static int update(int node, int start, int end, int idx) {
        tree[node] -= 1;
        if(start == end)
            return 0;
            
        int mid = (start + end) / 2;
        if(idx <= mid)
            return update(node*2, start, mid, idx);
        else
            return update(node*2+1, mid+1, end, idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        tree = new int[n*4];

        init(1, 1, n);

        int index = 1;
        for(int i = 0; i < n; i++) {
            int size = n-i;
            index += (k-1);

            if(index % size == 0) index = size;
            else if(index > size) index %= size;

            int num = find(1, 1, n, index);
            update(1, 1, n, num);

            sb.append(num);
            if(i < n-1) sb.append(", ");
        }

        sb.append('>');

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}