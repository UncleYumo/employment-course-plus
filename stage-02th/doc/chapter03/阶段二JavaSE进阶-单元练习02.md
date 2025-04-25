### 单元练习16

> 1. 请简述HashSet去除重元素复的原理
- 在HashSet底层中，每次添加元素的时候，都会先调用hashCode()方法，得到元素的hash值
- 再根据hash值，调用equals()方法，判断在哈希表中是否重复，如果重复，则不添加

2. List集合中有哪些特有方法（What methods are unique to List Collections?）
- add(Object e)
- get(int index)
- forEach(xxx)
- addAll()
- add(int index, Object e)
- stream()  // OG
- toArray()
- size()

3. ArrayList集合的底层原理是什么？（What is the underlying principle of ArrayList?）
- ArrayList底层原理是动态数组，扩容因子为1.5，初始容量为10
- ArrayList的查询速度快，增删慢，因为查询直接根据地址＋索引进行查询

4. LinkedList集合的底层原理是什么？（What is the underlying principle of LinkedList?）
- LinkedList底层原理是双向链表，增删快，查询慢，因为增删直接操作头结点，查询需要遍历整个链表
- LinkedList的增删快，查询慢，因为增删直接操作头结点，查询需要遍历整个链表

### 单元练习17

> 1. HashSet和TreeSet有什么区别？（What's the contrast between HashSet and TreeSet）
- HashSet是无序的，TreeSet是有序的
- TreeSet底层使用红黑树，HashSet底层使用哈表希
- Hash在处理数据的查询效率上比Tree高，但是TreeSet在处理数据的插入和删除效率上比HashSet高

> 2. HashSet和LinkedHashSet有什么区别？（What's the contrast between HashSet and LinkedHashSet）
- HashSet是无序的，LinkedHashSet是有序的
- HashSet底层使用哈希表，LinkedHashSet底层使用哈希表和链表
- HashSet的查询效率比LinkedHashSet高，但是LinkedHashSet的插入和删除效率比HashSet高

> 3. LinkedHashSet和TreeSet的区别是什么？（What's the contrast between LinkedHashSet and TreeSet） 
- 两个都是有序的，但是LinkedHashSet的插入和删除效率比TreeSet高
- TreeSet由于使用红黑树，所以查询效率比LinkedHashSet高

### 单元练习18

> 1. 什么是可变参数？在Java中如何声明和使用可变参数？
- 可变参数是Java语言中一种特殊的参数类型，它可以接受一个或多个参数，并且这些参数可是以对象
- 声明方式：`addAll(int...intArray)，其中，可变参数会自动转换成对应的int[]

> 2. Collections工具类是什么？有哪些常用方法？
- Collections是个好东西，它提供了一些常用的集合操作方法，比如排序、查找、替换、遍历等
- 常用方法：
- Collections.sort(List<T> list)：对List集合进行排序
- Collections.reverse(List<T> list)：对List集合进行反转
- Collections.shuffle(List<T> list)：对List集合进行随机排序
- Collections.binarySearch(List<T> list, T key)：对List集合进行二分查找，返回索引

> 3. 简要解释集合的并发修改异常问题
- 在进行对集合的普通遍历时，如果同时对当前被遍历的集合进行操作，会导致当前集合的索引指针出现异常，如在index为3时，删除了索引为3的元素
  那么下一次的索引应该进行减一，否则由于集合元素的前移，使得索引出现问题
- 解决办法是使用迭代器的api或者在fori遍历时直接--i

### 单元练习19

> 1. Map集合是什么？它的特点是什么？
- Map集合本质是一种以键值对（Key:Value）为形式的数据结构
- 它存储的元素是唯一的，即Key是唯一的，Value可以重复

> 2. HashMap和TreeMap的区别是什么？
- HashMap是无序的，TreeMap是有序的
- HashMap底层使用哈希表，TreeMap底层使用红黑树
- HashMap的查询效率比TreeMap高，但是TreeMap的插入和删除效率比HashMap高

> 3. 如何遍历Map集合中的键值对？
- 使用foreach: for(Map.Entry<K,V> entry: map.entrySet()){}
- 使用迭代器: Iterator<Map.Entry<K,V>> iterator = map.entrySet().iterator();
- 使用lambda: map.forEach((k,v)->{});  // 这个最推荐