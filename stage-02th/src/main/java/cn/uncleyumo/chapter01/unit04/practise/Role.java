package cn.uncleyumo.chapter01.unit04.practise;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @fileName Role
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Getter
@Setter
public abstract class Role {
    private String name;
    public Role() {
    }
    public Role(String name) {
        this.name = name;
    }
    public abstract Integer attack();
}

@Getter
@Setter
class Magician extends Role {
    private Integer magicLevel;
    public Magician(String name, Integer magicLevel) {
        super(name);
        this.magicLevel = magicLevel;
    }
    @Override
    public Integer attack() {
        return getMagicLevel() * 5;
    }
}

@Getter
@Setter
class Soldier extends Role {
    private Integer attackPower;
    public Soldier(String name, Integer attackPower) {
        super(name);
        this.attackPower = attackPower;
    }
    @Override
    public Integer attack() {
        return getAttackPower();
    }
}

class Team {
    private static final List<Role> roles = new ArrayList<>(5);
    public static void addMember(Role role) {
        if (roles.size() >= 5) {
            System.out.println("队伍已满！");
            return;
        }
        roles.add(role);
    }
    public static Integer attackSum() {
        return roles.stream().mapToInt(Role::attack).sum();
    }

    public static void main(String[] args) {
        addMember(new Magician("赵无极", 10));
        addMember(new Soldier("周芷若", 50));
        System.out.println("队伍总攻击力：" + attackSum());
    }
}

