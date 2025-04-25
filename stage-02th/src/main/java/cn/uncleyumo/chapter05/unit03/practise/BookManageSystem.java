package cn.uncleyumo.chapter05.unit03.practise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dev.uncleyumo.cn
 * @fileName BookManageSystem
 * @createDate 4/25/25 April
 * @school Wuxi University
 * @studentID 22344131
 * @description
 * 在线图书商店编写一段代码来管理用户的书单。需要实现以下功能：
 *  ①每个用户可以将一本或多本图书添加到书单中，并将图书信息存储在集合中。
 *  ②实现添加图书到书单的功能，确保同一本图书不会重复添加。
 *  ③实现从书单中移除图书的功能，用户可以选择移除已添加的图书。
 *  ④实现展示书单中的图书和统计书单中图书的数量的功能，以便用户可以查看书单内容和数量统计。
 */
public class BookManageSystem {
    private final Set<Book> bookSet;

    public BookManageSystem() {
        this.bookSet = new HashSet<>();
    }

    public void addBook(Book book) {
        this.bookSet.add(book);
        System.out.println(book.printBookInfo() + " has been added to book list.");
    }
    public void removeBook(Book book) {
        this.bookSet.remove(book);
        System.out.println(book.printBookInfo() + " has been removed from book list.");
    }
    public void showBookList() {
        System.out.println("---------------------------");
        bookSet.forEach(System.out::println);
        System.out.println("Total book count: " + bookSet.size());
        System.out.println("---------------------------");
    }
    public static void main(String[] args) {
        BookManageSystem bookManageSystem = new BookManageSystem();
        bookManageSystem.addBook(new Book("Java从入门到放弃", "黑马程序员"));
        bookManageSystem.addBook(new Book("Golang从入门到放弃", "黑马程序员"));
        bookManageSystem.addBook(new Book("古典之殇", "王国维"));
        bookManageSystem.showBookList();
        System.out.println(">>>>>> Delete 《古典之殇》");
        bookManageSystem.removeBook(new Book("古典之殇", "王国维"));
        bookManageSystem.showBookList();
        System.out.println(">>>>>> Add 《Java从入门到放弃》");
        bookManageSystem.addBook(new Book("Java从入门到放弃", "黑马程序员"));
        bookManageSystem.showBookList();
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Book {
    private String bookName;
    private String bookAuthor;
    public String printBookInfo() {
        return "Book Name: " + bookName + "(" + bookAuthor + ")";
    }
}
