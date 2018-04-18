package learn.io.charStream;

import java.io.*;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestInputStream {
    public static void main(String[] args) throws IOException {
        test();
    }

    public static void test() throws IOException {
        String s = "早上吃啥？中午吃啥？晚上吃啥？";

        ByteArrayInputStream bis = new ByteArrayInputStream(s.getBytes());
        InputStreamReader isr = new InputStreamReader(bis);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos);
        osw.append("每天终极三问：");
        System.out.println(isr.getEncoding());
        char[] chars = new char[24];
        int length = isr.read(chars, 0, chars.length);
        osw.write(chars, 0, length);
        osw.flush();
        System.out.println(bos.toString());
        isr.close();
        osw.close();
    }
}
