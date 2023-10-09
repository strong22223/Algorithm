package TheSeconfSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class IndexPriorityQueue<Key extends Comparable<Key>> {
    private int maxN;                 // 最大容量
    private int n;                    // 当前队列大小
    private int[] pq;                 // 保存索引的二叉堆
    private int[] qp;                 // pq的逆序，qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;               // 保存元素的数组

    @SuppressWarnings("unchecked")
    public IndexPriorityQueue(int maxN) {
        this.maxN = maxN;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1; // 初始化为-1表示不在队列中
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public void insert(int i, Key key) {
        if (contains(i)) {
            throw new IllegalArgumentException("Index is already in the priority queue");
        }
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    public int delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        int minIndex = pq[1];
        swap(1, n--);
        sink(1);
        assert minIndex == pq[n + 1];
        qp[minIndex] = -1; // 删除minIndex
        keys[minIndex] = null; // 释放内存
        pq[n + 1] = -1; // 不要遗留在pq中
        return minIndex;
    }

    public Key keyOf(int i) {
        if (!contains(i)) {
            throw new NoSuchElementException("Index is not in the priority queue");
        }
        return keys[i];
    }

    public void changeKey(int i, Key key) {
        if (!contains(i)) {
            throw new NoSuchElementException("Index is not in the priority queue");
        }
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j + 1, j)) {
                j++;
            }
            if (!less(j, k)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    class ing implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    }

    public static void main(String[] args) {
        IndexPriorityQueue<String> stringIndexPriorityQueue = new IndexPriorityQueue<String>(12);
        Integer[] ints = new Integer[100];


        Arrays.sort(ints, Integer::compareTo);
    }
}
