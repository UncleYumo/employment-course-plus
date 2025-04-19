package cn.uncleyumo.chapter02.unit02;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 完整图书管理系统实现（Lombok版本）
 */
public class Test05 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Library library = new Library();

        Book book1 = new Book("三国演义", "罗贯中", "人民文学出版社", 59.0);
        Book book2 = new Book("Java从入门到放弃", "吴彦祖", "机械工业出版社", 149.0);
        Book book3 = new Book("西游记", "吴承恩", "商务印书馆", 69.0);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // 测试查找
        System.out.println("=== 搜索测试 ===");
        List<Book> results = library.searchBook("罗贯中");
        results.forEach(System.out::println);

        // 测试删除
        System.out.println("\n=== 删除测试 ===");
        library.removeBook(book2);
        System.out.println("剩余书籍数量：" + library.getBooks().size());

        // 测试克隆
        System.out.println("\n=== 克隆测试 ===");
        Book clonedBook = book1.clone();
        System.out.println("克隆结果：" + clonedBook);
        System.out.println("是否同一对象：" + (book1 == clonedBook));
        System.out.println("是否相等：" + book1.equals(clonedBook));
    }
}

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
class Book implements Cloneable {
    // ① 书名和作者作为相等性判断依据
    @EqualsAndHashCode.Include
    private String title;
    @EqualsAndHashCode.Include
    private String author;
    private String publisher;
    private double price;

    // ③ 实现克隆方法
    @Override
    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    // ④ 添加书籍
    public void addBook(Book book) {
        books.add(book);
    }

    // ④ 移除书籍（基于equals实现）
    public void removeBook(Book book) {
        books.remove(book);
    }

    // ④ 关键词搜索（模糊匹配书名或作者）
    public List<Book> searchBook(String keyword) {
        return books.stream()
                .filter(b -> b.getTitle().contains(keyword) || b.getAuthor().contains(keyword))
                .collect(Collectors.toList());
    }

    // 获取当前所有书籍（用于测试）
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
