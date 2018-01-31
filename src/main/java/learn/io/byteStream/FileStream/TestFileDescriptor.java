package learn.io.byteStream.FileStream;

import java.io.*;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.io
 * company: SiBu
 * create_date: 2018/01/16
 * description :
 */
public class TestFileDescriptor {
    public static void testStandFD() {
        try {
            FileOutputStream out = new FileOutputStream(FileDescriptor.out);
            out.write('A');
            out.write('\\');
            out.write('n');
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testWrite() throws IOException {
        File file = new File("");//设定为当前文件夹
        String path = file.getAbsolutePath() + "\\src\\main\\java\\learn\\io\\testTemp";
        FileOutputStream out = new FileOutputStream(new File(path));
        FileOutputStream fdOut = new FileOutputStream(out.getFD());
        fdOut.write('a');
        System.out.printf("fdout(%s) is %s\n", fdOut, fdOut.getFD().valid());
        out.close();
        fdOut.close();
    }

    public static void testRead(String path) throws Exception{
        FileInputStream in = new FileInputStream(path);
        FileDescriptor fd = in.getFD();
        FileInputStream fdIn  = new FileInputStream(fd);
        System.out.println("in1.read():"+(char)in.read());
        System.out.println("in2.read():"+(char)fdIn.read());
        System.out.printf("fdin(%s) is %s\n", fdIn, fd.valid());
    }
    public static void main(String[] args) throws Exception {
        File file = new File("");//设定为当前文件夹
        String path = file.getAbsolutePath() + "\\src\\main\\java\\learn\\io\\testTemp";
//        testWrite();
        testRead(path);
    }
}
