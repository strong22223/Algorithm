package TheSeconfSort;

public class InsertSort<T extends Comparable<T>> extends SortStandard<T> {
    public InsertSort(T[] a) {
        super(a);
    }

    @Override
    public void sort() {
        int length = a.length;
        for (int i = 1, j; i < length; i++) {//直接从第一个开始
            for (j = i; j > 0 && less(a[j], a[j - 1]); j--) {//直到到达数组的起始地址.或者 前面元素 比 后面的元素 小的时间才去 停止, 否则一直叫唤两个元素的位置, 使得前面的元素一直是最小的.
                exchange(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        var insertSort = new InsertSort<>(SortStandard.Random(1000_000,5));
        insertSort.show("Prime");

        insertSort.sort();

        System.out.println("______________________________");
        insertSort.show("Sorted");
    }
}
