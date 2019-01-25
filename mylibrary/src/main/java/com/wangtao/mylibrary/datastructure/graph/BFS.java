package com.wangtao.mylibrary.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtao
 * @Description:广度优先搜索
 * @date 2019/1/25 10:04
 */
public class BFS {
    private int v;
    private Graph mGraph;

    public BFS(int v, Graph graph) {
        this.v = v;
        mGraph = graph;
    }

    /**
     * 广度优先搜索
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //记录访问过的顶点
        boolean[] visited = new boolean[v];
        //存储被访问到的顶点
        Queue<Integer> queue = new LinkedList<>();
        //记录访问的路径
        int[] pre = new int[v];
        //初始化
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        //开始顶点先加入队列
        queue.add(s);
        //队列不空
        while (queue.size() != 0) {
            int w = queue.poll();
            LinkedList<Integer> list = mGraph.getAdj()[w];
            for (int i = 0; i < list.size(); i++) {
                Integer q = list.get(i);
                if (!visited[q]) {
                    pre[q] = w;
                    if (q == t) {
                        print(pre, s, t);
                        return;
                    }
                    queue.add(q);
                    visited[q] = true;
                }
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
