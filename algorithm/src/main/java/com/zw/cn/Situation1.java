package com.zw.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 赵威
 * @date 2021/8/19 9:14
 * @desc 100w的两个数组，找出重复数据
 * 思路：先用java8去重，在排序，最后用双指针找出重复数据。排序可分为原本数组大致有序和无序，有序使用插入排序算法，无序使用快排算法。
 */
public class Situation1 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        int length = 1000000;
        for (int i = 0; i < length; i++) {
            list1.add(i);
        }
        for (int i = 300000; i < length+300000; i++) {
            list2.add(i);
        }
//        for (int i = 0; i < length; i++) {
//            list1.add(new Random().nextInt(length));
//        }
//        for (int i = 0; i < length; i++) {
//            list2.add(new Random().nextInt(length));
//        }
        long start = System.currentTimeMillis();
        List<Integer> list11 = list1.stream().distinct().collect(Collectors.toList());
        List<Integer> list22 = list2.stream().distinct().collect(Collectors.toList());
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start);
        int[] arr1 = list11.stream().mapToInt(Integer::valueOf).toArray();
        int[] arr2 = list22.stream().mapToInt(Integer::valueOf).toArray();
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start);
//        quickSort(arr1);
        insertSort(arr1);
        long end3 = System.currentTimeMillis();
        System.out.println(end3 - start);
//        quickSort(arr2);
        insertSort(arr2);
        long end4 = System.currentTimeMillis();
        System.out.println(end4 - start);
        System.out.println(findCommon(arr1, arr2).size());
        long end5 = System.currentTimeMillis();
        System.out.println(end5 - start);
    }

    public static List<Integer> findCommon(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return list;
        }
        int i = 0, j = 0;
        while ( i < arr1.length && j < arr2.length ) {
            if (arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            }
            else if (arr1[i] < arr2[j]) i++;
            else j++;
        }
        return list;
    }

    private static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 快排
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

}
