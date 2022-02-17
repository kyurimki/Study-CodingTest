import java.io.*;

public class BOJ1992 {
    static int[][] img;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        img = new int[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++)
                img[i][j] = input.charAt(j) - '0';
        }

        quadTree(0, 0, N);
        System.out.print(sb);
    }

    private static void quadTree(int x, int y, int size) {
        if(isAvailable(x, y, size)) {
            sb.append(img[x][y]);
            return ;
        }

        sb.append('(');
        
        int nn = size / 2;
        quadTree(x, y, nn);
        quadTree(x, y+nn, nn);
        quadTree(x+nn, y, nn);
        quadTree(x+nn, y+nn, nn);

        sb.append(')');
    }

    private static boolean isAvailable(int x, int y, int size) {
        int start = img[x][y];

        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(start != img[i][j])
                    return false;
            }
        }
        return true;
    }
}