package learn.java.guava.basic;


import java.util.Optional;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.guava.basic
 * company: SiBu
 * create_date: 2017/07/31
 * description :
 */
public class OptionalTest {


    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(5);
        System.out.println( possible.isPresent()); // returns true
        System.out.println(possible.get()); // returns 5
//        Objects.nonNull()
    }
}
