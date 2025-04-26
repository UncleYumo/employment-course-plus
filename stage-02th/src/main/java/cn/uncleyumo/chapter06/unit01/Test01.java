package cn.uncleyumo.chapter06.unit01;

import cn.uncleyumo.utils.LogPrinter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test01
 * @createDate 4/26/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description File IO
 */

public class Test01 {
    static String staticPath = System.getProperty("user.dir") + autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));

    public static void main(String[] args) {
        practise05();
    }

    private static void practise05() {
        File file = new File(staticPath);
        @SuppressWarnings("DataFlowIssue")
        List<File> list = Arrays.stream(file.listFiles()).toList();
        //noinspection ResultOfMethodCallIgnored
        list.forEach(File::delete);
    }

    private static void practise04() {
        List<File> files = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            files.add(new File(staticPath + "test" + i + ".txt"));
        }
        try {
            for (File file : files) {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise03() {
        File file = new File(staticPath);
        String[] list = file.list();
        System.out.println(Arrays.toString(list));
        File[] files = file.listFiles();
        assert files != null;
        //noinspection ResultOfMethodCallIgnored
        Arrays.stream(files).forEach(File::delete);
    }

    private static void practise02() {
        File file = new File(staticPath + "test.txt");
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            LogPrinter.INSTANCE.error("Failed to create file: " + e.getMessage());
        }
//        System.out.println(file.delete());
    }

    private static void practise01() {
        System.out.println(staticPath);
        File file = new File(staticPath + "record.txt");
        if (file.exists()) {
            System.out.println(
                    tabWrapper("lastModified()", 20) + " | " +
                            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                                    .format(file.lastModified())
            );
            System.out.println(
                    tabWrapper("length()", 20) + " | " +
                            file.length()
            );
        } else {
            System.out.println("File doesn't exist!");
        }
    }

    /**
     * 自动拼接路径分隔符
     */
    public static String autoSeparator(List<String> paths) {
        return paths.stream().reduce("", (a, b) -> a + File.separator + b) + File.separator;
    }

    /**
     * 根据字符串长度自动调整 Tab 数量，使其对齐到指定宽度
     *
     * @param str    输入的字符串
     * @param width  对齐的目标宽度（如 8 的倍数）
     * @return       补充 Tab 后的字符串
     */
    public static String tabWrapper(String str, int width) {
        // 计算需要补充的 Tab 数量
        int tabsNeeded = (width - str.length() + 7) / 8; // 向上取整
        return str + "\t".repeat(Math.max(0, tabsNeeded));
    }
}
