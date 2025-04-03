package cn.uncleyumo.chapter01;

import java.util.*;

/**
 * @author uncle_yumo
 * @fileName Test0107
 * @createDate 2025/4/3 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test0107 {
    public static void main(String[] args) {
        practice17();
    }

/*    设计一个程序，实现在跳水比赛中评委打分，有5名评委为1名运动员打分，运动员得分方式为去掉一个最高分，
    去掉一个最低分，然后剩下的3个分数求平均值，即为选手得分。请在键盘录入5名评委打的分数（0分到10分），
    将选手得分输出到控制台*/
    private static void practice17() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入5名评委打的分数（0分到10分）：");
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scanner.nextInt();
        }
        int max = Arrays.stream(scores).max().getAsInt();
        int min = Arrays.stream(scores).min().getAsInt();
        ArrayList<Integer> newScores = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != max && scores[i] != min) {
                newScores.add(scores[i]);
            }
        }
        double average = newScores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("选手得分：" + average);
    }

    /*    定义一个类，并在main方法中实现数组拷贝功能：
          定义两个长度为5的数组，其中arr1元素为：{10,34,56,12,100}、arr2为空数组，
          将arr1数组中的内容拷贝到arr2中，并在控制台分别输出arr1、arr2数组的内容
    */
    private static void practice16() {
        int[] arr1 = {10, 34, 56, 12, 100};
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        System.out.println("arr1数组内容：");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("arr2数组内容：");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    /*    定义一个类，并在main方法中完成如下任务：
        ① 定义两个数组变量arr1、arr2指向同一个长度为10的整型数组，使用键盘分别录入10个数字，
          使用数组arr1保存键盘输入的数字到数组中，遍历数组找出数组的最大值并输出到控制台显示。
        ② 使用数组变量 arr2修改数组的第一个元素为 100，遍历输出arr2数组保存的数据到控制台显示*/
    private static void practice15() {
        int[] arr1 = new int[10];
        int[] arr2 = arr1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr2.length; i++) {
            arr1[i] = scanner.nextInt();
        }
        int max = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > max) {
                max = arr1[i];
            }
        }
        System.out.println("数组最大值为：" + max);
        arr2[0] = 100;
        System.out.println("修改后的数组：");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    private static void practice14() {
        int[] arr1 = {11,22,33,44,55};
        System.out.println(arr1[0]);
        int[] arr2 = arr1;
        arr2 = null;
        System.out.println(arr1[arr1.length]);
    }

    /*    有一名老师在统计学生成绩，目前需要在系统中录入5名学生的成绩，
        他们的成绩分别是；100，99，95，90，85分，成绩录入后，系统会自动展示学生的平均成绩。请使用代码完成该系统的功能。*/
    private static void practice13() {
        System.out.println("需要录入的学生成绩分别是：100，99，95，90，85分。");
        Scanner scanner = new Scanner(System.in);
        int[] score = new int[5];
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int j : score) {
            sum += j;
        }
        double average = (double) sum / score.length;
        System.out.println("平均成绩：" + average);
    }

    /*    定义一个类，在main方法中完成如下任务：
        ① 使用静态初始化的方式创建一个数组，将10，20，30，40，50存入这个数组中；
        ② 将数组中的第三个元素打印到控制台上；
        ③ 使用动态初始化的方式再创建一个数组，将60，70，80，90，100存入这个数组中；
        ④ 遍历该数组并将结果打印到控制台上。*/
    private static void practice12() {
        int[] arr1 = {10, 20, 30, 40, 50};
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr2 = new int[5];
        arr2[0] = 60;
        arr2[1] = 70;
        arr2[2] = 80;
        arr2[3] = 90;
        arr2[4] = 100;
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    private static void practice11() {
        // 遍历数组的示例
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*    设计一个程序，帮助小学生练习10以内的加法，要求如下：
        ① 每次随机生成1道加法算式题目，显示在控制台上，学生在控制台查看题目并输入答案，
           当输入的答案正确时提示“回答正确”，否则提示“回答错误”
        ② 统计学生答对次数，答对5题时，提示“练习的很棒,程序结束！” 程序结束。*/
    private static void practice10() {
        System.out.println("----------------------");
        System.out.println("第一题");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (true) {
            int num1 = random.nextInt(10) + 1;
            int num2 = random.nextInt(10) + 1;
            int answer = num1 + num2;
            if (answer > 10) {
                continue;
            }
            System.out.print(num1 + " + " + num2 + " = ");
            command = scanner.nextLine();
            if (":wq".equals(command)) {
                System.out.println("已退出程序");
                break;
            }
            if (Integer.parseInt(command) == answer) {
                System.out.println("回答正确");
            } else {
                System.out.println("回答错误，正确答案是：" + answer);
            }
        }
        System.out.println("----------------------");
        System.out.println("第二题");
    }

    /*有五双鞋子，鞋码分别是41、42、43、44、45，小明的脚穿42和43的鞋子都合适，请用程序判断出不符合小明脚码数的鞋子有几双。*/
    private static void practice09() {
        List<Integer> shoeSizeList = List.of(41, 42, 43, 44, 45);
        System.out.println("小明脚穿42和43的鞋子都合适，不符合小明脚码数的鞋子有" +
                shoeSizeList.stream().filter(s -> s != 42 && s != 43).count()
                + "双。"
        );
    }

    /*    小明搬家想添置一套家用电器，某电商平台优惠如下：
        ① 拼单价: 电压力锅1199(满1199减650)，空气炸锅399(满399减50)，烧水壶199(满199减30）。
        ② 总价打6折（拼单价和折扣不能同时使用）。
        那么小明要买这三样东西，最少要花多少钱？*/
    private static void practice08() {
        double[] originalPriceList = {1199, 399, 199};
        double reductionPrice = originalPriceList[0] - 650 + originalPriceList[1] - 50 + originalPriceList[2] - 30;
        double discountPrice = originalPriceList[0] * 0.6 + originalPriceList[1] * 0.6 + originalPriceList[2] * 0.6;
        System.out.println("最优惠的价格为：" + Math.min(reductionPrice, discountPrice));
    }

    /*      设计一个程序，随机生成一组双色球（总共7个数字，一组双色球由6个红球+1个篮球组成，其中红球为1-33之间的数字，
        且不能重复【本题允许重复出现红球】，篮球为1-16之间的数字），要求如下：
            随机生成一组双色球，每个红球数字用“-”（中划线）分割连成字符串显示，蓝球最后一个显示，且和红球之间用空格分隔。如：“23-12-3-8-14-17 8”*/
    private static void practice07() {
        int[] redBall = new int[6];
        int blueBall = 0;
        Random random = new Random();
        // 随机生成6个红球
        for (int i = 0; i < 6; i++) {
            redBall[i] = random.nextInt(33) + 1;
        }
        blueBall = random.nextInt(16) + 1;

        for (int i = 0; i < redBall.length - 1; i++) {
            System.out.print(redBall[i] + "-");
        }
        System.out.println(redBall[5] + " " + blueBall);
    }

    /*③ 完成课堂案例：珠穆朗玛峰高度折纸案例*/
    private static void practice06() {
        double height = 8848;
        int count = 0;
        while (height >= 1) {
            System.out.println("第" + (count + 1) + "次折纸，高度：" + height);
            height /= 2;
            count++;
        }
    }

    /*② 改进程序，在循环执行过程中遇到偶数则生成一个（10-100）随机数，只输出随机数，不再输出原本应该输出的数字*/
    private static void practice05() {
        Random random = new Random();
        int i = 0;
        while (true) {
            i++;
            System.out.println(random.nextInt(91) + 10);
            if (i == 30) {
                break;
            }
        }
    }

    /*① 编写一个while死循环在控制台输出 1-30 之间的数字（提示：循环变量值为30时，使用break终止循环）*/
    private static void practice04() {
        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
            if (i == 30) {
                break;
            }
        }
    }

    private static void practice03() {
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                System.out.println("I Love Java");
            }
            System.out.println("I Love Java");
        }
    }

    private static void practice02() {
        int i = 100;
        while(i <= 999){
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 10 / 10 % 10;

            if(ge*ge*ge + shi*shi*shi + bai*bai*bai == i){
                System.out.println(i);
            }
            i++;
        }
    }

    public static void practice01() {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            System.out.print(sum + " ");
        }
    }
}
