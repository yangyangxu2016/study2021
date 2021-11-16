package com.example.demo.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * todo
 * date：2021/11/15  9:08 上午
 *
 * @author xuyy
 */
public class NioServer {



    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //默认阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定
        serverSocketChannel.bind( new InetSocketAddress(ServerConfig.port));
        System.out.println("启动成功");

        while (true){
            //获取新的tcp连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            //读取、响应
            if (socketChannel != null) {
                System.out.println("收到新连接"+socketChannel.getRemoteAddress());
                socketChannel.configureBlocking(false);

                ByteBuffer reqBuffer = ByteBuffer.allocate(1024);
                //循环读，非阻塞，可能返回null
                while (socketChannel.isOpen() && socketChannel.read(reqBuffer
                ) != -1) {
                    if (reqBuffer.position()>0) break;
                }

                if (reqBuffer.position()==0) continue;

                //翻转，开始读  pos=0,limit = pos
                reqBuffer.flip();
                byte[] content = new byte[reqBuffer.limit()];
                reqBuffer.get(content);
                System.out.println(new String(content));
                System.out.println("收到新数据：" + socketChannel.getRemoteAddress());


                String response = "HTTP/1.1 200 OK\n" + "Content-Length: 11\n" +
                        "\n" + "hello,world";
                ByteBuffer respBuffer = ByteBuffer.wrap(response.getBytes(StandardCharsets.UTF_8));
                while (respBuffer.hasRemaining()) {
                    socketChannel.write(respBuffer);
                }
            }


        }

    }
}
