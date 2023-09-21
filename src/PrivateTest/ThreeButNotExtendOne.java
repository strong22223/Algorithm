package PrivateTest;

public class ThreeButNotExtendOne {
    One one;

    ThreeButNotExtendOne() {
        this.one = new One();

    }

    public void print() {
        System.out.println(this.one.protect_);
        one.protectedMethod();
    }
}
