package com.zhrb.study;

import java.nio.*;

/**
 * @ClassName StudyBuffer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/16 15:16
 * @Version
 */
public class StudyBuffer {
    public static void main(String[] args) {
        //方式1：allocate方式直接分配，内部将隐含的创建一个数组
        ByteBuffer allocate = ByteBuffer.allocate(10);
        //方式2：通过wrap根据一个已有的数组创建
        byte[] bytes=new byte[10];
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        //方式3：通过wrap根据一个已有的数组指定区间创建
        ByteBuffer wrapoffset = ByteBuffer.wrap(bytes,2,5);

        //打印出刚刚创建的缓冲区的相关信息
        print(allocate,wrap,wrapoffset);
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

    private class BufferPut {
        private  void main(String[] args) {
            ByteBuffer buffer = ByteBuffer.allocate(10);
            print(buffer);
            byte H=0x48;
            byte e=0x65;
            byte l=0x6C;
            byte o=0x6F;
            buffer.put(H).put(e).put(l).put(l).put(o);
            print(buffer);
        }
        private  void print(Buffer... buffers) {
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
}
