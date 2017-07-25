package learn.java;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java
 * company: SiBu
 * create_date: 2017/02/23
 * description :
 */
public class ShadowTest {

    public int x = 0;

    public class FirstLevel {

        public int x = 1;

        public void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            class PhoneNumber {
                 void print() {
                    System.out.printf("PhoneNumber print");
                }
            }
            new PhoneNumber().print();
        }
    }
    {
        class PhoneNumber {
            void print() {
                System.out.printf("PhoneNumber print");
            }
        }
    }
    public static class SecondLevel{

    }

    public static void main(String[] args) {
        test();
    }
    public static int test() {
        String s = " ";
        try {
            s.split(",");
            if (s.length() ==1) {
                throw  new Exception("d");
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}