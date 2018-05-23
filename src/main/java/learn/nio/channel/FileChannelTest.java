package learn.nio.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.nio.channel
 * company: SiBu
 * create_date: 2018/05/22
 * description :
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        ReadableByteChannel source = Channels.newChannel(System.in);
        FileOutputStream outputStream = new FileOutputStream("test.txt");
        FileChannel fileChannel = outputStream.getChannel();
//        fileChannel.transferFrom(source,0,100);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16*1024);
        while (source.read(byteBuffer) != -1){
            byteBuffer.flip();
            fileChannel.write(byteBuffer);

            byteBuffer.clear();
        }
        source.close();
        fileChannel.close();

    }
}
