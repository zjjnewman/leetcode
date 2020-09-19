package qiuzhao.kedaxunfei;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1 {
    static long ret = 0;

    static class Helper{
        public int i = -1;
        public int j = -1;
        public long num;
    }

    public static void dfs(long[][] matrix, List<Helper> combine){
        if(combine.size() == 2){
            ret = Math.max(combine.get(0).num * combine.get(1).num, ret);
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(combine.size() == 1 && combine.get(0).j!=j && combine.get(0).i!=i){
                    Helper helper = new Helper();
                    helper.i=i;
                    helper.j=j;
                    helper.num= matrix[i][j];
                    combine.add(helper);
                    dfs(matrix, combine);
                    combine.remove(combine.size() - 1);
                } else if(combine.size()==0){
                    Helper helper = new Helper();
                    helper.i=i;
                    helper.j=j;
                    helper.num= matrix[i][j];
                    combine.add(helper);
                    dfs(matrix, combine);
                    combine.remove(combine.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            long[][] matrix = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j]=in.nextInt();
                }
            }
            ArrayList<Helper> combine = new ArrayList<>();
            ret = 0;
            dfs(matrix, combine);
            System.out.println(ret);
        }
    }
}
