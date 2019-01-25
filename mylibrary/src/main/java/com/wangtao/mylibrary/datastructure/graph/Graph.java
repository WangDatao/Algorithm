package com.wangtao.mylibrary.datastructure.graph;

import java.util.LinkedList;

/**
 * @author wangtao
 * @Description:图 两种表示方法：①邻接矩阵法；②：邻接表（哈希表、调表、平衡二叉查找树）
 * @date 2019/1/25 10:10
 */
public class Graph {
    //顶点个数
    private int v;
    private LinkedList<Integer> adj[];//邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图，两个顶点同时建立指向关系
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

}
