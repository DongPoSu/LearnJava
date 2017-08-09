package learn.java.generic;

import java.util.Collections;
import java.util.List;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class ArrayOfGenericReference < T extends Number> {
    Generic<Integer> [] gia;

    public static void main(String[] args) {
        List<? extends Integer> list = Collections.singletonList(1);
    }
}
