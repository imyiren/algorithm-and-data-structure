# data-structure
重学数据结构-java版

# 0. 目录
...待添加

# 1. LinkedList 链表
> 代码路径：[io.ilss.datastructure.linkedlist (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/linkedlist "linkedlist")

- 主要包含单向链表：io.ilss.datastructure.linkedlist.SingleLinkedList
    > 包括：单向链表的添加、遍历、修改、删除，常见面试题：单向链表有效个数、查找倒数第K个节点、单链表反转、反向遍历链表
- 主要包含双向链表：io.ilss.datastructure.linkedlist.DoubleLinkedList
    > 包括：双向链表的添加、遍历、修改、删除
- 延伸出单向环形链表 解决约瑟夫斯问题：io.ilss.datastructure.linkedlist.JosephuQuestion
    > 包括：环形链表的创建，节点删除等
# 2. SparseArray 稀疏数组
> 代码路径：[io.ilss.datastructure.sparsearray (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/sparsearray "sparsearray")

- 主要写了一个稀疏矩阵与稀疏数组的转换：io.ilss.datastructure.sparsearray.SparseArray
    > 包括：环形链表的创建，节点删除等

# 3. Stack 栈
> 代码路径：[io.ilss.datastructure.stack (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/stack "stack")

- 数组实现栈：io.ilss.datastructure.stack.ArrayStack
    > 包括：pop、push、peek等的实现
- 链表实现栈：io.ilss.datastructure.stack.LinkedStack
    > 包括: pop、push、peek等的实现
- 中缀表达式计算器问题：io.ilss.datastructure.stack.InfixCalculator
    > 包括: 利用栈解决中缀表达式计算。
- 中缀转后缀计算器问题：io.ilss.datastructure.stack.SuffixCalculator
    > 包括: 表达式转转中缀，中缀转后缀（逆波兰），后缀表达式计算问题。

# 4. Queue 队列
> 代码路径：[io.ilss.datastructure.queue (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/queue "queue")

- 数组简单队列：io.ilss.datastructure.queue.ArrayQueue
    > 包括: 出队、入队等操作
- 循环队列：io.ilss.datastructure.queue.CircleArrayQueue
    > 包括: 出队、入队等操作
- leetcode循环队列实现题：io.ilss.datastructure.queue.MyCircularDeque


# 5. Tree 树
> 代码路径：[io.ilss.datastructure.tree (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/tree "tree")

- 二叉树链式实现：io.ilss.datastructure.tree.BinaryTree
    > 包括: 各种遍历和查找实现
- 二叉树数组实现：io.ilss.datastructure.tree.ArrayBinaryTree
    > 包括: 各种遍历和查找实现
- 二叉线索树实现：io.ilss.datastructure.tree.ThreadedBinaryTree
    > 包括: 构建二叉线索树、二叉线索树的遍历等
- 哈夫曼树实现：io.ilss.datastructure.tree.HuffmanTree
    > 包括: 构建huffman树
- 哈夫曼编码实现：io.ilss.datastructure.tree.HuffmanCode
    > 包括: 构建huffman编码
- 二叉搜索树实现：io.ilss.datastructure.tree.BinarySortTree
    > 包括: 添加元素，删除元素等

# 6. Sort 排序
> 代码路径：[io.ilss.datastructure.sort (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/sort "sort")

- 冒泡排序：io.ilss.datastructure.sort.BubbleSort
- 插入排序：io.ilss.datastructure.sort.InsertSort
- 选择排序：io.ilss.datastructure.sort.SelectSort
- 归并排序：io.ilss.datastructure.sort.MergeSort
- 希尔排序：io.ilss.datastructure.sort.ShellSort
- 桶排序：io.ilss.datastructure.sort.RadixSort
- 快速排序：io.ilss.datastructure.sort.QuickSort
- 堆排序：io.ilss.datastructure.sort.HeapSort

# 7. Graph 图
> 代码路径：[io.ilss.datastructure.graph (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/graph "graph")

- AAA：io.ilss.datastructure.graph.Graph
    > 包括: 图的定义、DFS、BFS算法


# 8. Algorithm 算法
> 代码路径：[io.ilss.datastructure.algorithm (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/agorithm "agorithm")

- 汉诺塔问题：com.imyiren.algorithm.divideandconquer.HanoiTower
- 动态规划-01背包：com.imyiren.algorithm.dynamic.Package
- kmp算法-字符串匹配：com.imyiren.algorithm.kmp.MatchString
    > 包括: 暴力法解决、KMP算法解决


# 9. leetcode 刷题
> 代码路径：[io.ilss.datastructure.leetcode (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/leetcode "leetcode")

- 数组类：io.ilss.datastructure.leetcode.array.*
    > 包括: Q16、Q18、Q26、Q27、Q33
- 链表类：io.ilss.datastructure.leetcode.linked.*
    > 包括: 
- 树类：io.ilss.datastructure.leetcode.tree.*
    > 包括: 
- 图类：io.ilss.datastructure.leetcode.graph.*
    > 包括:
- 动态规划：io.ilss.datastructure.leetcode.dynamic.*
    > 包括: 

# 10. 剑指offer
> 代码路径：[io.ilss.datastructure.swordoffer (点击跳转)](https://github.com/imyiren/data-structure/tree/master/src/main/java/io/ilss/datastructure/swordoffer "swordoffer")

- 待添加：io.ilss.datastructure.swordoffer.XXX
    > 包括: 
