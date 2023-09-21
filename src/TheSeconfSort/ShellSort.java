package TheSeconfSort;

public class ShellSort extends SortStandard {

    public ShellSort(Comparable[] a) {
        super(a);
    }

    @Override
    public void sort() {
        int N = a.length;
        int h = 0;
        while (h < N) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i += h)
                for (int j = i; (j >= h) && (less(a[j], a[j - h])); j -= h)
                    exch(a, j, j - 1);
            h /= 3;
        }
    }

    public static void main(String[] args) {

        ShellSort shellSort = new ShellSort(ShellSort.Random(10000));
        shellSort.show();
        System.out.println("--------------");
        shellSort.sort();
        shellSort.show();
    }
}
