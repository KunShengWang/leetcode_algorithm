# 两个月力扣 HOT100 算法模板训练计划：按题型串联官方 HOT100

> 本计划只包含 LeetCode「热题 100」中的 100 道题，不加入灵神精选、进阶变形或其他补充题。

## 训练目标

目标不是机械刷完 100 道题，而是在两个月内训练四类能力：

1. 题型识别能力：看到题目后，能判断它属于什么算法类型，并说出判断依据。
2. 解题模板能力：掌握每类题的通用思路、代码骨架、变量含义和常见变形。
3. 边界控制能力：能主动检查空输入、单元素、重复元素、左右边界、递归终止、整数溢出等细节。
4. 复杂度分析能力：能根据数据范围判断可行复杂度，并讲清楚时间复杂度、空间复杂度和方案取舍。

## 执行原则

- 周期：建议 8 周完成第一轮。
- 每天节奏：2 道新题 + 1 道错题或同类题复刷；难题当天可只做 1 道。
- 每个题型先理解识别信号，再做对应 HOT100 核心题。
- 每题先独立判断题型和复杂度，再开始写代码；做完必须复盘，不只看是否 AC。
- 每周至少安排 1 天只做错题复盘和同类题对比。
- 面试训练时可以遮住题目标签，先自己判断题型，再对照本计划复盘。

## 总体路线

1. 第 1 周：哈希、双指针、普通数组。
2. 第 2 周：滑动窗口、子串、前缀和、矩阵。
3. 第 3 周：二分、栈、单调栈、堆。
4. 第 4 周：链表。
5. 第 5 周：二叉树、BST、树形递归。
6. 第 6 周：图、网格 BFS/DFS、拓扑、Trie、回溯。
7. 第 7 周：贪心、位运算与技巧题。
8. 第 8 周：动态规划、多维动态规划与综合复盘。

## 题型学习单元

### 1. 哈希表与集合

识别信号：

- 要快速判断某个值是否出现过、出现次数或进行分组归类。
- 题目要求把暴力的 O(n²) 查找优化到接近 O(n)。
- 需要维护“值 -> 下标 / 次数 / 分组 key”的映射。

相似题型区别：

- 哈希查找：关心某个补数或 key 是否存在。
- 哈希计数：关心频率、分组和出现次数。
- 哈希集合：关心去重和某个元素是否存在。

推荐题目：

