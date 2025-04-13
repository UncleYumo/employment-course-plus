package cn.uncleyumo.chapter01.unit01.practise;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author uncle_yumo
 * @fileName Beef
 * @createDate 2025/4/12 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beef implements Serializable {
    private String part;
    private Integer price;
    private static String place = "新西兰";

    /*
     * 计算购买数量
     */
    public String getCount(Integer money) {
        return money + "元能买" + money / price + "斤" + part;
    }
}
