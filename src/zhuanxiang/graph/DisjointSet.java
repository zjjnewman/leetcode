package zhuanxiang.graph;

import java.util.Arrays;

/**
 * 并查集
 */
public class DisjointSet {

    /**
     * 查找某节点根节点
     * @param x 查找x的节点
     * @param parent 根节点关系数组，下标表示节点，数组值表示节点的父节点。
     * @return 返回根节点
     */
    public static int findRoot(int x, int[] parent){
        // 假设x的根节点是自己
        int xRoot = x;
        // 如果父节点节点不是-1，说明不是根，就把这个父节点当做当前节点，向上查找。
        if(parent[xRoot] != -1){
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    /**
     * 合并x、y所在的两颗树
     * @param x
     * @param y
     * @param parent
     * @return 若两个点可以合并 返回true，否则false（说明两个点已经在集合里面了，也说明图里面有环）
     */
    public static boolean unionVertices(int x, int y, int[] parent){
        int xRoot = findRoot(x, parent);
        int yRoot = findRoot(y, parent);
        if(xRoot==yRoot){
            return false;
        }
        parent[xRoot] = yRoot;
        return true;
    }

    public static void initialParent(int[] parent){
        Arrays.fill(parent, -1);
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0,1},
                {1,2},
                {1,3},
                {2,4},
                {3,4},
                {2,5}
        };
        int[] parent =new int[6];
        initialParent(parent);
        boolean b = true;
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if(!unionVertices(x, y, parent)){
                System.out.println("有环");
                return;
            }
        }
        System.out.println("无环");
    }
}
