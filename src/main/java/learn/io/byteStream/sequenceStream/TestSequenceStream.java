package learn.io.byteStream.sequenceStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestSequenceStream {
    public static void main(String[] args) throws IOException {
        testStream();
    }

    private static void testStream() throws IOException {
        String s1 = "12345";
        String s2 = "67890";
        ByteArrayInputStream bis1 = new ByteArrayInputStream(s1.getBytes());
        ByteArrayInputStream bis2 = new ByteArrayInputStream(s2.getBytes());
        try(SequenceInputStream sis = new SequenceInputStream(bis1 ,bis2);) {

            byte[]bytes =new byte[5];
            while (sis.read(bytes,0,bytes.length) >0){
                System.out.println(new String(bytes));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
