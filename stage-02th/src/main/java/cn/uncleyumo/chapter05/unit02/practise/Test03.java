package cn.uncleyumo.chapter05.unit02.practise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test03
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 假设有一个小区物业管理系统，需要管理每个住户的信息，包括住户的姓名、电话、门牌号和欠费金额。现在要实现以下功能：
 *  ①使用LinkedList集合存储住户信息，每个住户信息用一个自定义类Resident表示。类包含姓名、电话、门牌号、欠费金额，重写toString方法
 *  ②定义PropertyManagementSystem类实现以下方法,使用Scanner类从控制台输入住户信息，格式如下:请输入住户信息（格式：姓名 电话 门牌号 欠费金额），输入0结束：
 *  ③使用List的add()方法将住户信息添加到LinkedList集合中。
 *  ④使用List的forEach()方法遍历LinkedList集合，查找指定门牌号的住户信息并打印出来。
 *  ⑤使用List的forEach()方法遍历LinkedList集合，统计所有住户的欠费金额和总人数，并打印出来。
 *  ⑥使用List的forEach()方法遍历LinkedList集合，打印所有住户的信息，并按照门牌号从小到大排序。
 */
public class Test03 {
    public static void main(String[] args) {
        PropertyManagementSystem propertyManagementSystem = new PropertyManagementSystem();
        propertyManagementSystem.addAllResident();
        System.out.println("---------------------------------------------------");
        propertyManagementSystem.findResidentByRoomNumber("1001");
        System.out.println("---------------------------------------------------");
        propertyManagementSystem.findAllResident();
        System.out.println("---------------------------------------------------");
        propertyManagementSystem.findAllResidentAndSort();
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class Resident {
    private String name;
    private String phone;
    private String roomNumber;
    private double balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return Double.compare(balance, resident.balance) == 0 &&
                Objects.equals(name, resident.name) &&
                Objects.equals(phone, resident.phone) &&
                Objects.equals(roomNumber, resident.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, roomNumber, balance);
    }

    @Override
    public String toString() {
        return "住户：" + name + " | 电话：" + phone + " | 门牌号：" + roomNumber + " | 欠费金额：" + balance;
    }
}

class PropertyManagementSystem {
    private final List<Resident> residents;
    public PropertyManagementSystem() {
        this.residents = new LinkedList<>();
    }
    public void addResident() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------开始添加住户----------");
        System.out.print("请输入住户姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入住户电话：");
        String phone = scanner.nextLine();
        System.out.print("请输入住户门牌号：");
        String roomNumber = scanner.nextLine();
        System.out.print("请输入住户欠费金额：");
        double balance = scanner.nextDouble();
        this.residents.add(new Resident(name, phone, roomNumber, balance));
    }
    public void addAllResident() {
        System.out.println("----------开始批量添加住户----------");
        for (int i = 0; i < 3; i++) {
            addResident();
        }
        System.out.println("----------添加住户结束----------");
    }
    public void findResidentByRoomNumber(String roomNumber) {
        System.out.println(residents.stream().filter(it -> it.getRoomNumber().equals(roomNumber)).toList().get(0));
    }
    public void findAllResident() {
        System.out.println(residents.stream().map(Resident::toString).collect(Collectors.joining("\n")));
    }
    public void findAllResidentAndSort() {
        System.out.println(
                "总欠款金额：" +
                residents.stream().mapToDouble(Resident::getBalance).sum() +
                "\n总人数：" + residents.size() +
                "\n排序后的住户信息：\n" +
                residents.stream()
                        .sorted(Comparator.comparing(Resident::getRoomNumber))
                        .map(Resident::toString)
                        .collect(Collectors.joining("\n"))
        );
    }
}