package cn.uncleyumo.chapter01.test05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author uncle_yumo
 * @fileName Test05
 * @proName employment-course-plus
 * @school Wuxi_University
 * @stuNumber 22344131
 * @createTime 2025/4/2
 * @updateTime 2025/4/2
 * @description
 **/

public class Test05 {
    public static void main(String[] args) {
        practise13();
    }

    /*1.
    题目2(训练）
    请编写程序，分别定义8种基本数据类型的变量，并打印变量的值。
    训练目标
    java中的八种基本基本数据类型和变量的定义
    训练提示
    1、java中的8种基本数据类型都有什么？
    2、定义变量的格式是什么？
    3、变量名该怎样定义？
    4、该怎样使用变量？
    参考方案
    定义变量，并输出变量的值。
    训练步骤
    1、创建java文件，定义类Test03，编写主方法。
    2、在java语言中，定义变量必须明确变量的数据类型。八种基本数据类型包括byte、short、int、long、float、double、char、boolean。
    3、定义变量的格式是：
    数据类型 变量名 = 初始化值; // 声明变量并赋值
    // 或
    数据类型 变量名; // 先声明
    变量名 = 初始化值; // 再赋值
    4、可以包含英文字母、数字字符、英文下划线（_）和英文美元符（$），并且不能以数字开头。在开发中，java变量的命名又最好符合“小驼峰”式的惯例规范，并且最好做到见名知意。
    5、在输出语句中，直接调用变量名即可。
    6、编译并运行代码，查看输出结果。*/
    public static void practise01() {
        // 定义变量并赋值
        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;
        float f = 3.4028235E38F;
        double d = 1.7976931348623157E308;
        char c = 'A';
        boolean bo = true;

        // 输出变量的值
        System.out.println("byte类型变量b的值为：" + b);
        System.out.println("short类型变量s的值为：" + s);
        System.out.println("int类型变量i的值为：" + i);
        System.out.println("long类型变量l的值为：" + l);
        System.out.println("float类型变量f的值为：" + f);
        System.out.println("double类型变量d的值为：" + d);
        System.out.println("char类型变量c的值为：" + c);
        System.out.println("boolean类型变量bo的值为：" + bo);
    }

    /*    1. 题干
    十进制、二进制、八进制、十六进制的书写格式是什么？任意进制到十进制的转换公式？十进制到任意进制的转换公式？*/
    public static void practise02() {
        // 十进制
        int decimal = 10;
        System.out.println("十进制：" + decimal);
        // 二进制
        int binary = 0b11111111;
        System.out.println("二进制：" + binary);
        // 八进制
        int octal = 0177;
        System.out.println("八进制：" + octal);
        // 十六进制
        int hexadecimal = 0x7F;
        System.out.println("十六进制：" + hexadecimal);
        // 任意进制到十进制的转换公式：按位权值进行乘法，最后结果相加
        // 十进制到任意进制的转换公式：除以进制数，余数为结果，再倒序排列。
    }

