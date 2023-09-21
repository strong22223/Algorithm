package LearningJava;

import java.util.Arrays;
import java.util.Comparator;

public class Accumulator extends CopyArray {
    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {

        return total / N;
    }

    public String toString() {
        return "Mean (" + N + " vales):" + String.format("7.5f", mean());
    }

    public static void main(String[] args) {
        CopyArray copyArray = new CopyArray();
        Accumulator accumulator = new Accumulator();
        int protest = copyArray.Protest;
        String[] a = {"111", "22",""};
        Arrays.sort(a, Comparator.comparingInt(String::length));
        for (String c:a)
            System.out.println(c);

    }
}
