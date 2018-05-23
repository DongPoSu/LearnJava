package learn.nio.channel.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author suzheng
 * @version v.1.0
 */
public class ChannelTransfer {
    public static void main(String[] args) throws IOException {
        if(args.length ==0){
            System.out.println("Usage: filename ...");
            return;
        }
        catFiles(Channels.newChannel(System.out), args);
    }

    private static void catFiles(WritableByteChannel target, String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            FileInputStream fileInputStream = new FileInputStream(args[i]);
            FileChannel channel  = fileInputStream.getChannel();
            channel.transferTo(0, channel.size(),target);
            channel.close();
            fileInputStream.close();
        }
    }
}
