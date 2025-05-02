package cn.uncleyumo.chapter07.unit01.practise;

import cn.uncleyumo.utils.LogPrinter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

import static cn.uncleyumo.chapter06.unit02.Test01.staticPath;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 5/2/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Student implements Serializable {
    private String name;
    private int age;
}

public class Test01 {
    public static void main(String[] args) {
        practise03();
    }

    /**
     * 为了降低代码的耦合性，我们会将一些信息写在文件中，请按照如下要求模拟该过程
     * ①在当前项目下创建一个文件c.txt，文件内容如下：
     * 张三,18
     * ②定义一个实体类Student，包含属性name（String），age（Int）
     * ③创建一个测试类，在测试类中读取c.txt文件中的内容，在测试类中创建Student对象，并将来自文件中的信息进行赋值，打印学生对象
     */
    private static void practise03() {
        String filePath = cn.uncleyumo.chapter07.unit01.Test01.staticPath + "c.txt";
        // Store the Serialized Student Object to c.txt
        Student stu = Student.builder().age(21).name("黑马吴彦祖").build();
        try (
                OutputStream os = new FileOutputStream(filePath);
                ObjectOutputStream oos = new ObjectOutputStream(os);
        ) {
            oos.writeObject(stu);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }

        // Read the Serialized Student Object from c.txt
        try (
                InputStream is = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(is);
        ) {
            Student stu1 = (Student) ois.readObject();
            LogPrinter.INSTANCE.info(stu1.toString());
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    /**
     * 质数是指是指一个大于1的自然数，除了1和它自身外，不能被其它自然数整除，被广泛应用于RSA加密算法中，要求创建一个测试类，完成如下任务：
     * ①写一个递归方法，可以输出0-n之间的所有质数，
     * ②在主方法中调用该方法，输出0-100之间的质数。
     */
    private static void practise02(int num) {
        if (num == 100) return;
        boolean isPrime = num != 1 && num != 0;
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (!isPrime) break;
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            LogPrinter.INSTANCE.info(num + "");
        }
        practise02(++num);
    }

    /**
     * 在程序运行过程中，为了日志信息的永久话存储，我们往往将日志信息保存到文件中，在文件中写入数据并且在写入的时候不会清空原来文件中的内容。
     * 请模拟该过程在上一题创建b.txt文件的下一行中写入“2023-05-31: NullPointException”，并且不会删除原来的数据。
     */
    private static void practise01() {
        String staticPath = cn.uncleyumo.chapter07.unit01.Test01.staticPath;
        String filePath = staticPath + "b.txt";
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write("2023-05-31: NullPointException");
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}