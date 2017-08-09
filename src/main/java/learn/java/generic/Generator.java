package learn.java.generic;

import java.util.Iterator;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class Generator implements Iterator<Coffee> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Coffee next() {
        return null;
    }

    @Override
    public void remove() {

    }


}
