package ProtectTest;

public class Test {
    public void dd() throws CloneNotSupportedException {
        Object clone = this.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Test test = new Test();
        test.dd();
//        int protect = two.protect_;
//        two.protectedMethod();
//        Three three = new Three();
//        three.protectedMethod();

    }
}
