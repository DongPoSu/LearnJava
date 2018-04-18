package learn.io.charStream;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestFile {
    public static void main(String[] args) throws FileNotFoundException {
        testFileReaderByFilePath();
    }

    private static void testFileReaderByFilePath() throws FileNotFoundException {
        String path = "D:\\note_pad++\\temp.sql";
        FileReader fileReader =new FileReader(path);
        String encode = fileReader.getEncoding();
        System.out.println(encode);
    }
}
