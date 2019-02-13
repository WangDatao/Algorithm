package com.wangtao.mylibrary.dynamicprogramming;

import java.util.LinkedList;

/**
 * @author wangtao
 * @Description:最短路径：Dijkstra算法
 * @date 2019/2/13 10:23
 */
public class ShortestPath {
    //有向有权图
    public static class Graph {
        //邻接表
        private LinkedList<Edge>[] adj;
        //顶点个数
        private int v;

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w) {
            this.adj[s].add(new Edge(s, t, w));
        }
    }

    //边
    public static class Edge {
        //边起始顶点id
        public int sid;
        //边的终止顶点id
        public int tid;
        //权重
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    //顶点
    public static class Vertex {
        public int id;
        public int dist;//起始顶点（不是上个邻接的顶点）到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }


    //java提供的优先级队列,没有更新数据的接口，自己实现一个
    private class PriorityQueue {
        //根据vertex.dist 构建小顶堆
        private Vertex[] nodes;
        private int capacity;
        private int count;

        public PriorityQueue(int capacity) {
            this.capacity = capacity;
            //从下标1开始存储数据
            this.nodes = new Vertex[capacity + 1];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        /**
         * 取出堆顶元素
         *
         * @return
         */
        public Vertex poll() {
            if (isEmpty()) return null;
            Vertex vertex = nodes[1];
            //堆化
            nodes[1] = nodes[count];
            nodes[count] = null;
            --count;
            heapifyUTD(nodes, 1, count);

            return vertex;
        }

        /**
         * 增加节点
         *
         * @param vertex
         */
        public void add(Vertex vertex) {
            if (count == capacity) return;
            ++count;
            nodes[count] = vertex;
            //堆化
            heapifyDTU(nodes, count);
        }

        /**
         * 更新Vertex dist
         *
         * @param vertex
         */
        public void update(Vertex vertex) {
            //遍历
            for (int i = 1; i < count; i++) {
                if (nodes[count].id == vertex.id) {
                    nodes[count].dist = vertex.dist;
                    //自小而上堆化，因为新的vertex.dist 更小
                    heapifyDTU(nodes, i);
                    break;
                }
            }
        }

        /**
         * 从上往下堆化
         */
        private void heapifyUTD(Vertex[] nodes, int i, int count) {
            while (true) {
                int minPos = i;
                if (i * 2 <= count && nodes[i * 2].dist < nodes[i].dist) minPos = i * 2;
                if (i * 2 + 1 <= count && nodes[i * 2 + 1].dist < nodes[minPos].dist)
                    minPos = i * 2 + 1;
                if (minPos == i) break;
                swapVertex(nodes, i, minPos);
                i = minPos;
            }
        }

        /**
         * 从下往上堆化
         *
         * @param nodes
         * @param i
         */
        private void heapifyDTU(Vertex[] nodes, int i) {
            while (i / 2 > 0 && nodes[i].dist < nodes[i / 2].dist) {
                swapVertex(nodes, i, i / 2);
                i = i / 2;
            }
        }

        private void swapVertex(Vertex[] vertexes, int i1, int i2) {
            Vertex tmp = vertexes[i1];
            vertexes[i1] = vertexes[i2];
            vertexes[i2] = tmp;
        }

    }

    public void dijkstra(Graph graph, int count, int s, int t) {
        //还原最短路径
        int[] predecessor = new int[count];
        //用于保存节点的dist
        Vertex[] vertexes = new Vertex[count];
        for (int i = 0; i < count; i++) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        //小顶堆
        PriorityQueue queue = new PriorityQueue(count);
        //标记是否进过队列
        boolean[] inqueue = new boolean[count];
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;

        while (!queue.isEmpty()) {
            //取堆顶元素
            Vertex minV = queue.poll();
            //找到最短路径
            if (minV.id == t) break;
            for (int i = 0; i < graph.adj[minV.id].size(); i++) {
                //取相邻的边
                Edge edge = graph.adj[minV.id].get(i);
                Vertex nextVertex = vertexes[edge.tid];
                //有更小的距离
                if (minV.dist + edge.w < nextVertex.dist) {
                    nextVertex.dist = minV.dist + edge.w;
                    predecessor[nextVertex.id] = minV.id;
                    //加入过队列中（访问过这个点）
                    if (inqueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }

        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }
}
