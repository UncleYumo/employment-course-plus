package cn.uncleyumo.chapter01;

import java.util.*;

/**
 * @author uncle_yumo
 * @fileName Test0110
 * @createDate 2025/4/4 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class Test0110 {

    public static void main(String[] args) {
        practise04();
    }

    private static void practise04() {
        Test03.start();
    }

    /*    某地电费收费标准如下
            ① 第一档电量为240度及以下（包含240度）的电量：0.4元/度;
            ② 第二档电量为241-400度（包含400度）之间的电量：0.5元/度;
            ③ 第三档电量为超过400度的电量：0.7元/度;
        请设计一个方法用来根据用电量计算并返回应付电费*/
    private static void practise03() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用电量：");
        int electricity = scanner.nextInt();
        double fee = Test02.calculateElectricityFee(electricity);
        System.out.println("应付电费：" + fee + "元");
    }

    /*    ① 定义一个方法，这个方法的作用是在控制台上打印1~100的数字。
        ② 定义一个方法，在这个方法参数里面传递一个随机数字，这个随机数的取值范围是1~100，随机数生成的是几，程序就计算1到几的数字之和。*/
    private static void practise01() {
        Test01.method01();
        Test01.method02(new Random().nextInt(100) + 1);
    }
}

/*定义一个类，并在类中实现个人所得税各种计算、查询功能，要求如下：
        ① 定义一个方法查询个人所得税税率，方法接收一个参数个人税前薪资，返回税率（小数）。
        ② 定义一个方法查询个人所得税速算扣除金额，方法接收一个参数个人税前薪资，返回速算扣除金额。
        ③ 定义一个方法计算个人所得税税额，方法接收一个参数返回个人所得税税额（个人所得税计算公式：个人所得税税额 = 税前薪资 * 适用税率 - 速算扣除数）

        税率表：
        1.年度不超过36000元的税率为： 3% 速算扣除数：0、
        2.超过36000-144000元的部分税率为： 10% 速算扣除数：2520
        3.超过144000-300000元的部分税率为：20% 速算扣除数：16920
        4.超过300000-420000元的部分税率为：25% 速算扣除数：31920
        5.超过420000-660000元的部分税率为：30% 速算扣除数：52920
        6.超过660000-960000元的部分税率为：35% 速算扣除数：85920
        7.超过960000元的税率为： 45% 速算扣除数：181920*/
class Test05 {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入个人税前薪资：");
        double salary = scanner.nextDouble();
        double rate = getTaxRate(salary);
        double deduction = getQuickDeduction(salary);
        double tax = calculateTax(salary);
        System.out.println("税率：" + rate + "%");
        System.out.println("速算扣除数：" + deduction);
        System.out.println("个人所得税税额：" + tax);
    }

    // 查询个人所得税税率
    public static double getTaxRate(double salary) {
        if (salary <= 36000) {
            return 0.03;
        } else if (salary <= 144000) {
            return 0.10;
        } else if (salary <= 300000) {
            return 0.20;
        } else if (salary <= 420000) {
            return 0.25;
        } else if (salary <= 660000) {
            return 0.30;
        } else if (salary <= 960000) {
            return 0.35;
        } else {
            return 0.45;
        }
    }

    // 查询速算扣除金额
    public static double getQuickDeduction(double salary) {
        if (salary <= 36000) {
            return 0;
        } else if (salary <= 144000) {
            return 2520;
        } else if (salary <= 300000) {
            return 16920;
        } else if (salary <= 420000) {
            return 31920;
        } else if (salary <= 660000) {
            return 52920;
        } else if (salary <= 960000) {
            return 85920;
        } else {
            return 181920;
        }
    }

    // 计算个人所得税税额
    public static double calculateTax(double salary) {
        double rate = getTaxRate(salary);
        double deduction = getQuickDeduction(salary);
        return salary * rate - deduction;
    }
}

/*定义一个类，并在类中完成如下任务：
① 定义一个求2个数最大公约数的方法，返回值为最大公约数。在main方法中从键盘接收两个整数，调用该方法并输出最大公约数到控制台上显示。
② 改进任务① 中方法的代码，如果接收的任何一个数字为0，方法返回0，并提示：“输入的数字不能为0”*/
class Test04 {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个数字：");
        int a = scanner.nextInt();
        System.out.print("请输入第二个数字：");
        int b = scanner.nextInt();
        int gcd = Test04.gcd(a, b);
        System.out.println("最大公约数：" + gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0 || a == 0) {
            System.out.println("输入的数字不能为0");
            return 0;
        }
        return gcd(b, a % b);
    }
}

