package tool;

import com.sun.istack.internal.Nullable;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class FileTools {

    /**
     * @param sourceFileName   待压缩文件的路径名称
     * @param outPutPath       输出到哪个文件夹
     * @param name             压缩文件后的名称，可不填写
     * @param isDelSrcFile     压缩后是否删除源文件
     * @param keepDirStructure 是否保留原目录结构
     * @throws ZipException
     * @throws IOException
     */
    public static void zipFile(String sourceFileName, String outPutPath, @Nullable String name, boolean isDelSrcFile, boolean keepDirStructure) throws ZipException, IOException {
        //待压缩文件
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            throw new IOException("文件不存在");
        }
        //压缩到该目录
        File outPutFile = new File(outPutPath);
        if (!outPutFile.exists()) {
            outPutFile.mkdirs();
        }
        OutputStream os = new FileOutputStream(outPutFile);
        zipFile(sourceFile, os, name, isDelSrcFile, keepDirStructure);
    }

    /**
     * @param sourceFile       压缩文件
     * @param outputStream     将压缩文件输出到流
     * @param name             压缩文件后的名称，可不填写
     * @param isDelSrcFile     是否删除源文件
     * @param keepDirStructure 是否保持原目录结构
     */
    public static void zipFile(File sourceFile, OutputStream outputStream, @Nullable String name, boolean isDelSrcFile, boolean keepDirStructure) {
        ZipOutputStream zos = null;
        String tmpName;
        try {
            zos = new ZipOutputStream(outputStream);
            if (name == null || name.isEmpty())//未提供名称，自动填写名称
                tmpName = sourceFile.getName();
            else
                tmpName=name;
            compress(sourceFile, zos, tmpName.substring(0, tmpName.lastIndexOf("/")), keepDirStructure);
            if (isDelSrcFile) {
                deleteFile(sourceFile.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     *
     * @param sourceFile       源文件
     * @param zos              zip输出流
     * @param name             压缩后的名称
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) {

    }

    public static void unZipFile(String fileName, String unZipFilePath) throws ZipException, IOException {
        //待解压文件
        File zipFile = new File(fileName);
        if (!zipFile.exists()) {
            throw new IOException("文件不存在");
        }
        //解压到该目录
        File pathFile = new File(unZipFilePath);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        //压缩文件
        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));//zip文件
        Enumeration entries = zip.entries();
        InputStream is = null;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            is = zip.getInputStream(zipEntry);

            //输出目录
            String outPath = unZipFilePath + "/" + zipEntry.getName();
            System.out.println("outpath：" + outPath + "\n" + "实体：" + zipEntry.getName());
            /*
             * 如果当前zipEntry是文件夹，最后是有一个斜杠：
             * outpath：D:/we/新建文件夹 (2)/
             * 实体：新建文件夹 (2)/
             * 本轮filename:新建文件夹 (2)
             *
             * 如果是文件，最后是没有斜杠的:
             * outpath：D:/we/新建文件夹 (2)/123459.txt
             * 实体：新建文件夹 (2)/123459.txt
             * 本轮filename:新建文件夹 (2)
             *
             * 所以，若是文件夹，去除最后一个斜杠，则表示这个文件夹的路径
             * 若是文件，去除最后一个斜杠，表示的是这个文件的父文件夹
             * */
            File file = new File(outPath.substring(0, outPath.lastIndexOf("/")));
            System.out.println("本轮filename:" + file.getName());
            if (!file.exists()) {//若是当前文件夹或当前文件的父文件夹不存在，创建文件夹
                file.mkdirs();
            }
            if (new File(outPath).isDirectory()) {
                continue;
            }
            OutputStream outputStream = new FileOutputStream(outPath);
            byte b[] = new byte[1024];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                outputStream.write(b);
            }
            is.close();
            outputStream.close();
        }

    }

    public static void copyFile(String fileName) throws FileNotFoundException {
        File selectFile = new File(fileName);
        if (!selectFile.exists()) {
            throw new FileNotFoundException("文件不存在");
        }
    }

    public static void pauseFile(String fileName, String targetPath) {

    }

    public static void moveFile(String fileName, String targetPath) {

    }

    public static void deleteFile(String fileName) {

    }
}
