package learn.io.byteStream.arrayStream;

import java.io.ByteArrayInputStream;

/**
 * ByteArrayInputStream
 * ByteArrayOutputStream
 * @author suzheng
 * @version v.1.0
 */
public class TestByteArrayStream {

    public static void main(String[] args) {
        testInputStream();
    }

    private static void testInputStream() {
        String s = " Japan's Fujifilm Holdings is set to take over Xerox Corp in a $6.1 billion deal, combining the U.S. company into their existing joint venture to gain scale and cut costs amid declining demand for office printing.";
        System.out.println(s.length());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.out.println(inputStream.available());
        System.out.println(inputStream.markSupported());
    }
}
