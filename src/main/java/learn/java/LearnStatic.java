package learn.java;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java
 * company: SiBu
 * create_date: 2017/02/22
 * description :
 */
public class LearnStatic{
    static String a;

    {
        System.out.println("代码块！2");
    }

    {
        System.out.println("代码块！1");
    }

    static {
        System.out.println("静态代码块！2");
    }

    static {
        System.out.println("静态代码块！1");
        System.out.println("a值" + a);
    }

    public LearnStatic() {
        a = "a";
    }

    private void learn() {

    }
    public static TestA testA = new TestA();

    public  class A extends C {
        {
            System.out.println("A block code");
        }
    }
    interface B{
        String a = null;

        public static void t(){
            System.out.printf("B");
        }

    }
    abstract class C {
        {
            System.out.println("C inline class");
        }

        public C() {
            learn();
        }
    }

    static class D {

    }
}
