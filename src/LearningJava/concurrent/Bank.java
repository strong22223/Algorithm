package LearningJava.concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        this.bankLock = new ReentrantLock();
        this.sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();

        try {

            while (accounts[from] < amount)
                sufficientFunds.await();
            System.out.println(Thread.currentThread());

        } finally {
            bankLock.unlock();
        }

    }
}
