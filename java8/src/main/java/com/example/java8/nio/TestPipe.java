package com.example.java8.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 视频13. NIO_Pipe 管道
 * 管道是2个线程之间的单向数据连接。
 * Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取
 */
public class TestPipe {
    public static void main(String[] args) throws IOException {
        TestPipe.test1();
    }

    private static void test1() throws IOException {
        //1. 获取管道
        Pipe pipe = Pipe.open();

        //2. 将缓冲区中的数据写入管道
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        //3. 读取缓冲区中的数据(用一个缓冲区完成了)
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, len));

        sourceChannel.close();
        sinkChannel.close();
    }

}
