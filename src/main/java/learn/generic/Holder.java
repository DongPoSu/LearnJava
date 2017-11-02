package learn.generic;

import java.time.Instant;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.generic
 * company: SiBu
 * create_date: 2017/07/25
 * description :
 */

public class Holder<T>{
    private T a;

    public Holder(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(new Holder<>("generic paradigm").getA());
        System.out.println(new Holder<>(1).getA());
        Instant instant = Instant.now();
    }
    public <E> E set(E data){
        return null;
    }

    @SafeVarargs
    public static<E> E useVarargs(E... args){
        System.out.println(args.length);
        return args.length > 0?args[0]:null;
    }
}
