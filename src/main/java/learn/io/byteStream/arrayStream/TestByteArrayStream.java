package learn.io.byteStream.arrayStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * ByteArrayInputStream
 * ByteArrayOutputStream
 *
 * @author suzheng
 * @version v.1.0
 */
public class TestByteArrayStream {

    public static void main(String[] args) {
        testInputStream();
    }

    private static void testInputStream() {
        String s = " Japan's Fujifilm Holdings is set to take over Xerox Corp in a $6.1 billion deal, combining the U.S. company into their existing joint venture to gain scale and cut costs amid declining demand for office printing.";
        ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
        byte[] bytes = new byte[24];
        ByteArrayOutputStream os = new ByteArrayOutputStream(bytes.length);
        if (is.markSupported()) {
            is.mark(1);
        }
        int length;
        length = is.read(bytes, 0, bytes.length);
        os.write(bytes, 0, length);
        System.out.println(os.toString());
        if (is.markSupported()) {
            is.reset();
        }
        length = is.read(bytes, 0, bytes.length);
        os.write(bytes, 0, length);
        System.out.println(os.toString());
    }
}
