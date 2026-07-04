# 两个月力扣算法模板训练计划：按题型串联 HOT100 + 灵神精选

目标不是机械刷完题单，而是在两个月内训练四类能力：

1. 题型识别能力：看到题目后，能判断它属于什么算法类型，并说出判断依据。
2. 解题模板能力：掌握每类题的通用思路、代码骨架、变量含义和常见变形。
3. 边界控制能力：能主动检查空输入、单元素、重复元素、左右边界、递归终止、整数溢出等细节。
4. 复杂度分析能力：能根据数据范围判断可行复杂度，并讲清楚时间复杂度、空间复杂度和方案取舍。

这份计划不再按 A/B/C 三档推进，而是按题型学习。HOT100 负责面试基本盘，灵神精选负责补齐 HOT100 覆盖不足的模板，进阶题用于检验变形能力。

## 执行原则

- 周期：建议 6-8 周完成第一轮，不要求一个月刷完。
- 每天节奏：2-3 道新题 + 1-2 道错题或同类题复刷。
- 每个题型先做入门模板题，再做 HOT100 核心题，最后做灵神补强或进阶变形。
- 每题先独立思考题型和复杂度，再写代码；做完必须复盘，不只看是否 AC。
- 每周至少安排 1 天只做错题复盘和同类题对比。
- 面试训练时可以遮住题目标签，先自己判断题型，再对照本计划复盘。

## 总体路线

1. 第 1-2 周：数组、哈希、双指针、滑动窗口、前缀和、差分。
2. 第 3 周：二分、矩阵、栈、单调栈、单调队列、堆。
3. 第 4 周：链表、设计类数据结构。
4. 第 5 周：二叉树、BST、树形递归、树上前缀和。
5. 第 6 周：图、网格 BFS/DFS、拓扑排序、并查集、最短路。
6. 第 7 周：回溯、贪心、位运算、字符串与 Trie/KMP。
7. 第 8 周：动态规划专题和错题二刷。

## 题型学习单元

### 1. 哈希表与集合

识别信号：

- 要快速判断某个值是否出现过、出现次数、分组归类。
- 题目要求从 O(n^2) 优化到 O(n)。
- 需要维护“值 -> 下标 / 次数 / 分组 key”的映射。

相似题型区别：

- 哈希查找：关心某个补数、某个 key 是否存在。
- 哈希计数：关心频率、异位词、窗口字符数量。
- 哈希集合：关心去重、连续段起点、是否访问过。

推荐题目：

