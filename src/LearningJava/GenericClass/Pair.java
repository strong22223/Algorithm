package LearningJava.GenericClass;


import LearningJava.Employee;

import java.io.Serializable;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }


    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    public static <T> Pair<T> makePair(Supplier<T> constr) {
        return new Pair<>(constr.get(), constr.get());
    }


    public static void main(String[] args) {
//        ReflectionTest.printConstructors(Pair.ArrayAlg.class);
//
//        ReflectionTest.printMethods(Pair.ArrayAlg.class);
//        ReflectionTest.printFields(Pair.ArrayAlg.class);
//
//     Pair<String> stringPair = new Pair<>();
//     ReflectionTest.printFields(stringPair.getClass());
        Pair<String> pair = Pair.makePair(String::new);
//        String[] mixmax = ArrayAlg.mixmax("add");
        String[] minmax = ArrayAlg.minmax(String[]::new, "woshi", "nishi");
        for (String a:minmax
             ) {
            System.out.println();
        }
    }
}

class ArrayAlg {
    /**
     * 在类型转换的时间会出现 类型转换失败 ,解决方案是在 参数列表中添加一个 数组构造器表达式
     *
     * @param a
     * @param <T>
     * @return
     */
    @SuppressWarnings("uncheck")
    public static <T extends Comparable> T[] mixmax(String a) {
        Comparable[] comparators = new Comparable[2];
        return (T[]) comparators;
    }

    public static <T extends Comparable> T[] minmax(IntFunction<T[]> constr, T... a) {
         ;
        return constr.apply(2);
    }

    /**
     * 使用限定 了实现接口 Comparable 和Serializable 接口的 参数类型 才可以去调用 minmax 方法
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Serializable & Comparable<T>> Pair<T> minmax(T[] a) {


        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) < 0) min = a[i];
            if (max.compareTo(a[i]) > 0) max = a[i];

        }
        return new Pair<>(min, max);
    }

    /**
     * genericMethod
     *
     * @param a
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }


}
