package First_base;

import java.util.Arrays;

public class StaticSETofInts {
    private int []a;

    public StaticSETofInts(int[] key) {
        // 保护性的复制变量
        a=new int[key.length];
        System.arraycopy(key, 0, a, 0, key.length);
        Arrays.sort(a);
    }
    
    public boolean contains(int key){
        return rank(key)!=-1;
    }

    private int rank(int key) {
        int lo=0;
        int hi=a.length-1;
        //key 必须在 lo~ 中间
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if (a[mid]<key) lo=mid+1;
            else if (a[mid]>key) hi=mid-1;
            else return mid;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={1,3,5,3,5,6};
        StaticSETofInts staticSETofInts = new StaticSETofInts(a);
        boolean contains = staticSETofInts.contains(5);
        System.out.println(contains);
    }
}
