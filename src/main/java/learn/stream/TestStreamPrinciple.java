package learn.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestStreamPrinciple {

    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1,10).parallel().sum());;
    }
}
