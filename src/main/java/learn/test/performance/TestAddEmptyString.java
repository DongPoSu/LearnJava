package learn.test.performance;

/**
 * 测试字符串拼接性能
 *
 * @author suzheng
 * @version v.1.0
 */
public class TestAddEmptyString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int size = 10000;
        testIntegerToStringPerformance(size);
        testAddStringPerformance(size);
    }

    /**
     * 测试字符串拼接性能
     * @param size
     */
    private static void testAddStringPerformance(int size) {
        System.out.println("测试字符串拼接性能-开始");
        testAddString(size);
        testStringBuildString(size);
        System.out.println("测试字符串拼接性能-结束");
    }

    /**
     * 测试数字转化成字符串性能
     * @param size
     */
    private static void testIntegerToStringPerformance(int size) {
        System.out.println("测试数字转化成字符串性能-开始");
        testAddString(size);
        testIntegerToString(size);
        System.out.println("测试数字转化成字符串性能-结束");
    }

    /**
     * x+"" 要创建3个字符串对象x,"",x+""
     *  运算量大导致创建许多对象效率低
     * @param size
     */
    private static void testAddString(int size) {
        long start = System.currentTimeMillis();
        String aa = "";
        for (int i = 0; i < size; i++) {
            aa = aa + i;
        }
        long userTime = System.currentTimeMillis() - start;
        System.out.println("testAddString：" + userTime);
    }

    private static void testStringBuildString(int size) {
        long start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            builder.append(i);
        }
        long userTime = System.currentTimeMillis() - start;
        System.out.println("testStringBuildString：" + userTime);
    }

    private static void testIntegerToString(int size) {
        long start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            Integer.toString(i);
        }
        long userTime = System.currentTimeMillis() - start;
        System.out.println("testIntegerToString：" + userTime);
    }

}