/*
定义一个类，并在类中完成如下任务：
        ① 定义一个有参有返回值的方法，返回数组元素的最大值，在main方法中调用该方法并在控制台输出最大值
        ② 定义一个有参有返回值的方法，实现随机数组功能（数组元素随机打乱），返回打乱后的随机数组，
        ③ 定义一个有参无返回值的方法，实现数组各元素在控制台输出打印功能，格式:"[1,2,3]"
        ④ 在main方法中将任务①定义的数组，作为参数调用任务②返回的随机数组 使用任务③ 的数组打印方法，将随机后的数组打印输出在控制台上
        ⑤ 定义两个名为sum的方法，方法1参数为两个int类型，该方法返回两个int类型变量相加的和，方法2为一个int类型，一个double类型，
        该方法返回两个参数的乘积，在main中分别调用两个方法sum(1,2)、sum(1,2.0) 并输出调用结果到控制台上。
*/
class Test03 {
    public static void start() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int max = getMax(arr);
        System.out.println("数组的最大值：" + max);
        int[] randomArr = shuffleArray(arr);
        System.out.println(Arrays.toString(randomArr));
        printArray(randomArr);
        System.out.println("1+2=" + sum(1, 2));
        System.out.println("1+2.0=" + sum(1, 2.0));
    }
    private static int getMax(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    // 打乱数组
    private static int[] shuffleArray(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        Collections.shuffle(list);
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    private static int sum(int a, int b) {
        return a + b;
    }
    private static double sum(int a, double b) {
        return a * b;
    }
}

class Test02 {
    public static double calculateElectricityFee(int electricity) {
        if (electricity <= 240) {
            return electricity * 0.4;
        } else if (electricity <= 400) {
            return electricity * 0.5;
        } else {
            return electricity * 0.7;
        }
    }
}

class Test01 {
    public static void method01() {
        for (int i = 1; i <= 100; i++) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }
    public static void method02(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println("1到" + num + "的和为：" + sum);
    }
}

class UnionLotto {
    public static void start() {
        // 用户投注号码
//        List<Integer> userBetList = userBet();
        List<Integer> userBetList = List.of(1, 2, 3, 4, 5, 6, 16);

        // 生成双色球号码
        List<Integer> ballList = generateBall();

        // 判断是否中奖及其奖金
        int prize = calculatePrize(userBetList, ballList);

        // 输出结果
        if (prize == 0) {
            return;
        }
        System.out.println("您的奖金为：" + prize + "元");
//        if (prize > 3000) {  // 大奖
//            // 结束游戏
//            System.out.println("恭喜您中大奖！");
//            System.exit(0);
//        }
    }

    private static int calculatePrize(List<Integer> userBetList, List<Integer> ballList) {
        int redBallCount = 0;
        int blueBallCount = 0;
        for (int i = 0; i < 6; i++) {
            if (userBetList.contains(ballList.get(i))) {
                redBallCount++;
            }
        }
        if (userBetList.get(6).equals(ballList.get(6))) {
            blueBallCount++;
        }

        String prizeType = String.format("%d%d", redBallCount, blueBallCount);
        return switch (prizeType) {
            case "01", "11", "21" -> 5;
            case "31", "40" -> 10;
            case "41", "50" -> 200;
            case "51" -> 3000;
            case "60" -> 5000000;
            case "61" -> 100000000;
            default -> {
                System.out.println("感谢您的参与，没有中奖！");
                yield 0;  // 结束switch语句并返回0
            }
        };
    }

    private static List<Integer> generateBall() {
        // 前6个为红色球，后1个为蓝色球，共7个号码
        List<Integer> ballList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int ball = random.nextInt(34) + 1;
            if (ballList.contains(ball)) {
                i--;
            } else {
                ballList.add(ball);
            }
        }
        ballList.add(random.nextInt(16) + 1);
        System.out.println("\n双色球开奖号码：" + ballList + "\n");
        return ballList;
    }

    public static List<Integer> userBet() {
        System.out.print("请输入您的投注号码：");
        Scanner scanner = new Scanner(System.in);
        List<Integer> betList = new ArrayList<>();
        while (true) {
            if (betList.size() == 6) {
                System.out.print("请输入蓝色球号码（1-16）：");
                int blueBall = scanner.nextInt();
                if (blueBall < 1 || blueBall > 16) {
                    System.out.println("蓝色球号码输入错误！");
                    continue;
                }
                betList.add(blueBall);
                break;
            }
            System.out.print("请输入第" + (betList.size() + 1) + "个红色球号码（1-33）：");
            int redBall = scanner.nextInt();
            if (redBall < 1 || redBall > 33 || betList.contains(redBall)) {
                System.out.println("红色球号码输入错误！");
                continue;
            }
            betList.add(redBall);
        }
        System.out.println("\n您的投注号码为：" + betList);
        return betList;
    }
}

