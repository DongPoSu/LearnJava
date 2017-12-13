package learn.extendtest;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.extendtest
 * company: SiBu
 * create_date: 2017/11/14
 * description :
 */
public class D {
    public void test(){}
    protected void test1(){}

    static class DStatic extends D{

        @Override
        public void test() {
            new DStatic();
            new DStatic1();
        }
        @Override
        public void test1(){


        }
    }
    class DStatic1 extends D{

        @Override
        public void test() {

        }

    }

    public static void main(String[] args) {
        DStatic dStatic  = new D.DStatic();
        dStatic.test();


    }
}
