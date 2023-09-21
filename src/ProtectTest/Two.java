package ProtectTest;

import PrivateTest.One;

public class Two extends One {


    public static void main(String[] args) {
        Two two = new Two();

        two.protectedMethod();
        One one = new One();
        Three three = new Three();
        three.protectedMethod();
    }
}
