package com.courses.io_8.asynchronousio_7;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by VSulevskiy on 18.08.2015.
 */
public class AppSecond {
    public static void main(String[] args) {
        File file = Paths.get("resourses\\wap.txt").toFile();
        System.out.println(file.exists());
        try {
            AsynchronousFileChannel asynchronousFileChannel =
                    AsynchronousFileChannel.open(file.toPath());
            ByteBuffer buffer = ByteBuffer.allocate(10_000_000);
            ReadStatus status = new ReadStatus();
            status.status = true;
            CompletionHandler<Integer, ByteBuffer> completionHandler = new MyCompletitionHandler(status);
            asynchronousFileChannel.read(buffer, 0, buffer, completionHandler);
            while (status.status) {
                System.out.println("Working");
            }
            printBufferSize(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void printBufferSize(ByteBuffer buffer) {
        int size = 0;
        for (byte i : buffer.array()) {
            size++;
        }
        System.out.println(size);
    }
}
