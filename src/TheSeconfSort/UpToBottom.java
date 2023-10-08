package TheSeconfSort;

import java.lang.reflect.Array;

public class UpToBottom<T extends Comparable<T>> extends SortStandard<T> {
    public UpToBottom(T[] a) {
        super(a);
    }

    /**
     * 自定向上的归并排序算法
     */
    @Override
    public void sort() {
        aux =  (T[]) Array.newInstance(a.getClass().getComponentType(),a.length);
//        sortUpToBottom(a, 0, a.length - 1);
        sortBottomToUp();
    }

    private void sortUpToBottom(T[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sortUpToBottom(a, lo, mid);//左 子数组 排序
        sortUpToBottom(a, mid + 1, hi);
        merage(a, lo, mid, hi);
    }

    private void sortBottomToUp() {
        int N = a.length;

        for (int size = 1; size < N; size += size) {//首先写出 自底向上归并排序算法 的子数组的长度 为 1
            for (int lo = 0; lo < N - size; lo += size + size) {
                merage(a, lo, lo + size - 1, Math.min(lo + 2 * size - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
//
//        var upToBottom = new UpToBottom<>(UpToBottom.Random(1000_000_000));
//        upToBottom.show();
//        System.out.println("----------------------");
//        upToBottom.sort();
//        upToBottom.show();
    }

}
