package learn.nio.channel.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * author: suzheng
 * version: v.1.0
 * package: learn.nio.channel.socket
 * company: SiBu
 * create_date: 2018/05/23
 * description :
 */
public class ConnectAsync {
    public static void main(String[] args) throws IOException, InterruptedException {
        String host = "localhost";
        int port = 1234;
        if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        InetSocketAddress addr = new InetSocketAddress( port);
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(false);
        System.out.println("initiating connection");
        sc.connect(addr);
        ByteBuffer byteBuffer = ByteBuffer.wrap("this is socket channel".getBytes());
        while (true) {
            if(sc.finishConnect()){
                byteBuffer.flip();
                sc.write(byteBuffer);
                byteBuffer.clear();
            }
            Thread.sleep(2000);

        }

//        System.out.println("connection established");
// Do something with the connected socket
// The SocketChannel is still nonblocking
//        sc.close();
    }


}

