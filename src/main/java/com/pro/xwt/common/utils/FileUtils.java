package com.pro.xwt.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by idiot on 2016/12/28.
 */
public class FileUtils {

    /**
     * @description 拷贝文件流到文件
     * @param multipartFile
     * @param tempPartFile
     */
    public static void copyInputStreamToFile(MultipartFile multipartFile, File tempPartFile) {
        File file = null;
        try {
            file = convert(multipartFile);  //multipartFile 转 file
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(tempPartFile);
            byte[] b = new byte[1024000];
            int n;
            while ((n = fis.read(b)) != -1) {
                fos.write(b, 0, n);
            }
            fis.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //用上面的 multipartFile 转 file方法  会在磁盘里面生成一个文件   干掉它
            if(file.exists()){
                file.delete();
            }
        }
    }

    /**
     * @description 合并分片文件到新文件里面
     * @param partFile  分片文件
     * @param destTempFile  新文件
     */
    public static void copyFile(File partFile, File destTempFile) {
        try {
            FileInputStream fis = new FileInputStream(partFile);
            FileOutputStream fos = new FileOutputStream(destTempFile, true);
            byte[] b = new byte[1024000];
            int n;
            while ((n = fis.read(b)) != -1) {
                fos.write(b, 0, n);
            }
            fis.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @description 删除目录以及目录下的文件
     * @param tempFileDir
     */
    public static void deleteDirectory(File tempFileDir) {
        if(tempFileDir.exists()){
            deleteFile(tempFileDir);
        }
    }

    public static void deleteFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(int i=0; i<files.length; i++){
                deleteFile(files[i]);
            }
        }
        file.delete();
    }

    /**
     * @description multipartFile 转 file   使用该方法会在磁盘里生成一个文件(通常是在项目根路劲下)
     * @param file
     * @return
     */
    public static File convert(MultipartFile file) {
        File convertFile = new File(file.getOriginalFilename());
        try {
            convertFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convertFile);
            fos.write(file.getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return convertFile;
    }
}
