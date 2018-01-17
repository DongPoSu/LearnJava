package learn.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestIoStream {

    public void testFileStream(){


        try {
            System.out.println(System.getProperty("user.name"));
            File file = new File("");//设定为当前文件夹
//            System.out.println(file.getCanonicalPath());//获取标准的路径
            String path = file.getAbsolutePath()+"\\src\\main\\java\\learn\\io\\TestConsole.java";
            FileInputStream inputStream = new FileInputStream(path);
            System.out.println(inputStream.available());
            byte [] cache = new byte[1024];
           while (inputStream.read(cache) >0){
               System.out.println(new String(cache));
           }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestIoStream ioStream = new TestIoStream();
        ioStream.testFileStream();
    }

}
