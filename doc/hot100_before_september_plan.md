# LeetCode Hot 100 八月底冲刺计划：按题型学习

> 目标：在 2026 年 8 月 31 日前完成力扣当前官方 Hot 100 第一遍。
>
> 当前进度：17 / 100，剩余 83 题。
>
> 学习方式：以题型为主线连续训练，日期只负责控制进度，不打断题型学习。

## 执行规则

- 每周完成 13～14 道新题：4 天刷 2 道，2 天刷 3 道，1 天复盘或休息。
- 每道题先独立思考 20～40 分钟；超过 45～60 分钟仍无思路，可以查看提示或题解。
- 完成标准：代码 AC、能说明核心思路、能分析复杂度、至少检查一个边界情况。
- 困难题第一遍先掌握核心模型，不强求一次写出所有解法。
- 八月底以前暂停非 Hot 100 扩展题，九月再进行错题二刷和扩展训练。

## 1. 哈希表与集合（3 / 3）

识别信号：快速查找补数、统计频率、按 key 分组、判断元素是否出现过。

核心模板：`HashMap<值, 下标/次数>`、`HashSet` 去重、为分组构造唯一 key。

边界重点：先查询还是先放入；重复元素能否使用同一下标；分组 key 是否唯一。

- [x] [1. 两数之和](https://leetcode.cn/problems/two-sum/) — 哈希查找补数
- [x] [49. 字母异位词分组](https://leetcode.cn/problems/group-anagrams/) — 哈希分组
- [x] [128. 最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/) — 集合 + 连续段起点

## 2. 双指针（4 / 4）

识别信号：数组有序、从两端收缩、原地移动、快慢指针同向扫描。

核心模板：左右指针利用单调性缩小范围；读写指针完成原地覆盖。

边界重点：指针移动条件是否会漏解；三数之和去重位置；原地写入是否覆盖未处理数据。

- [x] [283. 移动零](https://leetcode.cn/problems/move-zeroes/) — 快慢指针
- [x] [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/) — 左右指针
- [x] [15. 三数之和](https://leetcode.cn/problems/3sum/) — 排序 + 双指针 + 去重
- [x] [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/) — 左右最大值 + 双指针

## 3. 滑动窗口（2 / 2）

识别信号：连续子串或子数组、求最长或最短、窗口状态可以增删维护。

核心模板：右指针扩张；窗口非法或满足覆盖条件时移动左指针；同步维护频率。

边界重点：收缩条件是“非法时收缩”还是“合法时继续优化”；字符计数何时增减。

- [x] [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) — 最长无重复窗口
- [x] [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/) — 定长频率窗口

## 4. 子串与连续区间（0 / 3）

识别信号：连续区间计数、恰好和为 K、固定窗口极值、覆盖目标字符。

核心模板：前缀和 + 哈希计数、单调队列、覆盖型滑动窗口。

边界重点：前缀和哈希表先放入 `0 -> 1`；队首元素是否过期；覆盖计数是字符种类还是字符数量。

- [ ] [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/) — 前缀和 + 哈希计数
- [ ] [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/) — 单调队列
- [ ] [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/) — 覆盖型滑动窗口

## 5. 普通数组与区间（4 / 5）

识别信号：连续段最优值、区间合并、数组整体变换、前后缀信息、原地放置。

核心模板：Kadane、区间排序扫描、三次翻转、前后缀乘积、原地哈希。

边界重点：区间排序字段；`k %= n`；乘积中的 0；原地交换时避免重复值死循环。

- [ ] [53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/) — Kadane
- [x] [56. 合并区间](https://leetcode.cn/problems/merge-intervals/) — 排序 + 区间扫描
- [x] [189. 轮转数组](https://leetcode.cn/problems/rotate-array/) — 三次翻转
- [x] [238. 除了自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/) — 前后缀乘积
- [x] [41. 缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/) — 原地哈希

## 6. 矩阵（0 / 4）

识别信号：二维数组原地标记、旋转、按层遍历、行列有序搜索。

核心模板：首行首列作标记、四边界模拟、转置后翻转、从右上角走阶梯。

边界重点：空矩阵、单行单列；螺旋遍历每走完一条边都重新判断边界。

- [ ] [73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/) — 原地标记
- [ ] [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/) — 四边界模拟
- [ ] [48. 旋转图像](https://leetcode.cn/problems/rotate-image/) — 转置 + 翻转
- [ ] [240. 搜索二维矩阵 II](https://leetcode.cn/problems/search-a-2d-matrix-ii/) — 阶梯搜索

## 7. 链表与设计（0 / 14）

识别信号：节点删除或交换、倒数位置、判环、局部反转、链表排序、缓存设计。

核心模板：虚拟头节点、快慢指针、链表反转、归并、哈希表 + 双向链表。

边界重点：头节点被删除或交换；反转后各段的头尾连接；偶数和奇数长度；空链表。

- [ ] [160. 相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/) — 双指针路径对齐
- [ ] [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) — 迭代 / 递归
- [ ] [234. 回文链表](https://leetcode.cn/problems/palindrome-linked-list/) — 快慢指针 + 反转
- [ ] [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/) — 快慢指针判环
- [ ] [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) — 环入口推导
- [ ] [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/) — 虚拟头节点
- [ ] [2. 两数相加](https://leetcode.cn/problems/add-two-numbers/) — 模拟 + 进位
- [ ] [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) — 快慢指针
- [ ] [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/) — 局部重连
- [ ] [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/) — 分组反转
- [ ] [138. 随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/) — 哈希 / 节点穿插
- [ ] [148. 排序链表](https://leetcode.cn/problems/sort-list/) — 归并排序
- [ ] [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/) — 小根堆 / 分治
- [ ] [146. LRU 缓存](https://leetcode.cn/problems/lru-cache/) — 哈希表 + 双向链表

## 8. 二叉树与 BST（0 / 15）

识别信号：遍历、深度、高度、路径、层级、BST 有序性、由遍历序列构造树。

核心模板：前中后序递归、迭代栈、层序 BFS、BST 中序、树形 DP。

边界重点：递归函数的返回值含义；空节点返回什么；路径是否必须经过根；全局答案何时更新。

- [ ] [94. 二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/) — 递归 / 迭代
- [ ] [104. 二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/) — 后序递归
- [ ] [226. 翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/) — 树形递归
- [ ] [101. 对称二叉树](https://leetcode.cn/problems/symmetric-tree/) — 双树递归
- [ ] [543. 二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/) — 深度 + 全局答案
- [ ] [102. 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/) — BFS 分层
- [ ] [108. 将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/) — 分治构造
- [ ] [98. 验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/) — 上下界 / 中序
- [ ] [230. 二叉搜索树中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/) — BST 中序
- [ ] [199. 二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/) — 层序 / DFS
- [ ] [114. 二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) — 后序处理
- [ ] [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) — 分治 + 哈希
- [ ] [437. 路径总和 III](https://leetcode.cn/problems/path-sum-iii/) — 树上前缀和
- [ ] [236. 二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/) — 后序递归
- [ ] [124. 二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) — 树形 DP

## 9. 图、网格与 Trie（0 / 4）

识别信号：连通块、扩散所需时间、课程依赖、字符串前缀查询。

核心模板：网格 DFS/BFS、多源 BFS、入度拓扑排序、Trie 节点数组。

边界重点：访问标记的时机；BFS 是否按层计数；所有入度为 0 的点都要入队；Trie 区分路径存在与单词结束。

- [ ] [200. 岛屿数量](https://leetcode.cn/problems/number-of-islands/) — 网格 DFS/BFS
- [ ] [994. 腐烂的橘子](https://leetcode.cn/problems/rotting-oranges/) — 多源 BFS
- [ ] [207. 课程表](https://leetcode.cn/problems/course-schedule/) — 拓扑排序
- [ ] [208. 实现 Trie（前缀树）](https://leetcode.cn/problems/implement-trie-prefix-tree/) — Trie 设计

## 10. 回溯（0 / 8）

识别信号：返回所有排列、组合、子集、切分或棋盘方案，需要选择、递归和撤销。

核心模板：`path` + `startIndex/used` + 选择 + 递归 + 撤销选择。

边界重点：结果中添加 path 的拷贝；树层去重与树枝去重；访问状态必须恢复。

- [ ] [46. 全排列](https://leetcode.cn/problems/permutations/) — used 数组
- [ ] [78. 子集](https://leetcode.cn/problems/subsets/) — startIndex
- [ ] [17. 电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) — 多叉选择
- [ ] [39. 组合总和](https://leetcode.cn/problems/combination-sum/) — 可重复选择
- [ ] [22. 括号生成](https://leetcode.cn/problems/generate-parentheses/) — 合法性剪枝
- [ ] [79. 单词搜索](https://leetcode.cn/problems/word-search/) — 网格回溯
- [ ] [131. 分割回文串](https://leetcode.cn/problems/palindrome-partitioning/) — 切割回溯
- [ ] [51. N 皇后](https://leetcode.cn/problems/n-queens/) — 列与斜线约束

## 11. 二分查找（0 / 6）

识别信号：有序数组查找位置或边界；一半区间具有确定的有序性。

核心模板：闭区间二分、`lower_bound`、旋转数组有序半边判断、分割线二分。

边界重点：统一循环不变量；`mid = left + (right - left) / 2`；返回 left、right 还是 mid。

- [ ] [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/) — lower_bound
- [ ] [74. 搜索二维矩阵](https://leetcode.cn/problems/search-a-2d-matrix/) — 二维映射二分
- [ ] [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/) — 左右边界
- [ ] [33. 搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/) — 有序半边
- [ ] [153. 寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/) — 旋转数组二分
- [ ] [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/) — 二分分割

## 12. 栈与单调栈（0 / 5）

识别信号：括号或嵌套结构；寻找左右第一个更大或更小元素；矩形面积。

核心模板：匹配栈、状态栈、单调递增或递减下标栈。

边界重点：栈中存值还是下标；相等元素如何处理；是否需要在两端加入哨兵。

- [ ] [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/) — 匹配栈
- [ ] [155. 最小栈](https://leetcode.cn/problems/min-stack/) — 辅助栈
- [ ] [394. 字符串解码](https://leetcode.cn/problems/decode-string/) — 嵌套结构栈
- [ ] [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/) — 单调栈
- [ ] [84. 柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/) — 单调栈边界

## 13. 堆与 Top K（0 / 3）

识别信号：动态维护最大或最小的 K 个元素、数据持续到来、需要中位数。

核心模板：固定大小小根堆、频率哈希 + 堆、大根堆与小根堆平衡。

边界重点：堆大小何时收缩；两个堆的数量差和元素大小关系必须同时成立。

- [ ] [215. 数组中的第 K 个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/) — 堆 / 快速选择
- [ ] [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/) — 哈希 + 堆
- [ ] [295. 数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream/) — 双堆

## 14. 贪心（0 / 4）

识别信号：每一步维护当前最优覆盖范围、最少次数或最早结束位置。

核心模板：维护历史最优值、最远可达位置、当前层边界、字符最后出现位置。

边界重点：必须能说明局部选择为什么不损失全局最优；区分能否到达与最少跳几步。

- [ ] [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) — 历史最低价
- [ ] [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/) — 最远可达位置
- [ ] [45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/) — 分层覆盖
- [ ] [763. 划分字母区间](https://leetcode.cn/problems/partition-labels/) — 最后出现位置

## 15. 一维与背包动态规划（0 / 10）

识别信号：求最优值、方案数或可行性；当前结果依赖之前若干状态；存在重复子问题。

核心模板：线性 DP、选或不选、完全背包、01 背包、字符串可行性 DP。

边界重点：先定义 `dp[i]`；初始化决定边界；01 背包容量倒序，完全背包容量正序。

- [ ] [70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/) — 线性 DP
- [ ] [118. 杨辉三角](https://leetcode.cn/problems/pascals-triangle/) — 二维递推
- [ ] [198. 打家劫舍](https://leetcode.cn/problems/house-robber/) — 选 / 不选
- [ ] [279. 完全平方数](https://leetcode.cn/problems/perfect-squares/) — 完全背包
- [ ] [322. 零钱兑换](https://leetcode.cn/problems/coin-change/) — 完全背包最少数量
- [ ] [139. 单词拆分](https://leetcode.cn/problems/word-break/) — 字符串可行性 DP
- [ ] [300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/) — DP / 贪心 + 二分
- [ ] [152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/) — 最大最小双状态
- [ ] [416. 分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum/) — 01 背包
- [ ] [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/) — 字符串 DP

## 16. 多维与序列动态规划（0 / 5）

识别信号：网格路径、两个字符串或序列、区间回文。

核心模板：二维网格 DP、双序列 DP、中心扩展或区间状态。

边界重点：空字符串对应第 0 行和第 0 列；字符下标与 DP 下标相差 1；遍历方向必须满足依赖关系。

- [ ] [62. 不同路径](https://leetcode.cn/problems/unique-paths/) — 网格路径 DP
- [ ] [64. 最小路径和](https://leetcode.cn/problems/minimum-path-sum/) — 网格最优路径
- [ ] [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/) — 中心扩展 / 区间状态
- [ ] [1143. 最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/) — 双序列 DP
- [ ] [72. 编辑距离](https://leetcode.cn/problems/edit-distance/) — 插入、删除、替换

## 17. 数组与位运算技巧（4 / 5）

识别信号：元素出现次数具有规律、要求原地处理、排列的下一个状态、数组可映射成链表。

核心模板：异或抵消、Boyer-Moore 投票、三指针分区、从右向左寻找排列拐点、快慢指针找环。

边界重点：异或题的出现次数前提；相等元素的分区；排列完全降序时整体翻转。

- [ ] [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/) — 异或
- [x] [169. 多数元素](https://leetcode.cn/problems/majority-element/) — Boyer-Moore 投票
- [x] [75. 颜色分类](https://leetcode.cn/problems/sort-colors/) — 三指针分区
- [x] [31. 下一个排列](https://leetcode.cn/problems/next-permutation/) — 拐点 + 交换 + 翻转
- [x] [287. 寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/) — 数组映射成链表找环

## 六周进度安排

题目清单以上述 17 个题型章节为准。本表只规定每周学习哪些题型，不重复列题。

| 周次 | 日期 | 题型范围 | 新题数 | 目标累计 |
|---|---|---|---:|---:|
| 第 1 周 | 7 月 20 日—7 月 26 日 | 子串 3 + 普通数组 1 + 矩阵 4 + 二分 6 | 14 | 31 / 100 |
| 第 2 周 | 7 月 27 日—8 月 2 日 | 链表与设计 | 14 | 45 / 100 |
| 第 3 周 | 8 月 3 日—8 月 9 日 | 二叉树前 14 题 | 14 | 59 / 100 |
| 第 4 周 | 8 月 10 日—8 月 16 日 | 二叉树最大路径和 1 + 图 4 + 回溯 8 + 位运算 1 | 14 | 73 / 100 |
| 第 5 周 | 8 月 17 日—8 月 23 日 | 栈 5 + 堆 3 + 贪心 4 + 基础 DP 前 2 题 | 14 | 87 / 100 |
| 第 6 周 | 8 月 24 日—8 月 30 日 | 基础 DP 剩余 8 + 多维 DP 5 | 13 | 100 / 100 |
| 缓冲日 | 8 月 31 日 | 补漏、随机抽题和建立九月二刷清单 | 0 | 100 / 100 |

## 每周复盘模板

- 本周完成：`__/14`
- 未完成题目及原因：
- 最容易混淆的两个题型：
- 本周新增模板：
- 仍不能独立写出的题目：
- 下周需要补的题目：

## 欠账调整规则

- 每周考核总量，不要求每天绝对完成固定数量。
- 一周落后不超过 2 题，用本周复盘日补齐。
- 一周落后 3 题以上，暂缓困难题的多解法学习，先完成第一遍 AC。
- 不用第二天一次性硬补；把欠题均摊到本周剩余刷题日。
- 第一轮完成不等于永久掌握，九月统一二刷不能独立完成的题目。
