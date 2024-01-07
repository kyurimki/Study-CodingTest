/*
 * 2024.01.07
 * preOrder: root -> left -> right
 * inOrder: left -> root -> right
 * postOrder: left -> right -> root
 * 포스트오더 제일 마지막은 최상위 루트 노드
 * 인오더는 루트 노드를 알 때, 왼쪽/오른쪽 자식 노드로 구분 가능
 * -> 최상위 루트 노드를 구한 후 인오더에서 왼쪽/오른쪽 자식 노드로 구분해 재귀로 분할 정복
 * +인오더에서 인덱스 1인 값을 구하기 위해서 inOrderIdx 저장
 */
import java.io.*;
import java.util.*;

public class BOJ2263 {
    static int n;
    static int[] preOrder, inOrder, postOrder, inOrderIdx;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        preOrder = new int[n]; inOrder = new int[n]; postOrder = new int[n]; inOrderIdx = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) inOrder[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIdx[inOrder[i]] = i;
        }
        
        getPreOrder(0, n-1, 0, n-1);
        System.out.println(sb);
    }

    private static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return ;

        int root = postOrder[postEnd];
        sb.append(root).append(' ');

        int rootIdx = inOrderIdx[root];
        int leftLen = rootIdx - inStart;

        getPreOrder(inStart, rootIdx-1, postStart, postStart+leftLen-1);
        getPreOrder(rootIdx+1, inEnd, postStart+leftLen, postEnd-1);
    }
}
