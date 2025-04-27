package cn.uncleyumo.chapter06.unit01.practise;

import cn.uncleyumo.utils.LogPrinter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/27/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@SuppressWarnings({"ResultOfMethodCallIgnored", "DataFlowIssue"})
public class Test01 {
    public static String staticPath = System.getProperty("user.dir") + autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));
    public static void main(String[] args) {
        practise03();
    }

    /**
     * 请编写代码遍历你电脑上某个文件夹下的一级子文件，并打印他们的绝对路径，如果是文件还需要打印文件名和文件大小
     */
    private static void practise03() {
        File dir = new File(staticPath);
        if (dir.listFiles() == null) return;
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                System.out.println("Absolute Path of file: " + file.getAbsolutePath());
                System.out.println("Name of file: " + file.getName());
            } else {
                System.out.println("Absolute Path of dir: " + file.getAbsolutePath());
            }
        }
    }

    /**
     * 在开发过程中，有些功能需要我们对本地文件夹进行修改，请编写一个程序，模拟该过程
     * ①创建3个file对象 File file1 = new File(“test.txt”);//相对路径 File file2 = new File(“一级目录”); File file3 = new File(“目录A/目录B/目录C”);
     * ②判断file1是否存在？如果不存在，创建这个文件。
     * ③判断file2是否存在？如果不存在，创建这个目录。
     * ④判断file3是否存在？如果不存在，创建这个多级目录。
     */
    private static void practise02() {
        File file1 = new File(staticPath + "test.txt");
        File file2 = new File("一级目录");
        File file3 = new File(staticPath + "目录A/目录B/目录C");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                LogPrinter.INSTANCE.error(e.getMessage());
            }
        }
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (!file3.exists()) {
            file3.mkdirs();
        }
    }

    /**
     * 编写一个程序，请完成一下内容
     *  ①请在D盘根目录下创建一个文件：test1.txt(随意录入一些内容)；再创建一个目录：测试目录
     *  ②创建File对象，分别关联test1.txt，测试目录。获取、打印file1和file2的绝对路径；
     *  ③获取、打印file1和file2的文件名和目录名；
     *  ④获取、打印file1和file2的文件大小；
     *  ⑤分别判断file1和file2是否存在；
     *  ⑥分别判断file1和file2是否是文件？是否是目录？
     */
    private static void practise01() {
        File staticFile = new File(staticPath + "test1.txt");
        File staticDIr = new File(staticPath);
        System.out.println("Absolute path of file: " + staticFile.getAbsolutePath());
        System.out.println("Absolute path of dir: " + staticDIr.getAbsolutePath());
        System.out.println("Name of file: " + staticFile.getName());
        System.out.println("Name of dir: " + staticDIr.getName());
        System.out.println("Size of file: " + staticFile.length());
        System.out.println("Size of dir: " + staticDIr.length());
        System.out.println("Exist of file: " + staticFile.exists());
        System.out.println("Exist of dir: " + staticDIr.exists());
        System.out.println("Is file of file: " + staticFile.isFile());
        System.out.println("Is file of dir: " + staticDIr.isFile());
        System.out.println("Is dir of file: " + staticFile.isDirectory());
        System.out.println("Is dir of dir: " + staticDIr.isDirectory());
    }

    /**
     * 自动拼接路径分隔符
     */
    public static String autoSeparator(List<String> paths) {
        return paths.stream().reduce("", (a, b) -> a + File.separator + b) + File.separator;
    }
}
