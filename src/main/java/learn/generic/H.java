package learn.generic;

import java.util.HashMap;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.generic
 * company: SiBu
 * create_date: 2017/08/10
 * description :
 */
public class H<T,D,C> extends  B<T,D,C>  {

    public static void main(String[] args) {
        HashMap<String,Integer> testMap = new HashMap<>(1);
        testMap.put("1",1);
        testMap.put("1sdf",1);
        testMap.forEach(System.out::printf);
    }
}