1. [1. 两数之和](https://leetcode.cn/problems/two-sum/) - 哈希查找，记录值与下标
2. [49. 字母异位词分组](https://leetcode.cn/problems/group-anagrams/) - 哈希分组，设计统一 key
3. [128. 最长连续序列](https://leetcode.cn/problems/longest-consecutive-sequence/) - HashSet，只从连续段起点扩展

边界重点：

- 两数之和要注意不能重复使用同一个下标，通常先查再放。
- 异位词分组的 key 必须能唯一表示字符构成。
- 最长连续序列只从 `x - 1` 不存在的位置开始扩展，避免重复扫描。

### 2. 双指针

识别信号：

- 需要从数组两端向中间收缩，或者使用快慢指针同向扫描。
- 数组具有顺序、位置或单调性质，可以通过移动指针排除一批不可能答案。
- 要求原地移动元素，避免使用额外数组。

相似题型区别：

- 双指针通常依赖两端、快慢指针或排序后的单调性。
- 滑动窗口维护的是一个连续区间及其合法状态。
- 哈希表不依赖顺序，通常用额外空间换时间。

推荐题目：

1. [283. 移动零](https://leetcode.cn/problems/move-zeroes/) - 快慢指针，原地稳定移动
2. [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/) - 左右指针，移动短板
3. [15. 三数之和](https://leetcode.cn/problems/3sum/) - 排序 + 固定一位 + 左右指针 + 去重
4. [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/) - 左右最大值 + 双指针

边界重点：

- 移动零要保证非零元素相对顺序不变。
- 三数之和必须同时处理固定元素和左右指针的重复值。
- 接雨水的核心是明确哪一侧的最大高度已经能够确定当前位置答案。

### 3. 滑动窗口

识别信号：

- 题目要求连续子串或连续子数组。
- 询问最长、最短，并且窗口状态可以随着右端扩张、左端收缩动态维护。
- 出现“不重复”“异位词”“固定长度”等特征。

相似题型区别：

- 滑动窗口维护连续区间，并要求窗口状态可增删维护。
- 前缀和更适合任意子数组和以及存在负数的计数问题。
- 固定窗口长度确定；不定长窗口通过合法性决定何时收缩。

推荐题目：

1. [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) - 不定长窗口，重复时收缩
2. [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/) - 固定长度窗口 + 频率匹配

边界重点：

- 无重复字符题要明确 `while` 的收缩条件以及窗口长度计算。
- 异位词窗口长度必须始终等于目标字符串长度。
- 字符计数数组或哈希表的更新顺序要保持窗口不变量。

### 4. 子串、前缀和与窗口进阶

识别信号：

- 题目围绕连续子数组/子串进行计数、最值或覆盖。
- 子数组和等于某个值时，优先考虑前缀和 + 哈希。
- 需要固定窗口最大值时，考虑单调队列。

相似题型区别：

- 前缀和 + 哈希适合统计历史前缀状态。
- 单调队列适合固定窗口最值。
- 覆盖型滑动窗口需要维护目标字符是否全部满足。

推荐题目：

1. [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/) - 前缀和 + 哈希计数
2. [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/) - 单调队列维护窗口最大值
3. [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/) - 覆盖型滑动窗口

边界重点：

- 560 要初始化前缀和 `0 -> 1`，并先查询 `prefix - k` 再更新当前前缀。
- 239 的队列通常存下标，队头要及时淘汰过期元素。
- 76 要区分“字符出现次数满足”和“满足的字符种类数”。

### 5. 普通数组、区间与原地技巧

识别信号：

- 题目围绕数组整体扫描、区间合并、前后缀信息或原地放置。
- 要求 O(1) 额外空间，或者不能使用除法。
- 数值范围和数组下标存在对应关系，可以考虑原地哈希。

相似题型区别：

- 区间题通常先排序再扫描。
- 前后缀技巧利用当前位置左侧和右侧信息。
- 原地哈希把值放到它应该对应的位置。

推荐题目：

1. [53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray/) - Kadane / 线性 DP
2. [56. 合并区间](https://leetcode.cn/problems/merge-intervals/) - 排序 + 区间扫描
3. [189. 轮转数组](https://leetcode.cn/problems/rotate-array/) - 三次反转
4. [238. 除了自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/) - 前缀积 + 后缀积
5. [41. 缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/) - 原地哈希

边界重点：

- 最大子数组和要处理全负数组。
- 合并区间先按左端点排序，重叠时更新当前右端点。
- 轮转数组先执行 `k %= n`。
- 原地哈希只处理 `[1,n]` 内元素，并防止重复值导致死循环。

### 6. 矩阵与二维数组

识别信号：

- 要在二维数组中原地标记、旋转、按层遍历或利用行列有序性。
- 需要维护上、下、左、右四个边界。
- 可以从矩阵角落利用单调性逐步排除行或列。

相似题型区别：

- 矩阵模拟的核心是边界控制。
- 矩阵原地修改要考虑如何复用首行首列等空间。
- 有序矩阵搜索重点利用单调性，而不是遍历全部元素。

推荐题目：

1. [73. 矩阵置零](https://leetcode.cn/problems/set-matrix-zeroes/) - 首行首列作为标记
2. [54. 螺旋矩阵](https://leetcode.cn/problems/spiral-matrix/) - 四边界模拟
3. [48. 旋转图像](https://leetcode.cn/problems/rotate-image/) - 转置 + 翻转
4. [240. 搜索二维矩阵 II](https://leetcode.cn/problems/search-a-2d-matrix-ii/) - 右上角/左下角楼梯搜索

边界重点：

- 矩阵置零要单独记录首行或首列本身是否需要置零。
- 螺旋遍历每走完一条边都要检查边界是否交叉。
- 旋转图像要求原地操作。
- 搜索矩阵 II 要理解每一步为何能够排除一整行或一整列。

### 7. 链表

识别信号：

- 只能顺序访问，不能随机下标。
- 涉及删除、反转、合并、中点、环、倒数位置或链表设计。
- 头节点可能变化时通常需要虚拟头节点。

相似题型区别：

- 快慢指针适合中点、环和倒数位置。
- 虚拟头节点适合删除、合并和局部反转。
- 复杂链表操作的关键不是值，而是指针断开与重新连接的顺序。

推荐题目：

1. [160. 相交链表](https://leetcode.cn/problems/intersection-of-two-linked-lists/) - 双指针换头
2. [206. 反转链表](https://leetcode.cn/problems/reverse-linked-list/) - 基础迭代反转
3. [234. 回文链表](https://leetcode.cn/problems/palindrome-linked-list/) - 中点 + 反转后半段
4. [141. 环形链表](https://leetcode.cn/problems/linked-list-cycle/) - 快慢指针判环
5. [142. 环形链表 II](https://leetcode.cn/problems/linked-list-cycle-ii/) - Floyd 找环入口
6. [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/) - 虚拟头 + 双指针
7. [2. 两数相加](https://leetcode.cn/problems/add-two-numbers/) - 链表模拟进位
8. [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/) - 快慢指针 + 虚拟头
9. [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/) - 局部指针重连
10. [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/) - 分组检查 + 局部反转
11. [138. 随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/) - 哈希映射 / 原地拆链
12. [148. 排序链表](https://leetcode.cn/problems/sort-list/) - 归并排序
13. [23. 合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/) - 小根堆 / 分治
14. [146. LRU 缓存](https://leetcode.cn/problems/lru-cache/) - 双向链表 + 哈希表

边界重点：

- 空链表、单节点、两个节点要单独检查。
- 所有反转操作都要先保存 `next`，避免断链后丢失后续节点。
- K 个一组时剩余不足 K 个不能反转。
- LRU 的哈希表与双向链表必须始终保持一一对应。

### 8. 二叉树与 BST

识别信号：

- 要求遍历、深度、路径、祖先、构造或子树信息。
- 当前节点结果需要结合左右子树的返回值。
- BST 题目通常利用中序有序或上下界约束。

相似题型区别：

- DFS 递归适合路径、深度和子树信息。
- BFS 层序适合按层处理、层数和右视图。
- BST 先考虑中序遍历或上下界。
- 树形 DP 通常需要区分“向父节点返回的值”和“全局答案”。

推荐题目：

1. [94. 二叉树的中序遍历](https://leetcode.cn/problems/binary-tree-inorder-traversal/) - DFS 遍历基础
2. [104. 二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/) - 递归高度
3. [226. 翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/) - 递归交换左右子树
4. [101. 对称二叉树](https://leetcode.cn/problems/symmetric-tree/) - 双树镜像递归
5. [543. 二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree/) - 后序高度 + 全局答案
6. [102. 二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/) - BFS
7. [108. 将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/) - 分治构造平衡 BST
8. [98. 验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/) - 上下界 / 中序严格递增
9. [230. 二叉搜索树中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/) - 中序遍历
10. [199. 二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/) - 层序最后一个
11. [114. 二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) - 递归重连
12. [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) - 分治 + 哈希定位
13. [437. 路径总和 III](https://leetcode.cn/problems/path-sum-iii/) - 树上前缀和
14. [236. 二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/) - 后序递归
15. [124. 二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) - 树形 DP，负贡献截断

边界重点：

- 递归函数的返回值含义必须先定义清楚。
- BST 不能只比较父子节点，要保证整个子树满足范围约束。
- 路径和可能包含负数。
- 最大路径和中向父节点只能返回单边贡献。

### 9. 图、网格、BFS 与 Trie

识别信号：

- 网格上下左右移动，本质上可以抽象为图。
- 要求连通块、最短扩散时间或依赖关系判环。
- 大量字符串前缀插入和查询时考虑 Trie。

相似题型区别：

- DFS 适合连通块与遍历。
- BFS 适合无权最短路和多源扩散。
- 拓扑排序适合有向依赖图判环。
- Trie 专门维护字符串前缀结构。

推荐题目：

1. [200. 岛屿数量](https://leetcode.cn/problems/number-of-islands/) - 网格 DFS/BFS
2. [994. 腐烂的橘子](https://leetcode.cn/problems/rotting-oranges/) - 多源 BFS
3. [207. 课程表](https://leetcode.cn/problems/course-schedule/) - 拓扑排序判环
4. [208. 实现 Trie (前缀树)](https://leetcode.cn/problems/implement-trie-prefix-tree/) - Trie 设计

边界重点：

- 网格访问前先判断越界，再判断是否访问过。
- 多源 BFS 的所有初始源点要同时入队。
- 课程表最终要比较拓扑处理节点数与总课程数。
- Trie 要区分路径存在和完整单词结束。

### 10. 回溯

识别信号：

- 要求枚举所有排列、组合、子集、切分或放置方案。
- 通常存在“选择 -> 递归 -> 撤销选择”的搜索树。
- 需要通过约束进行剪枝。

相似题型区别：

- 排列通常需要 `used` 数组。
- 组合/子集通常使用 `startIndex` 控制后续选择范围。
- 网格回溯除了 path 外还需要恢复访问状态。

推荐题目：

1. [46. 全排列](https://leetcode.cn/problems/permutations/) - used 数组
2. [78. 子集](https://leetcode.cn/problems/subsets/) - startIndex / 选或不选
3. [17. 电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) - 多叉搜索树
4. [39. 组合总和](https://leetcode.cn/problems/combination-sum/) - 允许重复选择
5. [22. 括号生成](https://leetcode.cn/problems/generate-parentheses/) - 合法性剪枝
6. [79. 单词搜索](https://leetcode.cn/problems/word-search/) - 网格回溯
7. [131. 分割回文串](https://leetcode.cn/problems/palindrome-partitioning/) - 切割回溯 + 回文判断
8. [51. N 皇后](https://leetcode.cn/problems/n-queens/) - 行级递归 + 列/对角线约束

边界重点：

- path 加入结果时必须拷贝。
- 每次选择后必须正确恢复现场。
- 组合总和允许重复选择当前元素，因此递归下标处理与普通组合不同。
- 剪枝条件必须保证不会误删合法解。

### 11. 二分查找

识别信号：

- 有序数组中查找目标、边界或插入位置。
- 旋转数组仍然保留局部有序性质。
- 可以通过一个判断条件每次排除一半搜索空间。

相似题型区别：

- 普通二分直接在有序数据中查值或边界。
- 旋转数组二分要先判断哪一半有序。
- 二维矩阵可以映射成一维有序数组。

推荐题目：

1. [35. 搜索插入位置](https://leetcode.cn/problems/search-insert-position/) - lower_bound
2. [74. 搜索二维矩阵](https://leetcode.cn/problems/search-a-2d-matrix/) - 二维映射一维二分
3. [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/) - 左右边界
4. [33. 搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/) - 判断有序半边
5. [153. 寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/) - 利用与右端点关系二分
6. [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/) - 二分分割，困难题后置

边界重点：

- 固定一套区间定义，不要混用 `left <= right` 与 `left < right` 的更新方式。
- 使用 `mid = left + (right - left) / 2` 避免溢出。
- 边界二分要明确最终返回的是第一个满足还是最后一个满足的位置。
- 旋转数组每次都要证明舍弃的一半不可能包含答案。

### 12. 栈与单调栈

识别信号：

- 括号匹配、嵌套结构、最近未匹配元素。
- 对每个位置寻找左/右第一个更大或更小元素。
- 需要维护一个满足单调性的候选集合。

相似题型区别：

- 普通栈处理匹配和嵌套。
- 单调栈处理下一个更大/更小以及左右边界。
- 栈里存值还是下标取决于是否需要计算位置距离。

推荐题目：

1. [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/) - 括号匹配
2. [155. 最小栈](https://leetcode.cn/problems/min-stack/) - 辅助栈 / 同步维护最小值
3. [394. 字符串解码](https://leetcode.cn/problems/decode-string/) - 栈处理嵌套结构
4. [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/) - 单调栈求右侧第一个更大
5. [84. 柱状图中最大的矩形](https://leetcode.cn/problems/largest-rectangle-in-histogram/) - 单调栈确定左右边界

边界重点：

- 有效括号遇到右括号时必须先判断栈是否为空。
- 最小栈需要保证 push/pop 与最小值结构同步。
- 每日温度栈中存下标。
- 柱状图最大矩形常用哨兵简化首尾边界。

### 13. 堆、TopK 与数据流

识别信号：

- 求第 K 大、前 K 高频。
- 数据流不断加入，需要实时查询中位数。
- 只需要维护最重要的一部分元素。

相似题型区别：

- 堆适合动态维护 TopK。
- 排序适合一次性离线处理，但通常需要 O(n log n)。
- 中位数数据流需要两个堆共同维护左右两半。

推荐题目：

1. [215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/) - 小根堆 / 快速选择
2. [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/) - 频率哈希 + 堆
3. [295. 数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream/) - 大根堆 + 小根堆

边界重点：

- Java `PriorityQueue` 默认是小根堆。
- 比较器优先使用 `Integer.compare`，避免减法溢出。
- 双堆需要同时维护大小关系和堆顶大小关系。

### 14. 贪心

识别信号：

- 每一步都可以作出局部最优选择，并能证明不会损害全局最优。
- 出现最低价格、最远覆盖、最少跳跃、区间边界等特征。
- 目标通常是可达性或最少/最大数量。

相似题型区别：

- 贪心必须能够解释局部选择为何安全。
- 如果当前选择会影响多个后续状态且无法局部证明，通常考虑 DP。

推荐题目：

1. [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) - 维护历史最低价
2. [55. 跳跃游戏](https://leetcode.cn/problems/jump-game/) - 维护最远可达位置
3. [45. 跳跃游戏 II](https://leetcode.cn/problems/jump-game-ii/) - 分层维护下一跳最远边界
4. [763. 划分字母区间](https://leetcode.cn/problems/partition-labels/) - 最后出现位置决定区间边界

边界重点：

- 股票题只能先买后卖。
- 跳跃游戏要区分“是否可达”和“最少跳几步”。
- 跳跃游戏 II 更新步数的时机是到达当前层边界。
- 划分字母区间要预先记录每个字符最后出现的位置。

### 15. 动态规划

识别信号：

- 询问最优值、方案数或可行性。
- 当前状态依赖前面若干状态，并存在重叠子问题。
- 需要明确状态定义、状态转移、初始化和遍历顺序。

相似题型区别：

- 线性 DP 通常以一维下标作为状态。
- 背包 DP 出现容量和“选/不选”。
- 区间或序列 DP 需要考虑二维状态。
- 能 O(1) 压缩空间时，仍应先理解完整 DP 状态。

推荐题目：

1. [70. 爬楼梯](https://leetcode.cn/problems/climbing-stairs/) - 线性递推
2. [118. 杨辉三角](https://leetcode.cn/problems/pascals-triangle/) - 二维递推
3. [198. 打家劫舍](https://leetcode.cn/problems/house-robber/) - 选/不选当前房屋
4. [279. 完全平方数](https://leetcode.cn/problems/perfect-squares/) - 完全背包最少个数
5. [322. 零钱兑换](https://leetcode.cn/problems/coin-change/) - 完全背包最少硬币
6. [139. 单词拆分](https://leetcode.cn/problems/word-break/) - 字符串可行性 DP
7. [300. 最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/) - DP / 贪心 + 二分
8. [152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/) - 同时维护最大/最小乘积
9. [416. 分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum/) - 0/1 背包可行性
10. [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/) - DP / 栈

边界重点：

- 每道 DP 题先写清楚 `dp[i]` 或 `dp[i][j]` 的含义。
- 最少次数类初始化通常需要一个足够大的不可达值。
- 0/1 背包容量必须倒序遍历。
- 乘积最大子数组遇到负数时最大值和最小值可能互换角色。

### 16. 多维动态规划

识别信号：

- 状态同时依赖两个维度，例如二维网格、两个字符串或一个区间。
- 转移通常来自上方、左方、左上方或更短区间。
- 需要处理空前缀或边界行列。

相似题型区别：

- 网格 DP 的维度对应坐标。
- 双序列 DP 的两个维度对应两个字符串的前缀。
- 回文子串既可用区间 DP，也可用中心扩展。

推荐题目：

1. [62. 不同路径](https://leetcode.cn/problems/unique-paths/) - 网格计数 DP
2. [64. 最小路径和](https://leetcode.cn/problems/minimum-path-sum/) - 网格最优路径
3. [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/) - 区间 DP / 中心扩展
4. [1143. 最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence/) - 双序列 DP
5. [72. 编辑距离](https://leetcode.cn/problems/edit-distance/) - 双序列 DP

边界重点：

- 网格 DP 要先处理第一行、第一列或使用扩展边界。
- LCS 和编辑距离要明确 `dp[i][j]` 对应的是前多少个字符。
- 最长回文子串要区分子串和子序列。
- 编辑距离的插入、删除、替换分别对应哪个状态来源要理解清楚。

### 17. 技巧、位运算与数组原地处理

识别信号：

- 数字出现次数存在特殊规律。
- 需要 O(1) 空间完成排序、投票、找重复值或原地变换。
- 问题可以通过数学结构、环、异或或局部规律降低复杂度。

相似题型区别：

- 异或适合成对抵消。
- Boyer-Moore 投票利用候选人的抵消关系。
- 颜色分类是三指针分区。
- 重复数可以把数组映射为函数图，再用 Floyd 判环。

推荐题目：

1. [136. 只出现一次的数字](https://leetcode.cn/problems/single-number/) - 异或抵消
2. [169. 多数元素](https://leetcode.cn/problems/majority-element/) - Boyer-Moore 投票
3. [75. 颜色分类](https://leetcode.cn/problems/sort-colors/) - 荷兰国旗三指针
4. [31. 下一个排列](https://leetcode.cn/problems/next-permutation/) - 找下降点 + 交换 + 反转后缀
5. [287. 寻找重复数](https://leetcode.cn/problems/find-the-duplicate-number/) - Floyd 快慢指针找环

边界重点：

- 异或题要理解 `x ^ x = 0` 与 `x ^ 0 = x`。
- 多数元素题依赖题目保证多数元素一定存在。
- 颜色分类要维护三个区间的不变量。
- 下一个排列找不到下降点时，需要整体反转。
- 寻找重复数中数组值被当作下一个下标，不能修改原数组。

## 两个月建议节奏

### 第 1 周：哈希、双指针、普通数组

目标：优先建立数组题的基本盘，能快速判断“哈希换时间”“双指针排除答案”“数组原地处理”。

建议顺序：

1. 哈希：1、49、128。
2. 双指针：283、11、15、42。
3. 普通数组：53、56、189、238、41。
4. 复盘对比：两数之和为什么用哈希；三数之和为什么先排序；41 为什么属于原地哈希。

### 第 2 周：滑动窗口、子串、前缀和、矩阵

目标：能区分普通滑动窗口、前缀和 + 哈希、单调队列和二维矩阵模拟。

建议顺序：

1. 滑动窗口：3、438。
2. 子串综合：560、239、76。
3. 矩阵：73、54、48、240。
4. 复盘对比：560 为什么不能用普通滑动窗口；239 为什么用单调队列；76 如何判断窗口已经覆盖目标。

### 第 3 周：二分、栈、堆

目标：写稳二分边界，掌握普通栈、单调栈和 TopK / 双堆。

建议顺序：

1. 二分：35、74、34、33、153、4。
2. 栈与单调栈：20、155、394、739、84。
3. 堆：215、347、295。
4. 复盘对比：普通二分 vs 旋转数组二分；普通栈 vs 单调栈；第 K 大 vs 数据流中位数。

### 第 4 周：链表

目标：掌握虚拟头、快慢指针、局部反转、归并、双向链表 + 哈希。

建议顺序：

1. 基础链表：160、206、234、141、142、21。
2. 链表操作：2、19、24、25、138、148、23。
3. 设计题：146。
4. 复盘对比：141 判环 vs 142 找入口；普通反转 vs K 组反转；23 堆解法 vs 分治解法。

### 第 5 周：二叉树与 BST

目标：能判断前序、后序、层序、BST 中序以及树形 DP 的使用场景。

建议顺序：

1. 基础递归：94、104、226、101、543。
2. 层序与 BST：102、108、98、230、199。
3. 构造与路径：114、105、437、236、124。
4. 复盘对比：543 和 124 的递归返回值有什么区别；98 为什么不能只比较父子节点。

### 第 6 周：图、网格、Trie、回溯

目标：区分 DFS、BFS、拓扑排序、Trie 和回溯搜索树。

建议顺序：

1. 图与网格：200、994、207、208。
2. 回溯：46、78、17、39、22、79、131、51。
3. 复盘对比：网格 DFS vs 网格回溯；BFS 扩散 vs DFS 连通块；排列 vs 组合/子集。

### 第 7 周：贪心、位运算与技巧

目标：能说清楚贪心选择依据，并掌握常见 O(1) 空间技巧。

建议顺序：

1. 贪心：121、55、45、763。
2. 技巧：136、169、75、31、287。
3. 复盘对比：55 和 45 的目标差异；136 的异或性质；287 为什么能转化为环形链表。

### 第 8 周：动态规划与综合复盘

目标：能先定义状态，再写转移、初始化、遍历顺序和复杂度；完成 100 题第一轮闭环。

建议顺序：

1. 基础 DP：70、118、198、279、322、139、300、152、416、32。
2. 多维 DP：62、64、5、1143、72。
3. 每天随机抽 2-3 道前 7 周错题，遮住标签重新判断题型。
4. 最后完成一次 100 题清单盘点：不会 / 模糊 / 熟练三个等级。

## 每题复盘模板

题目：

题型：

识别信号：

- 题目中哪些关键词、数据范围或约束让我想到这个题型？

常见伪装：

- 这题如果换一种描述，可能会伪装成什么问题？

相似题型区别：

- 为什么不是另一种常见题型？例如滑动窗口 vs 前缀和、回溯 vs DP、DFS vs BFS、堆 vs 排序。

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

- 记录 HOT100 中同模板或易混淆的题。

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

## HOT100 完成度总表

- 总题数：100
- 本计划收录：100
- 非 HOT100 补充题：0
- 建议标记：`未做 / 已做未掌握 / 可独立写出 / 可面试讲解`

> 题单基准：LeetCode 热题 100（Top 100 Liked）。