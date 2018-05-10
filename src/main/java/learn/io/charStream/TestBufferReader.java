package learn.io.charStream;

import java.io.*;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestBufferReader {
    public static void main(String[] args) throws IOException {
        String s = "早上吃啥？\n中午吃啥？\n晚上吃啥？";
        CharArrayReader car = new CharArrayReader(s.toCharArray());
        BufferedReader br = new BufferedReader(car);
        String line = br.readLine();
//        br.lines().collect(Collectors.toList());
        CharArrayWriter caw = new CharArrayWriter();
        BufferedWriter bw = new BufferedWriter(caw);
        bw.write(line);
        bw.write("ssss");
        bw.newLine();
        bw.write("xxxx");
        bw.flush();
        System.out.println(caw.toString());
    }
}
