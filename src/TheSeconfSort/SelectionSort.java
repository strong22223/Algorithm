package TheSeconfSort;

import java.awt.event.MouseAdapter;
import java.util.Scanner;
import java.util.function.BiFunction;

public class SelectionSort extends SortStandard {

    public SelectionSort(Comparable[] a) {
        super(a);
    }

    /**
     * 选择排序的实现
     */
    @Override
    public void sort() {
        if(isSort())return;
        int length = a.length;//用于计算数组的长度。
        int min = -1;//用于标注最小的下标
        for (int i = 0; i < length; i++) {//从0 将当前下标作为最小的 flag 进行比较.
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {

        SelectionSort selectionSort = new SelectionSort(SortStandard.Random(100000));
        selectionSort.show();
        selectionSort.sort();
        System.out.println("-------------------------------------");
        selectionSort.show();
        System.out.println(Math.random());
        selectionSort.show();
    }
}
