package com.aoc.days.daytwentyone;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maczaka
 */
final class MatrixHelper {

    private MatrixHelper() {
        //nope;
    }

    static int[][] copyMatrixBlocks(final int limit, final int fromX, final int fromY, final int[][] matrix) {
        final int[][] subMatrix = new int[limit][limit];
        for (int j = 0; j < limit; j++) {
            System.arraycopy(matrix[fromX + j], fromY, subMatrix[j], 0, limit);
        }
        return subMatrix;
    }

    static int getCountOfMatrix(final int[][] matrix) {
        int count = 0;
        for (final int[] row : matrix) {
            for (final int element : row) {
                count += element;
            }
        }
        return count;
    }

//    static int getDeterminantOfMatrix(final int[][] matrix) {
//        int determinant = 0;
//        if (matrix.length == 2) {
//            determinant = matrix[0][0] * matrix[1][1] - (matrix[0][1] * matrix[1][0]);
//        } else {
//            for (int i = 0; i < matrix.length; i++) {
//                final int[][] subMatrix = createSubMatrixForDeterminant(matrix, 0, i);
//                determinant += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * getDeterminantOfMatrix(subMatrix);
//            }
//        }
//        return determinant;
//    }

    private static int[][] createSubMatrixForDeterminant(final int[][] inputMatrix, final int skipX, final int skipY) {
        final int size = inputMatrix.length;
        final int[][] subMatrix = new int[size - 1][size - 1];
        int k = 0;
        int l = 0;
        for (int i = 0; i < size; i++) {
            if (skipX != i) {
                for (int j = 0; j < size; j++) {
                    if (skipY != j) {
                        subMatrix[k][l] = inputMatrix[i][j];
                        l++;
                    }
                }
                k++;
            }
            l = 0;
        }
        return subMatrix;
    }

    static int getDeterminantOfMatrix(int[][] matrix) {
        int temporary[][];
        int result = 0;

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
        } else if (matrix.length == 3) {
            result = (matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]))
                    - (matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]))
                    + (matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]));
        } else {
            for (int i = 0; i < matrix[0].length; i++) {
                temporary = new int[matrix.length - 1][matrix[0].length - 1];

                for (int j = 1; j < matrix.length; j++) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (k < i) {
                            temporary[j - 1][k] = matrix[j][k];
                        } else if (k > i) {
                            temporary[j - 1][k - 1] = matrix[j][k];
                        }
                    }
                }

                result += matrix[0][i] * (i % 2 == 0 ? 1 : -1) * getDeterminantOfMatrix(temporary);
            }
        }
        return (result);
    }

    static void printMatrix(final int[][] matrix) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                builder.append(" ").append(matrix[i][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

}