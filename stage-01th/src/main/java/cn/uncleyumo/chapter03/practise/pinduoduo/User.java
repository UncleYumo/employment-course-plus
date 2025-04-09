package cn.uncleyumo.chapter03.practise.pinduoduo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author uncle_yumo
 * @fileName User
 * @createDate 2025/4/9 April
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    private String name;
    private Integer bargain;
    private Integer totalAmount;
}
