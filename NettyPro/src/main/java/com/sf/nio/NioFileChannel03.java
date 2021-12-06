package com.sf.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel03 {

    public static void main(String[] args) throws Exception {

        //创建文件输入流
        FileInputStream fileInputStream = new FileInputStream("01.txt");
        FileChannel inputChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("02.txt");
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);


        while (true){

            byteBuffer.clear();//缓存快需要清空，
            int read = inputChannel.read(byteBuffer);
            if(read == -1){
                break;
            }
            byteBuffer.flip();
            outputChannel.write(byteBuffer);


        }

        fileInputStream.close();
        fileOutputStream.close();


    }

}
