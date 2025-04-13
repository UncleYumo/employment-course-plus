package cn.uncleyumo.chapter01.unit01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author uncle_yumo
 * @fileName User
 * @createDate 2025/4/11 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class User implements Serializable {
    public static Integer NUMBER = 0;

    public User() {
        NUMBER++;
    }
}

class TestUser {
    public static void main(String[] args) {
        User user01 = new User();
        User user02 = new User();
        User user03 = new User();
        System.out.println(User.NUMBER);
    }
}