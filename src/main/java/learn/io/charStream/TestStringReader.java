package learn.io.charStream;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestStringReader {
    public static void main(String[] args) throws IOException {
        String s = "早上吃啥？中午吃啥？晚上吃啥？";
        StringReader sr = new StringReader(s);
        char[] chars = new char[1024];
        sr.read(chars);
        System.out.println(chars);
        sr.close();
        StringWriter sw = new StringWriter();
        sw.write(chars);

        System.out.println(sw.getBuffer().codePointAt(2));
    }
}
