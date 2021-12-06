package com.sf.nio;

import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NioFileChannel01 {


    public static void main(String[] args)throws Exception {
        String str = "hello";

        //创建一个输出流 -》 channel
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/songfei/Downloads/file01.txt");

        //通过fileOutStream获取对应的FileChannel
        //这个fileChannel的真实类型是 FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区 byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1023);

        //将文字输入bytebuffer中
        byteBuffer.put(str.getBytes());

        //对bytebuffer进行反转 flip
        byteBuffer.flip();

        fileChannel.write(byteBuffer);
        fileOutputStream.close();


    }


}