    /*
    定义一个类，并在main方法中完成如下任务：
    ① 分别定义int、long、double、boolean类型变量且初始化，并在控制台分别输出变量值
    ② 将double类型变量赋值给int类型变量，并在控制台输出int类型变量值
    ③ 将int类型变量赋值给double类型的变量，并在控制台输出double类型变量*/
    public static void practise03() {
        int i = 10;
        long l = 100L;
        double d = 3.1415926;
        boolean bo = true;
        System.out.println("int类型变量i的值为：" + i);
        System.out.println("long类型变量l的值为：" + l);
        System.out.println("double类型变量d的值为：" + d);
        System.out.println("boolean类型变量bo的值为：" + bo);
        i = (int)d;
        System.out.println("int类型变量i的值为：" + i);
        d = i;
        System.out.println("double类型变量d的值为：" + d);
    }

/*    5. 题干
    定义一个类，并在main方法中完成如下任务：
    ① 定义两个int类型变量并分别初始化值为65和97，分别将变量强制转换为char类型并输出到控制台
    ② 改变变量值，分别让变量值 加 10，再次分别将变量强制转换为char类型并输出到控制台
    ③ 定义char类型变量，初始化值为 110 ，在控制台输出char类型变量值*/
    public static void practise04() {
        int intA = 65;
        int intB = 97;
        System.out.println((char)intA);
        System.out.println((char)intB);
        intA += 10;
        intB -= 10;
        System.out.println((char)intA);
        System.out.println((char)intB);
        char charC = 110;
        System.out.println(charC);
    }

/*    6. 题干
    数字分解游戏，要求如下：
    ① 定义char类型变量，初始化值为 ‘z’ ，定义int型变量初始化值为char类型的变量，在控制台输出整型变量的值。
    ② 分别定义二进制的变量1110，八进制变量107，十六进制变量5b3，分别输出这几个变量的十进制结果*/
    public static void practise05() {
        char charA = 'z';
        System.out.println(charA);
        int intBinary = 0b1110;
        int intOctal = 0107;
        int intHexadecimal = 0x5b3;
        System.out.println(intBinary);
        System.out.println(intOctal);
        System.out.println(intHexadecimal);
    }

/*    1.
    题目3（应用）
    请根据下列描述，选用合适的数据类型定义变量，并输出变量的值。
    1、班级里有100个学员。
    2、某商品价格55.55元。
    3、地球已经诞生超过46亿年。
    4、“5是偶数”这句话的描述是假的。
    输出结果如下：
    100
    55.55
    4600000000
    false*/
    public static void practise06() {
        int stuNum = 100;
        double price = 55.55;
        long age = 4600000000L;
        boolean isEven = false;
        System.out.println(stuNum);
        System.out.println(price);
        System.out.println(age);
        System.out.println(isEven);
    }

/*    2.
    [题目二]
    某小伙想定一份外卖，商家的优惠方式如下：鱼香肉丝单点24元，油炸花生米单点8元，米饭单点3元。订单满30元8折优惠。鱼香肉丝优惠价16元，
    但是优惠价和折扣不能同时使用。那么这个小伙要点这三样东西，最少要花多少钱？请编写程序计算。
    【思路分析】：
    有两种购买方式，一种是不使用优惠价，另一种是使用优惠价。分别计算花费后，对两种方式的花费作对比。
    【参考方案】：
    使用算术运算符、赋值运算符和三元运算符联合完成本题
    【参考步骤】：
    1.    使用算术运算符求出不使用优惠时的总价
    2.    使用三元运算符判断总价是否满足打折条件，并求出折后总价
    3.    使用算术运算符求出使用优惠价时的总价
    4.    使用三元运算符判断最终更合算的购买方式和花费*/
    public static void practise07() {
        // 计算不使用优惠价时的总价
        double originalTotalPrice = 24 + 8 + 3;
        // 计算折后总价
        double discountTotalPrice =
                originalTotalPrice >= 30 ? originalTotalPrice * 0.8 : originalTotalPrice;

        System.out.println("不使用优惠价时的总价：" + originalTotalPrice);
        System.out.println("折后总价：" + discountTotalPrice);

        // 判断是否使用优惠价
        double finalTotalPrice = originalTotalPrice > 30 ? discountTotalPrice : originalTotalPrice;
        System.out.println("最终购买方式和花费：" + finalTotalPrice);
    }

    /*3.
    在java中，算术运算符加号“+”，也可以作为字符串的连接符。它可以将多个字符串连接在一起，组成一个新的字符串，
    也可以将其他数据类型与字符串连接在一起，组成一个新的字符串。请阅读如下解释：*/
    /*
    我们输出HelloWorld时，输出语句为：
    System.out.println("HelloWorld");
    其实，这个输出语句就是输出了一个字符串，这个字符串也可以由两个或者多个字符串组成。例如：
    System.out.println("Hello" + "World");
    这里，两个字符串会先拼接为一个，再输出，结果与上面一致。再比如：
    int age = 20;
    System.out.println("我的年龄是" + age);
    上面输出语句中，将int类型的变量与字符串连接在一起，组成一个新的字符串，程序的输出结果是：
    我的年龄是20
    而且，还可以多个数据与字符串连接，例如：
    int height = 180;
    System.out.println("我的年龄是" + age + "，我的身高是" + height);
    这个语句中，两个字符串与两个变量会拼成一个字符串输出，输出结果为：
    我的年龄是20，我的身高是180
    根据以上描述，请编写程序，定义两个整数（int类型）变量，并求这两个整数的和，将结果输出到屏幕上。输出格式如下：
    10 + 20 = 30*/
    public static void practise08() {
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + sum);
    }

    public static void practise09() {
        int a = 10;
        double b = 12.3;
        a += b;
        System.out.println(a);
    }

