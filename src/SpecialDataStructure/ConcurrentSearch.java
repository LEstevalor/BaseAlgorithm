package SpecialDataStructure;

public class ConcurrentSearch {
    // n是可定义的并查集数
    private int n;
    private int[] father;

    // 构造函数——初始化
    public ConcurrentSearch(int n) {
        this.n = n;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    // 查找
    public int find(int u) {
        return u == father[u] ? u : (father[u]=find(father[u])); // father[u]=find(father[u])保证及时更新根节点
    }

    // 合并
    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) father[v] = u;   // v的父节点被更替为u，加入并查集u的树
    }

    // 判断是否是同一个根节点
    public boolean same(int u, int v) {
        return find(u) == find(v);
    }
}
