package com.itheima.thread.demo03;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// 该类用于实现图片的下载功能
public class DownLoadImage01 {

    public static void main(String[] args) throws IOException {

        // 定义一个集合来存储读取到的数据
        List<String> dataInfo = new ArrayList<String>() ;

        // 创建一个输入流对象，读取数据
        BufferedReader br = new BufferedReader(new FileReader("images-url.txt")) ;
        String line = null ;
        while((line = br.readLine()) != null) {
            dataInfo.add(line) ;
        }

        // 释放流资源
        br.close();

        // 遍历集合挨个元素进行处理
        for(String url : dataInfo) {
            downLoad(url) ;
        }

    }

    // 下载图片代码
    private static void downLoad(String url) {

        try {

            URLConnection urlConnection = new URL(url).openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            File file = new File("D:\\images");
            if(!file.exists()){
                file.mkdirs() ;
            }
            FileOutputStream fos = new FileOutputStream(new File(file , UUID.randomUUID().toString().replace("-", "")) + ".jpg");
            byte[] bytes = new byte[1024] ;
            int len = 0;
            while((len = inputStream.read(bytes)) != -1){
                fos.write(bytes , 0 , len);
                fos.flush();
            }
            fos.close();
            inputStream.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
