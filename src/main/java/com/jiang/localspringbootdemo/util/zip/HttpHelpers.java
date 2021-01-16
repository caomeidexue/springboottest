package com.jiang.localspringbootdemo.util.zip;

import sun.net.www.protocol.ftp.FtpURLConnection;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-17 15:57
 */

public abstract class HttpHelpers {

    private static final String KEY = "file.encoding";

    private static final String ENCODING = "GBK";

    public static InputStream getInputStream(String url) throws Exception{
        URLConnection con = null;
        HttpURLConnection httpCon = null;
        FtpURLConnection ftpCon= null;
        try {
            System.setProperty(KEY, ENCODING);
            URL _url = new URL(url);
            con = _url.openConnection();
            con.setConnectTimeout(3000);
            con.setUseCaches(false);// 不缓存
            con.setDefaultUseCaches(false);
            if (con instanceof HttpURLConnection) {
                httpCon = (HttpURLConnection) con;
                httpCon.setInstanceFollowRedirects(true);
                //httpCon.setRequestProperty("Accept-Charset", "utf-8");
                if (httpCon.getResponseCode() >= 300) {
                    System.out.println("URL:" + url
                            + ",HTTP Request is not success, Response code is "
                            + httpCon.getResponseCode());
                } else {
                    return httpCon.getInputStream();
                }
            } else if(con instanceof FtpURLConnection){
                ftpCon = (FtpURLConnection)con;
                return ftpCon.getInputStream();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
           /* if(httpCon != null)
                httpCon.disconnect();*/
        }
        return null;
    }

    public static void main(String[] args) {
        // 1图片本地存储大小
        OutputStream fout = null;
        InputStream input = null;
        try {
            fout = new FileOutputStream("/Users/jiangqb/Desktop/temp" + File.separator + "1.jpg");
            input = getInputStream("https://j-image.missfresh.cn/1579157121105-870.png");
            byte[] buffer = new byte[1024];
            int count = 0 ;
            while((count=input.read(buffer)) != -1){
                fout.write(buffer, 0, count);
            }
            fout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(input != null) input.close();
                if(fout != null) fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 2是否可以构建图片
        try {
            input = getInputStream("http://192.168.1.200/t.jpg");
            ImageInputStream iis = ImageIO.createImageInputStream(input);
            if(iis != null) {
                Iterator<ImageReader> it = ImageIO.getImageReaders(iis);
                if(!it.hasNext()){
                    System.out.println("流不完整或不是图片！");
                } else {
                    System.out.println(it.next().getFormatName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
