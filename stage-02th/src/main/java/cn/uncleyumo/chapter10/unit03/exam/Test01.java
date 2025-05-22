package cn.uncleyumo.chapter10.unit03.exam;

import cn.uncleyumo.chapter08.unit01.kotlin.Stu;
import cn.uncleyumo.utils.LogPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 5/22/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description 在班级的花名册中有学生的姓名和年龄信息，现在要求我们将花名册中学生的信息按照一定的规则排序，请按照以下要求，完成该功能：
 * ①创建一个b.txt文件，在里面填充一些学生信息：张三，23；李四，19；王五17；赵六，22；每个学生信息单独一行
 * ②定义一个学生类，属性为name，age。生成setter和getter方法，有无参数构造方法
 * ③创建一个测试类，读取当前文件，并将学生信息重新排序后写入b.txt
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    public String getAgeString() {
        return String.valueOf(age);
    }
}

public class Test01 {
    public static String filePath = System.getProperty("user.dir") + "/stage-02th/src/main/resources/static/b.txt";

    public static void main(String[] args) {
        LogPrinter.INSTANCE.debug("开始测试写入学生数据（未排序）");
        writeFile(
                Map.of(
                        "张三", "23",
                        "李四", "19",
                        "王五", "17",
                        "赵六", "22"
                )
        );
        System.out.println();
        try {
            LogPrinter.INSTANCE.debug("开始测试读取并排序学生数据");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
        LogPrinter.INSTANCE.debug("开始测试写入学生数据（已排序）");
        readFile();
    }

    public static void writeFile(Map<String, String> maps) {
        LogPrinter.INSTANCE.debug("开始写入文件...");
        try (
                OutputStream outputStream = new FileOutputStream(filePath);
                PrintStream printStream = new PrintStream(outputStream);
        ) {
            maps.forEach((key, value) -> {
                printStream.println(key + "，" + value);
            });
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
        LogPrinter.INSTANCE.debug("写入文件完成...");
    }

    public static void readFile() {
        LogPrinter.INSTANCE.debug("开始读取文件...");
        try (
                InputStream inputStream = new FileInputStream(filePath);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            List<Student> stuList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("，");
                Student student = new Student(split[0], Integer.parseInt(split[1]));
                stuList.add(student);
                LogPrinter.INSTANCE.debug("Get: " + student);
            }
            System.out.println();
            List<Student> sortedStuList = stuList.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).toList();
            LogPrinter.INSTANCE.debug("排序后的学生列表：");
            sortedStuList.forEach(student -> {
                LogPrinter.INSTANCE.debug(student.toString());
            });
            System.out.println();
            writeFile(
                    sortedStuList.stream()
                            .collect(Collectors.toMap(Student::getName, Student::getAgeString))
            );
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
