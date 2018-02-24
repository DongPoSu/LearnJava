package learn.io.byteStream.bufferStream;

import java.io.*;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestBufferStream {
    public static void main(String[] args) throws IOException {
        testBufferStream();
    }

    private static void testBufferStream() throws IOException {
        String s = "North Korea may be only a few months away from completing development of a nuclear-tipped missile capable of hitting the U.S. mainland, despite existing international sanctions that, at times, have been sidestepped by smuggling and ship-to-ship transfers at sea of banned goods, according to officials.";
        byte[] bytes = s.getBytes();
        BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(bytes));
        if(bis.markSupported()){
            bis.mark(0);
        }
        byte[] targetBytes= new byte[24];
        int length = bis.read(targetBytes,0, targetBytes.length);
        System.out.println(new String(targetBytes,0, length));
        if(bis.markSupported()){
            bis.reset();
        }
        length = bis.read(targetBytes,0, targetBytes.length);
        System.out.println(new String(targetBytes,0, length));
        bis.close();

        BufferedOutputStream bos = new BufferedOutputStream(new ByteArrayOutputStream(),12);
        bos.write(targetBytes, 0 , length);
        bis.close();
        bos.close();
    }
}