1. [1. 两数之和](https://leetcode.cn/problems/two-sum/) - 哈希查找
2. [49. 字母异位词分组](https://leetcode.cn/problems/group-anagrams/) - 哈希分组
3. [128. 最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/) - 哈希集合，连续段起点
4. [169. 多数元素](https://leetcode.cn/problems/majority-element/) - Boyer-Moore 投票，也可哈希计数对照
5. [380. O(1) 时间插入、删除和获取随机元素](https://leetcode.cn/problems/insert-delete-getrandom-o1/) - 数组 + 哈希表设计

边界重点：

- 重复元素是否允许使用同一个下标。
- key 的设计是否唯一，例如异位词排序 key 或 26 位计数 key。
- HashMap 默认值、put 时机、是否先查后放。

### 2. 双指针与数组原地处理

识别信号：

- 数组有序，要求找两个数、三元组、最大面积。
- 需要原地移动、删除、分区、去重。
- 两端向中间收缩，或者快慢指针同向扫描。

相似题型区别：

- 双指针：通常利用有序性、左右边界或原地覆盖。
- 滑动窗口：维护一个连续区间，并根据合法性移动左右边界。
- 哈希：不依赖顺序，靠额外空间换时间。

推荐题目：

1. [283. 移动零](https://leetcode.cn/problems/move-zeroes/) - 快慢指针，稳定移动
2. [167. 两数之和 II - 输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/) - 有序数组左右指针
3. [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/) - 左右指针，移动短板
4. [15. 三数之和](https://leetcode.cn/problems/3sum/) - 排序 + 固定一位 + 双指针 + 去重
5. [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/) - 双指针 / 前后缀最大值 / 单调栈对照
6. [75. 颜色分类](https://leetcode.cn/problems/sort-colors/) - 三指针，荷兰国旗
7. [31. 下一个排列](https://leetcode.cn/problems/next-permutation/) - 从右向左找下降点 + 后缀反转
8. [287. 寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/) - 快慢指针找环，也可二分答案对照

边界重点：

- left、right 移动条件是否会漏解或死循环。
- 三数之和的去重位置：固定元素去重，左右指针命中后继续去重。
- 原地修改时读写指针是否覆盖了还没处理的数据。

### 3. 数组、区间与前后缀技巧

识别信号：

- 题目围绕一维数组整体变换、区间合并、前后缀信息或原地放置。
- 要求 O(1) 额外空间，或者要求不能使用除法。
- 数值范围和下标范围有对应关系，可以考虑原地哈希。

相似题型区别：

- 前后缀技巧：关心当前位置左边和右边的信息。
- 前缀和：关心任意连续区间的和。
- 区间排序：先按端点排序，再扫描合并或选择。
- 原地哈希：把值放到它应该出现的下标位置。

推荐题目：

1. [56. 合并区间](https://leetcode.cn/problems/merge-intervals/) - 排序 + 区间扫描
2. [189. 轮转数组](https://leetcode.cn/problems/rotate-array/) - 三次反转 / 环状替换
3. [238. 除了自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/) - 前缀积 + 后缀积
4. [41. 缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/) - 原地哈希，困难题后置

边界重点：

- 区间合并要先按左端点排序，遇到重叠时更新右端点。
- 轮转数组中 k 可能大于 n，要先 `k %= n`。
- 乘积题要考虑 0 的存在，前后缀写法天然处理 0。
- 原地哈希只处理 `[1, n]` 范围内的数，交换时要防止重复值死循环。

### 4. 滑动窗口

识别信号：

- 题目要求连续子数组、连续子串。
- 问最长、最短、个数，并且窗口合法性可以随着右边界扩张、左边界收缩维护。
- 出现“至多 K 个”“恰好 K 个”“不重复”“覆盖”“固定长度”。

相似题型区别：

- 滑动窗口适合连续区间，并且窗口状态可以增删维护。
- 前缀和适合求任意子数组和，尤其有负数或需要计数。
- 单调队列适合窗口最值，不是普通窗口计数。

推荐题目：

1. [1456. 定长子串中元音的最大数目](https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) - 固定长度窗口
2. [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) - 不定长最长窗口
3. [209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/) - 不定长最短窗口，正数数组
4. [713. 乘积小于 K 的子数组](https://leetcode.cn/problems/subarray-product-less-than-k/) - 乘积约束窗口
5. [904. 水果成篮](https://leetcode.cn/problems/fruit-into-baskets/) - 至多两类元素
6. [1004. 最大连续 1 的个数 III](https://leetcode.cn/problems/max-consecutive-ones-iii/) - 至多 K 次转换
7. [1493. 删掉一个元素以后全为 1 的最长子数组](https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/) - 至多一个 0，答案要扣掉删除位
8. [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/) - 固定长度 + 频率匹配
9. [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/) - 覆盖型最短窗口
10. [930. 和相同的二元子数组](https://leetcode.cn/problems/binary-subarrays-with-sum/) - 二元数组，恰好型可转至多型
11. [1248. 统计「优美子数组」](https://leetcode.cn/problems/count-number-of-nice-subarrays/) - 恰好 K 个奇数，转化为至多 K
12. [992. K 个不同整数的子数组](https://leetcode.cn/problems/subarrays-with-k-different-integers/) - 恰好 K 类，转化为 atMost(K) - atMost(K - 1)

边界重点：

- 固定窗口先入后出还是先出后入，要保证窗口长度正确。
- 不定长窗口中 while 收缩条件是“非法时收缩”还是“合法时尝试优化答案”。
- 恰好 K 通常不要硬写，优先考虑 atMost(K) - atMost(K - 1)。
- 当 k <= 0、字符串长度小于窗口长度、目标字符不存在时要单独处理。

### 5. 前缀和、差分与扫描线

识别信号：

- 频繁查询区间和。
- 问子数组和等于 K、可被 K 整除、同余关系。
- 多次对区间加减，最后求每个点的值。

相似题型区别：

- 前缀和：把区间和转为 prefix[r] - prefix[l]。
- 前缀和 + 哈希：统计历史前缀和出现次数。
- 差分：适合多次区间更新，最后统一还原。
- 滑动窗口：通常要求数组元素非负，窗口和才有单调性。

推荐题目：

1. [303. 区域和检索 - 数组不可变](https://leetcode.cn/problems/range-sum-query-immutable/) - 一维前缀和
2. [304. 二维区域和检索 - 矩阵不可变](https://leetcode.cn/problems/range-sum-query-2d-immutable/) - 二维前缀和
3. [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/) - 前缀和 + 哈希计数
4. [523. 连续的子数组和](https://leetcode.cn/problems/continuous-subarray-sum/) - 同余前缀和，长度至少 2
5. [974. 和可被 K 整除的子数组](https://leetcode.cn/problems/subarray-sums-divisible-by-k/) - 同余计数，注意负数取模
6. [1109. 航班预订统计](https://leetcode.cn/problems/corporate-flight-bookings/) - 差分数组
7. [1094. 拼车](https://leetcode.cn/problems/car-pooling/) - 差分 / 扫描线

边界重点：

- prefix[0] = 0 是否初始化。
- 哈希表里是否先放入 0 -> 1。
- Java 负数取模需要修正为 `(mod + k) % k`。
- 差分右边界是 r + 1，必须判断是否越界。

### 6. 矩阵与二维数组

识别信号：

- 要在二维数组中原地标记、旋转、按层遍历、从角落搜索。
- 行列有序，或者需要利用边界一圈一圈推进。

相似题型区别：

- 矩阵模拟：核心是边界收缩。
- 二维前缀和：核心是区域和公式。
- 网格图 DFS/BFS：核心是连通性和访问标记。

推荐题目：

1. [73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/) - 原地标记首行首列
2. [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/) - 四边界模拟
3. [48. 旋转图像](https://leetcode.cn/problems/rotate-image/) - 转置 + 翻转，或四点轮换
4. [240. 搜索二维矩阵 II](https://leetcode.cn/problems/search-a-2d-matrix-ii/) - 从右上角或左下角走楼梯
5. [74. 搜索二维矩阵](https://leetcode.cn/problems/search-a-2d-matrix/) - 二维映射成一维二分
6. [378. 有序矩阵中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/) - 值域二分 + 计数

边界重点：

- 空矩阵、单行、单列。
- 螺旋遍历时每走完一条边都要重新判断上下左右是否越界。
- 二维坐标映射：row = mid / n，col = mid % n。

### 7. 二分查找与二分答案

识别信号：

- 有序数组中查找位置、边界、插入点。
- 答案不是数组下标，但答案范围有单调性。
- 出现“最小化最大值”“最大化最小值”“至少/至多满足某条件”。

相似题型区别：

- 普通二分：在有序数据中找目标或边界。
- 二分答案：在答案范围上二分，每次用 check 判断是否可行。
- 双指针：通常利用局部移动规则，不需要 check 函数。

推荐题目：

1. [704. 二分查找](https://leetcode.cn/problems/binary-search/) - 闭区间二分基础
2. [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/) - lower_bound
3. [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/) - 左右边界
4. [33. 搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/) - 旋转数组判断有序半边
5. [153. 寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/) - 旋转数组最小值
6. [162. 寻找峰值](https://leetcode.cn/problems/find-peak-element/) - 比较相邻元素的趋势二分
7. [1539. 第 k 个缺失的正整数](https://leetcode.cn/problems/kth-missing-positive-number/) - 缺失数量单调
8. [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/) - 二分分割，困难题后置
9. [875. 爱吃香蕉的珂珂](https://leetcode.cn/problems/koko-eating-bananas/) - 最小可行速度
10. [1011. 在 D 天内送达包裹的能力](https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/) - 最小可行运力
11. [410. 分割数组的最大值](https://leetcode.cn/problems/split-array-largest-sum/) - 最小化最大段和
12. [1482. 制作 m 束花所需的最少天数](https://leetcode.cn/problems/minimum-number-of-days-to-make-m-bouquets/) - 最小可行天数
13. [1552. 两球之间的磁力](https://leetcode.cn/problems/magnetic-force-between-two-balls/) - 最大化最小距离

边界重点：

- 推荐固定使用闭区间模板：`while (left <= right)`，最后返回 `left` 作为第一个满足条件的位置。
- `mid = left + (right - left) / 2` 防止溢出。
- 二分答案必须先明确：check(mid) 为 true 时，答案往左还是往右。
- 上下界要有含义：最小可行值、最大可能值。

### 8. 栈、单调栈与单调队列

识别信号：

- 括号匹配、嵌套结构、最近未匹配元素。
- 对每个位置找左/右第一个更大或更小元素。
- 滑动窗口最大值、区间内最值。

相似题型区别：

- 普通栈：处理匹配、嵌套、表达式解析。
- 单调栈：处理“下一个更大/更小”“矩形面积”。
- 单调队列：处理固定窗口最值，队头可能过期。

推荐题目：

1. [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/) - 括号匹配
2. [155. 最小栈](https://leetcode.cn/problems/min-stack/) - 辅助栈维护最小值
3. [394. 字符串解码](https://leetcode.cn/problems/decode-string/) - 栈处理嵌套结构
4. [496. 下一个更大元素 I](https://leetcode.cn/problems/next-greater-element-i/) - 单调栈 + 映射
5. [503. 下一个更大元素 II](https://leetcode.cn/problems/next-greater-element-ii/) - 循环数组单调栈
6. [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/) - 单调栈求下一个更高温
7. [901. 股票价格跨度](https://leetcode.cn/problems/online-stock-span/) - 在线单调栈
8. [1019. 链表中的下一个更大节点](https://leetcode.cn/problems/next-greater-node-in-linked-list/) - 链表转数组 + 单调栈
9. [402. 移掉 K 位数字](https://leetcode.cn/problems/remove-k-digits/) - 贪心 + 单调栈
10. [84. 柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/) - 单调栈找左右边界
11. [85. 最大矩形](https://leetcode.cn/problems/maximal-rectangle/) - 每行转柱状图
12. [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/) - 单调队列
13. [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/) - 栈 / DP 双解

边界重点：

- 栈里存值还是存下标，要先想清楚。
- 单调栈弹出时，当前元素通常就是右边界，弹出后栈顶是左边界。
- 单调队列队头过期条件通常是 `index <= i - k`。
- 处理结果为空、前导零、哨兵元素。

### 9. 堆、TopK 与数据流

识别信号：

- 求第 K 大、第 K 小、前 K 高频。
- 数据流动态加入，需要实时查询。
- 多路有序结构合并。

相似题型区别：

- 堆：适合动态维护 TopK。
- 排序：适合一次性离线处理，复杂度 O(n log n)。
- 快速选择：适合数组第 K 大，平均 O(n)，但实现边界更容易错。

推荐题目：

1. [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/) - 小根堆 / 快速选择
2. [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/) - 频率哈希 + 堆
3. [703. 数据流中的第 K 大元素](https://leetcode.cn/problems/kth-largest-element-in-a-stream/) - 固定大小小根堆
4. [295. 数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream/) - 双堆
5. [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/) - 小根堆多路合并

边界重点：

- Java PriorityQueue 默认小根堆。
- 比较器不要写 `b - a`，可能溢出，使用 `Integer.compare(b, a)`。
- 堆大小超过 K 时弹出，还是先判断后加入，要保持不变量一致。

### 10. 链表

识别信号：

- 只能顺序访问，不能随机下标。
- 要删除、反转、合并、找中点、找环、找倒数第 N 个。
- 需要处理头节点变化。

相似题型区别：

- 快慢指针：找中点、找环、找倒数位置。
- 虚拟头节点：处理删除、合并、局部反转时的头节点变化。
- 递归/迭代反转：注意断链和重新连接。

推荐题目：

1. [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) - 基础反转
2. [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/) - 虚拟头节点
3. [160. 相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/) - 双指针换头
4. [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/) - 快慢指针判环
5. [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) - 快慢指针找入口
6. [234. 回文链表](https://leetcode.cn/problems/palindrome-linked-list/) - 找中点 + 反转后半段
7. [2. 两数相加](https://leetcode.cn/problems/add-two-numbers/) - 模拟进位
8. [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) - 快慢指针 + 虚拟头
9. [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/) - 局部重连
10. [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/) - 分组反转，困难题后置
11. [138. 随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/) - 哈希映射 / 原地拆链
12. [148. 排序链表](https://leetcode.cn/problems/sort-list/) - 归并排序
13. [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/) - 堆 / 分治合并
14. [146. LRU 缓存](https://leetcode.cn/problems/lru-cache/) - 双向链表 + 哈希表

边界重点：

- 空链表、单节点、两个节点。
- 删除头节点时必须考虑虚拟头。
- 反转前保存 `next`，避免断链后丢失后续节点。
- K 个一组反转时，剩余不足 K 个不能反转。

### 11. 二叉树、BST 与树形递归

识别信号：

- 题目天然是树结构，要求遍历、深度、路径、祖先、构造。
- 需要从左右子树拿信息合并到当前节点。
- BST 题目利用中序有序或上下界约束。

相似题型区别：

- DFS 递归：适合路径、深度、子树信息。
- BFS 层序：适合层数、最短层数、右视图。
- BST：先想中序遍历或上下界。
- 树形 DP：当前节点状态依赖左右子树多个状态。

推荐题目：

1. [94. 二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/) - DFS 遍历基础
2. [104. 二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/) - 递归高度
3. [226. 翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/) - 前序/后序递归
4. [101. 对称二叉树](https://leetcode.cn/problems/symmetric-tree/) - 双树递归
5. [543. 二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/) - 后序返回高度，外部维护答案
6. [102. 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/) - BFS 队列
7. [199. 二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/) - 层序最后一个
8. [108. 将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/) - 分治构造平衡 BST
9. [98. 验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/) - 上下界 / 中序有序
10. [230. 二叉搜索树中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/) - BST 中序
11. [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) - 递归分治 + 哈希定位
12. [114. 二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) - 后序重连 / 前序展开
13. [437. 路径总和 III](https://leetcode.cn/problems/path-sum-iii/) - 树上前缀和
14. [236. 二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/) - 后序递归返回目标信息
15. [124. 二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) - 树形 DP，贡献值不能为负
16. [337. 打家劫舍 III](https://leetcode.cn/problems/house-robber-iii/) - 树形 DP，选/不选当前节点

边界重点：

- 空节点递归返回值要与题意匹配。
- BST 不能只比较父子节点，要维护全局上下界。
- 路径和可能为负，最大路径和初始化不能写 0。
- 递归深度可能达到 n，空间复杂度要算递归栈。

### 12. 图、网格、拓扑与最短路

识别信号：

- 有节点和边、课程依赖、最短步数、连通块。
- 网格中上下左右移动，本质是图。
- 依赖关系要求判断是否有环或输出顺序。
- 带权路径要求最短距离。

相似题型区别：

- DFS：适合连通块、标记访问、递归搜索。
- BFS：适合无权最短路、层数扩散、多源扩散。
- 拓扑排序：适合有向依赖图判环和输出顺序。
- Dijkstra：适合非负权最短路。
- 并查集：适合动态合并连通块、判断两个点是否同集合。

推荐题目：

1. [200. 岛屿数量](https://leetcode.cn/problems/number-of-islands/) - 网格 DFS/BFS
2. [994. 腐烂的橘子](https://leetcode.cn/problems/rotting-oranges/) - 多源 BFS
3. [130. 被围绕的区域](https://leetcode.cn/problems/surrounded-regions/) - 从边界反向 DFS/BFS
4. [785. 判断二分图](https://leetcode.cn/problems/is-graph-bipartite/) - 图染色
5. [127. 单词接龙](https://leetcode.cn/problems/word-ladder/) - BFS 层数，建图优化
6. [207. 课程表](https://leetcode.cn/problems/course-schedule/) - 拓扑排序判环
7. [210. 课程表 II](https://leetcode.cn/problems/course-schedule-ii/) - 输出拓扑序
8. [743. 网络延迟时间](https://leetcode.cn/problems/network-delay-time/) - Dijkstra
9. [787. K 站中转内最便宜的航班](https://leetcode.cn/problems/cheapest-flights-within-k-stops/) - 有边数限制的最短路 / DP
10. [778. 水位上升的泳池中游泳](https://leetcode.cn/problems/swim-in-rising-water/) - Dijkstra / 并查集 / 二分可达
11. [1631. 最小体力消耗路径](https://leetcode.cn/problems/path-with-minimum-effort/) - Dijkstra / 二分答案

边界重点：

- 网格访问前先判断越界，再判断是否访问过。
- BFS 要按层计数，队列初始状态和时间起点要统一。
- 拓扑排序中入度为 0 的点要全部入队。
- Dijkstra 中堆里可能有过期距离，要跳过。

### 13. 并查集

识别信号：

- 题目问连通分量数量、是否属于同一集合。
- 多个等式、账户、边不断合并。
- 树加一条边，需要找导致成环的边。

相似题型区别：

- DFS/BFS：适合静态图一次性遍历。
- 并查集：适合频繁合并和查询连通性。
- 拓扑排序：处理有向依赖，不是无向连通性。

推荐题目：

1. [547. 省份数量](https://leetcode.cn/problems/number-of-provinces/) - 连通块数量
2. [990. 等式方程的可满足性](https://leetcode.cn/problems/satisfiability-of-equality-equations/) - 先合并等式，再检查不等式
3. [684. 冗余连接](https://leetcode.cn/problems/redundant-connection/) - 无向图加边找环
4. [721. 账户合并](https://leetcode.cn/problems/accounts-merge/) - 字符串映射到并查集

边界重点：

- parent 初始化为自己。
- find 要路径压缩。
- union 前后集合数量是否需要减少。
- 等式题必须先处理 `==`，再处理 `!=`。

### 14. 回溯

识别信号：

- 要枚举所有方案、所有排列、所有组合、所有切分。
- 题目要求返回全部结果，而不是最优值或数量。
- 需要选择、递归、撤销选择。

相似题型区别：

- 回溯：枚举搜索树，通常需要撤销状态。
- DFS：更泛化，可能只是遍历图或树。
- DP：适合有重叠子问题，求最优值或计数时常优先考虑。

推荐题目：

1. [78. 子集](https://leetcode.cn/problems/subsets/) - 选或不选 / startIndex
2. [46. 全排列](https://leetcode.cn/problems/permutations/) - used 数组
3. [17. 电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) - 多叉选择
4. [39. 组合总和](https://leetcode.cn/problems/combination-sum/) - 可重复选择，startIndex 不前进
5. [22. 括号生成](https://leetcode.cn/problems/generate-parentheses/) - 合法性剪枝
6. [79. 单词搜索](https://leetcode.cn/problems/word-search/) - 网格回溯，访问恢复
7. [131. 分割回文串](https://leetcode.cn/problems/palindrome-partitioning/) - 切割回溯 + 回文判断
8. [51. N 皇后](https://leetcode.cn/problems/n-queens/) - 行级递归 + 列/斜线约束
9. [37. 解数独](https://leetcode.cn/problems/sudoku-solver/) - 状态剪枝 + 回填恢复

边界重点：

- 递归终止条件是长度达到 n、start 到末尾，还是找到一个合法解。
- path 加入结果时要拷贝。
- 每次选择后必须恢复现场。
- 去重题要区分树层去重和树枝去重。

### 15. 贪心

识别信号：

- 每一步做局部最优选择，并且局部最优能推出全局最优。
- 区间调度、跳跃覆盖、股票一次交易、划分边界。
- 题目要求最少次数、最多保留、最早结束、最远覆盖。

相似题型区别：

- 贪心：需要能解释局部选择为什么不会损失最优解。
- DP：如果当前选择影响后续多个状态且无法局部证明，优先考虑 DP。
- 排序贪心：通常先按结束时间、起点、身高等关键字段排序。

推荐题目：

1. [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) - 维护历史最低价
2. [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/) - 最远可达位置
3. [45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/) - 当前层最远覆盖
4. [763. 划分字母区间](https://leetcode.cn/problems/partition-labels/) - 字符最后出现位置决定边界
5. [435. 无重叠区间](https://leetcode.cn/problems/non-overlapping-intervals/) - 按右端点选择最多不重叠区间
6. [452. 用最少数量的箭引爆气球](https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/) - 区间右端点贪心
7. [134. 加油站](https://leetcode.cn/problems/gas-station/) - 亏损段整体跳过
8. [605. 种花问题](https://leetcode.cn/problems/can-place-flowers/) - 局部可行性
9. [135. 分发糖果](https://leetcode.cn/problems/candy/) - 左右两遍贪心
10. [406. 根据身高重建队列](https://leetcode.cn/problems/queue-reconstruction-by-height/) - 排序 + 插入

边界重点：

- 贪心题面试中必须说出选择依据，而不是只说“每次取最优”。
- 区间题排序字段不同，含义完全不同。
- 跳跃游戏要区分能否到达和最少跳几步。
- 加油站必须先判断总油量是否够。

### 16. 动态规划

识别信号：

- 问最优值、方案数、是否可行。
- 当前结果依赖前面若干状态。
- 有重叠子问题，可以用状态转移避免重复计算。

相似题型区别：

- 线性 DP：状态通常是一维下标。
- 背包 DP：容量维度明显，选择物品或数字。
- 区间 DP：从短区间推长区间。
- 状态机 DP：每一天或每一步有多个互斥状态。
- 回溯：枚举所有方案；DP 通常只求值、计数或可行性。

推荐题目：

线性与基础 DP：

1. [70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/) - 线性递推
2. [746. 使用最小花费爬楼梯](https://leetcode.cn/problems/min-cost-climbing-stairs/) - 爬楼梯变形
3. [118. 杨辉三角](https://leetcode.cn/problems/pascals-triangle/) - 二维递推
4. [198. 打家劫舍](https://leetcode.cn/problems/house-robber/) - 选/不选
5. [213. 打家劫舍 II](https://leetcode.cn/problems/house-robber-ii/) - 环形拆成两段
6. [53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/) - Kadane，当前连续段最大和
7. [152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/) - 同时维护最大/最小乘积

背包与可行性：

1. [279. 完全平方数](https://leetcode.cn/problems/perfect-squares/) - 完全背包最少个数
2. [322. 零钱兑换](https://leetcode.cn/problems/coin-change/) - 完全背包最少硬币
3. [518. 零钱兑换 II](https://leetcode.cn/problems/coin-change-ii/) - 完全背包方案数，组合数
4. [377. 组合总和 Ⅳ](https://leetcode.cn/problems/combination-sum-iv/) - 完全背包方案数，排列数
5. [416. 分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum/) - 01 背包可行性
6. [474. 一和零](https://leetcode.cn/problems/ones-and-zeroes/) - 二维 01 背包
7. [1049. 最后一块石头的重量 II](https://leetcode.cn/problems/last-stone-weight-ii/) - 背包转化为接近 sum / 2
8. [494. 目标和](https://leetcode.cn/problems/target-sum/) - 正负号转 01 背包

序列、字符串与区间 DP：

1. [139. 单词拆分](https://leetcode.cn/problems/word-break/) - 字符串可行性 DP
2. [300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/) - DP / 贪心 + 二分
3. [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/) - 区间状态 / 中心扩展对照
4. [516. 最长回文子序列](https://leetcode.cn/problems/longest-palindromic-subsequence/) - 区间 DP
5. [1143. 最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/) - 双序列 DP
6. [72. 编辑距离](https://leetcode.cn/problems/edit-distance/) - 双序列 DP
7. [312. 戳气球](https://leetcode.cn/problems/burst-balloons/) - 区间 DP，最后戳哪个

路径与状态机：

1. [62. 不同路径](https://leetcode.cn/problems/unique-paths/) - 网格路径 DP
2. [64. 最小路径和](https://leetcode.cn/problems/minimum-path-sum/) - 网格最优路径
3. [120. 三角形最小路径和](https://leetcode.cn/problems/triangle/) - 自底向上压缩
4. [309. 买卖股票的最佳时机含冷冻期](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/) - 状态机 DP

边界重点：

- 状态定义必须先讲清楚：`dp[i]` 表示什么。
- 初始化决定边界，尤其是 `dp[0]`、空字符串、容量 0。
- 01 背包容量倒序，完全背包容量正序。
- 方案数题要区分组合数和排列数，循环顺序不同。

### 17. 位运算与数学

识别信号：

- 数字出现次数有特殊规律，例如一个数出现一次，其他出现两次或三次。
- 判断 2 的幂、统计二进制 1 的个数、范围按位与。
- 随机函数等概率转换。

相似题型区别：

- 异或：适合成对抵消。
- 按位计数：适合其他数出现三次，目标出现一次。
- 公共前缀：适合范围按位与。
- 拒绝采样：适合随机数等概率映射。

推荐题目：

1. [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/) - 异或抵消
2. [137. 只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii/) - 按位计数
3. [260. 只出现一次的数字 III](https://leetcode.cn/problems/single-number-iii/) - 分组异或
4. [231. 2 的幂](https://leetcode.cn/problems/power-of-two/) - `n & (n - 1)`
5. [338. 比特位计数](https://leetcode.cn/problems/counting-bits/) - 递推
6. [201. 数字范围按位与](https://leetcode.cn/problems/bitwise-and-of-numbers-range/) - 公共前缀
7. [470. 用 Rand7() 实现 Rand10()](https://leetcode.cn/problems/implement-rand10-using-rand7/) - 拒绝采样

边界重点：

- 位运算题要考虑 0、负数、Integer 边界。
- `n > 0 && (n & (n - 1)) == 0` 才能判断 2 的幂。
- 拒绝采样要保证每个结果概率完全相等。

### 18. 字符串、Trie 与 KMP

识别信号：

- 字符串匹配、重复周期、前缀查询。
- 需要判断一个字符串是否由某个子串重复构成。
- 大量插入和查询前缀。

相似题型区别：

- 哈希/排序：适合异位词、分组。
- KMP：适合精确匹配和周期性。
- Trie：适合前缀查询，不是普通哈希表。
- 滑动窗口：适合连续子串计数或覆盖。

推荐题目：

1. [28. 找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/) - KMP / 库函数边界
2. [459. 重复的子字符串](https://leetcode.cn/problems/repeated-substring-pattern/) - 周期性 / KMP
3. [686. 重复叠加字符串匹配](https://leetcode.cn/problems/repeated-string-match/) - 字符串拼接匹配
4. [214. 最短回文串](https://leetcode.cn/problems/shortest-palindrome/) - KMP / 字符串哈希
5. [208. 实现 Trie (前缀树)](https://leetcode.cn/problems/implement-trie-prefix-tree/) - Trie 设计

边界重点：

- 空字符串、模式串比主串长。
- KMP 的 next / lps 数组含义必须统一。
- Trie 节点要区分“路径存在”和“单词结束”。

## 两个月建议节奏

### 第 1 周：哈希、双指针、数组原地

目标：能快速判断“用哈希换时间”还是“利用有序性/原地指针”。

建议顺序：

1. 哈希表与集合：1、49、128、380。
2. 双指针与数组原地：283、167、11、15、75、31。
3. 数组、区间与前后缀：56、189、238、41。
4. 复盘对比：两数之和 vs 两数之和 II；三数之和为什么要先排序；前后缀乘积为什么不是前缀和。

### 第 2 周：滑动窗口、前缀和、差分

目标：能区分滑动窗口和前缀和。

建议顺序：

1. 滑动窗口：1456、3、209、713、904、1004、438、76。
2. 恰好型窗口：930、1248、992。
3. 前缀和与差分：303、560、523、974、1109、1094。
4. 复盘对比：560 为什么不能用普通滑动窗口；恰好 K 为什么常转成 atMost。

### 第 3 周：二分、矩阵、栈、堆

目标：写稳边界，形成“普通二分 vs 二分答案”的判断。

建议顺序：

1. 二分：704、35、34、33、153、162、875、1011、410。
2. 矩阵：73、54、48、74、240、378。
3. 栈与单调结构：20、155、394、496、739、239、84。
4. 堆：215、347、703、295。

### 第 4 周：链表与设计

目标：掌握虚拟头、快慢指针、局部反转、双向链表 + 哈希。

建议顺序：

1. 基础链表：206、21、160、141、142、234。
2. 链表操作：2、19、24、25、138、148、23。
3. 设计题：146、155、208、380、703、295。

### 第 5 周：二叉树与 BST

目标：能判断用前序、后序、层序、BST 中序还是树形 DP。

建议顺序：

1. 基础递归：94、104、226、101、543。
2. 层序与 BST：102、199、108、98、230。
3. 构造与路径：105、114、437、236、124、337。

### 第 6 周：图、网格、拓扑、并查集、最短路

目标：能区分 DFS、BFS、拓扑、并查集、Dijkstra。

建议顺序：

1. 网格图：200、994、130。
2. 图 BFS/染色/拓扑：785、127、207、210。
3. 并查集：547、990、684、721。
4. 最短路与变形：743、787、778、1631。

### 第 7 周：回溯、贪心、位运算、字符串

目标：能说清楚回溯树、贪心证明、位运算性质和字符串匹配模板。

建议顺序：

1. 回溯：78、46、17、39、22、79、131、51、37。
2. 贪心：121、55、45、763、435、452、134、605、135、406。
3. 位运算：136、137、260、231、338、201。
4. 字符串：28、459、686、214。

### 第 8 周：动态规划与综合复盘

目标：能先定义状态，再写转移、初始化、遍历顺序和复杂度。

建议顺序：

1. 线性 DP：70、746、118、198、213、53、152。
2. 背包：279、322、518、377、416、474、1049、494。
3. 字符串/区间 DP：139、300、5、516、1143、72、312。
4. 路径/状态机：62、64、120、309。
5. 每天随机抽 1-2 道错题，遮住标签重新判断题型。

## 每题复盘模板

题目：

题型：

识别信号：

- 题目中哪些关键词、数据范围或约束让我想到这个题型？

常见伪装：

- 这题如果换一种描述，可能会伪装成什么问题？

相似题型区别：

- 为什么不是另一种常见题型？例如滑动窗口 vs 前缀和、普通二分 vs 二分答案、回溯 vs DP、DFS vs BFS、堆 vs 排序。

核心模板：

- 通用思路：
- 当前题目如何套入模板：
- 核心变量含义：
- 哪些地方不能机械套：

边界检查清单：

- 最小输入：
- 最大输入：
- 空输入或特殊输入：
- 重复元素：
- 左右边界：
- 是否可能整数溢出：
- 循环或递归终止条件：

复杂度分析：

- 时间复杂度：
- 为什么是这个量级：
- 空间复杂度：
- 空间来自哪些数据结构或递归栈：
- 根据数据范围是否可接受：
- 是否存在更优解：

代码复盘：

- 是否有边界 bug：
- 是否有重复逻辑：
- 变量命名是否表达含义：
- 是否能更贴近模板写法：

一句话面试解释：

- 用一句话说明核心做法和为什么正确。

相似题：

- 至少记录 1-3 道同模板或易混题。

## 复盘卡片

题目：

题型：

识别信号：

核心模板：

关键边界：

时间复杂度：

空间复杂度：

一句话面试解释：

相似题：
