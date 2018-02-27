package learn.io.byteStream.objectStream;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        testbytes();
        testObjectStream();
//        testInteger();
    }

    /**
     * integer 会缓存0-127，i1在0-127自动包装为缓存对象等同于Integer.valueOf()，不在这个范围时会新生成一个对象。
     * new Integer() 每次都会新生成一个对象
     */
    private static void testInteger() {
        Integer i1 = 1000;
        Integer i2 = 1000;
        System.out.println("i1 == i2:" + (i1 == i2));

        Integer i3 = new Integer(1000);
        Integer i4 = new Integer(1000);
        System.out.println("i3 == i4: " + (i3 == i4));

        Integer i5 = Integer.valueOf(1000);
        Integer i6 = Integer.valueOf(1000);
        System.out.println("i5 == i6:" + (i5 == i6));

        System.out.println("i1 == i3:" + (i1 == i3));
        System.out.println("i1 == i5:" + (i1 == i5));
        System.out.println("i3 == i5:" + (i3 == i5));
    }

    private static void testObjectStream() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new ObjectBean("test"));
        System.out.println(Arrays.toString(bos.toByteArray()));
        oos.writeObject(new ObjectBean1("test"));
        System.out.println(Arrays.toString(bos.toByteArray()));

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois  = new ObjectInputStream(bis);
        ObjectBean obj= (ObjectBean) ois.readObject();
        System.out.println(obj);
        ObjectBean1 obj1= (ObjectBean1) ois.readObject();
        System.out.println(obj1);
    }

    private static void testbytes() {
        byte[] bytes = new byte[]{1, 2};
        byte[] bytes1 = bytes.clone();
        bytes1[1] = 10;
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = new byte[3];
        System.arraycopy(bytes, 0, bytes2, 0, 2);
        bytes2[1] = 20;
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes2));

        byte[] bytes3 = bytes;
        bytes3[1] = 30;
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes3));

        Map<Integer, Class<?>> priClass = new HashMap<>();
        priClass.put(1, byte.class);
        System.out.println(priClass.get(1));
    }
}
