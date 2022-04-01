import java.io.*;
import java.util.*;
import java.awt.*;

class Student21608 {
    int num;
    ArrayList<Integer> friends;

    public Student21608(int num, ArrayList<Integer> friends) {
        this.num = num;
        this.friends = friends;
    }
}

public class BOJ21608 {
    static int N;
    static ArrayList<Student21608> students;
    static Student21608[][] seat;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        students = new ArrayList<>();
        seat = new Student21608[N][N];
        for(int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < 4; j++)
                tmp.add(Integer.parseInt(st.nextToken()));
            students.add(new Student21608(s, tmp));
        }

        findSeat();
        System.out.println(getSatisfaction());
    }

    private static void findSeat() {
        for(int s = 0; s < N*N; s++) {
            Student21608 student = students.get(s);
            ArrayList<Point> available = new ArrayList<>();

            // 1. 비어 있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸
            int max = -1;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(seat[i][j] == null) {
                        int cnt = 0;
                        for(int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];
                            if(isIn(x, y) && seat[x][y] != null) {
                                if(student.friends.contains(seat[x][y].num)) cnt++;
                            }
                        }
                        if(cnt > max) {
                            max = cnt;
                            available.clear();
                            available.add(new Point(i, j));
                        } else if(cnt == max) {
                            available.add(new Point(i, j));
                        }
                    }
                }
            }
            if(available.size() == 1) {
                seat[available.get(0).x][available.get(0).y] = student;
                continue;
            }

            // 2. 인접한 칸 중에서 비어 있는 칸이 가장 많은 칸
            max = -1;
            ArrayList<Point> tmp = new ArrayList<>();
            for(Point p : available) {
                int cnt = 0;
                for(int k = 0; k < 4; k++) {
                    int x = p.x + dx[k];
                    int y = p.y + dy[k];
                    if(isIn(x, y) && seat[x][y] == null) cnt++;
                }
                if(cnt > max) {
                    max = cnt;
                    tmp.clear();
                    tmp.add(p);
                } else if(cnt == max)
                    tmp.add(p);
            }
            available = tmp;

            seat[available.get(0).x][available.get(0).y] = student;
        }
    }     

    private static boolean isIn(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }

    private static int getSatisfaction() {
        int sum = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int cnt = 0;
                for(int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(isIn(x, y) && seat[i][j].friends.contains(seat[x][y].num)) cnt++;
                }
                if(cnt != 0)
                    sum += Math.pow(10, cnt-1);
            }
        }

        return sum;
    }
}