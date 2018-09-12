package learn.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author suzheng
 * @version v.1.0
 */
public class CompletionThreadServiceTest {

    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactoryBuilder().build();
        ExecutorService service = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), factory, new ThreadPoolExecutor.AbortPolicy()
        );

        CompletionService completionService = new ExecutorCompletionService(service);
        List<QueryTask> list = getList();
        list.forEach(o -> {

            completionService.submit(o);
        });
        for (int i = 0; i < list.size(); i++) {
            Object o = null;
            try {
                o = completionService.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(o);
        }
        service.shutdown();

    }

    public static List<QueryTask> getList() {
        List<QueryTask> taskList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            taskList.add(new QueryTask(i));

        }
        return taskList;
    }

    static class QueryTask implements Callable<Integer> {

        private Integer id;

        public QueryTask(Integer id) {
            this.id = id;
        }

        @Override
        public Integer call() throws Exception {
//            Thread.sleep(1000L);
//            System.out.println(Thread.currentThread().getName());
            return id;
        }
    }
}
