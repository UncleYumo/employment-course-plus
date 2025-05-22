package cn.uncleyumo.chapter10.unit03.exam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName TestFileOperation
 * @createDate 5/22/25 May
 * @school Wuxi University
 * @studentID 22344131
 * @description 有一个FileOperation类，构造函数传入要操作的文件，并提供了一个readFile方法，可以读取指定文件的内容并返回，
 * 请按要求编写测试方法
 * 1.使用JUnit来测试
 * 2.使用@Before 初始指定要读取的文件
 * 3.通过断言来判断readFile方法是否按预期工作
 */

class FileOperation {
    private String file;

    public FileOperation(String file) {
        this.file = file;
    }

    public String readFile() {
        String content = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((content = reader.readLine()) != null) {
            }
            reader.close();
        } catch (Exception e) {
        }
        return content;
    }
}

public class TestFileOperation {
    private static String file;

    @Before
    public void prepare() {
        file = System.getProperty("user.dir") + "/stage-02th/src/main/resources/static/b.txt";
    }
    @Test
    public void testReadFile() {
        FileOperation fileOperation = new FileOperation(file);
        String content = fileOperation.readFile();
        Assert.assertEquals("内容不匹配", "The people's republic of China", content);
    }
}
