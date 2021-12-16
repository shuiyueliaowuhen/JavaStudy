package com.uni.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;


import com.sun.java.swing.plaf.windows.WindowsGraphicsUtils;
import jcifs.smb.*;

public class SmbFileUtil {

    public static void main(String[] args) throws Exception {
        SmbFileUtil test = new SmbFileUtil();
        //这里要注意，remoteUrl参数（也就是第一个参数），必须是有smb://前缀的，这是协议！后面拼接ip地址，再拼接的就是第一步中，共享文件夹的共享名！
        test.smbPut("smb://10.23.65.200/hydro",
                "/Users/songfei/Downloads/raft.pdf",
                "administrator","password");
    }


    /**
     * 删除文件
     * @param remoteUrl 共享文件目录
     * @param fileName 要删除的文件名
     */
    public static void deleteFile(String remoteUrl, String fileName, String userName, String pwd) {
        SmbFile SmbFile;
        try {
            // smb://userName:passWord@host/path/shareFolderPath/fileName
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, userName, pwd);
            SmbFile = new SmbFile(remoteUrl + "/" + fileName, auth);
            if (SmbFile.exists()) {
                SmbFile.delete();
            }
        } catch (MalformedURLException | SmbException e) {
            e.printStackTrace();
        }
    }



    /**
     * Description: 从共享目录拷贝文件到本地
     * @param remoteUrl 共享目录上的文件路径
     * @param localDir 本地目录
     */
    public void smbGet(String remoteUrl,String localDir) {
        InputStream in = null;
        OutputStream out = null;
        try {
            SmbFile remoteFile = new SmbFile(remoteUrl);
            String fileName = remoteFile.getName();
            File localFile = new File(localDir+File.separator+fileName);
            in = new BufferedInputStream(new SmbFileInputStream(remoteFile));
            out = new BufferedOutputStream(new FileOutputStream(localFile));
            byte[] buffer = new byte[1024];
            while(in.read(buffer)!=-1){
                out.write(buffer);
                buffer = new byte[1024];
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Description: 从本地上传文件到共享目录
     * @param remoteUrl 共享文件目录
     * @param localFilePath 本地文件绝对路径
     */
    public void smbPut(String remoteUrl,String localFilePath, String userName, String pwd) {
        InputStream in = null;
        OutputStream out = null;
        try {
            File localFile = new File(localFilePath);

            String fileName = localFile.getName();
            //这里推荐使用这种方式进行用户名密码的校验，在url中拼接，如果需要特殊字符可能无法转换
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, userName, pwd);
            SmbFile remoteFile = new SmbFile(remoteUrl+"/"+fileName, auth);
            in = new BufferedInputStream(new FileInputStream(localFile));
            out = new BufferedOutputStream(new SmbFileOutputStream(remoteFile));
            byte[] buffer = new byte[1024];
            while(in.read(buffer)!=-1){
                out.write(buffer);
                buffer = new byte[1024];
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
