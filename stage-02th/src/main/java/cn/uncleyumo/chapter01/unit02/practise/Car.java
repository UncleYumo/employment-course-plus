package cn.uncleyumo.chapter01.unit02.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author uncle_yumo
 * @fileName Car
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@AllArgsConstructor
public class Car {
    private String carType;
    private String licensePlateNumber;
    public void start() {
    }

    public void stop() {
    }
}

@Getter
@Setter
class Taxi extends Car {
    private String companyName;

    public Taxi(String carType, String licensePlateNumber, String companyName) {
        super(carType, licensePlateNumber);
        this.companyName = companyName;
    }

    @Override
    public void start() {
        System.out.println("欢迎乘坐" + companyName + "的车牌号为" + getLicensePlateNumber() + "的" + getCarType() + "型出租车，请系好安全带");
    }

    @Override
    public void stop() {
        System.out.println("感谢乘坐" + companyName + "的车牌号为" + getLicensePlateNumber() + "的" + getCarType() + "型出租车，下车时请记得带好随身物品");
    }
}

@Getter
@Setter
class FamiliarCar extends Car {
    private String driverName;

    public FamiliarCar(String carType, String licensePlateNumber, String driverName) {
        super(carType, licensePlateNumber);
        this.driverName = driverName;
    }

    @Override
    public void start() {
        System.out.println("您现在驾驶的是" + driverName + "的车牌号为" + getLicensePlateNumber() + "的" + getCarType() + "，请系好安全带");
    }

    @Override
    public void stop() {
        System.out.println(driverName + "的车牌号为" + getLicensePlateNumber() + "的" + getCarType() + "行驶完毕");
    }
}


class CarTest {
    public static void main(String[] args) {
        FamiliarCar familiarCar = new FamiliarCar("SUV", "京.J8888", "赵云");
        Taxi taxi = new Taxi("SUV", "京.J8888", "传智播客");
        familiarCar.start();
        familiarCar.stop();
        taxi.start();
        taxi.stop();
    }
}