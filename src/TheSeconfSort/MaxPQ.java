package TheSeconfSort;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.function.IntFunction;

public class MaxPQ<T extends Comparable<T>> {
    private T[] pq;
    private int N = 0;

    public MaxPQ() {
    }

    /**
     * 当前元素的构造方法,创建 N 个 泛型数组, 采用构造器的方式
     *
     * @param constr IntFunction <T []> 函数构造器
     * @param N      构造的数组的大小
     */
    public MaxPQ(@NotNull IntFunction<T[]> constr, int N) {
        this.pq = constr.apply(N);
    }

    /**
     * 采用 反射的方式来构造 泛型数组.
     *
     * @param a 利用传入的参数 ,并且利用反射的机制 构造 泛型数组.
     */
    @SafeVarargs
    public MaxPQ(T @NotNull ... a) {
        this.pq = (T[]) Array.newInstance(a.getClass().getComponentType(), N);
    }

    /**
     * 静态方法来构造函数
     *
     * @param constr 构造器
     * @param maxN   最大的长度
     * @param <T>    限制的类型
     * @return 返回 泛型数组
     */
    public static <T extends Comparable<T>> T[] makeMaxPQByConstr(IntFunction<T[]> constr, int maxN) {
        return constr.apply(maxN);
    }


    /**
     * @param <T>错误的方法,也是大家最容易想到的方法.强制转换存在错误,抛出 非检查型异常.
     */
    public static <T extends Comparable<T>> T[] makeMaxPQByCast(int maxN) {
        Comparable[] comparables = new Comparable[maxN];

        return (T[]) comparables;
    }

    /**
     * 传入下标,比较两个元素的大小, 如果 i 小于 j 会返回true.
     *
     * @param i 下标
     * @param j 下标
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 用于交换两个堆中的元素
     *
     * @param i 用于交换的第一个元素的下标
     * @param j 用于交换的第二个元素的下标
     */
    private void exch(int i, int j) {
        T tem = pq[i];
        pq[i] = pq[j];
        pq[j] = tem;
    }

    /**
     * 在插入一个元素的时间,总是在末尾去插入, 然后采用swim () 函数上浮到合适的位置.!!!
     *
     * @param key 添加的元素
     */
    public void insert(T key) {
        pq[++N] = key;//在尾部插入当前元素
        swim(N);//上浮元素, 保证堆是有序的
    }

    /**
     * 从根节点去除 堆的最大的元素,并且将 最后一个元素移动到根节点开始恢复堆的有序性
     */
    public T delMax() {
        T max = pq[1];//从根节点上寻找到 最大的元素
        exch(1, N--);//将根节点域最后一个节点交换位置,并且减少堆得数量.
        pq[N + 1] = null;//防止对象游离
        sink(1);//下沉元素,恢复堆得有序性
        return max;
    }

    /**
     * 用于上游元素, 直到最顶层或者是 他的父元素比他 大的时间停止
     * 传递的是元素的下标
     * 添加一个元素,恢复堆有序
     *
     * @param k 上浮元素下标
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k))//不是顶层,并且父元素 小于当前元素的时间 以知向上游动.
        {
            exch(k, k / 2);
            k /= 2;
        }
    }

    /**
     * 下沉当前元素,在下沉的过程中, 选择他的 2*K 或者是 2*k +1 的子类 取决于那个元素比较大
     * 用于删除一个元素 恢复 堆有序
     *
     * @param k 下沉的元素下标
     */
    private void sink(int k) {
        while (2 * k <= N)//不是在底层找出的时间, 在这里不能同时判断是 他的两个子类哪一个是更大的
        {//1. 首先去判断当前节点的 子节点 是否在数组范围内
            int j = 2 * k;
            //2.如果在的话,并且需要判断当前的节点是否是左孩子节点, 这样的话才能够去判断 两个节点哪一个更大
            if (j < N && less(j, j + 1)) j++;
            //3.再去判断当前节点是否比孩子节点小, 才能够去交换,
            if (less(j, k)) break;
            exch(j, k);
            k = j * 2;//有可能新加入的元素在交换之后 继续小于的的子元素,所以将 K 赋值为他的 孩子的下标
        }
    }

    public static void main(String[] args) {
//        Integer[] ts = makeMaxPQ(100);//出现编译错误,,并且在调用的时间抛出 ClassCastException.
//        MaxPQ<Solution> empoyeeMaxPQ = new MaxPQ<Solution>();在构造方法中,限定的类型 必须是实现了Comparable 接口的类型,才能够在构造函数中接收当前类型

    }
}
