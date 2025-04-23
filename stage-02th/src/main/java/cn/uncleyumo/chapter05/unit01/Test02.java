package cn.uncleyumo.chapter05.unit01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author dev.uncleyumo.cn
 * @fileName Test02
 * @createDate 4/23/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 开发一个简单的待办事项管理系统，要求实现以下功能，并创建测试类测试TodoItemList类所有方法
 *
 * ①创建待办事项TodoItem类包括事项名称、优先级（高、中、低）、截止日期，创建TodoItemList类，包含以下方法
 * ②添加待办事项；
 * ③根据优先级排序待办事项
 * ④根据截止日期排序待办事项
 * ⑤根据名称删除指定的待办事项
 * ⑥打印所有待办事项
 *
 * 提示：由于还没有学习List集合，需要使用Collection的toArray方法把ArrayList转化成数组，（        TodoItem[] todoItem = new TodoItem[items.size()];
 * TodoItem[] array = items.toArray(todoItem);）然后再使用Arrays进行排序
 */
public class Test02 {
    public static void main(String[] args) {
        TodoItemList todoItemList = new TodoItemList();
        todoItemList.addItem(new TodoItem("Task1", "高", LocalDate.now()));
        todoItemList.addItem(new TodoItem("Task2", "中", LocalDate.now().plusDays(4)));
        todoItemList.addItem(new TodoItem("Task3", "低", LocalDate.now().plusDays(2)));
        todoItemList.addItem(new TodoItem("Task4", "中", LocalDate.now().plusDays(1)));
        System.out.println("-------------------------------------");
        System.out.println("原始任务列表：");
        todoItemList.printAllItems();
        System.out.println("-------------------------------------");
        System.out.println("根据优先级排序：");
        todoItemList.sortByPriority();
        todoItemList.printAllItems();
        System.out.println("-------------------------------------");
        System.out.println("根据截止日期排序：");
        todoItemList.sortByDeadline();
        todoItemList.printAllItems();
        System.out.println("-------------------------------------");
        System.out.println("删除Task3:");
        todoItemList.deleteItem("Task3");
        todoItemList.printAllItems();
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class TodoItem {
    private String taskName;
    private String priority;
    private LocalDate deadline;
    public static int compareByPriority(TodoItem o1, TodoItem o2) {
        return getPriority(o2.getPriority()) - getPriority(o1.getPriority());
    }
    public static int getPriority(String priority) {
        return switch (priority) {
            case "高" -> 3;
            case "中" -> 2;
            case "低" -> 1;
            default -> 0;
        };
    }
    public static int compareByDeadline(TodoItem o1, TodoItem o2) {
        return o2.getDeadline().compareTo(o1.getDeadline());
    }
}

class TodoItemList {
    private List<TodoItem> itemList = new ArrayList<>();
    public void addItem(TodoItem item) {
        itemList.add(item);
    }
    public void sortByPriority() {
        TodoItem[] array = itemList.toArray(new TodoItem[itemList.size()]);
        Arrays.sort(array, TodoItem::compareByPriority);
        itemList = Arrays.asList(array);
    }
    public void sortByDeadline() {
        TodoItem[] array = itemList.toArray(new TodoItem[itemList.size()]);
        Arrays.sort(array, TodoItem::compareByDeadline);
        itemList = Arrays.asList(array);
    }
    public void deleteItem(String taskName) {
        itemList = itemList.stream().filter(item -> !item.getTaskName().equals(taskName)).toList();
    }
    public void printAllItems() {
        itemList.forEach(System.out::println);
    }
}
