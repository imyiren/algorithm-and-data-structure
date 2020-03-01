package com.imyiren.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 邻接矩阵实现无向图结构
 *
 * @author yiren
 */
public class Graph {
    /**
     * 顶点集合
     */
    public List<String> vertexList;
    /**
     * 邻接矩阵
     */
    public int[][] edges;

    /**
     * 边条数
     */
    public int numsOfEdges;

    public boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numsOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 插入节点
     *
     * @param vertex 节点信息
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 连接顶点
     *
     * @param vStart 起始点
     * @param vEnd   终止点
     * @param weight 权重
     */
    public void insertEdge(int vStart, int vEnd, int weight) {
        edges[vStart][vEnd] = weight;
        edges[vEnd][vStart] = weight;
        numsOfEdges++;
    }

    public int getNumsOfVertex() {
        return vertexList.size();
    }

    public int getNumsOfEdges() {
        return numsOfEdges;
    }

    public String getValue(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int vStart, int vEnd) {
        return edges[vStart][vEnd];
    }

    public void showGraph() {
        for (int[] arr : edges) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 得到下一个邻接节点的下标
     *
     * @param i
     * @return
     */
    public int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int i) {
        System.out.print(getValue(i));
        if (i < isVisited.length - 1) {
            System.out.print("->");
        }
        // 标记为被访问了
        isVisited[i] = true;

        // 找到当前节点的 相连节点
        int w = -1;
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[i][j] > 0) {
                w = j;
                break;
            }
        }

        // 有相连的节点
        while (w != -1) {
            if (!isVisited[w]) {
                // 如果没被访问就直接访问它
                dfs(isVisited, w);
            }
            // 然后跳到下一个，继续寻找幸运儿
            boolean flag = true;
            for (int j = w + 1; j < vertexList.size(); j++) {
                if (edges[i][j] > 0) {
                    flag = false;
                    w = j;
                    break;
                }
            }
            // 没有找到幸运儿
            if (flag) {
                w = -1;
            }
        }
    }

    public void dfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        String[] vertexes = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();

        graph.dfs();
    }
}
