package com.example.demo.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * todo
 * date：2021/11/14  6:24 下午
 *
 * @author xuyy
 */
public class BioServer {

   static ExecutorService threadPool = Executors.newFixedThreadPool(10);


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("启动");
            while (!serverSocket.isClosed()){
                Socket request = serverSocket.accept();
                System.out.println("收到新的连接 "+ request.toString());
              threadPool.submit(()->
              {
                  InputStream inputStream = null;
                  try {
                      inputStream = request.getInputStream();
                      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                      String msg;
                      while ((msg = bufferedReader.readLine()) != null) {
                          if (msg.length() == 0) {
                              break;
                          }
                          System.out.println(msg);
                      }
                      System.out.println("收到数据，来自： " + request.toString());

                      OutputStream outputStream = request.getOutputStream();
                      outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                      outputStream.write("Content-Length: 11\r\n\r\n".getBytes());
                      outputStream.write("hello,world".getBytes(StandardCharsets.UTF_8));
                      outputStream.flush();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }finally {
                      try {
                          request.close();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }

                  }


              });
        }
    }
}
