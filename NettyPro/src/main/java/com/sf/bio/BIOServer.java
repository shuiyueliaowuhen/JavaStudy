package com.sf.bio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args)throws Exception {
        //1创建一个线程池
        //2如果有客户端连接，就创建一个线程，与之通讯

        ExecutorService threadPool = Executors.newCachedThreadPool();

        //创建serverSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");

        while (true){
            //监听。等待客户端连接 阻塞
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");

            //创建一个线程，与客户端通讯
            threadPool.execute( () -> handler(socket) );


        }



    }

    //编写一个handler方法，和客户端通讯
    public static void handler(Socket socket){
        try {
            byte[] bytes = new byte[1024];
            //通过socket 获取输入流,阻塞
            InputStream inputStream = socket.getInputStream();

            //循环的读取客户端发送的数据
            while (true){
                System.out.println("线程信息，id=" +Thread.currentThread().getId() +",name="+Thread.currentThread().getName() );
                int read = inputStream.read(bytes);
                if( -1 != read){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
            System.out.println("handler结束");


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }













}
