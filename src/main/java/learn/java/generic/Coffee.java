package learn.java.generic;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter ++;

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                '}';
    }

    public static Generator generator(){
        return new Generator(){
          public Coffee next(){
              return new Coffee();
          }
        };
    }
}
