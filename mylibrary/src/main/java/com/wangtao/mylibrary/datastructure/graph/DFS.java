package com.wangtao.mylibrary.datastructure.graph;

import java.util.LinkedList;

/**
 * @author wangtao
 * @Description:深度优先搜索：回溯思想，递归实现
 * @date 2019/1/25 14:39
 */
public class DFS {
    private int v;
    private Graph mGraph;
    boolean found = false;

    public DFS(int v, Graph graph) {
        this.v = v;
        mGraph = graph;
    }

    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        //初始化
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    /**
     * 递归调用
     *
     * @param s
     * @param t
     * @param visited
     * @param prev
     */
    private void recurDfs(int s, int t, boolean[] visited, int[] prev) {
        if (found)
            return;
        visited[s] = true;

        if (s == t) {
            found = true;
            return;
        }

        LinkedList<Integer> list = mGraph.getAdj()[s];

        for (int i = 0; i < list.size(); i++) {
            Integer q = list.get(i);
            if (!visited[q]) {
                prev[q] = s;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }
}
