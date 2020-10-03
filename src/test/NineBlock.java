package test;

public class NineBlock {
    private static int[][] ma = new int[3][3];
    private static int[] st = new int[10];

    public static void main(String[] args) {
        dfs(0, 0);
    }

    private static void dfs(int x, int y) {
        int xx = x, yy = y;
        if (y == 3) {
            xx += 1;
            yy = 0;
        }
        if (xx == 3) {
            if (check(ma)) {
                print(ma);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (st[i] == 0) {
                st[i] = 1;
                ma[xx][yy] = i;
                dfs(xx, yy + 1);
                st[i] = 0;
                ma[xx][yy] = 0;
            }
        }
    }

    private static boolean check(int[][] ma) {
        int[] colVal = new int[3];
        int[] rowVal = new int[3];
        int[] ancel = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                colVal[i] += ma[j][i];
            }
            if (colVal[i] != 15) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rowVal[i] += ma[i][j];
            }
            if (rowVal[i] != 15) return false;
        }

        ancel[0] = ma[0][2] + ma[1][1] + ma[2][0];
        ancel[1] = ma[0][0] + ma[1][1] + ma[2][2];
        for (int i = 0; i < 2; i++) {
            if (ancel[i] != 15) return false;
        }

        return true;
    }

    private static void print(int[][] ma) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ma[i][j] + " ");
            }
            System.out.println("-----------");
        }
    }

}