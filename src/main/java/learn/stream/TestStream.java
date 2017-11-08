package learn.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestStream {

    public static void main(String[] args) {
        new TestStream().test();
    }
    private void test(){
        // 转换成其他结构
        testConvert();

        // 从 Collection 和数组 BufferedReader
        //        Collection.stream()
        //        Collection.parallelStream()
        //        Arrays.stream(T array) or Stream.of()
        //        java.io.BufferedReader.lines()
        testCollectionStream();
        testArraysStream();
        testBufferedReaderStream();

        // 静态工厂
        //        java.util.stream.IntStream.range()
        //        java.nio.file.Files.walk()
        testIntStream();
        testObjectStream();

        // 自己构建
        testSpliteratorStream();
        // 其它
        //        Random.ints()
        //        BitSet.stream()
        //        Pattern.splitAsStream(java.lang.CharSequence)
        //        JarFile.stream()
    }


    // 数据转换
    private void testConvert() {
        // 1. Array
        String[] strArray1 = Stream.of("A", "B", "C").toArray(String[]::new);

        // 2. Collection
        List<String> list1 = Stream.of("A", "B", "C").collect(Collectors.toList());
        List<String> list2 = Stream.of("A", "B", "C").collect(Collectors.toCollection(ArrayList::new));
        Set<String> hashSet = Stream.of("A", "B", "C").collect(Collectors.toCollection(HashSet::new));
        Set set1 = Stream.of("A", "B", "C").collect(Collectors.toSet());
        Stack stack1 = Stream.of("A", "B", "C").collect(Collectors.toCollection(Stack::new));

        // 3. String
        String str = Stream.of("A", "B", "C").collect(Collectors.joining());

        // 4.List To Map
        List<User> users = new ArrayList<User>();
        users.add(new User(10,"史蒂夫"));
        users.add(new User(23,"李经理"));
        users.add(new User(15,"龙之谷"));
        Stream<User> userStream = users.stream();

        // 5.Map To List
        Map<Integer,String>strHashMap = new HashMap<>();
        strHashMap.put(1,"asdfas");
        List<String> arrayList5 = strHashMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private  void testObjectStream() {
        String result = Stream.of("墨藻保湿控油泥膜", "四季保湿精华喷雾", "价格待确认").parallel()
            .reduce((s, s2) -> String.join(",", s, s2)).orElse("");
        System.out.println(result);
        boolean predicated = Stream.of("墨藻保湿控油泥膜", "四季保湿精华喷雾", "价格待确认")
            .allMatch(s -> s.length() > 4);
        System.out.println("allMatch: " + predicated);

    }

    private  void testIntStream() {
        int i = IntStream.range(1, 10).reduce(0, (left, right) -> {
            System.out.println("left:" + left + " right:" + right);
            return Integer.sum(left, right);
        });
        System.out.println("testIntStream: " + i);

        i = IntStream.range(1, 10).reduce((left, right) -> {
            System.out.println("left:" + left + " right:" + right);
            return left + right;
        }).orElse(100);
        System.out.println("testIntStream: " + i);

    }

    private  void testSpliteratorStream() {

    }

    private  void testBufferedReaderStream() {
    }

    private  void testArraysStream() {
    }

    private  void testCollectionStream() {
    }
}
