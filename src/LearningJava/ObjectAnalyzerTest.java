package LearningJava;

public class ObjectAnalyzerTest {
    public static void main(String[] args) {

   /*     var integers = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            integers.add(i * i);
            System.out.println(new Object*/
//        Analyzer().toString(integers));
//        }
        String[] c = {"wo", "ds"};
        Object[] a = {1, 2, 3, c};
        try {
            System.out.println(new ObjectAnalyzer().toString(a));

        } catch (IllegalAccessException illegalAccessException){
            System.out.println();
        }
    }
}
