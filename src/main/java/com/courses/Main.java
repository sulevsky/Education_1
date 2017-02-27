package com.courses;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int totalLines = 9;
        String result = generateStarsIn(totalLines);
        System.out.println(result);
    }

    private static String generateStarsIn(int lines) {
        IntUnaryOperator lineNumberToStars = mapLineNumberToStarsCountFunction(lines, Main::amountInLine);

        return IntStream.rangeClosed(1, lines)
                .map(lineNumberToStars)
                .mapToObj(Main::generateStars)
                .collect(Collectors.joining("\n"));
    }

    public static IntUnaryOperator mapLineNumberToStarsCountFunction(int total, IntBinaryOperator bf) {
        return i -> bf.applyAsInt(i, total);
    }

    public static int amountInLine(int lineNumber, int totalLinesCount) {
        return lineNumber <= Math.ceil(totalLinesCount / 2.0) ? lineNumber : totalLinesCount - lineNumber + 1;
    }

    public static String generateStars(int count) {
        return IntStream.range(0, count)
                .mapToObj(operand -> "*")
                .collect(Collectors.joining());
    }
}
