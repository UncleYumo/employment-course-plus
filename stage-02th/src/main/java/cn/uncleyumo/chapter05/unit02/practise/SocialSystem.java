package cn.uncleyumo.chapter05.unit02.practise;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * @author dev.uncleyumo.cn
 * @fileName SocialSystem
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 实现一个简单的社交系统，使用HashSet存储用户的好友列表，并实现以下功能：
 * ① 封装一个用户类，包含用户的ID和用户名等属性
 * ② 提供添加好友的方法，实现在好友列表中添加好友关系
 * ③ 提供删除好友的方法，实现从好友列表中删除好友关系
 * ④ 提供展示用户好友列表的方法，遍历好友列表，输出每个好友的用户名
 * ⑤ 提供检查用户是否是好友的方法，实现判断好友列表中是否存在好友关系，并输出结果
 */

public class SocialSystem {
    public static void main(String[] args) {
        // 测试代码
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        user1.addFriend(user2);
        user1.addFriend(user3);
        user1.showAllFriends();

        user1.deleteFriend(user2);
        user1.showAllFriends();

        System.out.println("Is Bob a friend of Alice? " + user1.isFriend(user2));
        System.out.println("Is Charlie a friend of Alice? " + user1.isFriend(user3));
    }
}

@Getter
@Setter
class User {
    private String id;
    private String name;
    private final Set<User> friends = new HashSet<>();

    public User(String name) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
    }

    public void addFriend(User user) {
        if (this.friends.contains(user)) {
            System.out.println("Already added " + user.getName() + " as your friend!");
            return;
        }
        this.friends.add(user);
        System.out.println("You have added " + user.getName() + " as your friend successfully!");
    }

    public void deleteFriend(User user) {
        if (!this.friends.contains(user)) {
            System.out.println("You don't have " + user.getName() + " as your friend!");
            return;
        }
        this.friends.remove(user);
        System.out.println("You have removed " + user.getName() + " from your friend list successfully!");
    }

    public void showAllFriends() {
        Iterator<User> iterator = friends.iterator();
        int index = 1;
        System.out.println("--------------------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString(index));
            index++;
        }
        System.out.println("--------------------------");
    }

    public boolean isFriend(User user) {
        return this.friends.contains(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | Name: " + getName();
    }

    public String toString(int index) {
        return index + " - ID: " + getId() + " | Name: " + getName();
    }
}
