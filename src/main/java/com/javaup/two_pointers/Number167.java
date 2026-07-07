package com.javaup.two_pointers;

public class Number167 {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int[] res = twoSum(numbers, 9);
        for (int loc : res) {
            System.out.println(loc);
        }
    }

    /**
     * 时间复杂度是 O(n²)（最坏情况）
     */
//    public static int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; i++) {
//            int y = i + 1;
//            while(y < numbers.length){
//                if(numbers[i] + numbers[y] == target){
//                    return new int[]{i + 1,y + 1};
//                }
//                // 根据题目数组非递减顺序排列的特性，及时止损，减少计算量
//                if(numbers[i] + numbers[y] > target){
//                    break;
//                }
//                y++;
//            }
//        }
//        return new int[]{};
//    }

    /**
     * 缩减空间思想
     * 时间复杂度是 O(n)
     */
    public static int[] twoSum(int[] numbers, int target) {
        int x = 0;
        int y = numbers.length - 1;
        while (true){
            int sum = numbers[x] + numbers[y];
            if(sum < target){
                x++;
            } else if (sum > target) {
                y--;
            }else {
                return new int[]{x + 1,y + 1};
            }
        }
    }
}
