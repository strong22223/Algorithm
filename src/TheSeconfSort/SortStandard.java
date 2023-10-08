package TheSeconfSort;

import java.io.*;

public abstract class SortStandard<T extends Comparable<T>> {
    private static final int THE_SIZE = 1000;
    T[] aux = null;//用户合并的辅助数组，在实在改接口的时间必须为此辅助空间实现空间的开辟。
    T[] a = null;//用于保存数据。

    public SortStandard() {

    }

    public SortStandard(T[] a) {
        this.a = a;
    }

    /**
     * yu b 返回 true
     */
    public boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换数组a 中德 i ， j 下标的元素。
     */
    public <t extends Comparable<t>> void exchange(t[] a, int i, int j) {
        t tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    /**
     * 展示到一个文件中
     *
     * @param filename 将结果全部输出到
     */
    public void show(String filename) {
        String className = this.getClass().getName();
        String[] split = className.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        for (String a : split)
            stringBuilder.append(a);
        try {
            FileWriter fileWriter = new FileWriter("./" + stringBuilder + filename + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Integer temp;

            for (T num : a) {
                temp = (Integer) num;
                bufferedWriter.write(temp + " ");

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }


    }

    public void show(String fileName, BufferedReader reader) throws IOException {




    }

    /**
     * 用于判断当前数组一个数组是否 为有序的
     * 在此固定的条件是，从 1开始，可以有效的避免数组的越界，并且将 i  与 i-1 进行比较 也可以避免越界
     */
    public boolean isSort() {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public abstract void sort();

    /**
     * @param count  随机产生数字的数量
     * @param length 随机产生数字的位数
     * @return 返回分是常委为 count ，位数 为length 的整型数组
     */
    public static Integer[] Random(int count, int length) {


        var v = new Integer[length];
        for (int i = 0; i < 1000; i++)
            v[i] = (int) (Math.random() * Math.pow(10, length)) + 1;
        return v;
    }

    /**
     * @param fileName 需要构建文件的名称
     * @param length   构建数字的
     * @return 返回字符
     * @throws FileNotFoundException
     */
    public BufferedReader Random(String fileName, int count, int length) throws FileNotFoundException {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < count; i++)
                bufferedWriter.write(String.valueOf((Math.random() * Math.pow(10, length)) + 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new BufferedReader(new FileReader(fileName));
    }

    /**
     * 用于合并两个有序的数组
     */
    public void merage(T[] a, int lo, int mid, int hi) {
        int i = lo;//定义出来 前子数组的 起始地址
        int j = mid + 1;//定义 后子数组的 起始地址
        //首先将所有元素copy 到辅助空间
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        for (int k = lo; k <= hi; k++) {//
            /*
             * 在这里合并的是 lo 到 hi 两者之间的元素
             */

            if (i > mid) a[k] = aux[j++];//在前子数组 的元素结束后,直接将所有的 后子数组的元素 赋值给 a
            else if (j > hi) a[k] = aux[i++];//在后子数组 的元素结束后,直接将所有的 钱子数组的元素 赋值给 a
            else if (less(aux[i], aux[j])) a[k] = aux[i++];//在 i 小于 j 的元素数值的时间 赋值
            else a[k] = aux[j++];
        }
    }

}
