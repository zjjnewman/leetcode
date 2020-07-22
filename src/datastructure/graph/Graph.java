package datastructure.graph;

public interface Graph {
    // 顶点 vertex
    int V();
    // 边 edge
    int E();

    void addEdge(int v, int w);

    // 遍历给定点的所有相邻点 adjoin
    Iterable<Integer> adj(int v);
}
