package cn.uncleyumo.chapter03.java;

/**
 * @author uncle_yumo
 * @fileName Test01
 * @createDate 2025/4/7 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test01 {
    public static void main(String[] args) {
        practise03();
    }

/*    小谷点了一份外卖，为了保护用户安全隐私，外卖APP对该手机号做了脱敏处理，脱敏规则如下：

    判断手机号是否是13开头的，如果是13开头并且手机号码是11位的话，则将手机号的第4-7位变为*。
    例如题目中的手机号变为136****4567。（不考虑用户录入字母和特殊字符的情况）

    模拟这个外卖APP中的脱敏操作，当用户输入完手机号的时候，自动进行脱敏处理，并把脱敏后的手机号打印在控制台上。*/
    private static void practise03() {
        String phone = "13612345678";
        if (phone.startsWith("13") && phone.length() == 11) {
            phone = phone.substring(0, 3) + "****" + phone.substring(7);
        }
        System.out.println(phone);
    }

    /*需求 : 对字符串进行遍历操作, 可以使用下列的哪些方法 ? 具体怎么遍历呢 ?*/
    public static void practise01() {
        // 1. toCharArray() 方法
        String str = "hello world";
        char[] chars = str.toCharArray();

        // 2. charAt() 方法
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c);
        }

        // 3. split() 方法
        String[] arr = str.split("");
        for (String s : arr) {
            System.out.println(s);
        }
    }

/*    使用String s= “boxuegu” 定义一个字符串“boxuegu”。
        ① 使用构造方法public String(original)、public String(char [] chars)、public String(byte[] bytes)的三种不同方式再次定义三个字符串变量存储字符串"boxuegu"。
        ② 返回字符串"boxuegu"的长度，并输出到控制台上。
        ③ 提取"boxuegu"字符串中索引2所表示的字符，并输出在控制台上。
        ④ 定义一个字符串"BoXueGu"和"boxuegu"进行内容上（忽略大小写）的比较。
    如果一样就在控制台上打印true，否则打印false。
        ⑤ 从字符串"boxuegu"截取出"xue"这个字符串，并输出在控制台上。
        ⑥ 将"bo#xue#gu"这个字符串使用#号进行分割，并分别输出在控制台上。*/
    public static void practise02() {
        String s1 = "boxuegu";

        // ① 使用构造方法public String(original)、public String(char [] chars)、public String(byte[] bytes)的三种不同方式
        // 再次定义三个字符串变量存储字符串"boxuegu"。
        String s2 = new String(s1);
        String s3 = new String(s1.toCharArray());
        String s4 = new String(s1.getBytes());

        // ② 返回字符串"boxuegu"的长度，并输出到控制台上。
        System.out.println(s1.length());

        // ③ 提取"boxuegu"字符串中索引2所表示的字符，并输出在控制台上。
        System.out.println(s1.charAt(2));

        // ④ 定义一个字符串"BoXueGu"和"boxuegu"进行内容上（忽略大小写）的比较。
        String s5 = "BoXueGu";
        if (s1.equalsIgnoreCase(s5)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        // ⑤ 从字符串"boxuegu"截取出"xue"这个字符串，并输出在控制台上。
        String s6 = s1.substring(2, 5);
        System.out.println(s6);

        // ⑥ 将"bo#xue#gu"这个字符串使用#号进行分割，并分别输出在控制台上。
        String s7 = "bo#xue#gu";
        String[] arr = s7.split("#");
        for (String s : arr) {
            System.out.println(s);
        }

    }
}
