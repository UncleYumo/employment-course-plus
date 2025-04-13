package cn.uncleyumo.chapter01.unit02.practise;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @fileName Auto
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@SuperBuilder
public class Auto implements Serializable {
    private String brand;
    private Long vehicleLength;
    private Long price;
    public String getType(Auto obj) {
        if (obj.getVehicleLength() > 5070) {
            return "大型车";
        }
        if (obj.getVehicleLength() < 4295) {
            return "小型车";
        }
        return "中型车";
    }
}

@SuperBuilder
class Suv extends Auto {

    @Override
    public String toString() {
        return String.format("""
                品牌：%s
                    价格：%d
                    车长：%d
                """, getBrand(), getPrice(), getVehicleLength());
    }
}

class AutoTest {
    public static void main(String[] args) {
        List<Auto> autoList = new ArrayList<>();
        autoList.add(Suv.builder().brand("奔驰").vehicleLength(4813L).price(400000L).build());
        autoList.add(Suv.builder().brand("奥迪").vehicleLength(4545L).price(458888L).build());
        autoList.add(Suv.builder().brand("宝马").vehicleLength(2300L).price(458999L).build());
        autoList.add(Suv.builder().brand("大众").vehicleLength(1390L).price(458833L).build());
        autoList.add(Suv.builder().brand("众泰").vehicleLength(5230L).price(458888L).build());
        autoList.add(Suv.builder().brand("解放").vehicleLength(7989L).price(999999L).build());
        for (Auto auto : autoList) {
            if ("中型车".equals(auto.getType(auto))) {
                System.out.println(auto);
            }
        }
    }
}