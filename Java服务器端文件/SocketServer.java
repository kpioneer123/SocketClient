package com.haocai;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("192.168.90.221",9998));

            System.out.println("服务器Start...");
            while(true){
                //获取连接客户端
                Socket socket = serverSocket.accept();
                //读取内容
                new ReaderThread(socket).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static class ReaderThread extends Thread{
        BufferedReader bufferedReader;
        public ReaderThread(Socket socket){
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            super.run();
            //循环读取内容
            String content = null;
            while(true){
                try {
                    while((content = bufferedReader.readLine())!=null){
                      System.out.println("接收到了客户端："+content);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
