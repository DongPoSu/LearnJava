package learn.thread;


import java.util.concurrent.TimeUnit;

/**
 * @author suzheng
 * @version v.1.0
 */
public class ThreadTest {

    private final Object o;

    public ThreadTest(Object o) {
        this.o = o;
    }

    public void test() {
        synchronized (o) {
            System.out.println("start thread-name-" + Thread.currentThread().getId());
            for (int i = 0; i < 100; i++) {
                System.out.println(o + "-" + i);
            }
            System.out.println("end thread-name-" + Thread.currentThread().getId());
        }
    }

    public void testThis() {
        synchronized (this) {
            System.out.println("start thread-name-" + Thread.currentThread().getId());
            for (int i = 0; i < 100; i++) {
                System.out.println(o + "-" + i);
            }
            System.out.println("end thread-name-" + Thread.currentThread().getId());
        }
    }

    public synchronized void testSync(){
        System.out.println("start thread-name-" + Thread.currentThread().getId());
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(o + "-" + i);
        }

        System.out.println("end thread-name-" + Thread.currentThread().getId());
    }

    public synchronized static void testStaticSync(){
        new ThreadTest("s1-static-").testSync();
        System.out.println("start thread-name-" + Thread.currentThread().getId());
        for (int i = 0; i < 10; i++) {
            System.out.println( "static-" + i);
        }
        System.out.println("end thread-name-" + Thread.currentThread().getId());

    }

    public static void main(String[] args) {
        final String s1 = "s1";
        final String s2 = "s2";

        new Thread(() ->  new ThreadTest(s1).testSync()).start();

        new Thread(() -> testStaticSync()).start();
    }

}
