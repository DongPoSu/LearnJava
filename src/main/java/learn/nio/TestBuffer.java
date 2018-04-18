package learn.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\note_pad++\\test.xml");
        FileChannel fc = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(28);
        fc.read(byteBuffer);
        byte[] bytes = new byte[28];
        byteBuffer.flip();
//        byteBuffer.get(bytes);
        System.out.println(byteBuffer.asCharBuffer().get(0));
        ByteBuffer slice = byteBuffer.slice();
        slice.slice().slice();
//        for (int i=0; i<slice.capacity(); ++i) {
//            byte b = slice.get( i );
//            b *= 11;
//            slice.put( i, b );
//        }
    }
}
