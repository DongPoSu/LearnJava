package learn.thread;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author suzheng
 * @version v.1.0
 */
public class ThreadTest {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private void test() {
        Lock readLock = readWriteLock.readLock();
        try {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " 获取读锁");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + " 释放读锁");
        }
    }

    private void test1() {

        Lock writeLock = readWriteLock.writeLock();
        try {
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + " 获取写锁");

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + " 释放写锁");
        }
    }

    private void test2() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 获取读锁");
            condition.await();
            System.out.println(Thread.currentThread().getName() + " 被唤醒了");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " 释放读锁");
        }
    }

    private void test3() {
        try {

            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 获取读锁");
            condition.await();
            System.out.println(Thread.currentThread().getName() + " 被唤醒了");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " 释放读锁");
        }
    }

    int count =0;
    private void testCount(){

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+count+"："+ (++count));
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        Thread t0 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
             threadTest.testCount();

            }
        });
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 2000; i++) {
                threadTest.testCount();
            }
        });

        t0.start();
        t1.start();
    }
}
