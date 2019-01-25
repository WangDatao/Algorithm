package com.wangtao.mylibrary.datastructure.topological;

import java.util.LinkedList;

/**
 * @author wangtao
 * @Description:拓扑排序：有向无环图 ， Kahn算法，图的深度优先搜索算法
 * @date 2019/1/25 16:33
 */
public class TopoSort {

    public class Graph {
        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        //有向图
        public void addEdge(int s, int t) { // s 先于 t，边 s->t
            adj[s].add(t);
        }
    }

    /**
     * Kahn 算法：贪心思想
     *
     * @param v
     * @param graph
     */
    public void topoSortByKahn(int v, Graph graph) {
        LinkedList<Integer>[] adj = graph.adj;

        int[] inDegree = new int[v]; // 统计每个顶点的入度
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < adj[i].size(); ++j) {
                int w = adj[i].get(j); // i->w
                inDegree[w]++;
            }
        }
        //入度为0的顶点
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); ++j) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }


}
