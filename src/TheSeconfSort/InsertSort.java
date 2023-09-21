package TheSeconfSort;

public class InsertSort extends SortStandard {
    public InsertSort(Comparable[] a) {
        super(a);
    }

    @Override
    public void sort() {
        int length = a.length;
        for (int i = 1, j; i < length; i++) {//直接从第一个开始
            for (j = i; j > 0 && less(a[j], a[j - 1]); j--) {//直到到达数组的起始地址.或者 前面元素 比 后面的元素 小的时间才去 停止, 否则一直叫唤两个元素的位置, 使得前面的元素一直是最小的.
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort(SortStandard.Random(20));
        insertSort.show();

        insertSort.sort();

        System.out.println("______________________________");
        insertSort.show();
    }
}
