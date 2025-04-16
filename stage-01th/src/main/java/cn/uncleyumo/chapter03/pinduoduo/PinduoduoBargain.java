package cn.uncleyumo.chapter03.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author uncle_yumo
 * @fileName PinduoduoBargain
 * @createDate 2025/4/9 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

public class PinduoduoBargain {
    private static final List<User> USER_LIST = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("开始拼夕夕砍价模拟");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        User user = User.builder().name("张三").totalAmount(10000).build();
        int count = 0;

        while (user.getTotalAmount() > 0) {
            count++;
            System.out.println("是否砍价（输入砍价用户名）：");
            String name = scanner.nextLine();
            User userByUsername = getUserByUsername(name);
            if (userByUsername != null) {
                System.out.println("用户已存在，请输入其他用户名：");
                continue;
            }
            User helpUser = User.builder()
                    .name(name)
                    .bargain(random.nextInt(user.getTotalAmount()) + 1)
//                    .bargain()
                    .build();
            if (count != 10) {
                System.out.println("第" + count + "次砍价，" + helpUser.getName() + " 砍了 " + helpUser.getBargain() + " 元");
                user.setTotalAmount(user.getTotalAmount() - helpUser.getBargain());
                helpUser.setTotalAmount(helpUser.getBargain());
                USER_LIST.add(helpUser);
                showBargainList();
            } else {
                // 若进入第十次砍价，必然将totalAmount置为0
                Integer amount = user.getTotalAmount();
                helpUser.setBargain(amount);
                user.setTotalAmount(0);
                USER_LIST.add(helpUser);
                System.out.println("已砍" + amount + "元，还差" + user.getTotalAmount() + "元");
            }
            if (user.getTotalAmount() <= 0) {
                System.out.println("砍价结束");
                break;
            }
        }
    }

    public static User getUserByUsername(String username) {
        return USER_LIST.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst()
                .orElse(null);
    }

    private static void showBargainList() {
        System.out.println("------------------>砍价帮<------------------");
        USER_LIST.forEach(user -> System.out.println(user.getName() + " 砍了 " + user.getBargain() + " 元"));
    }
}
