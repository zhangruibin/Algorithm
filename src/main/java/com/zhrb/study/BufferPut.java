package com.zhrb.study;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @ClassName BufferPut
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/16 15:52
 * @Version
 */
public class BufferPut {
    public static   void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        print(buffer);
        byte H=0x48;
        byte e=0x65;
        byte l=0x6C;
        byte o=0x6F;
        buffer.put(H).put(e).put(l).put(l).put(o);
        print(buffer);
        System.out.println("\n");
        ByteBuffer buffer2 = ByteBuffer.allocate(10);
        buffer2.put("Hello".getBytes());
        System.out.println("两种不同的buffer put方式的结果是否一致：");
        print(buffer,buffer2);
    }
    private static void print(Buffer... buffers) {
        for (Buffer buffer : buffers) {
            System.out.println("capacity="+buffer.capacity()
                    +",limit="+buffer.limit()
                    +",position="+buffer.position()
                    +",hasRemaining:"+buffer.hasArray()
                    +",remaining="+buffer.remaining()
                    +",hasArray="+buffer.hasArray()
                    +",isReadOnly="+buffer.isReadOnly()
                    +",arrayOffset="+buffer.arrayOffset());
        }
    }
}
