package learn.io.byteStream.dataStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestDataStream {
    public static void main(String[] args) {
        testDataStream();
    }

    private static void testDataStream() {
        byte[] b = {0, 0, 0, 1, 0, 115, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 115};
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (DataInputStream dis = new DataInputStream(bais);
             DataOutputStream dos = new DataOutputStream(baos)
        ) {
            System.out.println(dis.readInt());
            System.out.println(dis.readChar());
            System.out.println(dis.readLong());
            System.out.println(dis.readUTF());
            dos.writeInt(1);
            System.out.println(Arrays.toString(baos.toByteArray()));
            dos.writeChar('s');
            System.out.println(Arrays.toString(baos.toByteArray()));
            dos.writeLong(2L);
            System.out.println(Arrays.toString(baos.toByteArray()));
            dos.writeUTF("s");
            System.out.println(Arrays.toString(baos.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
