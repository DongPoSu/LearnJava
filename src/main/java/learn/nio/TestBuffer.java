package learn.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author suzheng
 * @version v.1.0
 */
public class TestBuffer {
    public static void main(String[] args) throws IOException {
        // 分配空间
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byte[] src = {1,1,3,4,5,6,7};
        byte[] dest = new byte[4];

        // 标记
        byteBuffer.mark();
        // 存入 position ++
        byteBuffer.put(src);
        // 重置position=mark
        byteBuffer.reset();
        // 获取position到limit的内容，同时position+=dest.length
        byteBuffer.get(dest);

        // newLimit 必须小于capacity 等同byteBuffer.limit(byteBuffer.position()).position(0);
        byteBuffer.flip();

        // 释放
        while (byteBuffer.hasRemaining()){
            byteBuffer.get();
        }
        // 清理
        byteBuffer.clear();

        // 压缩，丢弃小于position的元素，capacity变小
        byteBuffer = byteBuffer.compact();

        // 比较缓存区获取元素是否都相同，再比较长度
        System.out.println(byteBuffer.compareTo(ByteBuffer.allocate(10).put(src)));

        // 自定义的数组
        byteBuffer = ByteBuffer.wrap(src);
    }
}
