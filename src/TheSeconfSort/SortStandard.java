package TheSeconfSort;

public abstract class SortStandard {
    static Comparable[] aux = null;//用户合并的辅助数组，在实在改接口的时间必须为此辅助空间实现空间的开辟。
    Comparable[] a = null;//用于保存数据。

    public SortStandard(Comparable[] a) {
        this.a = a;
    }

    /**
     * a xiao yu b 返回 true
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换数组a 中德 i ， j 下标的元素。
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable a[], int i, int j) {
        Comparable tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    /**
     * 打印数组元素的每一个
     */
    public void show() {
        for (Comparable ele : a
        ) {
            System.out.println(ele);
        }
    }

    /**
     * 用于判断当前数组一个数组是否 为有序的
     * 在此固定的条件是，从 1开始，可以有效的避免数组的越界，并且将 i  与 i-1 进行比较 也可以避免越界
     *
     * @return
     */
    public boolean isSort() {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public abstract void sort();

    public static Integer[] Random(int count) {
        var v = new Integer[count];
        for (int i = 0; i < count; i++)
            v[i] = (int) (Math.random() * 100) + 1;
        return v;
    }

    /**
     * 用于合并两个有序的数组
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merage(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;//定义出来 前子数组的 起始地址
        int j = mid + 1;//定义 后子数组的 起始地址
        //首先将所有元素copy 到辅助空间
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++) {//
            /**
             * 在这里合并的是 lo 到 hi 两者之间的元素
             */

            if (i > mid) a[k] = aux[j++];//在前子数组 的元素结束后,直接将所有的 后子数组的元素 赋值给 a
            else if (j > hi) a[k] = aux[i++];//在后子数组 的元素结束后,直接将所有的 钱子数组的元素 赋值给 a
            else if (less(aux[i], aux[j])) a[k] = aux[i++];//在 i 小于 j 的元素数值的时间 赋值
            else a[k] = aux[j++];
        }
    }

}
