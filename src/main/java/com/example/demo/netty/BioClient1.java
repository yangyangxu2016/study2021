package com.example.demo.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * todo
 * date：2021/11/14  6:35 下午
 *
 * @author xuyy
 */
public class BioClient1 {

    public static void main(String[] args) throws IOException {
        new Thread(() -> connetcc()).start();
    }

    private  static void connetcc()  {
        Socket client = null;
        try {
            client = new Socket("127.0.0.1", 8080);
            OutputStream outputStream = client.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入");
            String msg = scanner.nextLine();
            outputStream.write(msg.getBytes(StandardCharsets.UTF_8));
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
