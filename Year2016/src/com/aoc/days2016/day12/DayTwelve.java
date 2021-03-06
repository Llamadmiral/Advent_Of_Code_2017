package com.aoc.days2016.day12;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DayTwelve extends DayBase {

    private static final String DAY_NR = "Eleven";

    public DayTwelve() {
        dayNr = DAY_NR;
        solution = new SolutionTwelve(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/11.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionTwelve(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{};
    }
}