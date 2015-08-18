package com.courses.io_8.asynchronousio_7;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

/**
 * Created by VSulevskiy on 18.08.2015.
 */
public class MyCompletitionHandler implements CompletionHandler<Integer, ByteBuffer> {
    private ReadStatus status;
    public  MyCompletitionHandler(ReadStatus status){
        this.status = status;
    }
    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        System.out.println("File is read, bytes:" + attachment.array().length);
        this.status.status = false;
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        System.err.println("Could not read");
        System.out.println("Could not read");
    }
}
