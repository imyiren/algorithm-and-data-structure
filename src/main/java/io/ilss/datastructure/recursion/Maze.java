package io.ilss.datastructure.recursion;

/**
 * @author feng
 */
public class Maze {
    public static void main(String[] args) {

        int[][] map = new int[8][7];
        // 使用1标识墙
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;

        System.out.println("====> 初始化");
        show(map);

        // 使用递归回溯找路
        setWay(map, 1, 1);

        System.out.println("====> 结果");
        show(map);
    }

    /**
     * 到6 5 说明通路找到
     * 约定：map[i][j] == 0 说明没有走过  1为墙 2为通路可以走 3表示走过但是走不通。
     * 寻找策略 下右上左 如果不同再回溯
     *
     * @param map 地图
     * @param i   开始行位置
     * @param j   开始列位置
     * @return 通路true 否则false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            // 假设可以走通
            map[i][j] = 2;
            // 向下
            if (setWay(map, i + 1, j)) {
                return true;
            }
            // 向右
            if (setWay(map, i, j + 1)) {
                return true;
            }
            // 向上走
            if (setWay(map, i - 1, j)) {
                return true;
            }
            // 向左
            if (setWay(map, i, j - 1)) {
                return true;
            }
            map[i][j] = 3;
            return false;
        }
        return false;
    }


    public static void show(int[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
