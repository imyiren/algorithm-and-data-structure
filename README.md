# data-structure
重学数据结构-java版

# 1. LinkedList 链表
> 代码路径：[io.ilss.datastructure.linkedlist (点击跳转)](https://github.com/ilssio/data-structure/tree/master/src/main/java/io/ilss/datastructure/linkedlist "linkedlist")

- 主要包含单向链表：io.ilss.datastructure.linkedlist.SingleLinkedList
    > 包括：单向链表的添加、遍历、修改、删除，常见面试题：单向链表有效个数、查找倒数第K个节点、单链表反转、反向遍历链表
- 主要包含双向链表：io.ilss.datastructure.linkedlist.DoubleLinkedList
    > 包括：双向链表的添加、遍历、修改、删除
- 延伸出单向环形链表 解决约瑟夫斯问题：io.ilss.datastructure.linkedlist.JosephuQuestion
    > 包括：环形链表的创建，节点删除等
# 2. SparseArray 稀疏数组
> 代码路径：[io.ilss.datastructure.sparsearray (点击跳转)](https://github.com/ilssio/data-structure/tree/master/src/main/java/io/ilss/datastructure/sparsearray "sparsearray")

- 主要写了一个稀疏矩阵与稀疏数组的转换：io.ilss.datastructure.sparsearray.SparseArray
    > 包括：环形链表的创建，节点删除等

# 3. Stack 栈
> 代码路径：[io.ilss.datastructure.stack (点击跳转)](https://github.com/ilssio/data-structure/tree/master/src/main/java/io/ilss/datastructure/stack "stack")

- 数组实现栈：io.ilss.datastructure.stack.ArrayStack
    > 包括：pop、push、peek等的实现
- 链表实现栈：io.ilss.datastructure.stack.LinkedStack
    > 包括: pop、push、peek等的实现
- 中缀表达式计算器问题：io.ilss.datastructure.stack.InfixCalculator
    > 包括: 利用栈解决中缀表达式计算。
- 中缀转后缀计算器问题：io.ilss.datastructure.stack.SuffixCalculator
    > 包括: 表达式转转中缀，中缀转后缀（逆波兰），后缀表达式计算问题。