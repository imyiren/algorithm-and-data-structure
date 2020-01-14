package com.imyiren.datastructure.sparsearray;

import java.util.Arrays;

/**
 * 稀疏数组
 *
 * @author feng
 */
public class SparseArray {

    /**
     * 稀疏数组：使用n行3列数组保存稀疏矩阵的值
     * arr[x][0]第几行
     * arr[x][1]第几列
     * arr[x][2]值
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][4] = 2;
        chessArray1[3][1] = 90;
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("chess size: " + sum);

        //创建对应稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 遍历二位数组 把非0 存到稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArray.length; i++) {
            System.out.println(Arrays.toString(sparseArray[i]));
        }

        // 将稀疏数组恢复成原始的二维数组
        int rowLen = sparseArray[0][0], colLen = sparseArray[0][1];
        int[][] chessArray2 = new int[rowLen][colLen];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
