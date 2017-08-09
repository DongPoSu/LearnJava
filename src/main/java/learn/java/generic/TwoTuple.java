package learn.java.generic;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.java.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
