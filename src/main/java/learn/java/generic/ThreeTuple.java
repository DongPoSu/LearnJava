package learn.java.generic;

import java.util.ArrayList;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    private C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
        new ArrayList().toString();
    }

    public C getThird() {
        return third;
    }

    public void setThird(C third) {
        this.third = third;
    }
}
