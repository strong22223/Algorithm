package TheSeconfSort;

public class Quick3way<T extends Comparable<T>> extends SortStandard<T> {
    public Quick3way() {
    }

    public Quick3way(T[] a) {
        super(a);
    }

    public void sort(int lo, int hi) {

        if (lo >= hi) return;
        //首先是
        int lt = lo, i = lo + 1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, i++, lt++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }
        sort( lo, lt-1);
        sort( gt+1, hi);
    }


    public static void main(String[] args) {

        Quick3way<Integer> tQuick3way = new Quick3way<>( );
        tQuick3way.show("prime");

         tQuick3way.sort(0,999999);


        System.out.println("______________________________");
        tQuick3way.show("sorted");
    }

    @Override
    public void sort() {

    }
}
