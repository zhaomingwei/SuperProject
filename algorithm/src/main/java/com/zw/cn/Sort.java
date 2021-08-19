package com.zw.cn;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 赵威
 * @date 2021/5/10 8:28
 * @desc 简单排序算法
 * 记忆：  冒泡 选择 (了) 插入 ， 堆  与  归并 不高兴 ， 于是派  快速  战斗
 */
public class Sort {

    public static void main(String[] args) {
//        int[] array = new int[]{4, 1, 2, 6, 8, 9, 0, 3, 5, 7};
//        int[] array = new int[]{4, 1, 2, 6, 8};
//        int[] array = new int[]{3, 5, 8, 1, 2, 9, 4, 7, 6};

        // 测试效率  电脑配置  Intel(R) Core(TM) i7-8700 CPU @ 3.20GHz  3.19 GHz   16.0 GB  64位
        int number = 10;

        int[] array1 = new int[number];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = new Random().nextInt(number);
        }

        //冒泡 10w 无序 大概 13s+  100w等不下去了，至少等了30分钟到1个小时
        long start1 = System.currentTimeMillis();
//        bubbleSort(array1);
        long end1 = System.currentTimeMillis();
        System.out.println("bubbleSort Sort : " + (end1 - start1));
//        System.out.println(Arrays.toString(array1));

        int[] array2 = new int[number];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = new Random().nextInt(number);
        }

        //选择 10w 无序 大概 3s+    100w 无序 352s+
        long start2 = System.currentTimeMillis();
//        selectSort(array2);
        long end2 = System.currentTimeMillis();
        System.out.println("selectSort Sort : " + (end2 - start2));
//        System.out.println(Arrays.toString(array2));

        int[] array3 = new int[number];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = new Random().nextInt(number);
        }

        //插入 10w 无序 大概 0.6s+   100w 无序 74s+
        long start3 = System.currentTimeMillis();
//        insertSort(array3);
        long end3 = System.currentTimeMillis();
        System.out.println("insertSort Sort : " + (end3 - start3));
//        System.out.println(Arrays.toString(array3));

        int[] array4 = new int[number];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = new Random().nextInt(number);
        }

        //堆 10w 无序 大概 0.009s+   100w 无序 0.1s+   1000w 无序 1.6s+     1亿 无序 26s+
        long start4 = System.currentTimeMillis();
//        heapSort(array4);
        long end4 = System.currentTimeMillis();
        System.out.println("heapSort Sort : " + (end4 - start4));
