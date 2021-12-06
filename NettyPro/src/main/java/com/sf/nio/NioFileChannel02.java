package com.sf.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel02 {

    public static void main(String[] args) throws Exception {

        //创建文件输入流
        File file = new File("/Users/songfei/Downloads/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        //通过fileInputStream 获取对应的FileChannel -》 实际类型 FIleChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //将通道内的数据读入到buffer
        fileChannel.read(byteBuffer);

        //buffer 的字节数据 转成string 输出
        System.out.println(new String(byteBuffer.array()));


    }

}
