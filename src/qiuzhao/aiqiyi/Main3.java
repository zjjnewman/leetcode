package qiuzhao.aiqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 机器人
 */
public class Main3 {
    public static boolean isPathCrossing(String path) {
        Set<Integer> vis = new HashSet<Integer>();

        int x = 0, y = 0;
        vis.add(getHash(x, y));

        int length = path.length();
        for (int i = 0; i < length; i++) {
            char dir = path.charAt(i);
            switch (dir) {
                case 'N': --x; break;
                case 'S': ++x; break;
                case 'W': --y; break;
                case 'E': ++y; break;
            }
            int hashValue = getHash(x, y);
            if (!vis.add(hashValue)) {
                return true;
            }
        }

        return false;
    }

    public static int getHash(int x, int y) {
        return x * 20001 + y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        if(isPathCrossing(path)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
