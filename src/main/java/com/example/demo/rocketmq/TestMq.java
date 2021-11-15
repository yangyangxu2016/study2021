package com.example.demo.rocketmq;

import jodd.io.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * todo
 * date：2021/9/29  11:30 上午
 *
 * @author xuyy
 */
public class TestMq {

    public static void main(String[] args) throws IOException {
        decodeCQ(new File("/Users/xuyy/project/github/study2021/src/main/java/com/example/demo/rocketmq/00000000000000000000"));

    }

    static void decodeCQ(File consumeQueue) throws IOException {
        FileInputStream fis = new FileInputStream(consumeQueue);
        DataInputStream dis = new DataInputStream(fis);

        long preTag = 0;
        long count = 1;
        while (true) {
            long offset = dis.readLong();
            int size = dis.readInt();
            long tag = dis.readLong();

            if (size == 0) {
                break;
            }
            if ((tag - preTag) != 1) {
                // System.err.printf("%d: %d %d %d\n", count++, tag, size,
                // offset);
                System.out.printf("[ERROR]%d: %d %d %d\n", count++, tag, size, offset);
            }
            preTag = tag;
            System.out.printf("%d: %d %d %d\n", count++, tag, size, offset);
        }
        fis.close();
    }


}
