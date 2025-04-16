package cn.uncleyumo.chapter02.unit01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author uncle_yumo
 * @fileName Test
 * @createDate 2025/4/16 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@AllArgsConstructor
class User implements Cloneable {
    private String name;
    private double[] scores;

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone failed: " + e.getMessage());
            return null;
        }
    }

//    public User deepClone() {
//        try {
//            User user = (User) super.clone();
//            user.scores = new ArrayList<>(scores);
//            return user;
//        } catch (CloneNotSupportedException e) {
//            System.out.println("Clone failed: " + e.getMessage());
//            return null;
//        }
//    }

    public User deepClone02() {
        try {
            User user = (User) super.clone();
            user.scores = user.scores.clone();
            return user;
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone failed: " + e.getMessage());
            return null;
        }
    }
}

/** @author uncle_yumo */
public class Test {
    public static void main(String[] args) {
        User user = new User("uncle_yumo", new double[]{80, 90, 95});
        User clone = user.deepClone02();
        // 打印user和clone的内存地址
        System.out.println("user: " + System.identityHashCode(user));
        System.out.println("clone: " + System.identityHashCode(clone));
        System.out.println("user: " + user);
        System.out.println("clone: " + clone);
        clone.setName("uncle_yumo_clone");
        clone.getScores()[0] = 100;
        System.out.println("user: " + user);
        System.out.println("clone: " + clone);
    }
}
