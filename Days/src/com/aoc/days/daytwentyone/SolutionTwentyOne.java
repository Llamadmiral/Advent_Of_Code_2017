package com.aoc.days.daytwentyone;

import com.aoc.solutionbase.SolutionBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aoc.days.daytwentyone.MatrixHelper.copyMatrixBlocks;
import static com.aoc.days.daytwentyone.MatrixHelper.printMatrix;

/**
 * @author maczaka
 */
class SolutionTwentyOne extends SolutionBase {

    private static final String STARTING_POSITION = ".#./" +
            "..#/" +
            "###";

    private final Map<Pattern, Pattern> ruleBook = new HashMap<>();
    private Pattern art;


    SolutionTwentyOne(String day) {
        super(day);
    }

    @Override
    protected void solvePartOne() {
        parseInput();
        art = new Pattern(STARTING_POSITION);
        for (int i = 0; i < 5; i++) {
            enhance(art);
        }
        setSolutionOne(art.getCount());
    }

    @Override
    protected void solvePartTwo() {
        for (int i = 0; i < 13; i++) {
            enhance(art);
        }
        setSolutionTwo(art.getCount());
    }


    private void enhance(final Pattern matrix) {
        List<int[][]> splittedMatrices = splitMatrix(matrix.getMatrix());
        List<int[][]> newMatrixSplitted = new ArrayList<>();
        for (final int[][] splitMatrix : splittedMatrices) {
            boolean found = false;
            for (final Map.Entry<Pattern, Pattern> rulePage : ruleBook.entrySet()) {
                if (rulePage.getKey().matrixEqualsWith(splitMatrix)) {
                    newMatrixSplitted.add(rulePage.getValue().getMatrix());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Could find rule for: ");
                printMatrix(splitMatrix);
            }
        }
        this.art.setMatrix(glueMatrixesTogether(newMatrixSplitted));
    }

    private int[][] glueMatrixesTogether(final List<int[][]> matrices) {
        int[][] newMatrix;
        if (matrices.size() != 1) {
            final int size = matrices.get(0).length;
            final int limit = size - 1;
            final int newRowSize = (int) Math.sqrt(matrices.size());
            final int newSize = newRowSize * size;
            newMatrix = new int[newSize][newSize];
            for (int i = 0; i < matrices.size(); i++) {
                final int[][] subMatrix = matrices.get(i);
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        newMatrix[(((i * size) / newSize) * size) + j][((i * size) % newSize) + k] = subMatrix[j][k];
                    }
                }
            }
        } else {
            newMatrix = matrices.get(0);
        }
        return newMatrix;
    }

    private List<int[][]> splitMatrix(final int[][] matrix) {
        final List<int[][]> splittedMatrix = new ArrayList<>();
        final int size = matrix.length;
        final int limit = size % 2 == 0 ? 2 : 3;
        for (int i = 0; i < size / limit; i++) {
            for (int j = 0; j < size / limit; j++) {
                splittedMatrix.add(copyMatrixBlocks(limit, i * limit, j * limit, matrix));
            }
        }
        return splittedMatrix;
    }


    private void parseInput() {
        final String[] rules = ((String) input).split("\n");
        for (final String rule : rules) {
            final String[] ruleParts = rule.split(" => ");
            ruleBook.put(new Pattern(ruleParts[0]), new Pattern(ruleParts[1]));
        }
    }
}
