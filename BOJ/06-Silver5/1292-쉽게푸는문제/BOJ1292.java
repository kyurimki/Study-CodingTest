import java.util.*;

public class BOJ1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();

		int num = 1;
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			arr.add(num);
			count++;
			if (num == count) {
				num++;
				count = 0;
			}
		}

        int sum = 0;
        for(int i = a; i <= b; i++) sum += arr.get(i-1);

        System.out.println(sum);

        sc.close();
    }
}