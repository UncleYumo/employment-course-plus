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
//        BuyPlainTicket.start();
//        VerificationCodeGeneration.start();
//        Judging.start();
//        EncryptedPassword.start();
        RedEnvelopeLuckyDraw.start();
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
