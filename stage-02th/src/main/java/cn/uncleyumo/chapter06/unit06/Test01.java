package cn.uncleyumo.chapter06.unit06;

import cn.uncleyumo.utils.LogPrinter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static cn.uncleyumo.chapter06.unit04.Test02.autoSeparator;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/28/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static String staticPath =
            System.getProperty("user.dir") +
                    autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));

    public static void main(String[] args) {
//        practise07();
        System.out.println(staticPath);
    }

    private static void practise07() {
        try (
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(new FileInputStream(staticPath + "stu.obj"))
        ) {
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise06() {
        Student student = new Student("学生1", 18, 100, "男", "北京", "12345678901");
        try (
                ObjectOutputStream objectOutputStream =
                        new ObjectOutputStream(new FileOutputStream(staticPath + "stu.obj"))
        ) {
            objectOutputStream.writeObject(student);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise05() {
        try (
                FileOutputStream fos = new FileOutputStream(staticPath + "log.txt", true);
                PrintStream printStream = new PrintStream(fos)
        ) {
            System.setOut(printStream);
            int count = 0;
            while (count < 1000) {
                System.out.println(System.currentTimeMillis() + "| " + count);
                Thread.sleep(500);
                count++;
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise04() {
        try (
                PrintStream printStream =
                        new PrintStream(
                                staticPath + "a.txt",
                                Charset.forName("GBK")
                        )
        ) {
            printStream.print(97);
            printStream.println("234234234真牛逼去啊");
            printStream.println();
            printStream.println("asdf你好");
            printStream.println("asdf你好");
            printStream.println("asdf你好");
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise03() {
        try (
                OutputStream os = new FileOutputStream(staticPath + "a.txt", true);
                Writer osw = new OutputStreamWriter(os, "GBK");
                BufferedWriter bw = new BufferedWriter(osw);
        ) {
            bw.write("令狐冲");
            bw.newLine();
            bw.write("东方不败");
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise02() {
        try (
                FileWriter fw = new FileWriter(staticPath + "a.txt");
                BufferedWriter bw = new BufferedWriter(fw);

        ) {
            bw.write(
                    """
                            你好
                            中国
                            asdf
                            asdfnha哈哈2
                            """.trim());
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    /**
     * objective: master the role of InputStreamReader
     */
    private static void practise01() {
        try (
                InputStream is = new FileInputStream(staticPath + "a.txt");
                Reader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr)
        ) {
            br.lines().forEach(System.out::println);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private int score;
    private String sex;
    private transient String address;
    private String phone;
}