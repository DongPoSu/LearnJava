package learn.stream;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author suzheng
 * @version v.1.0
 */
@FunctionalInterface
public interface MyFunction<T,R> {
    void test(T t,R r);

    default void put(T t,R r){
        test(t,r);
    }
    default MyFunction<T,R> peek(T t2, R r2){
        return (t1, r1) -> test(t2,r2);
    }
    default MyFunction<T,R> get(T t2, R r2){
        return (t, r) -> test(t2,r2);
    }
    class C{
        private MyFunction myFunction;
        public C(MyFunction<String,Integer> f){
            this.myFunction = f;
        }
    }
    @SuppressWarnings("unchecked")
    static void main(String[] args) {
        C c = new C((s, integer) -> System.out.println(s+integer));
        c.myFunction.test("string",2323);
        c.myFunction.test("模式电脑",999);

//        ((MyFunction) System.out::println).put("发送到");
//        ((MyFunction) System.out::println).put(2323L);

        Function function = ((Function<String, CharSequence>) s -> null)
                .andThen((Function<CharSequence, String>) s -> null)
                .andThen((Function<CharSequence, Integer>) integer -> null)
                .andThen((Function<Number, Integer>) integer -> null)
 ;
        Optional.of(2).ifPresent(System.out::println);
    }
}
