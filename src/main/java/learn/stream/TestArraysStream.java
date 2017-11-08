package learn.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.IntStream;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.stream
 * company: SiBu
 * create_date: 2017/11/07
 * description :
 *
 * @author suzheng
 */
public class TestArraysStream {
    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 1};
        System.out.println(Arrays.stream(array).distinct().count());
        System.out.println(Arrays.stream(array).count());
        System.out.println(Arrays.stream(array).max().orElse(8));
        Arrays.stream(array).peek(value -> System.out.println("peek" + value)).forEach(value -> value++);
        System.out.println(Arrays.stream(array).mapToDouble(value -> (double) value)
                .collect(DoubleSummaryStatistics::new,DoubleSummaryStatistics::accept
                        ,DoubleSummaryStatistics::combine).getCount());

        System.out.println(Arrays.stream(array).reduce((left, right) -> left + right).orElse(111));
        Arrays.stream(array).skip(1).sorted().limit(4).forEach(o-> System.out.println("排序："+ o));
        IntStream outputStream = Arrays.stream(array).flatMap(IntStream::of);
    }
}
