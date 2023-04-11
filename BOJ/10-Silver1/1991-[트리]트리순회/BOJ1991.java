import java.io.*;
import java.util.*;

class Node1991 {
    char value;
    Node1991 left, right;

    public Node1991(char value, Node1991 left, Node1991 right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BOJ1991 {
    static Node1991 tree = new Node1991('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            addNode(tree, root, left, right);
        }

        preOrder(tree);
        System.out.println();
        inOrder(tree);
        System.out.println();
        postOrder(tree);
        System.out.println();
    }

    public static void addNode(Node1991 tree, char root, char left, char right) {
        if(tree.value == root) {
            tree.left = (left == '.' ? null : new Node1991(left, null, null));
            tree.right = (right == '.' ? null : new Node1991(right, null, null));
        } else {
            if(tree.left != null) addNode(tree.left, root, left, right);
            if(tree.right != null) addNode(tree.right, root, left, right);
        }
    }

    public static void preOrder(Node1991 cur) {
        if(cur == null) return ;
        System.out.print(cur.value);
        preOrder(cur.left);
        preOrder(cur.right);
    }

    public static void inOrder(Node1991 cur) {
        if(cur == null) return ;
        inOrder(cur.left);
        System.out.print(cur.value);
        inOrder(cur.right);
    }

    public static void postOrder(Node1991 cur) {
        if(cur == null) return ;
        postOrder(cur.left);
        postOrder(cur.right);
        System.out.print(cur.value);
    }
}
