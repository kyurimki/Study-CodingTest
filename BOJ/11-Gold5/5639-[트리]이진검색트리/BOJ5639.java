import java.io.*;

class Node5639 {
    int key;
    Node5639 left, right;

    public Node5639(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public Node5639(int key, Node5639 left, Node5639 right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    void insert(int cur) {
        if(this.key > cur) {
            if(this.left == null) this.left = new Node5639(cur);
            else this.left.insert(cur);
        } else {
            if(this.right == null) this.right = new Node5639(cur);
            else this.right.insert(cur);
        }
    }
}

public class BOJ5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node5639 tree = new Node5639(Integer.parseInt(br.readLine()));
        String input = "";
        while((input = br.readLine()) != null) tree.insert(Integer.parseInt(input));

        printTree(tree);
    }

    static void printTree(Node5639 cur) {
        if(cur == null) return ;

        printTree(cur.left);
        printTree(cur.right);
        System.out.println(cur.key);
    }
}