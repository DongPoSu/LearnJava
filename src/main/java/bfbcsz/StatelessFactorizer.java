package bfbcsz;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author suzheng
 * @version v.1.0
 */
public class StatelessFactorizer  implements Servlet {
    private volatile int  update;

    private volatile  String name;
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
       return true;
    }

    public void generateFile() throws FileNotFoundException {
        File file = new File("/home/suzheng/Documents/code.csv");
        PrintWriter printWriter = new PrintWriter(file);
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 100000; i <= 203000; i++) {
            builder.append("W00").append(i).append(String.format("%06d",random.nextInt(999999))).append(",\n");
            printWriter.print(builder.toString());
            builder.delete(0,builder.length());
        }
        printWriter.close();
    }
    private static  volatile  String status="11";
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Exchanger<List<Integer>> exchanger = new Exchanger<>();
        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.execute(new Producer(exchanger));
        executor.execute(new Producer(exchanger));
    }

    static class Producer extends Thread {
        List<Integer> list = new ArrayList<>();
        Exchanger<List<Integer>> exchanger = null;
        public Producer(Exchanger<List<Integer>> exchanger) {
            super();
            this.exchanger = exchanger;
        }
        @Override
        public void run() {
            Random rand = new Random();
            int num;
            num=rand.nextInt(10000);
            list.add(num);
//            num=rand.nextInt(10000);
//            list.add(num);
//            num=rand.nextInt(10000);
//            list.add(num);
//            num=rand.nextInt(10000);
//            list.add(num);
//            num=rand.nextInt(10000);
//            list.add(num);
            try {
                System.out.print(Thread.currentThread().getName()+":交换前：");
                print();
                list = exchanger.exchange(null);
                System.out.print(Thread.currentThread().getName()+":交换后：");
                print();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        public void print(){
            for(Integer i:list){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

}
