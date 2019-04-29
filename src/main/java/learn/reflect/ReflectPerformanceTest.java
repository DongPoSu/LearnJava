package learn.reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;

/**
 * @author suzheng
 * @version v.1.0
 */
public class ReflectPerformanceTest {

    public void directInvoke(){
        Inner inner = new Inner();
        inner.setName("t");

    }

    public void reflectInvoke() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> c = Class.forName("test.TestClass");
        Class<?>[] argsType = new Class[1];
        argsType[0] = String.class;
        Method m = c.getMethod("setName", argsType);
        m.invoke(c,"s");
    }

    class  Inner{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static volatile  String a;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//        executorService.scheduleAtFixedRate(new MyRunnable(),2,100,TimeUnit.SECONDS);

    }
    static class  MyRunnable implements Runnable{


        @Override
        public void run() {
            System.out.println("taks1");

        }

//        public long getDelay(@NotNull TimeUnit unit) {
//            return 0;
//        }
//
//        public int compareTo(@NotNull Delayed o) {
//            return 0;
//        }
    }
}
