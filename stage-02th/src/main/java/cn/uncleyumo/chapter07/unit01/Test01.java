package cn.uncleyumo.chapter07.unit01;
import cn.uncleyumo.utils.LogPrinter;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.*;

import static cn.uncleyumo.chapter06.unit01.Test01.autoSeparator;

/**
 * @author dev.uncleyumo.cn(BookAir13)
 * @fileName Test01
 * @createDate 4/29/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 */
public class Test01 {
    public static String staticPath =
            System.getProperty("user.dir") +
                    autoSeparator(List.of("stage-02th", "src", "main", "resources", "static"));

    public static void main(String[] args) {
//        practise03();

    }

    private static void practise03() {
        // 1. create a parser object of dom4j
        SAXReader saxReader = new SAXReader();
        Document document = null;
        // 2. use saxReader to parse the xml file to Document Object
        try {
            document = saxReader.read(staticPath + "data.xml");
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
        if (document == null) return;
        Element rootElement = document.getRootElement();
        System.out.println("element name: " + rootElement.getName());
        Element user = rootElement.element("user");
        if (user == null) return;
        System.out.println("element name: " + user.getName());
        List<Element> userItems = user.elements();
        userItems.forEach(item -> {
            System.out.println(item.getName() + ": " + item.getText());
        });
    }

    private static void practise02() {
        Properties properties = new Properties();
        System.out.println("Init Properties: " + properties);
        try (
                FileReader fileReader = new FileReader(staticPath + "system_data.properties");
        ) {
            properties.load(fileReader);
            Map<String, String> infoMap= Map.of(
                    "name", "name",
                    "age", "age",
                    "sex", "sex000001",
                    "sex000001", "哈哈哈哈"
            );
            infoMap.forEach(properties::setProperty);
            System.out.println("Load Properties: " + properties);
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
        try (
                FileWriter fileWriter = new FileWriter(staticPath + "system_data.properties");
        ) {
            Map<String, String> infoMap= Map.of(
                    "name", "name",
                    "age", "age",
                    "sex", "sex000001",
                    "sex000001", "哈哈哈哈"
            );
            infoMap.forEach(properties::setProperty);
            properties.store(fileWriter, "Test store info");
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

    private static void practise01() {
        Properties properties = new Properties();
        System.out.println("Init Properties: " + properties);
        try (
                // Use UTF-8 to read file
                InputStream inputStream = new FileInputStream(staticPath + "system_data.properties");
                FileReader fileReader = new FileReader(new File(staticPath + "system_data.properties"));
                ) {
            // "src/main/resources/static/system_data.properties"
            properties.load(fileReader);
            System.out.println("Load Properties: " + properties);
            System.out.println();
            Set<String> strings = properties.stringPropertyNames();
            strings.forEach(key -> {
                System.out.println("Key is: " + key + " Value is: " + properties.getProperty(key));
            });
            System.out.println();
            properties.forEach((k, v) -> {
                System.out.println("Key is: " + k + " Value is: " + v);
            });
        } catch (Exception e) {
            LogPrinter.INSTANCE.error(e.getMessage());
        }
    }

}
