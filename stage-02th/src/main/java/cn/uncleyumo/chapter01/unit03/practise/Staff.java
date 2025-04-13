package cn.uncleyumo.chapter01.unit03.practise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author uncle_yumo
 * @fileName Staff
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@AllArgsConstructor
@Setter
@Getter
public class Staff {
    private String name;
    private String id;
    private Double salary;

    public void work() {

    }
}

@Setter
@Getter
class Manager extends Staff {
    private String bonus;

    public Manager(String name, String id, Double salary, String bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println(
                getName() + "，工号为" + getId() + "，工资为" + getSalary() + "的经理正在见客户，他的奖金是" + getBonus()
        );
    }
}

class Coder extends Staff {

    public Coder(String name, String id, Double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println(
                getName() + "，工号为" + getId() + "，工资为" + getSalary() + "的经理正在加班敲代码，他没有奖金"
        );
    }
}

class TestStaff {
    public static void main(String[] args) {
        Manager manager = new Manager("张三", "654321", 8000.0, "10000");
        manager.work();

        Coder coder = new Coder("李四", "987654", 3000.0);
        coder.work();
    }
}