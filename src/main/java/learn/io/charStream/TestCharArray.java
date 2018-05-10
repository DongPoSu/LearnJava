package learn.io.charStream;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestCharArray {
    public static void main(String[] args) throws IOException {
        test();
    }
    public static void test() throws IOException {
        String s = "早上吃啥？中午吃啥？晚上吃啥？";

        CharArrayReader car = new CharArrayReader(s.toCharArray());
        CharArrayWriter caw = new CharArrayWriter(48);
        char[] chars = new char[24];
        int length = car.read(chars,0 ,chars.length);
        caw.write(chars,0, length);
        System.out.println(caw.toString());
        car.close();
        caw.close();
    }
}
