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