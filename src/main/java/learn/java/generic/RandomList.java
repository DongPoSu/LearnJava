package learn.java.generic;

import java.util.ArrayList;
import java.util.Random;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class RandomList <T>{
    private ArrayList<T> storage = new ArrayList<T>();
    private Random random = new Random(47);
    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }

}
