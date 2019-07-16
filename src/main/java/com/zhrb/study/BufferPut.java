package com.zhrb.study;

import sun.misc.Unsafe;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

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

        byte M=0x4D;
        byte w=0x77;
        buffer.put(0,M).put(w);

        buffer2.put(0,M).put(w);

        System.out.println("两种不同的buffer put方式的结果是否一致：");
        print(buffer,buffer2);
        ByteBuffer buffer3 = ByteBuffer.allocateDirect(10);
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

            System.out.println("打印缓冲区中存储的元素：");
            System.out.println("buffer:"+new String(((ByteBuffer)buffer).array()));
            //两次rewind
            buffer.rewind();
            buffer.rewind();
            System.out.println("buffer rewind 之后：");
            System.out.println("buffer:"+new String(((ByteBuffer)buffer).array()));
            buffer.clear();
            System.out.println("buffer clear 之后：");
            System.out.println("buffer:"+new String(((ByteBuffer)buffer).array()));
            System.out.println("buffer clear 之后：");
            System.out.println("buffer:"+new String(((ByteBuffer)buffer).array()));

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
    //大文件时使用
    MappedByteBuffer m = (MappedByteBuffer) MappedByteBuffer.allocate(10);
}
