package learn.io.byteStream.FileStream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestRandomAccessFile {

    private void test() throws IOException {
        File file = new File("");//设定为当前文件夹
        String path = file.getAbsolutePath()+"\\src\\main\\java\\learn\\io\\testTemp";
        RandomAccessFile randomAccessFile  = new RandomAccessFile(path,"rw");
        randomAccessFile.setLength(10);
        System.out.println(randomAccessFile.readLine());
        System.out.println(randomAccessFile.getFilePointer());
    }
    public static void main(String[] args) throws IOException {
        new TestRandomAccessFile().test();
    }
}
