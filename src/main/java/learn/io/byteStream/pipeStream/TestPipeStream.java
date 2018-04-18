package learn.io.byteStream.pipeStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestPipeStream {
    public static void main(String[] args) throws IOException {
        testPipeStream();
    }

    private static void testPipeStream() throws IOException {
        String s = "The top Democrat on the intelligence panel, California Rep. Adam Schiff, said after the meeting was over that Hicks answered questions about her role in Trump's campaign and answered some questions about the transition period between the election and the inauguration. But she would not answer any questions about events since Trump took the oath of office, similar to some other White House officials who have spoken to the committee. Schiff said Hicks did not assert any type of executive privilege, but just said she had been advised not to answer.";

        PipedInputStream pis = new PipedInputStream(24);
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);
        Executor executor =Executors.newFixedThreadPool(5);
        executor.execute(()->{
            try {
                while (true){
                    byte [] bytes = new byte[1024];
                    pis.read(bytes);
                    System.out.println(new String(bytes));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        executor.execute(()->{
            try {
                while (true){
                    pos.write(s.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
