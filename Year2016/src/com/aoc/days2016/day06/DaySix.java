package com.aoc.days2016.day06;

import com.aoc.daybase.DayBase;
import com.aoc.solutionbase.SolutionBase;
import com.aoc.util.reader.Reader;

/**
 * @author Llamadmiral.
 */
public class DaySix extends DayBase {

    private static final String DAY_NR = "Six";

    public DaySix() {
        dayNr = DAY_NR;
        solution = new SolutionSix(DAY_NR);
        solution.setInput(Reader.readFromInput("2016/6.txt"));
    }

    @Override
    public SolutionBase getSolutionForTest() {
        return new SolutionSix(DAY_NR);
    }

    @Override
    public String[] getTestInputs() {
        return new String[]{"eedadn\n"
            + "drvtee\n"
            + "eandsr\n"
            + "raavrd\n"
            + "atevrs\n"
            + "tsrnev\n"
            + "sdttsa\n"
            + "rasrtv\n"
            + "nssdts\n"
            + "ntnada\n"
            + "svetve\n"
            + "tesnvt\n"
            + "vntsnd\n"
            + "vrdear\n"
            + "dvrsen\n"
            + "enarar"};
    }
}