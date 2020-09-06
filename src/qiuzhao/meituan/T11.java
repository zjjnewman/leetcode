package qiuzhao.meituan;

import javax.swing.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class T11 {

    // 并集
    private static Integer[] getB(Integer[] m, Integer[] n) {
        // 数组转set
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(m));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(n));

        // 合并两集
        set1.addAll(set2);

        Integer[] arr = {};
        return set1.toArray(arr);
    }

    // 交集
    private static Integer[] getJ(Integer[] m, Integer[] n)
    {
        List<Integer> rs = new ArrayList<Integer>();

        // 数组转set
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短数组
        for (Integer i : m.length > n.length ? n : m)
        {
            if (set.contains(i))
            {
                rs.add(i);
            }
        }
        Integer[] arr = {};
        return rs.toArray(arr);
    }

    // 差集
    private static HashSet<Integer> getC(Integer[] m, Integer[] n){
        // 数组转set
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(m.length > n.length ? m : n));

        // 遍历较短数组
        for (Integer i : m.length > n.length ? n : m) {
            // 如果集合里有相同的就删掉，如果没有就将值添加到集合
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        Integer[] arr = {};
        return set;
    }

    // 集合a
    private static int A(HashSet<Integer> dSet, Integer[] x){
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(x));
        dSet.removeAll(set);
        return dSet.size();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // n块土地
        int n = scanner.nextInt();
        // A 希望的p块土地
        int p = scanner.nextInt();
        // B希望的 q块土地
        int q = scanner.nextInt();

        Integer[] ai = new Integer[p];
        Integer[] bi = new Integer[q];
        for (int i = 0; i < p; i++) {
            ai[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            bi[i] = scanner.nextInt();
        }

        Integer[] b = getB(ai, bi);


        Integer[] j = getJ(ai, bi);


        HashSet<Integer> c = getC(ai, bi);
        HashSet<Integer> d = new HashSet<>(c);
        // 返回a
        int one = A(c, bi);
        int two = A(d, ai);
        int three = j.length;
        System.out.println(one+" "+ two+" "+three);
    }
}
