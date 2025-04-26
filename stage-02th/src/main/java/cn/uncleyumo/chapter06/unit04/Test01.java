package cn.uncleyumo.chapter06.unit04;

import cn.uncleyumo.utils.LogPrinter;

import java.io.*;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    private static final String staticPath = cn.uncleyumo.chapter06.unit02.Test01.getStaticPath();

    public static void main(String[] args) {
        practise01();
    }

    private static void practise01() {
        File file = new File(staticPath + "example.gif");
        File fileCopy = new File(staticPath + "copy" + File.separator + "example(copy).gif");
        if (!file.exists()) {
            LogPrinter.INSTANCE.warn("example.gif is not exits");
        }
        if (!fileCopy.getParentFile().exists()) {
            LogPrinter.INSTANCE.warn("Create " + fileCopy.getParentFile().getPath() + " directory");
            //noinspection ResultOfMethodCallIgnored
            fileCopy.getParentFile().mkdirs();
        }
        try (
                InputStream is = new FileInputStream(file);
                OutputStream os = new FileOutputStream(fileCopy)
        ) {
            byte[] buffer = new byte[1024 * 1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                LogPrinter.INSTANCE.info("Current buffer size: " + len);
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
