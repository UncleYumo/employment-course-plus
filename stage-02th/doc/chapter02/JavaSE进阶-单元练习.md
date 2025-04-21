### 单元练习5

> 1. 抽象类是否可以实现（implements）接口？需要重写抽象方法吗？

- 抽象类可以实现接口，也可以实现接口中的抽象方法
- 如果抽象类实现了接口但未实现接口中的所有抽象方法，则这些未重写的方法会变成抽象类的抽象方法，需要由继承它的子类进行实现（且必须实现）

> 2. 接口和抽象类的联系和区别？
- 接口和抽象类都不能实例化，只能被继承，不能被实例化。 
- 都可以定义抽象方法
- 都支持多态

> 3. 接口的优点有哪些？
- 接口可以实现多个类型的方法，可以定义默认方法，可以定义私有方法，可以定义静态方法等，灵活性高。
- 接口可以解决Java中多继承的需要，同时避免了多继承的复杂性。
- 接口本质上可以帮助规范代码，提高代码的可维护性。
- 接口可以实现多态，即依赖倒置原则。

### 单元练习6

> 1. 请问有几种形式的内部类？
- 静态内部类：只能访问外部类的静态成员，不能访问外部类的非静态成员。
- 成员内部类：可以访问外部类的成员变量和方法，包括静态成员和非静态成员。
- 局部内部类：只能在当前方法或代码块中使用，不能定义为类的成员。
- 匿名内部类：没有名字的内部类，只能在当前方法或代码块中使用。

> 2. 请问内部类会被编译成class文件吗？
- 会被编译成class文件。

> 3. 枚举的优点有哪些？
- 增强代码的可读性和可维护性。
- 枚举可以实现常量，可以避免魔法值。
- 枚举可以防止多次实例化。
- 方便统一管理常量


### 单元练习7

> 1. 什么是Java泛型，它有什么作用？
- 泛型可以让程序在编译时就检查类型是否正确，并在运行时避免类型转换错误。
- 泛型可以让代码更加灵活，可以适应不同类型的数据。

> 2. 请简述Java中的泛型通配符及其作用。
- 泛型通配符`?`可以表示任何类型，可以作为方法参数、返回值、变量类型、类类型等。
- 上界通配符`? extends T`表示类型参数T及其子类。
- 下界通配符`? super T`表示类型参数T及其父类。

> 3. 使用泛型的注意事项都有哪些
- 泛型只能用于类、接口、方法、构造器的声明，不能用于局部变量、异常、注解等。
- 泛型只能使用引用类型，不能使用原始类型。
- 泛型擦除：编译器会擦除泛型信息，使得泛型代码在运行时看不到泛型的类型信息。

### 单元练习8

> 1. Object 类的作用是什么？它有哪些常用方法？
- 在Java中，Object类是所有类的超类（根类），所有类都直接或间接继承自Object类，核心作用是为所有Java对象提供通用方法
- 常用方法：equals()、hashCode()、toString()、clone()、getClass()

> 2. Objects 类是什么？它与 Object 类有什么区别？
- Objects类是Java 7引入的工具类，专为操作对象提供静态方法
- Objects类与Object类没有任何关系，两者是两个不同类
- Objects类中提供的静态方法，可以代替Object类中的一些方法，如equals()、hashCode()、toString()等

> 3. 基本类型包装类有哪些？它们有什么作用？
- 基本类型包装类：Byte、Short、Integer、Long、Float、Double、Character
- 作用：包装基本类型为对象，可以调用对象的方法，如toString()、compareTo()等
- 此外，List、Map、Set等集合类中的泛型参数也可以使用包装类

### 阶段二单元评测
> 1. 多态的前提条件是什么？
- 子类继承父类
- 构成方法重写
- 父类引用指向子类对象，即向上转型

> 2. 什么是方法重写?
- 子类继承父类的方法，可以对父类的方法进行重写，即子类可以实现父类的功能，并可以增加新的功能。

### 单元练习9
> 1. StringBuilder类和String类有什么区别？
- StringBuilder类是可变字符串，可以修改字符串内容，而String类是不可变的，不能修改字符串内容，在修改的时候实际是创建新的字符串
- StringBuilder类提供了一些方法，如append()、insert()、delete()等，可以动态地修改字符串内容。
- StringBuilder类在字符串拼接时效率更高，而String类在字符串拼接时效率较低。

> 2. StringJoiner类是用来做什么的？
- StringJoiner类是一个用于拼接字符串的类，它提供了一种简单的方式来将多个字符串连接起来，并添加分隔符，可以避免使用StringBuilder类手动拼接字符串，提高代码的可读性。

> 3. BigDecimal类和double类型有什么区别？
- BigDecimal类是一个用于表示精确小数的类，它提供了许多方法，如add()、subtract()、multiply()、divide()等，可以进行精确的运算，可以避免double类型精度丢失的问题。
- double类型是一个基本的数据类型，它表示一个64位双精度浮点数，它具有固定的精度和范围，不能表示精确的数值，可能会丢失精度。

### 单元练习10
> 1. Date类的作用是什么？它的构造函数和常用方法有哪些？
- Date类是一个表示日期和时间的类
- 构造函数：Date()、Date(long time)、Date(int year, int month, int date)等
- 常用方法：getTime()、setTime()、getYear()、getMonth()等

> 2. SimpleDateFormat类的作用是什么？它的构造函数和常用方法有哪些？常用格式有哪些？
- SimpleDateFormat类是一个用于格式化和解析日期的类、
- 构造函数：SimpleDateFormat(String pattern)、SimpleDateFormat(String pattern, Locale locale)等
- 常用方法，如format()、parse()等，可以格式化日期，也可以解析日期字符串

### 单元练习11
> 1. 请简要介绍一下Java 8中新增的日期时间API。
- Java 8中引入了java.time包，提供了许多新的类和接口,如：
    - LocalDate
    - LocalTime
    - LocalDateTime
    - ZonedDateTime
    - Duration
    - Period

> 2. 什么是ZoneId类和ZoneDateTime类？它的常用方法有哪些？
- ZoneId类是一个时区标识符类，提供获取时区标识符的方法，如getId()、of()
- ZoneDateTime类是一个时区aware的日期时间类，它提供了获取时区信息、获取日期和时间等方法，如getZone()、getYear()、getMonth()

> 3. DateTimeFormatter是什么？它提供了哪些常用的格式化/解析方法？
- DateTimeFormatter是一个用于格式化和解析日期和时间的类
- 提供了许多常用的格式化/解析方法，如ofPattern()、ofLocalizedDateTime()

### 单元练习12
> 1. Arrays类的作用是什么？
- Arrays类是一个用于操作数组的类，提供了许多静态方法
- 如sort()、binarySearch()、equals()等，可以方便地对数组进行操作，如排序、查找等

> 2. Arrays类的常用方法有哪些？
- Arrays类提供了许多静态方法
- 如sort()、binarySearch()、equals()

> 3. 使用Arrays.sort()方法进行排序时，自定义排序规则的写法有几种呢？
- 使用Comparator接口的实现类
- 实现compare()方法，自定义排序规则