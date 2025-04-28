package cn.uncleyumo.chapter04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dev.uncleyumo.cn
 * @fileName InventoryManagementSystem
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 实现一个库存管理系统。实现以下功能：
 * ①封装一个库存类，包含商品的名称和库存数量等属性。
 * ②使用HashMap作为库存管理的数据结构，将商品名称作为键，库存对象作为值存储到Map中。
 * ③提供更新库存的方法，接收商品名称和数量作为参数，根据传入的数量更新库存数量。
 * ④提供检查库存是否充足的方法，根据商品名称获取库存对象，并判断库存数量是否大于等于购买数量。
 * ⑤在添加商品到购物车的方法中（不用实际添加到购物车，自己有兴趣可以结合第二题来做），需要检查库存是否充足，如果库存不足，则不允许添加商品到购物车，并输出提示信息。
 */

public class InventoryManagementSystem {
    private final Map<String, LocalCommodity> map;
    public InventoryManagementSystem() {
        this.map = new HashMap<>();
    }
    public LocalCommodity getCommodity(String name) {
        return map.get(name);
    }
    public void updateStock(String name, int stock) {
        LocalCommodity commodity = map.get(name);
        if (commodity == null) {
            System.out.println("Add an new commodity to Inventory: " + name);
            commodity = new LocalCommodity(name, stock);
        } else {
            System.out.println("Update stock of commodity: " + name);
            commodity.setStock(commodity.getStock() + stock);
        }
        map.put(name, commodity);
    }
    public boolean checkStock(String name, int stock) {
        LocalCommodity commodity = map.get(name);
        if (commodity == null) {
            System.out.println("Commodity: " + name + " is not exist.");
            return false;
        }
        if (commodity.getStock() < stock) {
            System.out.println("Commodity: " + name + " is not enough.");
            return false;
        }
        return true;
    }
    public void purchase(String name, int stock) {
        if (checkStock(name, stock)) {
            updateStock(name, -stock);
            return;
        }
        System.out.println("Purchase failed.");
    }
    public void showStock() {
        for (Map.Entry<String, LocalCommodity> entry : map.entrySet()) {
            System.out.println("Commodity: " + entry.getKey() + ", Stock: " + entry.getValue().getStock());
        }
    }
    public static void main(String[] args) {
        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();
        inventoryManagementSystem.updateStock("apple", 10);
        inventoryManagementSystem.updateStock("banana", 20);
        inventoryManagementSystem.updateStock("apple", 5);
        inventoryManagementSystem.showStock();
        inventoryManagementSystem.purchase("apple", 8);
        inventoryManagementSystem.showStock();
        inventoryManagementSystem.purchase("banana", 30);
        inventoryManagementSystem.showStock();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class LocalCommodity {
    private String name;
    private int stock;
}