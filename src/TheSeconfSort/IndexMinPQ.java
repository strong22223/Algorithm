package TheSeconfSort;

/**
 * 当前带索引的有限队列，寻找到的是队列的最小的元素
 */
public class IndexMinPQ<T extends Comparable<T>> {

    private int N;//记录有限队列的长度 从 1 dao N 结束。
    private int[] pq;//记录 索引二叉堆，从 1 开始。
    private int[] qp;//逆序：qp[ pq[i] ]= pq [ qp[i] ]= i
    private T[] keys;//用于存储元素.

    private void swim(int index) {
        while (index >= 1) {
            if (less(index, index / 2))//孩子小于父亲
                exch(index,index/2);
                index /= 2;
        }
    }

    private void sink(int index) {

    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        T tem = keys[pq[i]];
        keys[pq[i]] = keys[pq[j]];
        keys[pq[j]] = tem;
    }
}
