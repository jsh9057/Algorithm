package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class q2151 {
    static int[][] map;
    static boolean[][][] visit;
    static int N;

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N][4];

        int startY = -1, startX = -1;
        int endY = -1, endX = -1;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == '*') {
                    map[i][j] = -1;
                } else if (input.charAt(j) == '#') {
                    if (startY == -1) {
                        startY = i;
                        startX = j;
                    } else {
                        endY = i;
                        endX = j;
                    }
                    map[i][j] = 1;
                } else if (input.charAt(j) == '!') {
                    map[i][j] = 2;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            visit[startY][startX][i] = true;
            queue.add(new Node(startY, startX, i, 0));
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.y == endY && now.x == endX) {
                System.out.println(now.step);
                return;
            }
            if(map[now.y][now.x]==-1){ continue; }

            System.out.println("[" + now.y + "][" + now.x + "]");
            int ny = now.y + dy[now.pos];
            int nx = now.x + dx[now.pos];
            if(isRange(ny,nx) && !visit[ny][nx][now.pos]){
                visit[ny][nx][now.pos]=true;
                queue.add(new Node(ny,nx,now.pos,now.step));
            }
            if (map[now.y][now.x] == 2) {
                if (now.pos == 2 || now.pos == 3) {   // 남북 방향으로 들어왔다면
                    for (int i = 0; i < 2; i++) {
                        ny = now.y + dy[i];
                        nx = now.x + dx[i];
                        if (isRange(ny, nx) && !visit[ny][nx][i]) {
                            visit[ny][nx][i] = true;
                            queue.add(new Node(ny, nx, i, now.step + 1));
                        }
                    }

                } else {                           // 동서 방향으로 들어왔다면
                    for (int i = 2; i < 4; i++) {
                        ny = now.y + dy[i];
                        nx = now.x + dx[i];
                        if (isRange(ny, nx) && !visit[ny][nx][i]) {
                            visit[ny][nx][i] = true;
                            queue.add(new Node(ny, nx, i, now.step + 1));
                        }
                    }
                }
            }
        }
    }

    static boolean isRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    static class Node {
        int y, x;
        int pos;
        int step;

        public Node(int y, int x, int pos, int step) {
            this.y = y;
            this.x = x;
            this.pos = pos;
            this.step = step;
        }
    }

}
