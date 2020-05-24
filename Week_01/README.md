学习笔记

（解题思路，含Queue 和Priority Queue 源码分析）

---
### 两个数相加：<br/>
暴力解法，双重for循环（原题默认数组中数字不重复）<br/>

或者用HashMap

---
### 三个数相加：<br/>

>中间结果要去重，一开始我没有处理好重复问题<br/>
>思路：先排序，左指针(枚举)先固定，中指针和右指针分别从左右两端往中间移动，相遇后移动左指针重来<br/>
>
>#### 指针移动时：
+ 三数相加 = 0 --->中右指针往中间移动<br/>
    + 再加while循环判断指针所在数若与指针移动前的数相同，继续移动（**去重**）
* 三数相加 > 0 --->右指针左移<br/>
+ 三数相加 < 0 --->中指针右移<br/>
---
### 反转链表：

1-->2-->3-->null<br/>
pre:null<br/>
进入循环(curr!=null)：<br/>
。。。。。curr:1 -->  tmp:2-->  3  -->  null<br/>
pre:null <-- curr:1 ||  tmp:2-->  3  -->  null<br/>。。null <-- pre:1 ||  tmp:2-->  3  -->  null<br/>。。null <-- pre:1 ||  curr:2-->  3  -->  null<br/>

---

### 交换节点对：
使用递归：交换前两个，指向后面调用自身函数返回的（递归交换完）结果<br/>

---
### 合并两个链表，合并两个数组：

合并数组时,双指针从右到左遍历完数组一或数组二后停止循环，把数组二剩余的元素复制到数组一开头。

---



### Queue 和Priority Queue 源码分析：

Queue(sun.misc)的源码在尾部添加新项，删除元素从头部删除。时间复杂度为o(1)<br/>

优先队列中的元素不允许为空，且必须实现比较器(实现comparator，或类实现了comparable)。

| PriorityQueue(represented as a balanced binary heap)         |                                                              |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Implementation note: <br/>this implementation provides O(log(n)) time for the enqueuing and dequeuing methods<br/>({@code offer}, {@code poll}, {@code remove()} and {@code add});<br/> linear time for the {@code remove(Object)} and {@code contains(Object)} methods; <br/>and constant time for the retrieval methods ({@code peek}, {@code element}, and {@code size}). | 源码中介绍：<br/>入队和出队方法时为o(logn)的时间复杂度，<br/>删除和查找指定元素为o(n)的时间复杂度(需要遍历)，<br/>获取第一个元素为o(1)的时间复杂度。 |

为什么contains方法不用比较器，而是直接遍历找索引所在位置emmm。

```java
private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(queue[i]))
                    return i;
        }
        return -1;
    }
```



---