/*  定义一个类，并在main方法中完成如下任务：
    ① 定义两个int类型变量，分别输出两个变量加、减、乘、除 的结果，并输出到控制台。
    ② 将步骤①中 两变量相加 将运算结果在控制台输出，格式为："两数之和是:xx"。
    ③ 将步骤①中 变量1进行前++输出到控制台上、变量2进行后++输出到控制台上。
    ④ 判断步骤①的两个变量和是否大于10作为条件1、积是否大于20作为条件2，如果两个条件都满足，则在控制台上输出true，
      如果两个条件任意一个不满足，则在控制台上输出false。
    ⑤ 使用int类型变量接收3.14，解释输出结果为整数的原因。
    ⑥ 键盘录入两个整数，比较这两个数的大小如果哪个数大就在控制台上输出哪个数字。*/
    public static void practise10() {
        int a = 10;
        int b = 20;
        System.out.println("两数之和是：" + (a + b));
        System.out.println("两数之差是：" + (a - b));
        System.out.println("两数之积是：" + (a * b));
        System.out.println("两数之商是：" + (a / b));
        System.out.println("变量1进行前++输出到控制台上：" + ++a);
        System.out.println("变量2进行后++输出到控制台上：" + b++);
        if ((a + b) > 10 && (a * b) > 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int intPi = (int)3.14;
        System.out.println("3.14的整数部分：" + intPi);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个整数：");
        int num1 = scanner.nextInt();
        System.out.print("请输入第二个整数：");
        int num2 = scanner.nextInt();
        if (num1 > num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }
    }

/*  小明想定一份外卖，鱼香肉丝单点24元，油炸花生米单点8元，米饭单点3元。
    商家的优惠方式如下：
    ① 折扣：订单8折优惠券
    ② 满减：订单满30元可以使用15元优惠券（折扣和满减不能同时使用）
    那么这个小明要点这三样东西，最少要花多少钱？*/
    public static void practise11() {
        double totalPrice = 24 + 8 + 3;
        double discountPrice = totalPrice * 0.8;
        double couponPrice = totalPrice >= 30 ? totalPrice - 15 : totalPrice;
        System.out.println("不使用优惠券时的总价：" + totalPrice);
        System.out.println("使用8折优惠券后的价格：" + discountPrice);
        System.out.println("使用满减优惠券后的价格：" + couponPrice);
        System.out.println("最终购买方式和花费：" +
                (discountPrice > couponPrice ? discountPrice : couponPrice)
            );
    }

/*    定义一个类，并在main方法中完成如下任务：
    ① 键盘录入一个学生的成绩,如果成绩大于90分(包含90分)，则在控制台上打印优秀，如果成绩在60分(包含60分)到90分之间，
    则在控制台上打印一般，如果成绩在0(包含0分)到60分之间，则在控制台上打印不及格。
    ② 键盘录入一个1~7之间的数字，输入值为1，则在控制台上打印"星期一"。输入值为2，则在控制台上打印"星期二"。以此类推。
    ③ 使用for循环输出1-100之内的所有偶数数字*/
    public static void practise12() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生的成绩：");
        int score = scanner.nextInt();
        if (score > 90) {
            System.out.println("优秀");
        } else if (score >= 60) {
            System.out.println("一般");
        } else {
            System.out.println("不及格");
        }
        System.out.print("请输入1-7之间的数字：");
        int day = scanner.nextInt();
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
        for (int i = 2; i <= 100; i += 2) {
            System.out.println(i);
        }
    }

    /*    NBA扣篮大赛上一共有4位选手参赛，他们的成绩分别是 2 、4 、6 、8，统计出分数低于5分的球员一共有几位？*/
    private static void practise13() {
        int[] scores = {2, 4, 6, 8};
        int count = (int) Arrays.stream(scores).filter(score -> score < 5).count();
        System.out.println("分数低于5分的球员一共有：" + count + "位");
    }
}