class SearchPrimeNumbers {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入起始数字：");
        int start = scanner.nextInt();
        System.out.print("请输入结束数字：");
        int end = scanner.nextInt();
        List<Integer> primeList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        System.out.println("素数列表：" + primeList);
        System.out.println("素数个数：" + primeList.size());
    }
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
class RedEnvelopeLuckyDraw {
    public static void start() {
        List<Integer> redEnvelopeList = new ArrayList<>(List.of(9, 666, 188, 520, 99999));
        List<String> winnerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (!redEnvelopeList.isEmpty()) {
            System.out.println("红包列表：" + redEnvelopeList);
            System.out.print("请输入抽奖人的昵称：");
            String nickname = scanner.nextLine();
            int index = random.nextInt(redEnvelopeList.size());
            String currentWinner = "恭喜" + nickname + "获得" + redEnvelopeList.remove(index) + "元！";
            winnerList.add(currentWinner);
            System.out.println(currentWinner);
        }
        System.out.println("\n---------------------------------\n");
        winnerList.forEach(System.out::println);
    }
}

class EncryptedPassword {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入密码：");
            String password = scanner.next();
            if (":wq".equals(password)) {
                System.out.println("退出程序！");
                break;
            }
            if (!password.matches("\\d{4}")) {
                System.out.println("密码必须为4位数字！");
                continue;
            }
            String encryptedPassword = encrypt(password);
            System.out.println("加密后的密码为：" + encryptedPassword);
        }
    }

    private static String encrypt(String password) {
        List<Integer> tempList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        password.chars().forEach(item -> tempList.add(item - '0'));
        tempList.forEach(item -> {
            item += 5;
            item %= 10;
            list.add(item);
        });
        // 倒序排列list
        Collections.reverse(list);
        System.out.println(list);
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}

class Judging {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> scoreList = new ArrayList<>();
        while (true) {
            System.out.print("请输入第" + (scoreList.size() + 1) + "个评委的打分，输入0或-1结束：");
            int score = scanner.nextInt();
            if (score == 0 || score == -1) {
                break;
            }
            scoreList.add(score);
            System.out.println(scoreList);
        }
        double result = Judging.judge(scoreList);
        System.out.println("平均分：" + result);
    }

    public static double judge(List<Integer> scoreList) {
        scoreList.sort(Comparator.reverseOrder());  // 降序排序
        int sum = scoreList.stream().mapToInt(score -> score).sum();
        sum -= scoreList.get(0) + scoreList.get(scoreList.size() - 1);  // 去掉最高分和最低分
        return (double) sum / (scoreList.size() - 2);
    }
}

class VerificationCodeGeneration {
    public static void start() {
        String code = generateCode(10000);
        System.out.println("验证码：" + code);
    }

    public static String generateCode(int len) {
        StringBuilder sb = new StringBuilder();

        // 随机生成数字 0：随机数字、1：随机小写字母、2：随机大写字母
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            int type = random.nextInt(3);   // 随机生成 0-2 之间的数字
            switch (type) {
                case 0 -> sb.append(random.nextInt(10));
                case 1 -> sb.append((char) (random.nextInt(26) + 'a'));
                case 2 -> sb.append((char) (random.nextInt(26) + 'A'));
            }
        }
        return sb.toString();
    }
}

class BuyPlainTicket {
    public static void start() {
        double price = calculatePrice(1000, 8, "经济舱");
        System.out.println("初始价格为：" + 1000);
        System.out.println("优惠价格为：" + price);
    }

    public static double calculatePrice(
            double price,
            int month,
            String type
    ) {
        return price = calculateDiscountedPrice(type, price, month >= 5 && month <= 10);
    }

    public static double calculateDiscountedPrice(String type, double price, boolean isHighSeason) {
        return switch (type) {
            case "头等舱" -> price * (isHighSeason ? 0.9 : 0.7);
            case "经济舱" -> price * (isHighSeason ? 0.85 : 0.65);
            default -> price;
        };
    }
}
