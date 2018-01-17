package learn.io;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.io
 * company: SiBu
 * create_date: 2017/12/13
 * description :
 */
public class MyAutoClose {
    class AutoClose1 implements AutoCloseable {

        @Override
        public void close() throws Exception {
            throw new Exception("autoclose1");
        }
    }

    class AutoClose2 implements AutoCloseable {

        @Override
        public void close() throws Exception {
            throw new Exception("autoclose2");
        }
    }


    private void test() {
        try (
                AutoClose2 autoClose2 = new AutoClose2();AutoClose1 autoClose1 = new AutoClose1();
            ) {
            System.out.println("block code");
            throw  new Exception("block exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        new MyAutoClose().test();
    }
}

