package LearningJava.GenericClass;


import LearningJava.ReflectionTest;

import java.io.Serializable;

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


    class ArrayAlg {
    /**
     * 使用限定 了实现接口 Comparable 和Serializable 接口的 参数类型 才可以去调用 minmax 方法
     * @param a
     * @return
     * @param <T>
     */
    public static  <T extends  Serializable&Comparable<T> > Pair<T> minmax(T[] a) {


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
 public static void main(String[] args) {
//        ReflectionTest.printConstructors(Pair.ArrayAlg.class);
//
//        ReflectionTest.printMethods(Pair.ArrayAlg.class);
//        ReflectionTest.printFields(Pair.ArrayAlg.class);
//
//     Pair<String> stringPair = new Pair<>();
//     ReflectionTest.printFields(stringPair.getClass());


    }
}

