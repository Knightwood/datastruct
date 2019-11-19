import java.io.*;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Hello World!");

        File file1 = new File("D:\\AAA\\BBB");
        if (!file1.exists()){
            file1.mkdirs();
        }
        File file = new File("D:\\AAA\\BBB\\测试文件.txt");

        RandomAccessFile rF = new RandomAccessFile(file, "rw");
        rF.setLength(1024 * 1024);
        rF.close();

        // 所要写入的文件内容
        String s1 = "第一个字符串";
        String s2 = "第二个字符串";
        String s3 = "第三个字符串";
        String s4 = "第四个字符串";
        String s5 = "第五个字符串";
// 利用多线程同时写入一个文件
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(5,Integer.MAX_VALUE,60, TimeUnit.SECONDS,new SynchronousQueue<>());
        poolExecutor.execute(new runable(1024 * 1, s1.getBytes()));
        poolExecutor.execute(new runable(1024 * 2, s2.getBytes()));
        poolExecutor.execute(new runable(1024 * 3, s3.getBytes()));
        poolExecutor.execute(new runable(1024 * 4, s4.getBytes()));
        poolExecutor.execute(new runable(1024 * 5, s5.getBytes()));
        //new FileWriteThread(1024 * 1, s1.getBytes()).start(); // 从文件的1024字节之后开始写入数据
        //new FileWriteThread(1024 * 2, s2.getBytes()).start(); // 从文件的2048字节之后开始写入数据
        //new FileWriteThread(1024 * 3, s3.getBytes()).start(); // 从文件的3072字节之后开始写入数据
        //new FileWriteThread(1024 * 4, s4.getBytes()).start(); // 从文件的4096字节之后开始写入数据
        //new FileWriteThread(1024 * 5, s5.getBytes()).start(); // 从文件的5120字节之后开始写入数据
    }


    // 利用线程在文件的指定位置写入指定数据
    static class runable implements Runnable{
        private int skip;
        private byte[] content;

        public runable(int skip, byte[] content) {
            this.skip = skip;
            this.content = content;
        }

        @Override
        public void run() {
            RandomAccessFile raf = null;
            try {
                raf = new RandomAccessFile("D:\\AAA\\BBB\\测试文件.txt", "rw");
                raf.seek(skip);
                raf.write(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    raf.close();
                } catch (Exception e) {
                }
            }

        }
    }

    static class FileWriteThread extends Thread {
        private int skip;
        private byte[] content;

        public FileWriteThread(int skip, byte[] content) {
            this.skip = skip;
            this.content = content;
        }

        public void run() {
            RandomAccessFile raf = null;
            try {
                raf = new RandomAccessFile("D:\\测试文件.txt", "rw");
                raf.seek(skip);
                raf.write(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    raf.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
/*
    public static void a1(File file) throws IOException {
        //创建一个字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getName())) ;

        //写数据
        bw.write("hello");
        bw.write("world");

        //刷新流
        bw.flush();

        //关闭资源
        bw.close();
    }
    public void b2(File file) throws IOException {
        Writer out=new FileWriter(file);
        String data="awagtergsrth";
        out.write(data);
        out.close();
    }*/

