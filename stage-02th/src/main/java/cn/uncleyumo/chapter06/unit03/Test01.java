package cn.uncleyumo.chapter06.unit03;

import cn.uncleyumo.utils.ColorPrinter;
import cn.uncleyumo.utils.LogPrinter;
import cn.uncleyumo.utils.pojo.MetaPrinter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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
        practise07();
    }

    private static void practise07() {
        try {
            @SuppressWarnings("resource")
            OutputStream os = new FileOutputStream(staticPath + "test01.txt", false);
            // create two thread to write to the same file
            new Thread(() -> {
                int count = 0;
                while (count <= 1000) {
                    try {
                        os.write("x".getBytes());
                        if (count % 10 == 0) {
                            os.write("\r\n".getBytes());
                        }
                        try {
                            Thread.sleep(3);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    count++;
                }
            }).start();
            new Thread(() -> {
                int count = 0;
                while (count <= 1000) {
                    try {
                        os.write("-".getBytes());
                        if (count % 10 == 0) {
                            os.write("\r\n".getBytes());
                        }
                        try {
                            Thread.sleep(3);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    count++;
                }
            }).start();
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise06() {
        // Append mode to test01.txt
        try (OutputStream os = new FileOutputStream(staticPath + "test01.txt", true)) {
            os.write(97);
            os.write(98);
            os.write('c');
            os.write("\r\n".getBytes());
            os.write("Hello World!\r\n".getBytes());
            os.write("Hello World!\r\n".getBytes());
            os.write("Hello World!\r\n".getBytes());
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise05() {
        try (OutputStream os = new FileOutputStream(staticPath + "test01.txt")) {
            os.write(97);
            os.write(98);
            os.write('c');
            os.write('\n');
            os.write("Hello World!\n".getBytes());
            os.write("Hello World!\n".getBytes());
            os.write("Hello World!\n".getBytes());
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise04() {
        FileInputStream staticTestFileInputStream = getStaticTestFileInputStream();
        File file = getStaticTestFile();
        if (staticTestFileInputStream == null) return;
        if (file == null) return;
        // prepare a byte arr, make sure that its capacity is enough to store the content of the file
        byte[] bytes = new byte[(int) file.length()];
        try {
            int len = staticTestFileInputStream.read(bytes);
            System.out.println("This term's byte length: " + len);
            System.out.println("The content is: \n" + new String(bytes, 0, len, StandardCharsets.UTF_8));
        } catch (IOException e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    @SuppressWarnings({"DataFlowIssue"})
    private static void practise03() {
        // read file(test01.text) by line
        try (BufferedReader br = new BufferedReader(new FileReader(getStaticTestFile()))) {
            String line;
            Map<String, String> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                if (line.contains("::")) {
                    String[] split = line.split("::");
                    map.put(split[0], split[1]);
                }
            }
            int len = getMaxLenOfMap(map);
            map.forEach((k, v) -> System.out.println(
                    getFormatStringByLength(k, len) + " is " + v
            ));
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static FileInputStream getStaticTestFileInputStream() {
        File file = getStaticTestFile();
        if (file == null) return null;
        try(FileInputStream is = new FileInputStream(file)) {
            // Clone a new FileInputStream and return it
            return new FileInputStream(file);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
            return null;
        }
    }

    private static String getFormatStringByLength(String str, int len) {
        if (str.length() >= len) {
//            LogPrinter.INSTANCE.warn("The length of original string is less than or equal to the len you inputted!");
            return str;
        }
        return str + " ".repeat(len - str.length());
    }

    private static int getMaxLenOfMap(Map<String, ?> map) {
        //noinspection OptionalGetWithoutIsPresent
        return map.keySet().stream().mapToInt(String::length).max().getAsInt();
    }

    private static File getStaticTestFile() {
        File file = new File(staticPath + "test01.txt");
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                LogPrinter.INSTANCE.error(e.getMessage());
                return null;
            }
        }
        return file;
    }

    private static void practise02() {
        InputStream staticTestFileInputStream = getStaticTestFileInputStream();
        if (staticTestFileInputStream == null) return;
        byte[] buffer = new byte[4];
        try {
            int len = staticTestFileInputStream.read(buffer);
            System.out.println("This term's byte length: " + len);
            System.out.println("The content is: " + new String(buffer, 0, len, StandardCharsets.UTF_8));
            System.out.println("----------------------------------------------");
            len = staticTestFileInputStream.read(buffer);
            System.out.println("This term's byte length: " + len);
            System.out.println("The content is: " + new String(buffer, 0, len, StandardCharsets.UTF_8));
        } catch (IOException e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise01() {
        File file = getStaticTestFile();
        if (file == null) return;
        try (InputStream is = new FileInputStream(file)) {
            int b;
            while ((b = is.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }
}
