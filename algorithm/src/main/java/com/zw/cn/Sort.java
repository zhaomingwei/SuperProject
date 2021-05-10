package com.zw.cn;

import java.util.Arrays;

/**
 * @author 赵威
 * @date 2021/5/10 8:28
 * @desc 简单排序算法
 * 记忆：  冒泡 选择 (了) 插入 ， 堆  与  归并 不高兴 ， 于是派  快速  战斗
 */
public class Sort {

    public static void main(String[] args) {
//        int[] nums = new int[]{4, 1, 2, 6, 8, 9, 0, 3, 5, 7};
        int[] nums = new int[]{4, 1, 2, 6, 8};

        // 测试效率
        // int number = 1000000;
        // int[] array = new int[number];
        // for (int i = 0; i < array.length; i++) {
        // array[i] = new Random().nextInt(number);
        // }
//        long start = System.currentTimeMillis();


//        bubbleSort(nums);
//        selectSort(nums);
//        insertSort(nums);
        heapSort(nums);
//        quickSort(nums);

//        long end = System.currentTimeMillis();
//        System.out.println("用时：" + (end - start));// 测试结果： 元素为5万个时：11毫秒。50万：66毫秒。100万：136毫秒

        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left];
        int i = left;
        int j = right;


    }

    /**
     * 冒泡排序
     * <p>
     * 比较次数：
     * 第一轮比较：n-1 次
     * 第二轮比较：n-2 次
     * ...
     * 第n-1轮比较：1次
     * 总比较次数：(n-1)+(n-2)+...+1 ≈ n²/2
     * 平均时间复杂度： 时间复杂度 O(n²)
     * 也可直接看成两次for循环嵌套，且都与数组长度有关，所以n*n -> n²
     *
     * @param nums 待排序数组
     */
    private static void bubbleSort(int[] nums) {
        //控制轮数，紧挨的两数相比，只需要比n-1轮，从0即代表第一轮比较，比较length-1轮
        for (int i = 0; i < nums.length - 2; i++) {
            //控制每轮比较次数，比到i处的下一个元素，最后到j-1实际也就是到i处
            for (int j = nums.length - 1; j > i; j--) {
                //大于是降序，小于是升序
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序  4, 1, 2, 6, 8, 9, 0, 3, 5, 7, 1, 8, 4, 6, 9, 2, 11, 10
     * <p>
     * 比较次数：
     * 第一轮比较：n-1 次
     * 第二轮比较：n-2 次
     * ...
     * 第n-1轮比较：1次
     * 总比较次数：(n-1)+(n-2)+...+1 ≈ n²/2
     * 时间复杂度：O(n²)
     * 也可直接看成两次for循环嵌套，且都与数组长度有关，所以n*n -> n²
     * 平均时间复杂度： 时间复杂度  与 冒泡排序一样  O(n²)
     *
     * @param nums 待排序数组
     */
    private static void selectSort(int[] nums) {
        //控制轮数，n个数，只需要查找n-1轮，从0即代表第一轮查找，查找length-1轮
        for (int i = 0; i < nums.length - 1; i++) {
            //记录待排序中最小元素的下标，初始为i
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    //记录最小下标
                    min = j;
                }
            }
            //如果待排序中没有比下标为i的元素小则不交换
            if (min != i) {
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
    }

    /**
     * 插入排序 4, 1, 2, 6, 8, 9, 0, 3, 5, 7, 1, 8, 4, 6, 9, 2, 11, 10
     * <p>
     * 1, 2, 4, 6, 8, 9, 0, 3, 5, 7, 1, 8, 4, 6, 9, 2, 11, 10
     * 0, 1, 2, 4, 6, 8, 9, 3, 5, 7, 1, 8, 4, 6, 9, 2, 11, 10
     * <p>
     * 比较次数：
     * <p>
     * 第一轮其实是自己跟自己比，i=0，也就不需要比，没意思，所以从i=1开始
     * <p>
     * 第一轮比较：0 次
     * 第二轮比较：1 次
     * ...
     * 第n轮比较：n-1 次
     * 总比较次数：(n-1)+(n-2)+...+1 ≈ n²/2
     * 时间复杂度：O(n²)
     * 也可直接看成两次for循环嵌套，且都与数组长度有关，所以n*n -> n²
     * 平均时间复杂度： 时间复杂度  与 冒泡排序  、  选择排序 一样  O(n²)
     *
     * @param nums 待排序数组
     */
    private static void insertSort(int[] nums) {
        /*
         * 第一个for循环
         * 把数组分成两部分，右边为未排序，左边为已排序
         * 记录排序与未排序分割点tmp（tmp为下一个排序对象）
         */
        for (int i = 1; i < nums.length; i++) {
            //当前元素取出 留一个坑位，好让数据往右移动，留个坑位给需要插入的元素；也是用作比较的数据
            int tmp = nums[i];
            //左边已排好序下标
            int leftIndex = i - 1;
            /*
             * 第二个循环
             * 将排序对象tmp与已排序数组比较
             * 当temp比最近左边的数大时（按从小到大循序排列时）
             * 直接结束本次循环，进行下一个数排序
             * 否则比左边这个数小时将这个数后移，腾出这个数的位置
             */
            while (leftIndex >= 0 && tmp < nums[leftIndex]) {
                nums[leftIndex + 1] = nums[leftIndex];
                leftIndex--;
            }
            //待插入的数比已排序好的数都大 需要插入排好序的最后  则不需要交换了
            if (leftIndex + 1 != i) {
                //把tmp放在空位上
                nums[leftIndex + 1] = tmp;
            }
        }
    }

    /**
     * 堆排序
     *
     * @param nums
     */
    private static void heapSort(int[] nums) {
        //构建大顶堆
        //(nums.length-1)/2  第一个非叶子节点
        for (int i = (nums.length-1)/2; i>=0 ; i--) {
            adjustHeap(nums, i, nums.length);
        }

        //不断交换顶和尾元素然后调整
        for (int i = nums.length-1; i >=0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            adjustHeap(nums, 0, i);
        }
    }

    /**
     * 调整堆  大顶堆
     * 4, 1, 2, 6, 8
     *
     * @param nums   待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] nums, int parent, int length) {
        //作为父节点
        int tmp = nums[parent];
        //左孩子
        int lChild = 2 * parent + 1;
        //lChild < length  代表 有 左节点
        while (lChild < length){
            //右孩子 2 * parent + 2
            int rChild = lChild + 1;
            //rChild < length  有 右孩子 ， 且 左节点 小于右节点  左节点 + 1
            if (rChild < length && nums[lChild] < nums[rChild]){
                lChild++;
            }

            // 父节点 与 左右节点中最大的一个 比较 大小
            if (tmp >= nums[lChild]){
                break;
            }

            //父节点小于左右节点中最大的一个  则交换，把最大的一个节点换到父节点
            nums[parent] = nums[lChild];

            //选取该节点的孩子节点继续向下筛选
            parent = lChild;
            lChild = 2 * parent + 1;
        }

        // 如果相等 说明 该父节点没有子节点，不相等 此时的parent 是该父节点的需要调整的对应子节点，需要跟当前节点交换
        if (tmp != nums[parent]) {
            nums[parent] = tmp;
        }
    }

}