//        System.out.println(Arrays.toString(array4));

        int[] array5 = new int[number];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = new Random().nextInt(number);
        }

        //快排 10w 无序 大概 0.02s+   100w 无序 0.09s+   1000w 无序 0.9s+   1亿 无序 9.5s+
        System.out.println(Arrays.toString(array5));
        long start5 = System.currentTimeMillis();
        quickSort(array5);
        long end5 = System.currentTimeMillis();
        System.out.println("quick Sort : " + (end5 - start5));
        System.out.println(Arrays.toString(array5));

    }

    private static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 快排  适合数组无序
     * <p>
     * 时间复杂度  O(nlogn)
     * <p>
     * 首先在随机序列中选择一个基准值(pivot) 然后将除了pivot以外的值分为比 pivot 大 和 小  两个类别，小的在pivot 左边，大的在pivot 右边
     * 形如： [比pivot小的值]   pivot   [比pivot大的值]
     * 接着对pivot 左边 和 右边 进行排序，那么总体排序也就完成。对 左边 和 右边排序 可以继续使用 快排。
     * <p>
     * [1 2]       3          [5 8 9 4 7 6]
     * [1] 2    1是pivot     [4] 5 [8 9 7 6]  5是pivot
     * 1 2    排好序     4 5 [7 6] 8 [9]  8是pivot
     * 1 2    排好序     4 5 [6] 7 8 9  7是pivot
     * 1 2    排好序     4 5 6 7 8 9  排好序
     * 最后排完是： 1 2 3 4 5 6 7 8 9
     *
     * @param array 3 5 8 1 2 9 4 7 6
     *              第一步：      2 5(left) 8 1(right) 3 9 4 7 6     交换3 和 2
     *              第二步：      2 5(left) 8 1(right) 3 9 4 7 6
     *              第三步：      2 1 8(left)(right) 5 3 9 4 7 6
     *              第四步：      2 1(right) 8(left) 5 3 9 4 7 6
     * @param start
     * @param end
     */
    private static void sort(int[] array, int start, int end) {
        //left 与 right left与right相邻时，有两种情况：
        // 第一：两个都符合各自while条件，则left++，right--，此时left在右，right在左
        // 第二：其中一个符合对应while条件，则left++或者right--，此时left与right重合，在同一个位置，此时在走一次循环，必然符合其中一个while，那么此时left与right依然是背向分开了
        // 所以下面判断 start >= end 时 即代表本次 排序完成   = 的情况 是只有一个数，那么此时的start = end
        if (start >= end) {
            return;
        }
        // 第一个值作为基准值
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left <= right) {
            // 从左到右找， left一直往右移动 ，找第一个比pivot大的值的下标
            while (left <= right && array[left] < pivot) {
                left++;
            }
            // 从右到左找， right一直往左移动 ，找第一个比pivot小的值的下标
            while (left <= right && array[right] > pivot) {
                right--;
            }
            // 交换 左边第一个比pivot大的值 与 右边第一个比pivot小的值, left++,right--继续找，继续换
            if (left <= right) {
                int tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
                left++;
                right--;
            }
        }
        sort(array, start, right);
        sort(array, left, end);
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
     * @param array 待排序数组
     */
    private static void bubbleSort(int[] array) {
        //控制轮数，紧挨的两数相比，只需要比n-1轮，从0即代表第一轮比较，比较length-1轮
        for (int i = 0; i < array.length - 2; i++) {
            //控制每轮比较次数，比到i处的下一个元素，最后到j-1实际也就是到i处
            for (int j = array.length - 1; j > i; j--) {
                //大于是降序，小于是升序
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
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
     * @param array 待排序数组
     */
    private static void selectSort(int[] array) {
        //控制轮数，n个数，只需要查找n-1轮，从0即代表第一轮查找，查找length-1轮
        for (int i = 0; i < array.length - 1; i++) {
            //记录待排序中最小元素的下标，初始为i
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    //记录最小下标
                    min = j;
                }
            }
            //如果待排序中没有比下标为i的元素小则不交换
            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }

    /**
     * 插入排序 适合数组大致有序
     *
     * 4, 1, 2, 6, 8, 9, 0, 3, 5, 7, 1, 8, 4, 6, 9, 2, 11, 10
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
     * @param array 待排序数组
     */
    private static void insertSort(int[] array) {
        /*
         * 第一个for循环
         * 把数组分成两部分，右边为未排序，左边为已排序
         * 记录排序与未排序分割点tmp（tmp为下一个排序对象）
         */
        for (int i = 1; i < array.length; i++) {
            //当前元素取出 留一个坑位，好让数据往右移动，留个坑位给需要插入的元素；也是用作比较的数据
            int tmp = array[i];
            //左边已排好序下标
            int leftIndex = i - 1;
            /*
             * 第二个循环
             * 将排序对象tmp与已排序数组比较
             * 当temp比最近左边的数大时（按从小到大循序排列时）
             * 直接结束本次循环，进行下一个数排序
             * 否则比左边这个数小时将这个数后移，腾出这个数的位置
             */
            while (leftIndex >= 0 && tmp < array[leftIndex]) {
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }
            //待插入的数比已排序好的数都大 需要插入排好序的最后  则不需要交换了
            if (leftIndex + 1 != i) {
                //把tmp放在空位上
                array[leftIndex + 1] = tmp;
            }
        }
    }

    /**
     * 堆排序
     * 可参考：https://www.jb51.net/article/86163.htm
     * <p>
     * 时间复杂度  O(nlogn)
     * <p>
     * 第一步：将数组里n个数据存入堆里，时间复杂度 O(nlogn)
     *
     * @param array
     */
    private static void heapSort(int[] array) {
        //创建堆，升序：大顶堆   降序：小顶堆
        // 是先创建 大顶堆或者小顶堆 然后再将根节点沉到最后，此时大顶堆就变成了 根节点是最小元素 尾结点就是最大元素，小顶堆就变成了 根节点是最大元素 尾结点就是最小元素，
        // 所以最后输出就是  大顶堆 升序， 小顶堆 降序
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            // 第一个非叶子节点 就是 (length-1)/2
            // 当前节点下标i，其左节点下标：2i+1，右节点下标：2i+2
            adjustHeap(array, i, array.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        //从后往前遍历 交换堆顶元素与末尾元素 不断调整堆，将最大元素或者最小元素往后沉，使之有序
        for (int i = array.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            //重新对堆进行调整，断开调整后的元素，i+1
            adjustHeap(array, 0, i);
        }
    }

    /**
     * 调整堆  大顶堆
     * 4, 1, 2, 6, 8
     *
     * @param array  待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] array, int parent, int length) {
        //将temp作为父节点
        int temp = array[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && array[lChild] < array[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            array[parent] = array[lChild];

            //选取孩子结点的孩子结点作为父节点,继续向下筛选调整
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        // 如果相等 说明 该父节点没有子节点，不相等 此时的parent 是该父节点的需要调整的对应子节点，需要跟当前节点交换
        if (temp != array[parent]) {
            array[parent] = temp;
        }
    }

}
