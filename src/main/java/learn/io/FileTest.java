package learn.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author suzheng
 * @version v.1.0
 */
public class FileTest {
    public void testStatic() throws IOException {
        File file = File.createTempFile("temp","");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getPath());
        file.deleteOnExit();
        System.out.println(file.length());
        System.out.println(file.exists());
        FilenameFilter filter = (dir, name) -> false;
        file.list(filter);
    }

    public static void main(String[] args) throws IOException {
        FileTest fileTest = new FileTest();
        fileTest.testStatic();

    }
}
