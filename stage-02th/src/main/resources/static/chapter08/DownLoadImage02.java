package com.itheima.thread.demo03;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 该类用于实现图片的下载功能
public class DownLoadImage02 {

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

        // 补全代码

    }

    /**
     * 图片下载的代码
     * @param url：要下载的图片地址
     */
    private static void downLoad(String url) {
        try {

            URLConnection urlConnection = new URL(url).openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            File file = new File("D:\\images") ;
            if(!file.exists()) {
                file.mkdirs() ;
            }
            FileOutputStream fos = new FileOutputStream(new File(file ,  UUID.randomUUID().toString().replace("-", "")) + ".jpg");
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

    /**
     * 对集合进行拆分
     * @param source：要拆分的集合对象
     * @param n：要拆分的份数
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

}
