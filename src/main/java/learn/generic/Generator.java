package learn.generic;

import java.util.Iterator;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class Generator implements Iterable<Coffee> {
    private Coffee [] arrays = new Coffee[10];


    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.forEach(o->{
            System.out.println(o.toString());
        });
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new Iterator<Coffee>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Coffee next() {
                return new Coffee();
            }
        };
    }
}
