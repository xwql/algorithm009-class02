#### 学习笔记

| 分治 |
| ---- |
|      |

```python
def divide_conquer(problem, param1, param2, ...):
# recursion terminator
	if problem is None:
		print_result
		return
# prepare data
	data = prepare_data(problem)
	subproblems = split_problem(problem, data)
# conquer subproblems
	subresult1 = self.divide_conquer(subproblems[0], p1, ...)
	subresult2 = self.divide_conquer(subproblems[1], p1, ...)
	subresult3 = self.divide_conquer(subproblems[2], p1, ...)
...
# process and generate the final result
	result = process_result(subresult1, subresult2, subresult3, …)
```




| 回溯算法                                                     |
| ------------------------------------------------------------ |
| “回溯”算法也叫“回溯搜索”算法，主要用于在一个庞大的空间里搜索我们所需要的问题的解。<br/>状态指求解问题的不同阶段。<br/>“回溯”指的是“状态重置”，可以理解为“回到过去”、“恢复现场”，是在编码的过程中，是为了节约空间而使用的一种技巧。而回溯其实是“深度优先遍历”特有的一种现象。<br/>“全排列”就是一个非常经典的“回溯”算法的应用。<br/>状态变量: 深度（depth），已经选的数（path），布尔数组（used） |

####  回溯代码

``` 
main:
//判断 返回
//调用方法
  backtrack(xxx,xxx,xx,,x)
  return xxx;
  
backtrack(...){
  if() ...;//判断,终止条件，达到所需深度
  //处理...
  backtrack(...);  //递归
//回溯，删除刚刚添加的元素
  remove...
}
```

