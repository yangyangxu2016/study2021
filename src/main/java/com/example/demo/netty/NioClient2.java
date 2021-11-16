package com.example.demo.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * todo
 * date：2021/11/15  9:25 上午
 *
 * @author xuyy
 */
public class NioClient2 {

    public static void main(String[] args) throws IOException {

        SocketChannel clientChannel = SocketChannel.open();
        clientChannel.configureBlocking(false);
        clientChannel.connect(new InetSocketAddress(ServerConfig.ipAddress, ServerConfig.port));

        while (!clientChannel.finishConnect()) {
            Thread.yield();
        }
        //等待控制台输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("等待控制台输入：");
        String msg = scanner.nextLine();

        //包装
        ByteBuffer reqBuffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
        //循环写
        while (reqBuffer.hasRemaining()) {
            clientChannel.write(reqBuffer);
        }

        System.out.println("收到服务器响应：");
        ByteBuffer respBuffer = ByteBuffer.allocate(1024);
        while (clientChannel.isOpen() && clientChannel.read(respBuffer) != -1) {
            //长连接情况下
            if (respBuffer.position() >0) break;
        }

        respBuffer.flip();

        int limit = respBuffer.limit();
        byte[] bytes = new byte[limit];
        respBuffer.get(bytes);
        System.out.println(new String(bytes));
        System.out.println("结束连接"+clientChannel.getRemoteAddress());
        scanner.close();
        clientChannel.close();

    }
}
