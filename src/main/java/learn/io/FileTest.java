package learn.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author suzheng
 * @version v.1.0
 */
public class FileTest {
    public void testStatic() throws IOException, URISyntaxException {
        File file = File.createTempFile("temp","");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getPath());
        file.deleteOnExit();
        System.out.println(file.length());
        System.out.println(file.exists());
        FilenameFilter filter = (dir, name) -> false;
        file.list(filter);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);

        file = new File("/sd");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getUsableSpace());
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        FileTest fileTest = new FileTest();
        fileTest.testStatic();

    }
}
