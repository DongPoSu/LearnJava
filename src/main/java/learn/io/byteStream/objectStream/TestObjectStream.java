package learn.io.byteStream.objectStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    }

    private static void testObjectStream() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new ObjectBean("test"));
        oos.writeObject(new ObjectBean("good"));
        System.out.println(Arrays.toString(bos.toByteArray()));
//
//        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois  = new ObjectInputStream(bis);
//        System.out.println(ois.readObject());
//        System.out.println(ois.readObject());
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

        Map<Integer,Class<?>> priClass = new HashMap<>();
        priClass.put(1,byte.class);
        System.out.println(priClass.get(1));
    }
}
